package se.zust.badgateway.controller;

import se.zust.badgateway.controller.base.BaseServlet;
import se.zust.badgateway.pojo.DO.UserDO;
import se.zust.badgateway.pojo.DTO.UserDTO;
import se.zust.badgateway.service.UserService;
import se.zust.badgateway.util.BeanUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * @author zhu
 */
@WebServlet("users/*")
public class UserServlet extends BaseServlet {
    /**
     * 注册用户
     */
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        UserDTO userDTO = BeanUtils.Request2Bean(req,UserDTO.class);

        if (UserService.getInstance().register(userDTO)) {
            req.setAttribute("info", "success");
            resp.sendRedirect("/login.jsp");
        } else {
            req.setAttribute("info","error");
            req.getRequestDispatcher("/regist.jsp").forward(req,resp);
        }

    }

    /**
     * 添加用户
     */
    protected void post(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        UserDTO userDTO = BeanUtils.Request2Bean(req,UserDTO.class);

        if (UserService.getInstance().register(userDTO)) {
            ServletContext servletContext = req.getServletContext();
            servletContext.setAttribute("userDOList", UserService.getInstance().listUser());
            req.setAttribute("info", "success");
            resp.sendRedirect("/adminHome/adminHome.jsp");
        } else {
            req.setAttribute("info","error");
            req.getRequestDispatcher("/adminHome/adminHome.jsp").forward(req,resp);
        }

    }

    /**
     * 删除用户
     */
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        System.out.println(id);
        UserService.getInstance().deleteUser(id);

        req.setAttribute("info", "success");

        ServletContext servletContext = req.getServletContext();
        servletContext.setAttribute("userDOList", UserService.getInstance().listUser());

        req.getRequestDispatcher("/adminHome/adminHome.jsp").forward(req, resp);
    }

    /**
     * 修改用户
     */
    protected void put(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDO userDO = BeanUtils.Request2Bean(req, UserDO.class);

        if (UserService.getInstance().updateUser(userDO)) {
            req.setAttribute("info", "success");
            ServletContext servletContext = req.getServletContext();
            servletContext.setAttribute("userDOList", UserService.getInstance().listUser());
        } else {
            req.setAttribute("info", "error");
        }

        req.getRequestDispatcher("/adminHome/adminHome.jsp").forward(req, resp);
    }

    /**
     * 查询用户
     */
    protected void get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserDO> userDOList = UserService.getInstance().listUser();

        req.setAttribute("userDOList", userDOList);

        req.getRequestDispatcher("/adminHome/adminHome.jsp").forward(req, resp);
    }
}


