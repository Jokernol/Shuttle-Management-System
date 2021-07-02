package se.zust.badgateway.service;

import org.apache.ibatis.session.SqlSession;
import se.zust.badgateway.mapper.DriverMapper;
import se.zust.badgateway.pojo.DO.DriverDO;
import se.zust.badgateway.pojo.DTO.DriverDTO;
import se.zust.badgateway.util.MybatisUtils;
import se.zust.badgateway.util.ObjectUtils;

import java.util.List;
import java.util.UUID;

/**
 * @author zhu
 */
public class DriverService {
    //静态内部类实现单例模式

    private DriverService() {
    }

    private static class DriverServiceInnerClass {
        private static final DriverService INSTANCE = new DriverService();
    }

    public static DriverService getInstance() {
        return DriverService.DriverServiceInnerClass.INSTANCE;
    }

    public boolean insertDriver(DriverDTO driverDTO) {
        boolean flag = true;

        if (ObjectUtils.isAnyFiledNull(driverDTO)) {
            //数据不能有空
            flag = false;
        } else {
            //操作数据库
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            DriverMapper mapper = sqlSession.getMapper(DriverMapper.class);

            String id = UUID.randomUUID().toString().replace("-", "");
            DriverDO driverDO = new DriverDO(
                id,
                driverDTO.getAge(),
                driverDTO.getName(),
                driverDTO.getAddress(),
                driverDTO.getTelephone(),
                driverDTO.getDrivingExperience()
            );
            //插入数据库
            mapper.insertDriver(driverDO);
            //提交更改
            sqlSession.commit();
            //关闭数据库连接
            sqlSession.close();
        }

        return flag;
    }

    public void deleteDriver(String id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        DriverMapper mapper = sqlSession.getMapper(DriverMapper.class);

        mapper.deleteDriverById(id);

        sqlSession.commit();

        sqlSession.close();
    }

    public boolean updateDriver(DriverDO driverDO) {
        if (ObjectUtils.isAnyFiledNull(driverDO)) {
            return false;
        }

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        DriverMapper mapper = sqlSession.getMapper(DriverMapper.class);

        mapper.updateDriver(driverDO);

        sqlSession.commit();

        sqlSession.close();

        return true;
    }

    public List<DriverDO> listDriver() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        DriverMapper mapper = sqlSession.getMapper(DriverMapper.class);

        List<DriverDO> driverDOList = mapper.listDriver();

        sqlSession.close();

        return driverDOList;
    }
}
