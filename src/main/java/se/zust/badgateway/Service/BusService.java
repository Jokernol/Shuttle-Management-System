package se.zust.badgateway.Service;

import org.apache.ibatis.session.SqlSession;
import se.zust.badgateway.mapper.BusMapper;
import se.zust.badgateway.pojo.po.BusPO;
import se.zust.badgateway.util.MybatisUtils;
import se.zust.badgateway.util.ObjectIsNull;

/**
 * @author 王怀瑾
 */
public class BusService {
    public boolean addBus(BusPO bus) {
        if (ObjectIsNull.checkObjAllFieldIsNull(bus)) {
            return false;
        }
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BusMapper mapper = sqlSession.getMapper(BusMapper.class);
        int i = mapper.addBus(bus);
        sqlSession.commit();
        sqlSession.close();
        return i != 0;
    }

    public boolean upDate(BusPO bus){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BusMapper mapper = sqlSession.getMapper(BusMapper.class);
        int i = mapper.addBus(bus);
        sqlSession.commit();
        sqlSession.close();
        return i != 0 ;

    }


}
