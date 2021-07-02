package se.zust.badgateway.controller;

import se.zust.badgateway.controller.base.BaseServlet;
import se.zust.badgateway.pojo.DO.DriverDO;
import se.zust.badgateway.pojo.DO.UserDO;
import se.zust.badgateway.pojo.DTO.DriverDTO;
import se.zust.badgateway.service.DriverService;
import se.zust.badgateway.service.UserService;
import se.zust.badgateway.util.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 韩成峰
 */
@WebServlet("drivers/*")
public class DriverServlet extends BaseServlet {
    /**
     * 添加司机信息
     */
    protected void post(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DriverDTO driverDTO= BeanUtils.Request2Bean(req,DriverDTO.class);

        if(DriverService.getInstance().insertDriver(driverDTO)) {
            req.setAttribute("info", "success");
        } else {
            req.setAttribute("info", "error");
        }

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    /**
     * 删除司机信息
     */
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        DriverService.getInstance().deleteDriver(id);

        req.setAttribute("info", "success");

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    /**
     * 修改司机信息
     */
    protected  void put(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        DriverDO driverDO = BeanUtils.Request2Bean(req, DriverDO.class);

        if(DriverService.getInstance().updateDriver(driverDO)) {
            req.setAttribute("info", "success");
        } else {
            req.setAttribute("info", "error");
        }

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    /**
     * 查询司机信息
     */
    protected void get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<DriverDO> driverDOList = DriverService.getInstance().listDriver();

        req.setAttribute("driverDOList", driverDOList);

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

}
