package se.zust.badgateway.Service;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import se.zust.badgateway.mapper.StationMapper;
import se.zust.badgateway.mapper.UserMapper;
import se.zust.badgateway.pojo.po.StationPO;
import se.zust.badgateway.pojo.po.UserPO;
import se.zust.badgateway.util.MybatisUtils;

import java.util.List;

public class TestMapper {

    @Test
    public void testMapper() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StationMapper  mapper = sqlSession.getMapper(StationMapper.class);

        List<StationPO> userPOList = mapper.listStastion();

        for (StationPO user : userPOList) {
            System.out.println(user.toString());
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
