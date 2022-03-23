package com.nit.ssm.controller;

import com.nit.ssm.dto.*;
import com.nit.ssm.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/quest")
public class QuestionController {

    @Resource
    private QuestionService questionService;

    private final Logger logger = LoggerFactory.getLogger(QuestionController.class);

    @RequestMapping(value = "/topic",method = RequestMethod.GET)
    public GarbageListRspDTO garbageList(){
        GarbageListRspDTO garbageListRspDTO = new GarbageListRspDTO();
        try{
            garbageListRspDTO = questionService.listGarbage();
        }catch (Exception e){
            logger.error(e.toString());
        }
        return garbageListRspDTO;
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public ExamListRspDTO examList(ExamListReqDTO examListReqDTO, HttpSession session){
        List<SortDTO> resultList = new ArrayList<>();
        SortDTO sortDTO;
        Integer UserId = (Integer) session.getAttribute("loginId");
        int i=0;
        ExamDTO examDTO = new ExamDTO();
        //String sortId = null;
        ExamListRspDTO examListRspDTO = new ExamListRspDTO();
        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String timeString = timeFormat.format(new Date());
        for(i=0;i<10;i++)
        {
            examDTO.setUserId(UserId);
            examDTO.setAnswerId(examListReqDTO.getGarbageAnswerList().get(i).toString());
            examDTO.setExamSn(timeString);
            examDTO.setGarbageId(examListReqDTO.getGarbageIdList().get(i).toString());
            try{
                sortDTO = questionService.AnswerGarbage(examDTO);
                examDTO.setSortId(sortDTO.getSortId().toString());
                resultList.add(sortDTO);
                //System.out.println(resultList.get(i));
            }catch (Exception e){
                logger.error(e.toString());
            }
            //examDTO.setSortId(sortId);
            try{
                questionService.InsertExam(examDTO);
            }catch (Exception e){
                logger.error(e.toString());
            }
        }
        examListRspDTO.setResultList(resultList);
        return examListRspDTO;
    }

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public ExamTableRspDTO list4Table(ExamTableReqDTO examTableReqDTO, HttpSession session) {
        Integer UserId = (Integer) session.getAttribute("loginId");
        ExamTableRspDTO tableRspDTO = new ExamTableRspDTO();
        try {
            examTableReqDTO.setUserId(UserId);
            tableRspDTO = questionService.examTable(examTableReqDTO);
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return tableRspDTO;
    }

    @RequestMapping(value = "/queryResult", method = RequestMethod.POST)
    public ExamTableRspDTO listResultTable(ExamTableReqDTO examTableReqDTO){
        ExamTableRspDTO tableRspDTO = new ExamTableRspDTO();
        try{
            tableRspDTO = questionService.resultTable(examTableReqDTO);
        }catch (Exception e){
            logger.error(e.toString());
        }
        return tableRspDTO;
    }

    @RequestMapping(value = "/garbagePie", method = RequestMethod.GET)
    public ExamResultPieDTO listResultTable(HttpSession session){
        Integer UserId = (Integer) session.getAttribute("loginId");
        ExamResultPieDTO examResultPieDTO = new ExamResultPieDTO();
        ExamTableReqDTO tableReqDTO = new ExamTableReqDTO();
        try{
            tableReqDTO.setUserId(UserId);
            examResultPieDTO = questionService.resultPieTable(tableReqDTO);
        }catch (Exception e){
            logger.error(e.toString());
        }
        return examResultPieDTO;
    }

    @RequestMapping(value = "/garbageRanking",method = RequestMethod.GET)
    public ExamTableRspDTO listResultRanking(){
        ExamTableRspDTO examTableRspDTO = new ExamTableRspDTO();
        try{
            examTableRspDTO = questionService.listResultRanking();
        }catch (Exception e){
            logger.error(e.toString());
        }
        return  examTableRspDTO;
    }

    @RequestMapping(value = "/garbageLineChart",method = RequestMethod.GET)
    public ExamTableRspDTO listResultLineChart(HttpSession session){
        ExamTableRspDTO examTableRspDTO = new ExamTableRspDTO();
        ExamTableReqDTO tableReqDTO = new ExamTableReqDTO();
        ExamDTO examDTO = null;
        List<ExamLineResultDTO> lineResultDTOS = new ArrayList<>();
        try{
            Integer UserId = (Integer) session.getAttribute("loginId");
            tableReqDTO.setUserId(UserId);
            examTableRspDTO = questionService.listLineChart(tableReqDTO);
            Integer i = 0;
            Integer j = 0;

            for(i=0;i<examTableRspDTO.getExamTable().size();i=i+10){
                ExamLineResultDTO examLineResultDTO = new ExamLineResultDTO();
                int true_answer = 0;
                int wrong_answer = 0;
                for(j=0;j<10;j++){
                    examDTO = (ExamDTO)examTableRspDTO.getExamTable().get(i+j);
                    if(examDTO.getSortId().equals( examDTO.getAnswerId())){
                        true_answer = true_answer +1;
                    }else{
                        wrong_answer = wrong_answer + 1;
                    }
                }

                examLineResultDTO.setCreateTime(examDTO.getCreateTime());
                examLineResultDTO.setTrueCount(true_answer);
                examLineResultDTO.setWrongCount(wrong_answer);

                lineResultDTOS.add(examLineResultDTO);
            }
            examTableRspDTO.setExamTable(lineResultDTOS);
        }catch (Exception e){
            logger.error(e.toString());
        }
        return examTableRspDTO;
    }
}
