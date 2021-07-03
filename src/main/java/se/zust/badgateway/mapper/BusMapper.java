package se.zust.badgateway.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import se.zust.badgateway.pojo.DO.BusDO;

import java.util.List;


/**
 * @author zhu
 */
public interface BusMapper {
    @Select("select * from bus where id = #{id}")
    BusDO getBusById(String id);

    @Select("select * from bus")
    List<BusDO> listBus();

    @Insert("insert bus " +
        "values (#{id}, #{seat}, #{brand}, #{insuranceDate}, #{drivingLicense}, #{registerTime})"
    )
    void insertBus(BusDO busDO);

    @Delete("delete from bus where id = #{id}")
    void deleteBusById(String id);

    @Update("update bus set seat = #{seat}, brand = #{brand}, insurance_date = #{insuranceDate}, driving_license = #{drivingLicense}, register_time = #{registerTime} where id = #{id}")
    void updateBus(BusDO busDO);
}
