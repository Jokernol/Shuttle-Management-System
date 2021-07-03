package se.zust.badgateway.util;
    import se.zust.badgateway.pojo.DO.StationDO;
    import se.zust.badgateway.service.StationService;

    import javax.servlet.ServletContextEvent;
    import javax.servlet.ServletContextListener;
    import javax.servlet.annotation.WebListener;

    import java.util.List;

/**
 * @author 王怀瑾
 */

@WebListener
public class Listener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        StationService stationService = new StationService();
        List<StationDO> stationList = stationService.allStation();
        servletContextEvent.getServletContext().setAttribute("stationList", stationList);
        System.out.print("map坐标初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
