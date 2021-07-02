package se.zust.badgateway.controller;

import se.zust.badgateway.controller.base.BaseServlet;
import se.zust.badgateway.service.StationService;
import se.zust.badgateway.pojo.DO.StationDO;
import se.zust.badgateway.util.BeanUtils;

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
@WebServlet("stations/*")
public class StationServlet extends BaseServlet {
    protected void post(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StationDO stationPo = BeanUtils.Request2Bean(req, StationDO.class);
        StationService stationService = new StationService();
        boolean i = stationService.addStation(stationPo);
        req.getRequestDispatcher("addSation.jsp").forward(req,resp);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    protected void put(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    protected void get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = req.getServletPath();
        String eUrl = url.substring(url.lastIndexOf("/")+1);
        StationService stationService = new StationService();
        List<StationDO> stationList = stationService.allStation();
        HttpSession session = req.getSession();
        session.setAttribute("stationList",stationList);
        req.getRequestDispatcher("/UserHome.jsp").forward(req,resp);
    }
}
