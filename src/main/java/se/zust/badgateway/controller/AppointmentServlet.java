package se.zust.badgateway.controller;

import org.apache.ibatis.session.SqlSession;
import se.zust.badgateway.controller.base.BaseServlet;
import se.zust.badgateway.mapper.AppointmentMapper;

import se.zust.badgateway.pojo.DO.AppointmentDO;

import se.zust.badgateway.pojo.DO.RosterDO;
import se.zust.badgateway.pojo.DO.UserDO;
import se.zust.badgateway.service.AppointmentService;
import se.zust.badgateway.util.MybatisUtils;

import javax.servlet.ServletContext;
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
@WebServlet("appointments/*")
public class AppointmentServlet extends BaseServlet {
    /**
     * 用户查看排班列表
     */
    protected void get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String position = req.getParameter("position");

        List<RosterDO> rosterListOfAddress = AppointmentService.getInstance().getRoster(position);

        System.out.println(rosterListOfAddress);

        HttpSession session = req.getSession();

        session.setAttribute("rosterListOfAddress",rosterListOfAddress);

        req.getRequestDispatcher("userHome.jsp").forward(req,resp);
    }

    /**
     *用户添加预约
     */
    protected void post(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String info;
        String rosterId = req.getParameter("rosterId");

        HttpSession session = req.getSession();

//        UserDO user =(UserDO) session.getAttribute("UserDO");
        UserDO user = new UserDO();
        user.setId("1");
        int i = AppointmentService.getInstance().addAppointment(user,rosterId);

        switch (i){
            case 0:
                info = "不能重复预约";
                req.setAttribute("info",info);
                break;
            case 1:
                info = "预约成功";
                req.setAttribute("info",info);
                break;
            case 2:
                info = "车辆已满";
                req.setAttribute("info",info);
                break;
            default:
                info = "error";
                req.setAttribute("info",info);
                break;
        }

        System.out.println(info);

        List<AppointmentDO> appointmentList = AppointmentService.getInstance().appointmentOfUser(user.getId());

        session.setAttribute("appointmentList",appointmentList);

        req.getRequestDispatcher("/userHome.jsp").forward(req,resp);
    }

    /**
     *用户删除排班
     */
    protected void delete(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {

        String rosterId = req.getParameter("rosterId");

        HttpSession session = req.getSession();
//        UserDO user = (UserDO)session.getAttribute("user");
        UserDO user = new UserDO();
        user.setId("1");
        AppointmentDO appointmentDO = new AppointmentDO(user.getId(),rosterId);
        AppointmentService.getInstance().deleteAppointment(appointmentDO);

        session.setAttribute("appointmentList",AppointmentService.getInstance().appointmentOfUser(appointmentDO.getUserId()));

//        req.getRequestDispatcher("userHome.jsp").forward(req,resp);

    }

}
