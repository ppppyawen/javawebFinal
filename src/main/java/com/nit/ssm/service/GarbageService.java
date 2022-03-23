package com.nit.ssm.service;

import com.nit.ssm.dto.GarbageStatisticDTO;
import com.nit.ssm.dto.TableReqDTO;

import java.util.List;

/**
 * TODO
 *
 * @author gcl
 * @version 1.0
 * @Description

 */
public interface GarbageService {

    /**
     * @Description 获得垃圾题目相关的统计数据
     * @Author gcl
* @param:
     * @Return java.util.List<com.homework.ssm.dto.GarbageStatisticDTO>
     */
    List<GarbageStatisticDTO> getGarbageStatistic(TableReqDTO tableReqDTO);

    /**
     * @Description 获得垃圾的总条数, 注意不能使用列表的条数
     * @Author gcl
* @param:
     * @Return java.lang.Integer
     */
    Integer getGarbageCount();

}
