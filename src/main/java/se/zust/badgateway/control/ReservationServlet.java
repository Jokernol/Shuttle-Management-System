package se.zust.badgateway.control;

import se.zust.badgateway.Service.RosterService;
import se.zust.badgateway.pojo.po.RosterPO;
import se.zust.badgateway.pojo.po.UserPO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author 王怀瑾
 */
@WebServlet("/reservation.do")
public class ReservationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RosterService rosterService = new RosterService();
        String positionName = req.getParameter("name");
        List<RosterPO> rosterList = rosterService.getRosterPo(positionName);
        req.setAttribute("rosterList",rosterList);
        req.getRequestDispatcher("userAppointment.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        RosterPO roster = (RosterPO)req.getAttribute("roster");
        UserPO user =(UserPO)session.getAttribute("User");
        RosterService rosterService = new RosterService();
        rosterService.AppointmentInformation(roster,user);

    }
}
