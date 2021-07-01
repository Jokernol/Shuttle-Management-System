package se.zust.badgateway.Service;

import org.apache.ibatis.session.SqlSession;
import se.zust.badgateway.mapper.BusMapper;
import se.zust.badgateway.mapper.StationMapper;
import se.zust.badgateway.pojo.po.StationPO;
import se.zust.badgateway.util.MybatisUtils;
import se.zust.badgateway.util.ObjectIsNull;

import java.util.List;

/**
 * @author 王怀瑾
 */
public class StationService {
    public boolean addStation(StationPO stationPo){
        System.out.print("sssss"+ObjectIsNull.checkObjAllFieldIsNull(stationPo));
        if (!ObjectIsNull.checkObjAllFieldIsNull(stationPo)) {
            return false;
        }
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StationMapper mapper = sqlSession.getMapper(StationMapper.class);
        int i = mapper.addStation(stationPo);
        sqlSession.commit();
        sqlSession.close();
        return i != 0;
    }

    public List<StationPO> allStation(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StationMapper mapper = sqlSession.getMapper(StationMapper.class);
        List<StationPO> S= mapper.listStastion();

        sqlSession.commit();

        sqlSession.close();
        return S;
    }
}
