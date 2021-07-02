package se.zust.badgateway.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import se.zust.badgateway.pojo.DO.AppointmentDO;
import se.zust.badgateway.pojo.DO.StationDO;
import se.zust.badgateway.pojo.DO.UserDO;

/**
 * @author 王怀瑾
 */
public interface AppointmentMapper {

    //从appointment获得某一车站的列表
    @Select("select * from station where group = #{position}")
    AppointmentDO getUserById(String position);
}
