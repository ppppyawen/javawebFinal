package com.nit.ssm.controller;

import com.nit.ssm.dto.GarbageStatisticDTO;
import com.nit.ssm.dto.TableReqDTO;
import com.nit.ssm.dto.TableRspDTO;
import com.nit.ssm.service.impl.GarbageServiceImpl;
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
@RequestMapping("/api/garbage")
public class GarbageController {

    @Autowired
    GarbageServiceImpl garbageService;

    @RequestMapping("/query")
    public TableRspDTO getGarbageStatistic(TableReqDTO tableReqDTO){
        List<GarbageStatisticDTO> garbageStatistic = garbageService.getGarbageStatistic(tableReqDTO);
        TableRspDTO tableRspDTO = new TableRspDTO();
        tableRspDTO.setListTable(garbageStatistic);
        Integer garbageCount = garbageService.getGarbageCount();
        tableRspDTO.setTotal(garbageCount);
        return tableRspDTO;
    }

}
