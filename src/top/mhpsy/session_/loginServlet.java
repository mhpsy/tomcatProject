package top.mhpsy.session_;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class loginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("loginServlet");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession();
        Object username1 = session.getAttribute("username");
        Object password1 = session.getAttribute("password");

        if (
                username1 != null && password1 != null
                        && "xxx".equals(username1.toString()) && "xxx".equals(password1.toString())
        ) {

            resp.setCharacterEncoding("utf-8");
            PrintWriter writer = resp.getWriter();

            System.out.println("loginServlet: " + username1 + " " + password1);
            writer.println(new String("<h1>登录成功 1</h1>".getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8));

            return;
        }

        if ("xxx".equals(username) && "xxx".equals(password)) {
            HttpSession session1 = req.getSession();
            session1.setAttribute("username", username);
            session1.setMaxInactiveInterval(60 * 60 * 24 * 7);// 7 days
            session1.setAttribute("password", password);

//            resp.sendRedirect(getServletContext().getContextPath() + "/success.html");
            PrintWriter writer = resp.getWriter();
            writer.println("登录成功2");
        } else {
            resp.sendRedirect(getServletContext().getContextPath() + "/login.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
