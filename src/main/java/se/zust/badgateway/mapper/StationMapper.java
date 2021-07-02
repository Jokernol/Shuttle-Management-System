package se.zust.badgateway.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import se.zust.badgateway.pojo.DO.StationDO;

import java.util.List;

/**
 * @author 王怀瑾
 */
public interface StationMapper {
    @Insert("insert station values (#{lngX}, #{latY}, #{position})")
    int addStation(StationDO stationDO);


    @Select("select * from station")
    List<StationDO> listStastion();
}
