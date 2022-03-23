package com.nit.ssm.controller;

import com.nit.ssm.dto.*;
import com.nit.ssm.service.UserService;
//import com.sun.javaws.IconUtil;
import com.nit.ssm.utils.CodeUtil;
import com.nit.ssm.utils.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.RenderedImage;
import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Resource
    private UserService userService;
    /*日志*/
    private final Logger logger = LoggerFactory.getLogger(UserController.class);


    @RequestMapping(value = "/code", method = RequestMethod.GET)
    public void code (HttpSession session, HttpServletResponse response) {
        HashMap<String,Object> codeMessage;
        try{
            codeMessage = CodeUtil.getCode();
            session.setAttribute("randomCode", codeMessage.get("code"));
            ImageIO.setUseCache(false);// 防止Tomcat缓存
            ImageIO.write((RenderedImage) codeMessage.get("buffImg"), "jpg", response.getOutputStream()); //注意有些情况修改图片格式为png
        }catch (Exception e){
              logger.error(e.toString());
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public OpResultDTO add(UserDTO userDTO) {
        OpResultDTO opResult = new OpResultDTO();
        try {
            opResult.setIntResult(userService.add(userDTO));
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return opResult;
    }
    @RequestMapping(value = "/repetition",method = RequestMethod.POST)
    public OpResultDTO repetite(UserDTO userDTO)
    {
        OpResultDTO opResult = new OpResultDTO();
        try{
            opResult.setIntResult(userService.repetite(userDTO));
            if(opResult.getIntResult() != null)
            {
                opResult.setStrResult("Repetite");
            }
            else
            {
                opResult.setStrResult("NoRepetite");
            }
        }catch (Exception e){
            logger.error(e.toString());
        }
        return opResult;
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Object login(LoginDTO loginDTO, HttpSession session){
        String verifyCode = (String) session.getAttribute("randomCode");
        LoginDTO loginDTOResult;
        OpResultDTO opResult = new OpResultDTO();
        Object res = null;
        try{
            if(!loginDTO.isAdministrator_login()) {//判断是否为管理员
                if (loginDTO.getVerifyCode().equals(verifyCode))//验证码通过
                {
                    loginDTOResult = userService.login(loginDTO);
                    if (loginDTOResult != null)//账户密码正确
                    {
                        if (loginDTOResult.getUserStatus() == 1) {
                            res = CommonUtil.ajaxReturn("Success");
                            session.setAttribute("loginId",loginDTOResult.getUserId());
                            session.setAttribute("loginPhone", loginDTO.getUserPhone());
                            session.setAttribute("loginType", loginDTOResult.getUserType());
                            session.setAttribute("loginName",loginDTOResult.getUserName());
                            //System.out.println(loginDTO.getUserName());
                        } else if (loginDTOResult.getUserStatus() == 2) {
                            res = CommonUtil.ajaxReturn(400,"账号审核未通过！请联系管理员!");
                        } else if (loginDTOResult.getUserStatus() == 0) {
                            res = CommonUtil.ajaxReturn(400,"账号尚未审核！请联系管理员!");
                        }
                    } else {
                        res = CommonUtil.ajaxReturn(400,"用户名或密码错误！请重新输入！");
                    }
                } else {
                    res = CommonUtil.ajaxReturn(400,"验证码错误！请重新输入!");
                }
            }else{
                if (loginDTO.getVerifyCode().equals(verifyCode))//验证码通过
                {
                    //loginDTOResult2 = userService.login(loginDTO);
                    if(loginDTO.getUserPhone().equals("13999999999")&&loginDTO.getUserPwd().equals("4e0ec1d450a7ccb8dab79e1e62107589")){
                        res = CommonUtil.ajaxReturn("Success");
                        session.setAttribute("loginPhone", "13999999999");
                        session.setAttribute("loginType", "1");
                        session.setAttribute("loginName","admin");
                        session.setAttribute("loginId",1);
                    }
                    else
                    {
                         res = CommonUtil.ajaxReturn(400,"用户名或密码错误！请重新输入！");
                    }
                }
                else
                {
                    res = CommonUtil.ajaxReturn(400,"验证码错误！请重新输入!");
                }
            }
        }catch (Exception e){
            logger.error(e.toString());
        }
        return res;
    }

    @RequestMapping("/getUnpassedUser")
    public TableRspDTO getUnpassedUser(TableReqDTO tableReqDTO){
        List<UserDTO> unpassedUser = userService.getUnpassedUser(tableReqDTO);
        TableRspDTO tableRspDTO = new TableRspDTO();
        tableRspDTO.setListTable(userService.getUnpassedUser(tableReqDTO));
        tableRspDTO.setTotal(userService.countUser());
        return tableRspDTO;
    }

    @RequestMapping("/updateUserStatus")
    public OpResultDTO updateUserStatus(UserDTO userDTO){
        System.out.println(userDTO);
        Integer res = userService.updateUserStatus(userDTO);
        OpResultDTO opResultDTO = new OpResultDTO();
        Integer status = userDTO.getUserStatus();
        if(status==1||status==2){
            if (res!=0){
                opResultDTO.setStrResult("已更新用户状态!");
            }else {
                opResultDTO.setStrResult("更新失败,请重试!");
                opResultDTO.setCode(400);
            }
        }else{
            opResultDTO.setStrResult("输入错误!");
            opResultDTO.setCode(400);
        }
        return opResultDTO;
    }

    @RequestMapping("/logOut")
    public void logOut(HttpSession session){
        session.invalidate();
    }

    @RequestMapping("/username")
    public  OpResultDTO userName(HttpSession session){
        OpResultDTO opResultDTO = new OpResultDTO();
        opResultDTO.setStrResult((String)session.getAttribute("loginName"));
        return opResultDTO;
    }
}
