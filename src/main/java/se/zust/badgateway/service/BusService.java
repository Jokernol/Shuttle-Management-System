package se.zust.badgateway.service;

import org.apache.ibatis.session.SqlSession;
import se.zust.badgateway.mapper.BusMapper;
import se.zust.badgateway.pojo.DO.BusDO;
import se.zust.badgateway.pojo.DTO.BusDTO;
import se.zust.badgateway.util.MybatisUtils;
import se.zust.badgateway.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @author zhu
 */
public class BusService {
    //静态内部类实现单例模式

    private BusService() {
    }

    private static class BusServiceInnerClass {
        private static final BusService INSTANCE = new BusService();
    }

    public static BusService getInstance() {
        return BusService.BusServiceInnerClass.INSTANCE;
    }

    public boolean insertBus(BusDTO busDTO) {
        boolean flag = true;

        if (ObjectUtils.isAnyFiledNull(busDTO)) {
            //数据不能有空
            flag = false;
        } else {
            //操作数据库
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            BusMapper mapper = sqlSession.getMapper(BusMapper.class);

            String id = UUID.randomUUID().toString().replace("-", "");
            LocalDateTime localDateTime = LocalDateTime.now();
            BusDO busDO = new BusDO(
                id,
                busDTO.getSeat(),
                busDTO.getBrand(),
                busDTO.getInsuranceDate(),
                busDTO.getDrivingLicense(),
                localDateTime
            );
            //插入数据库
            mapper.insertBus(busDO);
            //提交更改
            sqlSession.commit();
            //关闭数据库连接
            sqlSession.close();
        }

        return flag;
    }

    public void deleteBus(String id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BusMapper mapper = sqlSession.getMapper(BusMapper.class);

        mapper.deleteBusById(id);

        sqlSession.commit();

        sqlSession.close();
    }

    public boolean updateBus(BusDO busDO) {
        if (ObjectUtils.isAnyFiledNull(busDO)) {
            return false;
        }

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BusMapper mapper = sqlSession.getMapper(BusMapper.class);

        mapper.updateBus(busDO);

        sqlSession.commit();

        sqlSession.close();

        return true;
    }

    public List<BusDO> listBus() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BusMapper mapper = sqlSession.getMapper(BusMapper.class);

        List<BusDO> busDOList = mapper.listBus();

        sqlSession.close();

        return busDOList;
    }
}
