package controller;

import entity.Sport;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/voting")
public class SportsVoting extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getSession().getAttribute("user") == null) {
            List<String> votedUsers = new ArrayList<>();
            req.getSession().setAttribute("user", votedUsers);
            votedUsers.add(req.getParameter("user"));
            logic(req, resp);
        } else {
            List list = (List) req.getSession().getAttribute("user");
            if (list.contains(req.getParameter("user"))) {
                req.setAttribute("error", "you had already voted");
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
                requestDispatcher.forward(req, resp);
            } else {
                list.add(req.getParameter("user"));
                logic(req, resp);
            }
        }
    }

    private void logic(HttpServletRequest req, HttpServletResponse resp) {
        ServletContext servletContext = getServletContext();
        Object o = servletContext.getAttribute("map");
        Map map = (Map) o;
        Object[] objects = req.getParameterMap().values().toArray();
        Object[] o1 = (Object[]) objects[0];
        Sport sport = (Sport) map.get(o1[0]);
        int integer = sport.getCountOfVoices();
        integer++;
        sport.setCountOfVoices(integer);
        sport.getUsers().add(req.getParameter("user"));

        req.setAttribute("map", map);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/votingRes.jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

}
