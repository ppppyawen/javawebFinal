package com.nit.ssm.utils;

import com.nit.ssm.dto.ExamResultDTO;
import com.nit.ssm.dto.ExamTableReqDTO;
import com.nit.ssm.dto.ExamTableRspDTO;
import com.nit.ssm.service.QuestionService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import static org.apache.poi.ss.usermodel.CellType.STRING;

/**
 * TODO
 *
 * @author wlj
 * @version 1.0
 * @Description

 */

@RestController
@RequestMapping(value = "/api/data")
public class ImportExport {
    @Resource
    private QuestionService questionService;
    private final  Logger logger = LoggerFactory.getLogger(ImportExport.class);


    @ResponseBody
    @RequestMapping(value = "/questExport",method = RequestMethod.POST)
    public void exportQuestData(ExamTableReqDTO examTableReqDTO){
        ExamResultDTO examResultDTO = null;
        ExamTableRspDTO tableRspDTO = new ExamTableRspDTO();
        try{
            tableRspDTO = questionService.resultTable(examTableReqDTO);
        }catch (Exception e){
            logger.error(e.toString());
        }
        //在SpringMVC中获取Response
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        // 输出流的字符编码处理
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/vnd.ms-excel");
        //response.setHeader("Content-Disposition", "attachment;filename=questResult.xls");
        System.out.println(tableRspDTO.toString());
        try {
            OutputStream os = response.getOutputStream();
            // 创建Excel工作薄
            HSSFWorkbook book = new HSSFWorkbook();
            // 在Excel工作薄中建一张工作表
            HSSFSheet sheet = book.createSheet("答题信息");
            // 设置单元格格式(文本)
            // HSSFCellStyle cellStyle = book.createCellStyle();
            // 第一行为标题行
            HSSFRow row = sheet.createRow(0);// 创建第一行
            HSSFCell cell0 = row.createCell(0);
            HSSFCell cell1 = row.createCell(1);
            HSSFCell cell2 = row.createCell(2);
            HSSFCell cell3 = row.createCell(3);
            HSSFCell cell4 = row.createCell(4);
            // 定义单元格为字符串类型
            cell0.setCellType(STRING);
            cell1.setCellType(STRING);
            cell2.setCellType(STRING);
            cell3.setCellType(STRING);
            cell4.setCellType(STRING);
            // 在单元格中输入数据
            cell0.setCellValue("题目序号");
            cell1.setCellValue("垃圾名称");
            cell2.setCellValue("所选答案");
            cell3.setCellValue("正确答案");
            cell4.setCellValue("备注");
            // 循环导出数据到excel中
            for (int i = 0; i < tableRspDTO.getExamTable().size(); i++) {
                // 创建第i行
                examResultDTO = (ExamResultDTO)tableRspDTO.getExamTable().get(i);
                HSSFRow rowi = sheet.createRow(i + 1);
                // 在第i行的相应列中加入相应的数据
                /*
                System.out.println(i+1);
                System.out.println(examResultDTO.getGarbageName());
                System.out.println(examResultDTO.getAnswerName());
                System.out.println(examResultDTO.getTrueName());
                System.out.println(examResultDTO.getSortInfo());
                
                 */
                rowi.createCell(0).setCellValue(i+1);
                rowi.createCell(1).setCellValue(examResultDTO.getGarbageName());
                rowi.createCell(2).setCellValue(examResultDTO.getAnswerName());
                rowi.createCell(3).setCellValue(examResultDTO.getTrueName());
                rowi.createCell(4).setCellValue(examResultDTO.getSortInfo());
            }
            // 写入数据，把相应的EXCEL工作簿存盘
            book.write(os);
        } catch (IOException e) {
            logger.error(e.toString());
        }
    }
}

