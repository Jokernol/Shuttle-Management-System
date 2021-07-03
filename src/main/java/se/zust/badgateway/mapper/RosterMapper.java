package se.zust.badgateway.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import se.zust.badgateway.pojo.DO.RosterDO;

import java.util.List;

public interface RosterMapper {
    @Select("select * from roster where id = #{id}")
    RosterDO getRosterById(String id);

    @Select("select * from roster")
    List<RosterDO> listRoster();

    @Insert("insert roster values (#{id}, #{busId}, #{driverId}, #{origin}, #{destination}, #{departureTime}, #{rest})")
    void insertRoster(RosterDO rosterDO);

    @Delete("delete from roster where id = #{id}")
    void deleteRosterById(String id);

    @Update("update roster set bus_id = #{busId}, driver_id = #{driverId}, origin = #{origin}, destination = #{destination}, departure_time = #{departureTime}, rest = #{rest} where id = #{id}")
    void updateRoster(RosterDO rosterDO);

    @Delete("delete from bus where userId = #{userId}")
    void deleteBusById(String id);
}
