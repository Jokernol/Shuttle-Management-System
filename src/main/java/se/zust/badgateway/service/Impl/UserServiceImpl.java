package se.zust.badgateway.service.Impl;

import org.apache.ibatis.session.SqlSession;
import se.zust.badgateway.mapper.UserMapper;
import se.zust.badgateway.pojo.DTO.LoginDTO;
import se.zust.badgateway.pojo.DTO.RegisterDTO;
import se.zust.badgateway.pojo.DO.UserDO;
import se.zust.badgateway.util.MybatisUtils;

import java.util.UUID;

/**
 * @author 韩成峰
 */
public class UserServiceImpl {
    public int regist(RegisterDTO registerDTO){
        if("".equals(registerDTO.getUsername())||"".equals(registerDTO.getPassword())
        ||"".equals(registerDTO.getIdentity())||"".equals(registerDTO.getTelephone())){
            //数据不能为空
            return 0;
        }else{
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            if(mapper.getUserByUserName(registerDTO.getUsername())!=null){
                //重名，注册失败
                return 1;
            }

            String id=UUID.randomUUID().toString().replace("-","");
            //UserPO userPo=new UserPO(id,registerDTO.getUsername(),registerDTO.getPassword(),registerDTO.getIdentity(),registerDTO.getTelephone(),1) ;
            //mapper.insertUser(userPo);
            sqlSession.close();
            return 2;
        }
    }
}
