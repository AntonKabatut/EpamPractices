package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ListOfUsers")
public class ListOfUsers extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List users;
        if (req.getSession().getAttribute("users")==null){
            users=new ArrayList<>();
            req.getSession().setAttribute("users",users);
        } else {
            users=(List) req.getSession().getAttribute("users");
        }

        users.add(req.getParameter("user"));
        resp.sendRedirect("/ListOfUsers");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("list",req.getSession().getAttribute("users"));
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/listOfUsers.jsp");
        requestDispatcher.forward(req,resp);

    }
}
