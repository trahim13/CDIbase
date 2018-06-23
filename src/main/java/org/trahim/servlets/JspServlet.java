package org.trahim.servlets;

import org.trahim.annototions.WorkerPerson;
import org.trahim.beans.Worker;
import org.trahim.beans.interfaces.Person;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/jsp")
public class JspServlet extends HttpServlet {
    @Inject
    @WorkerPerson
    Worker worker;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/myJSP.jsp");
        requestDispatcher.forward(req, resp);
    }
}
