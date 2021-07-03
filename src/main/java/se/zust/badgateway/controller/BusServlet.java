package se.zust.badgateway.controller;

import se.zust.badgateway.controller.base.BaseServlet;
import se.zust.badgateway.pojo.DO.BusDO;
import se.zust.badgateway.pojo.DTO.BusDTO;
import se.zust.badgateway.service.BusService;
import se.zust.badgateway.service.UserService;
import se.zust.badgateway.util.BeanUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author zhu
 */
@WebServlet("buses/*")
public class BusServlet extends BaseServlet {
    /**
     * 新增车辆
     */
    protected void post(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BusDTO busDTO = BeanUtils.Request2Bean(req, BusDTO.class);

        if (BusService.getInstance().insertBus(busDTO)) {
            req.setAttribute("info", "success");
            ServletContext servletContext = req.getServletContext();
            servletContext.setAttribute("busDOList", BusService.getInstance().listBus());
        } else {
            req.setAttribute("info", "error");
        }

        req.getRequestDispatcher("/adminHome/busManage.jsp").forward(req, resp);
    }

    /**
     * 删除车辆
     */
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        BusService.getInstance().deleteBus(id);

        ServletContext servletContext = req.getServletContext();
        servletContext.setAttribute("busDOList", BusService.getInstance().listBus());

        req.setAttribute("info", "success");

        req.getRequestDispatcher("/adminHome/busManage.jsp").forward(req, resp);
    }

    /**
     * 修改车辆
     */
    protected void put(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BusDO busDO = BeanUtils.Request2Bean(req, BusDO.class);
        System.out.println(busDO);
/*********************/
        if (BusService.getInstance().updateBus(busDO)) {
            req.setAttribute("info", "success");
            ServletContext servletContext = req.getServletContext();
            servletContext.setAttribute("busDOList", BusService.getInstance().listBus());
        } else {
            req.setAttribute("info", "error");
        }

        req.getRequestDispatcher("/adminHome/busManage.jsp").forward(req, resp);
    }

    /**
     * 查询车辆
     */
    protected void get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BusDO> busDOList = BusService.getInstance().listBus();

        req.setAttribute("busDOList", busDOList);

        req.getRequestDispatcher("/adminHome/busManage.jsp").forward(req, resp);
    }
}
