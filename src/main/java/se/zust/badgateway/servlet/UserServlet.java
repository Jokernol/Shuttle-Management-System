package se.zust.badgateway.servlet;

import se.zust.badgateway.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 韩成峰
 */
@WebServlet(name = "UserServlet",urlPatterns = {"/User/*"},loadOnStartup = 1)
public class UserServlet extends HttpServlet {

    UserService userService;
    @Override
    public void init() throws ServletException {
        userService =(UserService)getServletContext().getAttribute("userService");
    }
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res){
        try {
        if(userService==null) {
            userService=(UserService)getServletContext().getAttribute("userService");
            PrintWriter out=res.getWriter();
            String uri = req.getRequestURI();
            String servletName = getServletName(uri);
            String servletMethod = getMethod(uri);
        }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public String getServletName(String uri){
        int end=uri.indexOf("/",2);
        String method="";
        if(end==-1) {
            method=uri.substring(1);
        }else {
            method=uri.substring(1,end);
        }
        return method;

    }
    public String getMethod(String uri){
        int start=uri.indexOf("/",2);
        int end=uri.indexOf("/",start+1);
        String method="";
        if(end==-1) {
            method=uri.substring(start+1);
        } else {
            method=uri.substring(start+1,end);
        }
        return method;
    }
}


