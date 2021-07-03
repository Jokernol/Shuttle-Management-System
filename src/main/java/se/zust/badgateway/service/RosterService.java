package se.zust.badgateway.service;

import org.apache.ibatis.session.SqlSession;
import se.zust.badgateway.mapper.DriverMapper;
import se.zust.badgateway.mapper.RosterMapper;
import se.zust.badgateway.pojo.DO.DriverDO;
import se.zust.badgateway.pojo.DO.RosterDO;
import se.zust.badgateway.pojo.DTO.RosterDTO;
import se.zust.badgateway.util.MybatisUtils;
import se.zust.badgateway.util.ObjectUtils;

import java.util.List;
import java.util.UUID;

/**
 * @author 王怀瑾
 */
public class RosterService {

    private RosterService(){}

    private static class RosterServiceInnerClass{
        private static final RosterService INSTANCE = new RosterService();
    }

    public static RosterService getInstance() {
        return RosterService.RosterServiceInnerClass.INSTANCE;
    }


    public List<RosterDO> listRoster(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        RosterMapper mapper = sqlSession.getMapper(RosterMapper.class);

        List<RosterDO> rosterList = mapper.listRoster();

        sqlSession.commit();

        sqlSession.close();

        return rosterList;
    }

    public int addRoster(RosterDTO rosterDTO){
        String id = UUID.randomUUID().toString().replace("-","");

        if (ObjectUtils.isAnyFiledNull(rosterDTO)) {
            return 0;
        }else {
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            RosterMapper mapper = sqlSession.getMapper(RosterMapper.class);

//            if (mapper.getRoster(rosterDTO.getBusId(),rosterDTO.getDriverId(),rosterDTO.getOrigin())!=null){
//                return 1;
//            }

            RosterDO rosterDO = new RosterDO(
                id,
                rosterDTO.getBusId(),
                rosterDTO.getDriverId(),
                rosterDTO.getOrigin(),
                rosterDTO.getDestination(),
                rosterDTO.getDepartureTime(),
                rosterDTO.getRest()
            );
            mapper.insertRoster(rosterDO);
            sqlSession.commit();
            sqlSession.close();
        }
        return 2;
    }

    public List<RosterDO> ListRoster(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        RosterMapper mapper = sqlSession.getMapper(RosterMapper.class);

        List<RosterDO> s =  mapper.listRoster();

        sqlSession.commit();

        sqlSession.close();

        return  s;
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

    public List<RosterDO> getRosterOfUser(String id){

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        RosterMapper mapper = sqlSession.getMapper(RosterMapper.class);



        List<RosterDO> rosterDOList = mapper.getRosterOfUser(id);

        sqlSession.commit();

        sqlSession.close();

        return rosterDOList;


    }

    public boolean updateRoster(RosterDO rosterDO) {
        if (ObjectUtils.isAnyFiledNull(rosterDO)) {
            return false;
        }

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RosterMapper mapper = sqlSession.getMapper(RosterMapper.class);

        mapper.updateRoster(rosterDO);

        sqlSession.commit();

        sqlSession.close();

        return true;
    }
}
