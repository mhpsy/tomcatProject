package top.mhpsy.achieveTomcat;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import top.mhpsy.achieveTomcat.handleRunServlet.HandleRunServlet;
import top.mhpsy.achieveTomcat.servlet.ServletLu;

import javax.servlet.Filter;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class tomcatMain {

    public static final ConcurrentHashMap<String, ServletLu>
            servletMapping = new ConcurrentHashMap<String, ServletLu>();


    //2容器 servletUrlMapping
    // -ConcurrentHashMap
    // -HashMap
    // key                    - value
    // url-pattern       ServletName

    public static final ConcurrentHashMap<String, String>
            servletUrlMapping = new ConcurrentHashMap<>();


    //你可以这里理解session, tomcat还维护一个容器
    public static final ConcurrentHashMap<String, HttpSession>
            sessionMapping = new ConcurrentHashMap<>();


    //你可以这里理解filter, tomcat还维护了filter的容器
    public static final ConcurrentHashMap<String, String>
            filterUrlMapping = new ConcurrentHashMap<>();

    public static final ConcurrentHashMap<String, Filter>
            filterMapping = new ConcurrentHashMap<>();


    public static void main(String[] args) {
        try {
            new tomcatMain().init();
            ServerSocket serverSocket = new ServerSocket(9999);
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                new Thread(new HandleRunServlet(socket)).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //直接对两个容器进行初始化
    public void init() {
        //读取web.xml => dom4j =>
        //得到web.xml文件的路径 => 拷贝一份.
        String path = Objects.requireNonNull(this.getClass().getResource("/")).getPath();
        //System.out.println("path= " + path);
        //使用dom4j技术完成读取
        SAXReader saxReader = new SAXReader();
        //困难->真的掌握
        try {
            Document document = saxReader.read(new File(path + "web.xml"));
            System.out.println("document= " + document);
            //得到根元素
            Element rootElement = document.getRootElement();
            //得到根元素下面的所有元素
            List<Element> elements = rootElement.elements();
            //遍历并过滤到 servlet servlet-mapping
            for (Element element : elements) {
                if ("servlet".equalsIgnoreCase(element.getName())) {
                    //这是一个servlet配置
                    //System.out.println("发现 servlet");
                    //使用反射将该servlet实例放入到servletMapping
                    Element servletName = element.element("servlet-name");
                    Element servletClass = element.element("servlet-class");
                    ServletLu put = servletMapping.put(servletName.getText(),
                            (ServletLu) Class.forName(servletClass.getText().trim()).newInstance());
                } else if ("servlet-mapping".equalsIgnoreCase(element.getName())) {
                    //这是一个servlet-mapping
                    //System.out.println("发现 servlet-mapping");
                    Element servletName = element.element("servlet-name");
                    Element urlPatter = element.element("url-pattern");
                    servletUrlMapping.put(urlPatter.getText(), servletName.getText());

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
