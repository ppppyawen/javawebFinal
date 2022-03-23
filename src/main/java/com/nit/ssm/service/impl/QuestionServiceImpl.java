package com.nit.ssm.service.impl;


import com.nit.ssm.dto.*;
import com.nit.ssm.mapper.QuestionMapper;
import com.nit.ssm.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired(required = false)
    private QuestionMapper questionMapper;
    @Override
    public GarbageListRspDTO listGarbage() throws Exception{
        List<GarbageQuestionDTO> listGarbageDTOs = questionMapper.listGarbage();
        return new GarbageListRspDTO(listGarbageDTOs);
    }

    @Autowired(required = false)
    @Override
    public SortDTO AnswerGarbage(ExamDTO examDTO) throws Exception{

        return questionMapper.AnswerGarbage(examDTO);
    }

    @Autowired(required = false)
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void InsertExam(ExamDTO examDTO) throws Exception{

        questionMapper.InsertExam(examDTO);
    }

    @Autowired(required = false)
    @Override
    public ExamTableRspDTO examTable(ExamTableReqDTO tableReqDTO) throws Exception{
        Integer count = questionMapper.countExamTable(tableReqDTO.getUserId());
        List<ExamHistoryDTO> listExamHistoryDTOs = questionMapper.listExamTable(tableReqDTO.getStart(),
                tableReqDTO.getPageSize(),tableReqDTO.getUserId());
        return new ExamTableRspDTO(count,listExamHistoryDTOs);
    }

    @Autowired(required = false)
    @Override
    public ExamTableRspDTO resultTable(ExamTableReqDTO tableReqDTO) throws  Exception{
        String examSn = tableReqDTO.getExamSn();
        List<ExamResultDTO> listExamResultDTOs;
        listExamResultDTOs = questionMapper.listResultTrueName(examSn);
        return new ExamTableRspDTO(listExamResultDTOs);
    }

    @Autowired(required = false)
    @Override
    public ExamResultPieDTO resultPieTable(ExamTableReqDTO examTableReqDTO) throws Exception{
        ExamResultPieDTO examResultPieDTO;
        examResultPieDTO = questionMapper.resultPieTable(examTableReqDTO.getUserId());
        return examResultPieDTO;
    }

    @Override
    public ExamTableRspDTO listResultRanking() throws  Exception{
        List<ExamResultRankDTO> listExamResultRankDTOs;
        listExamResultRankDTOs = questionMapper.listResultRanking();
        return new ExamTableRspDTO(listExamResultRankDTOs);

    }

    @Override
    public ExamTableRspDTO listLineChart(ExamTableReqDTO examTableReqDTO) throws  Exception{
        List<ExamDTO> listExamDTOs;
        listExamDTOs = questionMapper.listLineChart(examTableReqDTO.getUserId());
        return new ExamTableRspDTO(listExamDTOs);

    }
}
