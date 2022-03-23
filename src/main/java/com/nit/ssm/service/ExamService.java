package com.nit.ssm.service;

import com.nit.ssm.dto.ExamInfoDTP;
import com.nit.ssm.dto.TableReqDTO;

import java.util.List;

/**
 * TODO
 *
 * @author gcl
 * @version 1.0

 */
public interface ExamService {

    List<ExamInfoDTP> getAllExamInfo(TableReqDTO tableReqDTO);
    Integer count();
}
