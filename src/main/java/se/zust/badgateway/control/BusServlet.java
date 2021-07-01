package se.zust.badgateway.control;

import se.zust.badgateway.Service.BusService;
import se.zust.badgateway.pojo.po.BusPO;
import se.zust.badgateway.util.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 王怀瑾
 */
@WebServlet("Bus")
public class BusServlet extends Basis {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BusPO bus = BeanUtils.Request2Bean(req,BusPO.class);
        BusService busService = new BusService();
        boolean i = busService.addBus(bus);
        String info;
        req.getRequestDispatcher("WEB-INF/Admin.jsp").forward(req,resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BusPO bus = BeanUtils.Request2Bean(req,BusPO.class);
        BusService busService = new BusService();


    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

}
