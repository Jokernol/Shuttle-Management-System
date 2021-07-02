package se.zust.badgateway.service;

import org.apache.ibatis.session.SqlSession;
import se.zust.badgateway.mapper.UserMapper;
import se.zust.badgateway.pojo.DO.UserDO;
import se.zust.badgateway.pojo.DTO.LoginDTO;
import se.zust.badgateway.util.MybatisUtils;

/**
 * @author zhu
 */
public class SessionService{
    //静态内部类实现单例模式

    private SessionService() {
    }

    private static class SessionServiceInnerClass{
        private static final SessionService INSTANCE = new SessionService();
    }

    public static SessionService getInstance() {
        return SessionServiceInnerClass.INSTANCE;
    }

    public int login(LoginDTO loginDTO) {
        //创建数据库连接
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用mapper接口访问数据库
        UserDO userDO = mapper.getUserByUserName(loginDTO.getUsername());
        //关闭数据库连接
        sqlSession.close();

        if (userDO != null) {
            if (userDO.getPassword().equals(loginDTO.getPassword())) {
                if (userDO.getType() == 0) {
                    //管理员
                    return 0;
                } else {
                    //普通用户
                    return 1;
                }
            } else {
                //密码错误
                return 2;
            }
        } else {
            //用户不存在
            return 3;
        }
    }

    public UserDO getUserByUserName(String username) {
        //创建数据库连接
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用mapper接口访问数据库
        UserDO userDO = mapper.getUserByUserName(username);
        //关闭数据库连接
        sqlSession.close();

        return userDO;
    }
}
