package se.zust.badgateway.controller;

import se.zust.badgateway.pojo.DTO.RegisterDTO;
import se.zust.badgateway.pojo.DTO.LoginDTO;
import se.zust.badgateway.service.Impl.UserServiceImpl;
import se.zust.badgateway.util.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * @author 韩成峰
 */
public class UserServlet extends HttpServlet {
    /**
     * 查询用户
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }

    /**
     * 修改用户
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    }

    /**
     * 添加用户
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        RegisterDTO registerDTO = BeanUtils.Request2Bean(req,RegisterDTO.class);
    }
}


