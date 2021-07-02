package se.zust.badgateway.controller;

import se.zust.badgateway.pojo.DO.AppointmentDO;
import se.zust.badgateway.pojo.DO.RosterDO;
import se.zust.badgateway.pojo.DO.UserDO;
import se.zust.badgateway.service.Impl.AppointmentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author 王怀瑾
 */
public class AppointmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String position = req.getParameter("position");
        AppointmentService appointmentService = new AppointmentService();
        List<RosterDO> rosterList =  appointmentService.getRoster(position);
        req.setAttribute("rosterList",rosterList);
        req.getRequestDispatcher("UserHome.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String AgreementNumber = req.getParameter("AgreementNumber");
        HttpSession session = req.getSession();
        UserDO user =(UserDO) session.getAttribute("UserDO");

    }
}
