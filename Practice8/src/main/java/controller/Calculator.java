package controller;

import service.CountingService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calculator")
public class Calculator extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String number1 = req.getParameter("number1");
        String number2 = req.getParameter("number2");
        String operation = req.getParameter("operation");

        int result = CountingService.counting(number1, number2, operation);

        req.setAttribute("result", result);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/calculateRes.jsp");
        requestDispatcher.forward(req, resp);

    }
}
