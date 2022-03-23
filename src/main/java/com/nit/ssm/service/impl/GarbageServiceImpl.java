package com.nit.ssm.service.impl;

import com.nit.ssm.dto.GarbageStatisticDTO;
import com.nit.ssm.dto.TableReqDTO;
import com.nit.ssm.mapper.GarbageMapper;
import com.nit.ssm.service.GarbageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author gcl
 * @version 1.0
 * @Description

 */
@Service
public class GarbageServiceImpl implements GarbageService
{

    @Autowired
    private GarbageMapper garbageMapper;

    @Override
    public List<GarbageStatisticDTO> getGarbageStatistic(TableReqDTO tableReqDTO) {
        return garbageMapper.listTable(tableReqDTO.getStart(),tableReqDTO.getPageSize(),tableReqDTO.getQueryText());
    }

    @Override
    public Integer getGarbageCount() {
        return garbageMapper.count();
    }
}
