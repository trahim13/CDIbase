package org.trahim.servlets;

import javax.decorator.Delegate;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/decor")
public class Decorator extends HttpServlet {
    @Inject
    Original original;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = original.doJob();
        System.out.println(s);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/decorator.jsp");
        dispatcher.forward(req, resp);


    }
}


interface Original {
    String doJob();
}

class SameClass implements Original {
    @Override
    public String doJob() {
        return "Same class job.";
    }
}


@javax.decorator.Decorator
class MyDecorator implements Original {
    @Inject
    @Delegate
    Original original;

    @Override
    public String doJob() {
        StringBuilder msg = new StringBuilder("Decorator msg. ");
        msg.append(original.doJob());
        String str = msg.append(" Aftrer all work.").toString();
        return str;
    }
}