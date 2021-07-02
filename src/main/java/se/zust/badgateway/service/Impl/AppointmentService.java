package se.zust.badgateway.service.Impl;

import org.apache.ibatis.session.SqlSession;
import se.zust.badgateway.mapper.AppointmentMapper;
import se.zust.badgateway.mapper.BusMapper;
import se.zust.badgateway.mapper.RosterMapper;
import se.zust.badgateway.pojo.DO.AppointmentDO;
import se.zust.badgateway.pojo.DO.RosterDO;
import se.zust.badgateway.pojo.DO.UserDO;
import se.zust.badgateway.util.MybatisUtils;

import java.util.List;

/**
 * @author 王怀瑾
 */
public class AppointmentService {
    //从station中获得车站民为**的排班列表,供用户选择
    public List<RosterDO> getRoster(String position){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RosterMapper mapper = sqlSession.getMapper(RosterMapper.class);
        List<RosterDO> rosterList = mapper.RosterOfAdder(position);
        sqlSession.commit();
        sqlSession.close();
        //return i != 0;
        return rosterList;
    }

    //向数据库中添加用户id和班次
    public void addAppointment(UserDO userDO,String AgreementNumber){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
    }
}
