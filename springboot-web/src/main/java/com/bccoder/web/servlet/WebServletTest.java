package com.bccoder.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/a","/b"},name = "test WebServlet",loadOnStartup=-1
        ,initParams = {@WebInitParam(name="c",value = "ctest")},asyncSupported = false)
public class WebServletTest extends HttpServlet {
    public WebServletTest(){
        System.out.println("web servlet class");
    }
    protected void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        System.out.println("web servlet service method");
    }
}
