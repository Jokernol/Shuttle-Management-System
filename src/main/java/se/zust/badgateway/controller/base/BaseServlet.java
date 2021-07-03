package se.zust.badgateway.controller.base;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 王怀瑾
 */
public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        String url = req.getRequestURI();
        String methodName = url.split("/")[2];
        System.out.println(methodName);
        System.out.println(url);

        try {
            Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.setAccessible(true);
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {


            req.getRequestDispatcher("");
            System.out.print("方法执行出错");
            e.printStackTrace();
        }
    }
}
