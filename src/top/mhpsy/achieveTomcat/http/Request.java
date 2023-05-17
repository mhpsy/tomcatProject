package top.mhpsy.achieveTomcat.http;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class Request {

    private InputStream inputStream;// 输入流

    private String Method;// 请求方法

    private String url;// 请求路径

    private HashMap<String, String> parameterMap = new HashMap<>();// 请求参数

    public Request(InputStream inputStream) {
        this.inputStream = inputStream;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        System.out.println("request init");
        try {
            String requestLine = bufferedReader.readLine();
            String[] split = requestLine.split(" ");
            this.Method = split[0];

            int i = split[1].indexOf("?");
            if (i == -1) {
                this.url = split[1];
            } else {
                this.url = split[1].substring(0, i);
                String parameter = split[1].substring(i + 1);
                String[] parameterVal = parameter.split("&");

                for (String s : parameterVal) {
                    String[] val = s.split("=");
                    parameterMap.put(val[0], val[1]);
                    if (parameterVal.length == 2) {
                        System.out.println(val[0] + " : " + val[1]);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("request err");
        }


    }

    public String getMethod() {
        return Method;
    }

    public void setMethod(String method) {
        Method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HashMap<String, String> getParameterMap() {
        return parameterMap;
    }

    public void setParameterMap(HashMap<String, String> parameterMap) {
        this.parameterMap = parameterMap;
    }

    public String getParameter(String name) {
        return parameterMap.getOrDefault(name, "");
    }

}
