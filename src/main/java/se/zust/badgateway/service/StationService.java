package se.zust.badgateway.service;

import org.apache.ibatis.session.SqlSession;
import se.zust.badgateway.mapper.StationMapper;
import se.zust.badgateway.pojo.DO.StationDO;
import se.zust.badgateway.util.MybatisUtils;
import se.zust.badgateway.util.ObjectUtils;

import java.util.List;

/**
 * @author 王怀瑾
 */
public class StationService {
    public boolean addStation(StationDO stationPo) {
        System.out.print("sssss" + ObjectUtils.isAnyFiledNull(stationPo));
        if (!ObjectUtils.isAnyFiledNull(stationPo)) {
            return false;
        }
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StationMapper mapper = sqlSession.getMapper(StationMapper.class);
        int i = mapper.insertStation(stationPo);
        sqlSession.commit();
        sqlSession.close();
        return i != 0;
    }

    public List<StationDO> allStation() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StationMapper mapper = sqlSession.getMapper(StationMapper.class);
        List<StationDO> S = mapper.listStation();

        sqlSession.commit();

        sqlSession.close();
        return S;
    }
}
