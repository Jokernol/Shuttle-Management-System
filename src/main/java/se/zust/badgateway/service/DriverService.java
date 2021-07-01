package se.zust.badgateway.service;

import org.apache.ibatis.session.SqlSession;
import se.zust.badgateway.mapper.DriverMapper;
import se.zust.badgateway.mapper.UserMapper;
import se.zust.badgateway.pojo.dto.DriverDTO;
import se.zust.badgateway.pojo.po.DriverPO;
import se.zust.badgateway.pojo.po.UserPO;
import se.zust.badgateway.util.MybatisUtils;

import java.util.UUID;

/**
 * @author 韩成峰
 */
public class DriverService {
    public int addDriver(DriverDTO driverDTO){
        if(driverDTO.getAddress()==null){
            //信息填写不全(这里只写了地址，用非空方法填补，返回0）
            return 0;
        }else{
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            DriverMapper mapper = sqlSession.getMapper(DriverMapper.class);


            if(mapper.getDriverByName(driverDTO.getName())!=null){
                //重名，驾驶员增加失败
                return 1;
            }

            String id= UUID.randomUUID().toString().replace("-","");
            DriverPO driverPO=new DriverPO(id,driverDTO.getName(),driverDTO.getAddress(),driverDTO.getAge(),driverDTO.getDrivingExperience(),driverDTO.getTelephone()) ;
            mapper.insertDriver(driverPO);
            sqlSession.close();
            return 2;
        }
    }
}
