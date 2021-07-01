package se.zust.badgateway.service;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import se.zust.badgateway.mapper.UserMapper;
import se.zust.badgateway.pojo.po.UserPO;
import se.zust.badgateway.util.MybatisUtils;

public class TestMapper {

    @Test
    public void testMapper() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.addUser(new UserPO("2", "1", "1", "1", "1"));

        sqlSession.commit();
        sqlSession.close();
    }
}
