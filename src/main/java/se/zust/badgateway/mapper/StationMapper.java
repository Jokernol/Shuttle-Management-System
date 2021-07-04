package se.zust.badgateway.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import se.zust.badgateway.pojo.DO.StationDO;

import java.util.List;

/**
 * @author 王怀瑾
 */
public interface StationMapper {
    @Insert("insert station values (#{x}, #{y}, #{position})")
    int insertStation(StationDO stationDO);

    @Select("select * from station")
    List<StationDO> listStation();

    @Delete("delete from station where position = #{position}")
    void  deleteStation(String position);

}
