package org.trahim.beans;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

@WebServlet(urlPatterns = "/scope")
public class Scope extends HttpServlet {

    @Inject
    private MyDependentBean bean;
    @Inject
    private ChangeMyDependentBean changeBean;

    @Inject
    private ConversationBean conversationBean;


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        bean.setI(5);
        changeBean.changeI();
        writer.write(bean.getI() + " Dependent bean value i - " + changeBean.getBean().getI());


        writer.write(" CONVERSATION ");

        writer.write(conversationBean.getValue() + " "); //0


        conversationBean.setValue(10);
        writer.write(conversationBean.getValue() + " "); //10


        conversationBean.startConversation();
        writer.write(" Start conversation: "+ conversationBean.getValue()); //9




        conversationBean.setValue(30);
        writer.write(" " + conversationBean.getValue() + " "); //30


        conversationBean.endConversation();
        writer.write(" " +"End conversation: "+ conversationBean.getValue() + " "); //30





    }
}


//@ApplicationScoped //singleton
//@SessionScoped     //singleton
//@RequestScoped     //singleton
//@ConversationScoped
@Dependent
        //prototype
class MyDependentBean implements Serializable {
    private int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}

class ChangeMyDependentBean {
    @Inject
    private MyDependentBean bean;

    public void changeI() {
        bean.setI(10);
    }

    public MyDependentBean getBean() {
        return bean;
    }
}

@ConversationScoped
class ConversationBean implements Serializable {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Inject
    Conversation conversation;

    public void startConversation() {
        conversation.begin();
        value = 9;
    }

    public void endConversation() {
        conversation.end();
    }

}
