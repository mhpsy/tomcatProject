package top.mhpsy.webServlet;

import javax.servlet.ServletContext;
import java.io.PrintWriter;

public class webUtils {
    public static int visitCount(ServletContext servletContext) {
        Object visitCount = servletContext.getAttribute("visitCount");
        if (visitCount == null) {
            servletContext.setAttribute("visitCount", 1);
            return 1;
        } else {
            int count = Integer.parseInt(visitCount.toString());
            count++;
            servletContext.setAttribute("visitCount", count);
            return count;
        }
    }

    public static void closeWriter(PrintWriter writer) {
        if (writer != null) {
            writer.flush();
            writer.close();
        }
    }
}
