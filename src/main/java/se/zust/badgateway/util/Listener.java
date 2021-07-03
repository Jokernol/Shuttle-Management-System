package se.zust.badgateway.util;
    import se.zust.badgateway.pojo.DO.StationDO;
    import se.zust.badgateway.service.RosterService;
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


        servletContextEvent.getServletContext().setAttribute("stationList", StationService.getInstance().allStation());
        System.out.print("map坐标初始化");

        servletContextEvent.getServletContext().setAttribute("rosterList",RosterService.getInstance().listRoster());
        System.out.print("预约列表初始化");

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
