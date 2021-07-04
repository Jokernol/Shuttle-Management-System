package se.zust.badgateway.controller;

import se.zust.badgateway.controller.base.BaseServlet;
import se.zust.badgateway.pojo.DO.RosterDO;
import se.zust.badgateway.pojo.DTO.RosterDTO;
import se.zust.badgateway.service.DriverService;
import se.zust.badgateway.service.RosterService;
import se.zust.badgateway.util.BeanUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author fang
 */
@WebServlet("rosters/*")
public class RosterServlet extends BaseServlet {

    protected void post(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RosterDTO rosterDTO = BeanUtils.Request2Bean(req,RosterDTO.class);
        int i = RosterService.getInstance().addRoster(rosterDTO);

        System.out.println("ssss");
        String info;

        switch (i){
            case 0 :
                info= "输入不能为空";
                break;
            case 1 :
                info="班次已经存在";
                break;
            case 2:
                info="添加成功";
                break;
            default:
                info="error";
                break;
        }
        System.out.println(info);
        req.setAttribute("info",info);

        List<RosterDO> rosterList = RosterService.getInstance().listRoster();

        ServletContext servletContext = req.getServletContext();

        servletContext.setAttribute("rosterDOList", rosterList);
//        req.getRequestDispatcher("/adminHome/rosterManage.jsp").forward(req,resp);
        resp.sendRedirect("/adminHome/rosterManage.jsp?info="+ URLEncoder.encode(info, "utf-8"));
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        System.out.println(id);

        List<RosterDO> rosterList = RosterService.getInstance().deleteRoster(id);

        ServletContext servletContext = req.getServletContext();

        servletContext.setAttribute("rosterDOList", rosterList);

//        req.getRequestDispatcher("/adminHome/rosterManage.jsp").forward(req,resp);
        resp.sendRedirect("/adminHome/rosterManage.jsp");
    }

    protected void put(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RosterDO rosterDO = BeanUtils.Request2Bean(req,RosterDO.class);
        String info;
        if(RosterService.getInstance().updateRoster(rosterDO)) {
            ServletContext servletContext = req.getServletContext();
            servletContext.setAttribute("rosterDOList",RosterService.getInstance().listRoster());
//            req.setAttribute("info", "success");
            info = "success";
        } else {
//            req.setAttribute("info", "error");
            info = "error";
        }

//        req.getRequestDispatcher("/adminHome/rosterManage.jsp").forward(req, resp);

        resp.sendRedirect("/adminHome/rosterManage.jsp?info="+ URLEncoder.encode(info, "utf-8"));
    }
}
