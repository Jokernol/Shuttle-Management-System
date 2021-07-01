package se.zust.badgateway.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import se.zust.badgateway.pojo.po.RosterPO;

import java.util.List;

public interface RosterMapper {
    @Select("select * from roster where id = #{id}")
    RosterPO getRosterById(String id);

    @Select("select * from roster")
    List<RosterPO> listRoster();

    @Insert("insert roster values (#{id}, #{driver}, #{group}, #{departureTime})")
    void insertRoster(RosterPO rosterPO);

    @Delete("delete from roster where id = #{id}")
    void deleteRosterById(String id);

    @Update("update roster" +
        "set driver = #{driver}, group = #{group}, departure_time = #{departureTime}" +
        "where id = #{id}")
    void updateRoster(RosterPO rosterPO);
}
