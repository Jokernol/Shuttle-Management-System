package se.zust.badgateway.service;

import org.apache.ibatis.session.SqlSession;
import se.zust.badgateway.mapper.UserMapper;
import se.zust.badgateway.pojo.dto.RegisterDTO;
import se.zust.badgateway.pojo.dto.UserDTO;
import se.zust.badgateway.pojo.po.UserPO;
import se.zust.badgateway.util.MybatisUtils;

import java.util.UUID;

/**
 * @author 韩成峰
 */
public class UserService {
    public int login(UserDTO userDTO) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserPO userPo=mapper.getUserByUserName(userDTO.getUsername());
        sqlSession.close();
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
            UserPO userPo=new UserPO(id,registerDTO.getUsername(),registerDTO.getPassword(),registerDTO.getIdentity(),registerDTO.getTelephone(),1) ;
            mapper.insertUser(userPo);
            sqlSession.close();
            return 2;
        }
    }


}
