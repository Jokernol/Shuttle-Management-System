package se.zust.badgateway.controller;

import se.zust.badgateway.controller.base.BaseServlet;
import se.zust.badgateway.pojo.DO.UserDO;
import se.zust.badgateway.pojo.DTO.LoginDTO;
import se.zust.badgateway.service.SessionService;
import se.zust.badgateway.service.UserService;
import se.zust.badgateway.util.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author zhu
 */
@WebServlet("sessions/*")
public class SessionServlet extends BaseServlet {
    /**
     * 登陆
     */
    protected void post(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginDTO loginDTO = BeanUtils.Request2Bean(req, LoginDTO.class);

        HttpSession httpSession = req.getSession();

        if (loginDTO != null) {
            UserDO userDO = SessionService.getInstance().getUserByUserName(loginDTO.getUsername());

            int result = SessionService.getInstance().login(loginDTO);
            switch (result) {
                case 0:
                    httpSession.setAttribute("userDO", userDO);
                    req.getRequestDispatcher("/index.jsp").forward(req, resp);
                    break;
                case 1:
                    httpSession.setAttribute("userDO", userDO);
                    req.getRequestDispatcher("/index.jsp").forward(req, resp);
                    break;
                default:
                    req.setAttribute("info", "error");
                    break;
            }
        }
    }

    /**
     * 登出
     */
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        httpSession.invalidate();

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
