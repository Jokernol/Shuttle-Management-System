package se.zust.badgateway.controller;

import se.zust.badgateway.pojo.dto.DriverDTO;
import se.zust.badgateway.pojo.dto.RegisterDTO;
import se.zust.badgateway.service.DriverService;
import se.zust.badgateway.util.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 韩成峰
 */
@WebServlet("/Driver")
public class DriverServlet extends HttpServlet {
    DriverService driverService =new DriverService();
    @Override
    protected  void doPut(HttpServletRequest req, HttpServletResponse res) throws IOException {
        DriverDTO driverDTO= BeanUtils.Request2Bean(req,DriverDTO.class);
        if(driverDTO!=null){
            int result=driverService.addDriver(driverDTO);
            PrintWriter writer=res.getWriter();
            switch (result){
                case 0:
                    writer.write("0");
                    break;
                case 1:
                    writer.write("1");
                    break;
                case 2:
                    writer.write("2");
                    break;
                default:
                    break;
            }
        }
    }
}
