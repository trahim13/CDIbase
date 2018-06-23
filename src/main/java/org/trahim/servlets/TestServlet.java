package org.trahim.servlets;

import org.trahim.annototions.StudentPerson;
import org.trahim.annototions.WorkerPerson;
import org.trahim.beans.disposes.Car;
import org.trahim.beans.interfaces.Person;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/test")
public class TestServlet extends HttpServlet {

    @Inject
    @WorkerPerson
    private Person worker;


    @Inject
    @StudentPerson
    private Person student;

    @Inject
    private Person policemen;

    //For example
    //    @Inject
//    public void setStudent(Student student) {
//        this.student = student;
//    }
//
//    @Inject
//    public TestServlet(Student student) {
//        this.student = student;
//    }
//
//    public TestServlet() {
//    }

    @Inject
    private String msg;

    @Inject
    private int anInt;

    @Inject
    private double aDouble;

    @Inject
    private Car car;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.write("<p>"+worker.toString()+"</p>");
        writer.write("<p>"+"The name is  - " + worker.getName()+"</p>");


        writer.write("<p>"+student.toString()+"</p>");
        writer.write("<p>"+"The name is  - " + student.getName()+"</p>");


        writer.write("<p>"+policemen.toString()+"</p>");
        writer.write("<p>"+"The name is  - " + policemen.getName()+"</p>");

        writer.write("<p>"+msg+ " " + aDouble+" " + anInt + "</p>");
        writer.write("<p>"+car.getName()+"</p>");
    }
}
