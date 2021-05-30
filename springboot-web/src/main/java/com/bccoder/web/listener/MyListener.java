package com.bccoder.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyListener implements ServletContextListener {
    /**
     * 当Servlet 容器启动Web 应用时调用该方法。在调用完该方法之后，容器再对Filter 初始化，
     * 并且对那些在Web 应用启动时就需要被初始化的Servlet 进行初始化。
     * @param sce
     */
    public void contextInitialized(ServletContextEvent sce){
        System.out.println("context init");
    }

    /**
     * 当Servlet 容器终止Web 应用时调用该方法。在调用该方法之前，容器会先销毁所有的Servlet 和Filter 过滤器。
     * @param sce
     */
    public void contextDestroyed(ServletContextEvent sce){
        System.out.println("context destory");

    }
}
