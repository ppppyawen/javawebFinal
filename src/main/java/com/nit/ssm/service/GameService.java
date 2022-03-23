package com.nit.ssm.service;

import com.nit.ssm.dto.GarbageAnswerDTO;
import com.nit.ssm.dto.GarbageListRspDTO;

public interface GameService {

    GarbageListRspDTO listGarbage() throws Exception;

    GarbageAnswerDTO AnswerGarbage(GarbageAnswerDTO garbageAnswerDTO) throws Exception;
}
