package se.zust.badgateway.Service;

import org.apache.ibatis.session.SqlSession;
import se.zust.badgateway.mapper.RosterMapper;
import se.zust.badgateway.mapper.StationMapper;
import se.zust.badgateway.pojo.po.ReservationPo;
import se.zust.badgateway.pojo.po.RosterPO;
import se.zust.badgateway.pojo.po.UserPO;
import se.zust.badgateway.util.MybatisUtils;
import se.zust.badgateway.util.ObjectIsNull;

import java.util.List;

/**
 * @author 王怀瑾
 */
public class RosterService{
    public List<RosterPO> getRosterPo(String positionName){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RosterMapper mapper = sqlSession.getMapper(RosterMapper.class);
        List<RosterPO> list =  mapper.getRosterList(positionName);
        sqlSession.commit();
        sqlSession.close();
        return list;
    }
    //添加预约信息
    public void AppointmentInformation(RosterPO rosterPO,UserPO userPO){
        ReservationPo reservationPo = new ReservationPo();

    }
}
