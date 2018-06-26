package controller;

import entity.User;
import service.DBManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Authorization")
public class Authorization extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager dbManager= DBManager.getInstance();
        String login=req.getParameter("login");
        String password=req.getParameter("password");
        List<User> users=dbManager.findUserByLoginAndPassword(login,password);

        if (users.size()>0){
            resp.sendRedirect("/Authorization");
        } else {
            req.setAttribute("error","Invalid Credentials");
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("/authorization.jsp");
            requestDispatcher.forward(req,resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/listOfUsers.jsp");
        requestDispatcher.forward(req,resp);
    }

}
