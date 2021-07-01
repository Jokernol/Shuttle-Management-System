package se.zust.badgateway.controller;

import se.zust.badgateway.pojo.dto.RegisterDTO;
import se.zust.badgateway.pojo.dto.UserDTO;
import se.zust.badgateway.service.UserService;
import se.zust.badgateway.util.BeanUtils;

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
@WebServlet("/User")
public class UserServlet extends HttpServlet {
    UserService userService=new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        UserDTO userDTO = BeanUtils.Request2Bean(req,UserDTO.class);
        if(userDTO!=null){
            PrintWriter writer=res.getWriter();
            int result=userService.login(userDTO);
            switch (result){
                case 0:
                    req.getRequestDispatcher("WEB-INF/adminHome.jsp").forward(req,res);
                    break;
                case 1:
                    req.getRequestDispatcher("WEB-INF/userHome.jsp").forward(req,res);
                    break;
                case 2:
                    writer.write("2");
                    break;
                case 3:
                    writer.write("3");
                    break;
                default:
                    break;
            }
        }


    }
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RegisterDTO userDTO = BeanUtils.Request2Bean(req,RegisterDTO.class);
        if(userDTO!=null){
            int result=userService.regist(userDTO);
            PrintWriter writer=res.getWriter();
            switch (result) {
                case 0:
                    writer.write("0");
                    break;
                case 1:
                    writer.write("1");
                    break;
                default:
                    req.getRequestDispatcher("WEB-INF/userHome.jsp").forward(req, res);
                    break;
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        super.doPost(req, res);
    }

}


