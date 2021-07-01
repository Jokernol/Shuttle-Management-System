package se.zust.badgateway.control;

import se.zust.badgateway.Service.StationService;
import se.zust.badgateway.pojo.po.StationPO;
import se.zust.badgateway.util.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 王怀瑾
 */
@WebServlet("/station.do")
public class StationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = req.getServletPath();
        String eUrl = url.substring(url.lastIndexOf("/")+1);
        StationService stationService = new StationService();
        List<StationPO> stationList = stationService.allStation();
        HttpSession session = req.getSession();
        session.setAttribute("stationList",stationList);
        req.getRequestDispatcher("/UserHome.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StationPO stationPo=BeanUtils.Request2Bean(req,StationPO.class);
        StationService stationService = new StationService();
        boolean i = stationService.addStation(stationPo);
        req.getRequestDispatcher("addSation.jsp").forward(req,resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
