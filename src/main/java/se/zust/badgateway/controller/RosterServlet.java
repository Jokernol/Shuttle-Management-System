package se.zust.badgateway.controller;

import se.zust.badgateway.controller.base.BaseServlet;
import se.zust.badgateway.pojo.DO.RosterDO;
import se.zust.badgateway.service.RosterService;
import se.zust.badgateway.util.BeanUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author fang
 */
@WebServlet("rosters/*")
public class RosterServlet extends BaseServlet {

    protected void get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    protected void post(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RosterDO rosterDO = BeanUtils.Request2Bean(req, RosterDO.class);

        List<RosterDO> rosterList = RosterService.getInstance().addRoster(rosterDO);

        ServletContext servletContext = req.getServletContext();

        servletContext.setAttribute("rosterList", rosterList);

        req.getRequestDispatcher("adminHome.jsp").forward(req,resp);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        List<RosterDO> rosterList = RosterService.getInstance().deleteRoster(id);

        ServletContext servletContext = req.getServletContext();

        servletContext.setAttribute("rosterList", rosterList);

        req.getRequestDispatcher("adminHome.jsp").forward(req,resp);
    }
}
