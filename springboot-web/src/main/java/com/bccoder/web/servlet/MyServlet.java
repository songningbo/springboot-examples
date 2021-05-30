package com.bccoder.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/servlet")
public class MyServlet extends HttpServlet {
    public MyServlet(){
        System.out.println("my servlet class");
    }
    protected void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException{
        System.out.println("servlet service method");
    }
}
