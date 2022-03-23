package com.nit.ssm.controller;

import com.nit.ssm.dto.ExamInfoDTP;
import com.nit.ssm.dto.TableReqDTO;
import com.nit.ssm.dto.TableRspDTO;
import com.nit.ssm.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * TODO
 *
 * @author pyw
 * @version 1.0
 */
@CrossOrigin
@RestController
@RequestMapping("/api/exam")
public class ExamController {

    @Autowired
    ExamService examService;

    @RequestMapping("/getAllExamInfo")
    public TableRspDTO getAllExamInfo(TableReqDTO tableReqDTO){
        List<ExamInfoDTP> allExamInfo = examService.getAllExamInfo(tableReqDTO);
        Integer count = examService.count();
        TableRspDTO tableRspDTO = new TableRspDTO();
        tableRspDTO.setTotal(count);
        tableRspDTO.setListTable(allExamInfo);
        return tableRspDTO;
    }

}
