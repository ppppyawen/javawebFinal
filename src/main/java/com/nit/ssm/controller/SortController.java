package com.nit.ssm.controller;

import com.nit.ssm.dto.OpResultDTO;
import com.nit.ssm.dto.SortDTO;
import com.nit.ssm.dto.TableReqDTO;
import com.nit.ssm.dto.TableRspDTO;
import com.nit.ssm.service.SortService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/sort")
public class SortController {

    @Resource
    private SortService sortService;
    private final Logger logger = LoggerFactory.getLogger(com.nit.ssm.controller.SortController.class);

    /**
     * @Description: 获取数据列表
     * @Author: wl

     */
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public TableRspDTO list4Table(TableReqDTO tableReqDTO) {
        TableRspDTO tableRspDTO = new TableRspDTO();
        try {
            tableRspDTO = sortService.list4Table(tableReqDTO);
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return tableRspDTO;
    }

    /**
     * @Description: 添加记录
     * @Author: wl

     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public OpResultDTO add(SortDTO sortDTO) {
        OpResultDTO opResult = new OpResultDTO();
        try {
            opResult.setIntResult(sortService.add(sortDTO));
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return opResult;
    }

    /**
     * @Description: 编辑记录
     * @Author: wl
*/
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public OpResultDTO update(SortDTO sortDTO) {
        OpResultDTO opResult = new OpResultDTO();
        try {
            opResult.setIntResult(sortService.edit(sortDTO));
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return opResult;
    }

    /**
     * @Description: 删除记录
     * @Author: wl
*/
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public OpResultDTO remove(Integer sortId) {
        OpResultDTO opResult = new OpResultDTO();
        try {
            opResult.setIntResult(sortService.remove(sortId));
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return opResult;
    }
}