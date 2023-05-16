package top.mhpsy.webServlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(urlPatterns = "/servletConfig_1", initParams = {
//        @WebInitParam(name = "username", value = "xxxx"),
//        @WebInitParam(name = "password", value = "123456")
//})
public class servletConfig_1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig servletConfig = getServletConfig();
        String username = servletConfig.getInitParameter("username");
        System.out.println("ServletConfig:" + username);
        ServletContext servletContext = servletConfig.getServletContext();
        System.out.println("ServletContext:" + servletContext.getInitParameter("username"));
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print("ServletConfig:" + username + "<br>");
        writer.print("ServletContext:" + servletContext.getInitParameter("username") + "<br>");
        writer.print("<h1>" + webUtils.visitCount(servletContext) + "</h1>");
        writer.print("<h1> servletCon我就是要试一试中文text.getContextPath():" + servletContext.getContextPath() + "</h1>");
        writer.print("<h1> servletContext.getRealPath(\"/\"):" + servletContext.getRealPath("/") + "</h1>");
        writer.print("<h1> servletContext.getServletContextName():" + servletContext.getServletContextName() + "</h1>");
        writer.print("<h1> servletContext.getServerInfo():" + servletContext.getServerInfo() + "</h1>");
        webUtils.closeWriter(writer);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
