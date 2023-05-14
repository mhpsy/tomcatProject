package top.mhpsy.requestForward;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class checkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("checkServlet");
        Object payMoney = req.getAttribute("payMoney");
        int i = Integer.parseInt(String.valueOf(payMoney));
        System.out.println("checkServlet: " + i);
        if (i > 100) {
            resp.sendRedirect(getServletContext().getContextPath() + "/success.html");
        } else {
            resp.sendRedirect(getServletContext().getContextPath() + "/pay.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
