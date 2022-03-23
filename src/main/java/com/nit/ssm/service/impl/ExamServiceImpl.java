package com.nit.ssm.service.impl;

import com.nit.ssm.dto.ExamInfoDTP;
import com.nit.ssm.dto.TableReqDTO;
import com.nit.ssm.mapper.ExamMapper;
import com.nit.ssm.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author gcl
 * @version 1.0

 */
@Service
public class ExamServiceImpl implements ExamService {

    @Autowired(required = false)
    ExamMapper examMapper;

    @Override
    public Integer count() {
        return examMapper.countExam();
    }

    @Override
    public List<ExamInfoDTP> getAllExamInfo(TableReqDTO tableReqDTO) {
        return examMapper.getAllExamInfo(tableReqDTO.getStart(),tableReqDTO.getPageSize(),tableReqDTO.getQueryText());
    }
}
