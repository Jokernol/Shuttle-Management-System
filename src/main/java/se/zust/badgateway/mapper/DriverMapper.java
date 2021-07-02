package se.zust.badgateway.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import se.zust.badgateway.pojo.DO.DriverDO;
import se.zust.badgateway.pojo.DO.UserDO;

import java.util.List;

/**
 * @author 韩成峰
 */
public interface DriverMapper {
    @Select("select * from driver")
    List<DriverDO> listDriver();

    @Select("select * from driver where name = #{name}")
    DriverDO getDriverByName(String name);

    @Insert("insert driver values (#{id}, #{age}, #{name}, #{address},#{telephone}, #{drivingExperience})")
    void insertDriver(DriverDO driverDO);

    @Delete("delete from driver where id = #{id}")
    void deleteDriverById(String id);

    @Update("update driver set age = #{age}, name = #{name}, address = #{address}, telephone = #{telephone}, driving_experience = #{drivingExperience} where id = #{id}")
    void updateDriver(DriverDO driverDO);
}
