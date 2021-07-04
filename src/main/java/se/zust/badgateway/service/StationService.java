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

    private StationService(){}

    private static class StationServiceInnerClass{
        private static final StationService INSTANCE = new StationService();
    }

    public static StationService getInstance() {
        return StationService.StationServiceInnerClass.INSTANCE;
    }

    public boolean addStation(StationDO stationPo) {
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

    public void deleteStation(String position){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StationMapper mapper = sqlSession.getMapper(StationMapper.class);

        mapper.deleteStation(position);

        sqlSession.commit();
        sqlSession.close();
    }
}
