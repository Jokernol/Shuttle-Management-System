package se.zust.badgateway.mapper;

import org.apache.ibatis.annotations.*;
import se.zust.badgateway.pojo.DO.AppointmentDO;
import se.zust.badgateway.pojo.DO.RosterDO;
import se.zust.badgateway.pojo.DO.StationDO;
import se.zust.badgateway.pojo.DO.UserDO;

import java.util.List;

/**
 * @author 王怀瑾
 */
public interface AppointmentMapper {
    /**
     * 获得车站点的排班
     */
    @Select("select * from roster where origin = #{position}")
    List<RosterDO> RosterOfAdder(String position);

    @Insert("insert appointment values (#{userId}, #{rosterId})")
    void InsertAppointment(AppointmentDO appointmentDO);

    @Update("update roster set rest = #{rest} where id = #{rosterId}")
    void increaseRest(@Param("rest") int rest, @Param("rosterId") String rosterId);

    /**
     *查询所有的预约记录
     */
    @Select("select * from appointment")
    List<AppointmentDO> allAppointment();

    @Delete("delete from appointment where user_id = #{user_id} and roster_id=#{roster_id}")
    void deleteRosterById(@Param("user_id") String userId,@Param("roster_id") String rosterId);


    @Select("select * from appointment where user_id=#{userid}")
    List<AppointmentDO> AppointmentOfUser(String userid);
}
