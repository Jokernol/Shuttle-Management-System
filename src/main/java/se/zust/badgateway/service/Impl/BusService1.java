package se.zust.badgateway.service.Impl;

import org.apache.ibatis.session.SqlSession;
import se.zust.badgateway.mapper.BusMapper;
import se.zust.badgateway.pojo.DO.BusDO;
import se.zust.badgateway.util.MybatisUtils;
import se.zust.badgateway.util.ObjectUtils;

/**
 * @author 王怀瑾
 */
public class BusService1 {
    public boolean addBus(BusDO bus) {
        if (ObjectUtils.isAnyFiledNull(bus)) {
            return false;
        }
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BusMapper mapper = sqlSession.getMapper(BusMapper.class);
        //int i = mapper.insertBus(bus);
        sqlSession.commit();
        sqlSession.close();
        //return i != 0;
        return true;
    }

    public boolean upDate(BusDO bus){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BusMapper mapper = sqlSession.getMapper(BusMapper.class);
        //int i = mapper.addBus(bus);
        sqlSession.commit();
        sqlSession.close();
        //return i != 0 ;
        return true;
    }


}
