package com.nit.ssm.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

//@WebFilter(filterName = "ManagerFilter",urlPatterns = {"/pages/*"})
public class ManagerFilter implements Filter {

    //标示符：表示当前用户未登录(可根据自己项目需要改为json样式)
    String NO_LOGIN = "不是管理员！";

    //不需要管理员就可以访问的路径(比如:注册登录等)
    String[] includeUrls = new String[]{"/pages/loginelement.html","/pages/register.html","/pages/garbage.html","/pages/Question/"};


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        String uri = request.getRequestURI();

        System.out.println("filter url:"+uri);
        //是否需要过滤
        boolean needFilter = isNeedFilter(uri);


        if (!needFilter) { //不需要过滤直接传给下一个过滤器
            filterChain.doFilter(servletRequest, servletResponse);
            //System.out.println("userType:"+session.getAttribute("loginType"));
        } else { //需要过滤器
            // session中包含user对象,则是登录状态
            if(session!=null&& session.getAttribute("loginType").toString().equals("1")){
                System.out.println("userType:"+session.getAttribute("loginType"));
                filterChain.doFilter(request, response);
            }else{//不是管理员
                String requestType = request.getHeader("X-Requested-With");
                //判断是否是ajax请求
                if(requestType!=null && "XMLHttpRequest".equals(requestType)){
                    response.getWriter().write(this.NO_LOGIN);
                }else{

                    response.setCharacterEncoding("utf-8");
                    response.setContentType("text/html;charset=UTF-8");
                    PrintWriter out = response.getWriter();
                    out.println("<script language=javascript>" +
                            "alert('您不是管理员！没有权限进入');" +
                            "setTimeout(function () {" +
                            "location.href = '../../index.html';" +
                            "},1000);"+
                            "</script>");
                }
                return;
            }
        }
    }

    /**
     * @Author: wl
     * @Description: 是否需要过滤
* @param uri
     */
    public boolean isNeedFilter(String uri) {

        for (String includeUrl : includeUrls) {
            if(uri.indexOf(includeUrl) != -1) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
