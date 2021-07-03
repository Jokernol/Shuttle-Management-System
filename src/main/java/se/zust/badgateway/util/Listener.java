package se.zust.badgateway.util;
    import se.zust.badgateway.pojo.DO.StationDO;
    import se.zust.badgateway.service.*;

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

        servletContextEvent.getServletContext().setAttribute("userDOList", UserService.getInstance().listUser());
        servletContextEvent.getServletContext().setAttribute("busDOList", BusService.getInstance().listBus());
        servletContextEvent.getServletContext().setAttribute("driverDOList", DriverService.getInstance().listDriver());
        servletContextEvent.getServletContext().setAttribute("stationList", StationService.getInstance().allStation());
        servletContextEvent.getServletContext().setAttribute("rosterDOList",RosterService.getInstance().listRoster());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
