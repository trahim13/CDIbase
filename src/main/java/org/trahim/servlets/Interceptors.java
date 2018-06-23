package org.trahim.servlets;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.InvocationContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/interceptors")
public class Interceptors extends HttpServlet {

    @Inject
    private MyInterceptBean bean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        bean.doJob1();
        bean.doJob2();
    }


}

class MyInterceptor {

    @AroundConstruct
    private void aroundMyConstructor(InvocationContext context)  {
        System.out.println("before constructor");
        try {
            context.proceed();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @PostConstruct
    private void postMyConstructor(InvocationContext context)  {
        System.out.println("post constructor");
        try {
            context.proceed();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    private void preDestroy() {
        System.out.println("predestroy");
    }

    @AroundInvoke
    private Object aroundMethod(InvocationContext context) throws Exception {
        System.out.println("before method");
        return context.proceed();
    }
}

@RequestScoped
@javax.interceptor.Interceptors({MyInterceptor.class})
class MyInterceptBean {

    public MyInterceptBean() {
    }

    public void doJob1() {
        System.out.println("do job one");
    }

    @ExcludeClassInterceptors
    public void doJob2() {
        System.out.println("do job two");
    }


}
