package se.zust.badgateway.service;

import org.apache.ibatis.session.SqlSession;
import se.zust.badgateway.mapper.AppointmentMapper;
import se.zust.badgateway.mapper.RosterMapper;
import se.zust.badgateway.pojo.DO.AppointmentDO;
import se.zust.badgateway.pojo.DO.RosterDO;
import se.zust.badgateway.pojo.DO.UserDO;
import se.zust.badgateway.util.MybatisUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 王怀瑾
 */
public class AppointmentService {

    private AppointmentService(){}

    private static class AppointmentServiceInnerClass{
        private static final AppointmentService INSTANCE = new AppointmentService();
    }

    public static AppointmentService getInstance() {
        return AppointmentService.AppointmentServiceInnerClass.INSTANCE;
    }

    /**
     * 获得某一车站的班次
     */
    public List<RosterDO> getRoster(String position){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        AppointmentMapper mapper = sqlSession.getMapper(AppointmentMapper.class);

        List<RosterDO> rosterList = mapper.RosterOfAdder(position);

        sqlSession.commit();

        sqlSession.close();

        return rosterList;
    }

    /**
     *  用户预约班次并查重
     */
    public int addAppointment(UserDO userDO,String rosterId){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        RosterMapper mapper = sqlSession.getMapper(RosterMapper.class);

        AppointmentMapper mapper1 = sqlSession.getMapper(AppointmentMapper.class);

        AppointmentDO appointmentDO = new AppointmentDO(userDO.getId(),rosterId);
        RosterDO rosterDO = mapper.getRosterById(rosterId);
        if (rosterDO.getRest()>=0){
            int i = rosterDO.getRest();

            List<AppointmentDO> appointmentList = mapper1.allAppointment();

            for (AppointmentDO it:appointmentList){
                if (appointmentDO.toString().equals(it.toString())){
                    return 0;
                }
            }

            mapper1.InsertAppointment(appointmentDO);
            mapper1.increaseRest(--i,rosterId);
            return 1;
        }
        sqlSession.commit();
        sqlSession.close();
        return 2;
    }

    /**
     *删除预约
     */
    public void deleteAppointment(AppointmentDO appointmentDO){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AppointmentMapper mapper = sqlSession.getMapper(AppointmentMapper.class);
        mapper.deleteRosterById(appointmentDO);

        RosterMapper mapper1 = sqlSession.getMapper(RosterMapper.class);
        RosterDO rosterDO = mapper1.getRosterById(appointmentDO.getRosterId());
        int i = rosterDO.getRest();

        mapper.lessRoster(--i, appointmentDO.getRosterId());
    }

    /**
     * 返回所有的用户的预约
     */
    public List<AppointmentDO> appointmentOfUser(String userId){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AppointmentMapper mapper = sqlSession.getMapper(AppointmentMapper.class);
        return mapper.AppointmentOfUser(userId);
    }

    /**
     *更新列表
     */
    public List<AppointmentDO> AppointmentDoList(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        AppointmentMapper mapper1 = sqlSession.getMapper(AppointmentMapper.class);

        List<AppointmentDO> s =  mapper1.allAppointment();

        sqlSession.commit();

        sqlSession.close();

        return s;

    }


}
