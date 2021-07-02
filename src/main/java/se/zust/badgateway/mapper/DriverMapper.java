package se.zust.badgateway.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import se.zust.badgateway.pojo.DO.DriverDO;

/**
 * @author 韩成峰
 */
public interface DriverMapper {
    @Select("select * from driver where name = #{name}")
    DriverDO getDriverByName(String name);

    @Insert("insert driver values (#{id}, #{name}, #{address}, #{age}, #{driving_experience},#{telephone})")
    void insertDriver(DriverDO driverDO);
}
