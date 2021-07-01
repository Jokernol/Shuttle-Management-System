package se.zust.badgateway.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import se.zust.badgateway.pojo.po.BusPO;
import se.zust.badgateway.pojo.po.StationPO;

import java.util.List;

/**
 * @author 王怀瑾
 */
public interface StationMapper {
    @Insert("insert station values (#{lngX}, #{latY}, #{positionName})")
    int addStation(StationPO stationPO);


    @Select("select * from station")
    List<StationPO> listStastion();
}
