package se.zust.badgateway.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
    @Select("select * from station where roster_Id = #{position}")
    List<RosterDO> RosterOfAdder(String position);

    @Insert("insert driver values (#{userId}, #{rosterId})")
    void InsertAppointment(AppointmentDO appointmentDO);

    @Update("update roster set rest = #{rest} where id = #{id}")
    void increaseRest(Integer rest,String rosterId);

    /**
     *查询所有的预约记录
     */
    @Select("select * from appointment")
    List<AppointmentDO> allAppointment();

    @Delete("delete from roster where user_id = #{user_id} and roster_id=#{roster_id}")
    void deleteRosterById(AppointmentDO appointmentDO);

    @Update("update roster set rest = #{rest} where id = #{id}")
    void lessRoster(Integer rest,String id);

    @Select("select * from appointment where user_id=#{userid}")
    List<AppointmentDO> AppointmentOfUser(String userid);
}
