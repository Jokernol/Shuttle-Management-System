package se.zust.badgateway.util;


import com.mysql.cj.AbstractQuery;
import se.zust.badgateway.Service.StationService;
import se.zust.badgateway.control.StationServlet;
import se.zust.badgateway.pojo.po.StationPO;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@WebListener
public class Listener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        StationService stationService = new StationService();
        List<StationPO> stationList = stationService.allStation();
        servletContextEvent.getServletContext().setAttribute("stationList",stationList);
    }
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }

}

