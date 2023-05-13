package top.mhpsy.webServlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;


public class servletConfig_3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();//获取请求的资源路径
        StringBuffer requestURL = req.getRequestURL();//获取请求的统一资源定位符（绝对路径）
        String remoteAddr = req.getRemoteAddr();//获取客户端的ip地址
        String remoteHost = req.getRemoteHost();//获取客户端的主机名
        int remotePort = req.getRemotePort();//获取客户端的端口号
        String remoteUser = req.getRemoteUser();//获取客户端的用户名
        String header = req.getHeader("User-Agent");//获取客户端的浏览器
        String method = req.getMethod();//获取请求的方式
        String contextPath = req.getContextPath();//获取请求的工程路径
        String servletPath = req.getServletPath();//获取请求的Servlet路径
        String queryString = req.getParameter("like");//获取请求的参数
        String[] likes = req.getParameterValues("likes");//获取请求的参数
        System.out.println("requestURI:" + requestURI);
        System.out.println("requestURL:" + requestURL);
        System.out.println("remoteAddr:" + remoteAddr);
        System.out.println("remoteHost:" + remoteHost);
        System.out.println("remotePort:" + remotePort);
        System.out.println("remoteUser:" + remoteUser);
        System.out.println("header:" + header);
        System.out.println("method:" + method);
        System.out.println("contextPath:" + contextPath);
        System.out.println("servletPath:" + servletPath);
        System.out.println("queryString:" + queryString);
        System.out.println("likes:" + Arrays.toString(likes));
        ServletContext servletContext = getServletContext();
    }
}
