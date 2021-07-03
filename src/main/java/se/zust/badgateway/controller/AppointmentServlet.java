package se.zust.badgateway.controller;

import org.apache.ibatis.session.SqlSession;
import se.zust.badgateway.mapper.AppointmentMapper;

import se.zust.badgateway.pojo.DO.AppointmentDO;

import se.zust.badgateway.pojo.DO.UserDO;
import se.zust.badgateway.service.AppointmentService;
import se.zust.badgateway.util.MybatisUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * @author 王怀瑾
 */
public class AppointmentServlet extends HttpServlet {
    AppointmentService appointmentService = new AppointmentService();

    /**
     *
     * 用户查看车站列表
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String position = req.getParameter("position");

        updateAppointmentOfUser(req,resp);

        req.getRequestDispatcher("UserHome.jsp").forward(req,resp);
    }

    /**
     *用户添加排班
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String info;
        String rosterId = req.getParameter("rosterId");

        HttpSession session = req.getSession();

        UserDO user =(UserDO) session.getAttribute("UserDO");

        int i = appointmentService.addAppointment(user,rosterId);

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
        updateAppointment(req,resp);

        updateAppointmentOfUser(req,resp);

        req.getRequestDispatcher("userHome.jsp").forward(req,resp);

    }

    /**
     *用户删除排班
     */
    protected void delete(HttpServletRequest req,HttpServletResponse resp){

        AppointmentDO appointmentDO = (AppointmentDO)req.getAttribute("appointment");

        appointmentService.deleteAppointment(appointmentDO);

        updateAppointmentOfUser(req,resp);

        updateAppointment(req,resp);

    }

    /**
     *
     * 更新预约列表.每次对预约表更新都使用
     */
    protected void updateAppointment(HttpServletRequest req,HttpServletResponse resp){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        AppointmentMapper mapper1 = sqlSession.getMapper(AppointmentMapper.class);

        ServletContext servletContext = req.getServletContext();

        servletContext.setAttribute("allAppointment", mapper1.allAppointment());

    }

    protected void updateAppointmentOfUser(HttpServletRequest req,HttpServletResponse resp){
        HttpSession session = req.getSession();

        UserDO user =(UserDO)session.getAttribute("user");

        session.setAttribute("appointmentOfUser",appointmentService.appointmentOfUser(user.getId()));
    }
}
