package com.nit.ssm.controller;


import com.nit.ssm.dto.GarbageAnswerDTO;
import com.nit.ssm.dto.GarbageListRspDTO;
import com.nit.ssm.service.GameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/api/game")
public class GameController {

    @Resource
    private GameService gameService;

    private final Logger logger = LoggerFactory.getLogger(GameController.class);

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public GarbageListRspDTO garbageList(){
        GarbageListRspDTO garbageListRspDTO = new GarbageListRspDTO();
        try{
            garbageListRspDTO = gameService.listGarbage();
        }catch (Exception e){
            logger.error(e.toString());
        }
        return garbageListRspDTO;
    }

    @RequestMapping(value = "/resultQuery",method = RequestMethod.POST)
    public GarbageAnswerDTO garbageAnswer(GarbageAnswerDTO garbageAnswerDTO){
        try {
            garbageAnswerDTO = gameService.AnswerGarbage(garbageAnswerDTO);
        }catch (Exception e) {
            logger.error(e.toString());
        }
        return garbageAnswerDTO;
    }
}
