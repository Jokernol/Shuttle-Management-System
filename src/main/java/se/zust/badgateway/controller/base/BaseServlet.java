package se.zust.badgateway.controller.base;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;

/**
 * @author 王怀瑾
 */
public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestUrl = req.getHeader("referer");

        String url = req.getRequestURI();
        String methodName = url.split("/")[2];
        String url2 = requestUrl.split("/")[4];
        String url1 = requestUrl.split("/")[3];

        try {
            Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.setAccessible(true);
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {

            String info = "操作错误";
            resp.sendRedirect("/"+url1+"/"+url2+"?info1="+ URLEncoder.encode(info, "utf-8"));
            System.out.print("方法执行出错");

            e.printStackTrace();

        }
    }
}
