package se.zust.badgateway.controller;

import se.zust.badgateway.pojo.DO.RosterDO;
import se.zust.badgateway.pojo.DO.StationDO;
import se.zust.badgateway.service.Impl.RosterService;
import se.zust.badgateway.util.BeanUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
@WebServlet("/Roster.do")
public class RosterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RosterDO rosterDO = BeanUtils.Request2Bean(req,RosterDO.class);
        RosterService rosterService = new RosterService();
        List<RosterDO> rosterList = rosterService.addRoster(rosterDO);
        ServletContext servletContext = req.getServletContext();
        servletContext.setAttribute("rosterList", rosterList);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        RosterService rosterService = new RosterService();
        List<RosterDO> rosterList = rosterService.deleteRoster(id);
        ServletContext servletContext = req.getServletContext();
        servletContext.setAttribute("rosterList", rosterList);
    }
}
