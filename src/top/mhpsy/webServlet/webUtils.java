package tom.mhpsy.webServlet;

import javax.servlet.ServletContext;

public class webUtils {
    public static int visitCount(ServletContext servletContext) {
        Object visitCount = servletContext.getAttribute("visitCount");
        if (visitCount != null) {
            servletContext.setAttribute("visitCount", 1);
            return 1;
        } else {
            servletContext.getAttribute("visitCount");
        }

    }
}
