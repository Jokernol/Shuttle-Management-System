package se.zust.badgateway.service;

import org.apache.ibatis.session.SqlSession;
import se.zust.badgateway.mapper.UserMapper;
import se.zust.badgateway.pojo.dto.UserDTO;
import se.zust.badgateway.pojo.po.UserPO;
import se.zust.badgateway.util.MybatisUtils;

/**
 * @author 韩成峰
 */
public class UserService {
    public int login(UserDTO userDTO) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserPO userPo=mapper.getUserByUserName(userDTO.getName());
        if (userPo==null){
            //用户名不存在
            return 3;
        }
        if (userPo.getPassword().equals(userDTO.getPassword())){
            if(userPo.getType()==0){
                //管理员
                return 0;
            }else{
                //普通用户
                return 1;
            }
        }else {
            //密码错误
            return 2;
        }
    }


}
