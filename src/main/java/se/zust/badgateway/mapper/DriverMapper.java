package se.zust.badgateway.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import se.zust.badgateway.pojo.po.DriverPO;
import se.zust.badgateway.pojo.po.RosterPO;

/**
 * @author 韩成峰
 */
public interface DriverMapper {
    @Select("select * from driver where name = #{name}")
    DriverPO getDriverByName(String name);

    @Insert("insert driver values (#{id}, #{name}, #{address}, #{age}, #{driving_experience},#{telephone})")
    void insertDriver(DriverPO driverPO);
}
