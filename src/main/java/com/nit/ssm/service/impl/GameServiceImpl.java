package com.nit.ssm.service.impl;
import com.nit.ssm.dto.GarbageAnswerDTO;
import com.nit.ssm.dto.GarbageListRspDTO;
import com.nit.ssm.dto.GarbageQuestionDTO;
import com.nit.ssm.mapper.GameMapper;
import com.nit.ssm.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GameServiceImpl implements GameService {

    @Autowired(required = false)
    private GameMapper gameMapper;

    @Override
    public GarbageListRspDTO listGarbage() throws Exception{
        List<GarbageQuestionDTO> listGarbageDTOs = gameMapper.listGarbage();
        return  new GarbageListRspDTO(listGarbageDTOs);
    }


    @Autowired(required = false)
    @Override
    public GarbageAnswerDTO AnswerGarbage(GarbageAnswerDTO garbageAnswerDTO) throws Exception{

        return gameMapper.AnswerGarbage(garbageAnswerDTO);
    }
}
