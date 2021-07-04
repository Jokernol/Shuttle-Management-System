package se.zust.badgateway.controller;

import se.zust.badgateway.controller.base.BaseServlet;
import se.zust.badgateway.pojo.DO.StationDO;
import se.zust.badgateway.service.StationService;
import se.zust.badgateway.util.BeanUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author 王怀瑾
 */
@WebServlet("stations/*")
public class StationServlet extends BaseServlet {

    /**
     * 添加站点
     */
    protected void post(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StationDO stationPo = BeanUtils.Request2Bean(req, StationDO.class);

        StationService.getInstance().addStation(stationPo);

        ServletContext servletContext = req.getServletContext();

        servletContext.setAttribute("stationList",StationService.getInstance().allStation() );

        resp.sendRedirect("/adminHome/mapManage.jsp");

//        req.getRequestDispatcher("/adminHome/mapManage.jsp").forward(req, resp);

    }


    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String position = req.getParameter("position");

        StationService.getInstance().deleteStation(position);

        ServletContext servletContext = req.getServletContext();

        servletContext.setAttribute("stationList",StationService.getInstance().allStation() );

        resp.sendRedirect(req.getContextPath()+"/adminHome/mapManage.jsp");
//        req.getRequestDispatcher(req.getContextPath()+"/adminHome/mapManage.jsp").forward(req, resp);

    }}
