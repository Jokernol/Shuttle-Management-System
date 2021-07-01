package se.zust.badgateway.control;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author 王怀瑾
 */
public class Basis extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url= req.getServletPath();
        System.out.print("file/dopost/\n");
        String methodName = url.substring(url.lastIndexOf("/")+1);
        Method method = null;
        try{
            method = getClass().getDeclaredMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this,req,resp);
        } catch (Exception e){
            System.out.println("file方法调用出错");
        }
    }
}
