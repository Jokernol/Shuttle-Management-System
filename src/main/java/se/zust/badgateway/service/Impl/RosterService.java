package se.zust.badgateway.service.Impl;

import org.apache.ibatis.session.SqlSession;
import se.zust.badgateway.mapper.RosterMapper;
import se.zust.badgateway.pojo.DO.RosterDO;
import se.zust.badgateway.util.MybatisUtils;

import java.util.List;
import java.util.UUID;

/**
 * @author 王怀瑾
 */
public class RosterService {
    public List<RosterDO> addRoster(RosterDO rosterDO){
        String id = UUID.randomUUID().toString().replace("-","");
        rosterDO.setBusId(id);
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RosterMapper mapper = sqlSession.getMapper(RosterMapper.class);
        mapper.insertRoster(rosterDO);
        List<RosterDO> rosterList = mapper.listRoster();
        sqlSession.commit();
        sqlSession.close();
        return rosterList;
    }

    public List<RosterDO> deleteRoster(String id){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RosterMapper mapper = sqlSession.getMapper(RosterMapper.class);
        mapper.deleteRosterById(id);
        List<RosterDO> rosterList = mapper.listRoster();
        sqlSession.commit();
        sqlSession.close();
        return rosterList;
    }
}
