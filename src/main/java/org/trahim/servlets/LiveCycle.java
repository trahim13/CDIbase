package org.trahim.servlets;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/livecycle")
public class LiveCycle extends HttpServlet {

    @Inject
    LiveCycleBean bean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        bean.doJob1();

        bean.doJob2();
    }


}

class LiveCycleBean {

    public LiveCycleBean() {
        System.out.println("constructor.");
    }

    @PostConstruct
    private void postConstructor() {
        System.out.println("post constructor");
    }

    @PreDestroy
    private void preDestroy() {
        System.out.println("predestroy");
    }

    @AroundInvoke
    private void aroundInvoke() {
        System.out.println("before method");
    }


    public void doJob1() {
        System.out.println("do job one");
    }

    public void doJob2() {
        System.out.println("do job two");
    }
}
