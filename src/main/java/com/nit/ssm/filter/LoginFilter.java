package com.nit.ssm.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

//@WebFilter(filterName = "LoginFilter",urlPatterns = {"/pages/*"})
public class LoginFilter implements Filter {

    //标示符：表示当前用户未登录(可根据自己项目需要改为json样式)
    String NO_LOGIN = "您还未登录";

    //不需要登录就可以访问的路径(比如:注册登录等)
    String[] includeUrls = new String[]{"/pages/loginelement.html","/pages/register.html","/pages/garbage.html"};


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
        } else { //需要过滤器
            // session中包含user对象,则是登录状态
            if(session!=null&&session.getAttribute("loginPhone") != null){
                System.out.println("user:"+session.getAttribute("loginPhone"));
                filterChain.doFilter(request, response);
            }else{
                String requestType = request.getHeader("X-Requested-With");
                //判断是否是ajax请求
                if(requestType!=null && "XMLHttpRequest".equals(requestType)){
                    response.getWriter().write(this.NO_LOGIN);
                }else{

                        response.setCharacterEncoding("utf-8");
                        response.setContentType("text/html;charset=UTF-8");
                        PrintWriter out = response.getWriter();
                        if(uri.indexOf("/pages/Question")!=-1 || uri.indexOf("/pages/Manager")!=-1){
                            out.println("<script language=javascript>" +
                                    "alert('尚未登录,正在为您跳转到登录界面！');" +
                                    "setTimeout(function () {" +
                                    "location.href = '../loginelement.html';" +
                                    "},1000);"+
                                    "</script>");
                        }else{
                            out.println("<script language=javascript>" +
                                    "alert('尚未登录,正在为您跳转到登录界面！');" +
                                    "setTimeout(function () {" +
                                    "location.href = 'loginelement.html';" +
                                    "},1000);"+
                                    "</script>");
                        }

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
            if(includeUrl.indexOf(uri) != -1) {
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
