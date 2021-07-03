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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

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

        req.getRequestDispatcher("addSation.jsp").forward(req, resp);
    }
}
