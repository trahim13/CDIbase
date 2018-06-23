package org.trahim.servlets;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/spec")
public class Specializes extends HttpServlet {
    @Inject
    private A a;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str = a.print();
    }
}

interface A {
    String print();
}

class B implements A {
    @Override
    public String  print() {
        return "B";
    }
}

@javax.enterprise.inject.Specializes
class C extends B {
    @Override
    public String print() {
        return "C";
    }
}


