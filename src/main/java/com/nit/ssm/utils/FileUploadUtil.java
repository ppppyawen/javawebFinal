package com.nit.ssm.utils;

import com.nit.ssm.dto.OpResultDTO;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/upload")
public class FileUploadUtil {

    private final Logger logger = LoggerFactory.getLogger(FileUploadUtil.class);

    /**
     * @Description: 图片上传，采用Base64方式
     * @Author: wl
*/
    @RequestMapping(value = "/garbageImage", method = RequestMethod.POST)
    public OpResultDTO saveBase64(@RequestParam(value = "imgBase64") String imgBase64) {
        OpResultDTO opResult = new OpResultDTO();
        StringBuffer fileName = new StringBuffer();
        StringBuffer directoryName = new StringBuffer();
        StringBuffer pathName = new StringBuffer();
        StringBuffer imgPrefix = new StringBuffer();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        fileName.append(df.format(new Date()));
        //图片文件在服务器上的保存路径，需要与Nginx的反向代理整合考虑
        System.out.println(ClassUtils.getDefaultClassLoader().getResource("").getPath());
        pathName.append("D:/Download/Images/userImage");
        try {
            if (imgBase64.indexOf("data:image/png;") != -1) {
                imgPrefix.append("data:image/png;base64,");
                fileName.append(".png");
            } else if (imgBase64.indexOf("data:image/jpeg;") != -1) {
                imgPrefix.append("data:image/jpeg;base64,");
                fileName.append(".jpeg");
            } else if (imgBase64.indexOf("data:image/jpg;") != -1) {
                imgPrefix.append("data:image/jpg;base64,");
                fileName.append(".jpg");
            } else if (imgBase64.indexOf("data:image/bmp;") != -1) {
                imgPrefix.append("data:image/bmp;base64,");
                fileName.append(".bmp");
            }
            imgBase64 = imgBase64.replace(imgPrefix.toString(), "");
            df = new SimpleDateFormat("yyyyMMdd");
            directoryName.append(df.format(new Date()) + "/");
            File file = new File(pathName.toString() + directoryName.toString() + fileName.toString());
            byte[] fileBytes = Base64.getDecoder().decode(imgBase64);
            FileUtils.writeByteArrayToFile(file, fileBytes);
            opResult.setIntResult(file.hashCode());
            //图片的返回路径需要根据自己的需求自行设置，注意应是相对路径
            opResult.setObjResult("../upload/images/" + directoryName.toString() + fileName.toString());
        } catch (IOException e) {
            logger.error(e.toString());
        }
        return opResult;
    }

    @RequestMapping(value = "/userImage", method = RequestMethod.POST)
    public OpResultDTO upLoadUserImage(@RequestParam(value = "imgBase64") String imgBase64) {
        OpResultDTO opResult = new OpResultDTO();
        StringBuffer fileName = new StringBuffer();
        StringBuffer directoryName = new StringBuffer();
        StringBuffer pathName = new StringBuffer();
        StringBuffer imgPrefix = new StringBuffer();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        fileName.append(df.format(new Date()));
        //图片文件在服务器上的保存路径，需要与Nginx的反向代理整合考虑
        System.out.println(ClassUtils.getDefaultClassLoader().getResource("").getPath());
        //pathName.append("D:/Download/Images/userImage/");
        pathName.append("target/classes/static/upload/Images/userImage/");
        try {
            if (imgBase64.indexOf("data:image/png;") != -1) {
                imgPrefix.append("data:image/png;base64,");
                fileName.append(".png");
            } else if (imgBase64.indexOf("data:image/jpeg;") != -1) {
                imgPrefix.append("data:image/jpeg;base64,");
                fileName.append(".jpeg");
            } else if (imgBase64.indexOf("data:image/jpg;") != -1) {
                imgPrefix.append("data:image/jpg;base64,");
                fileName.append(".jpg");
            } else if (imgBase64.indexOf("data:image/bmp;") != -1) {
                imgPrefix.append("data:image/bmp;base64,");
                fileName.append(".bmp");
            }
            imgBase64 = imgBase64.replace(imgPrefix.toString(), "");
            df = new SimpleDateFormat("yyyyMMdd");
            directoryName.append(df.format(new Date()) + "/");
            //System.out.println(pathName.toString()+"" + directoryName.toString() + fileName.toString());
            File file = new File(pathName.toString() + directoryName.toString() + fileName.toString());
            byte[] fileBytes = Base64.getDecoder().decode(imgBase64);
            FileUtils.writeByteArrayToFile(file, fileBytes);
            opResult.setIntResult(file.hashCode());
            //图片的返回路径需要根据自己的需求自行设置，注意应是相对路径
            opResult.setObjResult("../../upload/Images/userImage/" + directoryName.toString() + fileName.toString());
            //System.out.println("../../upload/Images/userImage/" + directoryName.toString() + fileName.toString());
        } catch (IOException e) {
            logger.error(e.toString());
        }
        return opResult;
    }

    /**
     * @Description: 文件上传，采用FormData方式，注意参数接收方式
     * @Author: wl
*/
    @ResponseBody
    @RequestMapping(value = "/accessory", method = RequestMethod.POST)
    public OpResultDTO saveAccessory(@RequestParam("asyData") MultipartFile[] asyData) {
        OpResultDTO opResult = new OpResultDTO();
        StringBuffer fileName = new StringBuffer();
        StringBuffer directoryName = new StringBuffer();
        StringBuffer pathName = new StringBuffer();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        pathName.append("D://static/upload/accessories/");
        try {
            for (MultipartFile file : asyData) {
                String OriginalName = file.getOriginalFilename();
                String suffixName = OriginalName.substring(OriginalName.lastIndexOf("."));
                fileName.append(df.format(new Date()) + suffixName);
                df = new SimpleDateFormat("yyyyMMdd");
                directoryName.append(df.format(new Date()) + "/");
                File desFile = new File(pathName.toString() + directoryName.toString() + fileName.toString());
                System.out.println(desFile.getParentFile());
                if (!desFile.exists()) {
                    desFile.getParentFile().mkdirs();
                }
                file.transferTo(desFile);
            }
            opResult.setIntResult(fileName.hashCode());
            opResult.setObjResult("../upload/accessories/" + directoryName.toString() + fileName.toString());
        } catch (IOException e) {
            logger.error(e.toString());
        }
        return opResult;
    }
}

