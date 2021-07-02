package se.zust.badgateway.controller;

import se.zust.badgateway.pojo.DTO.LoginDTO;
import se.zust.badgateway.service.Impl.SessionServiceImpl;
import se.zust.badgateway.util.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author zhu
 */
@WebServlet("/sessions")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginDTO loginDTO = BeanUtils.Request2Bean(req, LoginDTO.class);
        if(loginDTO !=null) {
            int result = SessionServiceImpl.getInstance().login(loginDTO);
            switch (result) {
                case 0:
                    req.getRequestDispatcher("WEB-INF/adminHome.jsp").forward(req, resp);
                    break;
                case 1:
                    req.getRequestDispatcher("WEB-INF/userHome.jsp").forward(req, resp);
                    break;
                default:
                    req.setAttribute("info", "error");
                    break;
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        httpSession.invalidate();
    }
}
