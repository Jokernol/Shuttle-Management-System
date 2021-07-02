package se.zust.badgateway.service;

import org.apache.ibatis.session.SqlSession;
import se.zust.badgateway.mapper.UserMapper;
import se.zust.badgateway.pojo.DO.UserDO;
import se.zust.badgateway.pojo.DTO.UserDTO;
import se.zust.badgateway.util.MybatisUtils;
import se.zust.badgateway.util.ObjectUtils;

import java.util.List;
import java.util.UUID;

/**
 * @author 韩成峰
 */
public class UserService {
    //静态内部类实现单例模式

    private UserService() {
    }

    private static class UserServiceInnerClass {
        private static final UserService INSTANCE = new UserService();
    }

    public static UserService getInstance() {
        return UserService.UserServiceInnerClass.INSTANCE;
    }

    public boolean register(UserDTO userDTO) {
        boolean flag = true;

        if (ObjectUtils.isAnyFiledNull(userDTO)) {
            //数据不能有空
            flag = false;
        } else {
            //操作数据库
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            if (mapper.getUserByUserName(userDTO.getUsername()) != null) {
                //用户已存在
                return false;
            }

            String id = UUID.randomUUID().toString().replace("-", "");
            UserDO userDO = new UserDO(
                id,
                userDTO.getUsername(),
                userDTO.getPassword(),
                userDTO.getIdentity(),
                userDTO.getTelephone(),
                1
            );
            //插入数据库
            mapper.insertUser(userDO);
            //提交更改
            sqlSession.commit();
            //关闭数据库连接
            sqlSession.close();
        }

        return flag;
    }

    public void deleteUser(String id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.deleteUserById(id);

        sqlSession.commit();

        sqlSession.close();
    }

    public boolean updateUser(UserDO userDO) {
        if(ObjectUtils.isAnyFiledNull(userDO)) {
            return false;
        }

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.updateUser(userDO);

        sqlSession.commit();

        sqlSession.close();

        return true;
    }

    public List<UserDO> listUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<UserDO> userDOList = mapper.listUser();

        sqlSession.close();

        return userDOList;
    }
}
