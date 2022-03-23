package com.nit.ssm.utils;

import java.util.HashMap;

public class CommonUtil {

    public static Object ajaxReturn(Object data,int errCode,String errMsg){
        HashMap<String, Object> res = new HashMap<>();
        res.put("data",data);
        res.put("errCode",errCode);
        res.put("errMsg",errMsg);
        return res;
    }

    public static Object ajaxReturn(Object data){
        return ajaxReturn(data,200,"");
    }

    public static Object ajaxReturn(int errCode,String errMsg){
        return ajaxReturn("",errCode,errMsg);
    }
}
