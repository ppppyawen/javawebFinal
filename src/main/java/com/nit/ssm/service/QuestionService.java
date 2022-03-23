package com.nit.ssm.service;

import com.nit.ssm.dto.*;

public interface QuestionService {
    GarbageListRspDTO listGarbage() throws Exception;

    SortDTO AnswerGarbage(ExamDTO examDTO) throws Exception;

    void InsertExam(ExamDTO examDTO) throws Exception;

    ExamTableRspDTO examTable(ExamTableReqDTO tableReqDTO) throws Exception;

    ExamTableRspDTO resultTable(ExamTableReqDTO tableReqDTO) throws Exception;

    ExamResultPieDTO resultPieTable(ExamTableReqDTO examTableReqDTO) throws Exception;

    ExamTableRspDTO listResultRanking() throws  Exception;

    ExamTableRspDTO listLineChart(ExamTableReqDTO examTableReqDTO) throws  Exception;
}

