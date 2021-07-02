package se.zust.badgateway.mapper;

import org.apache.ibatis.annotations.Insert;
import se.zust.badgateway.pojo.po.RosterPO;

/**
 * @author 王怀瑾
 */
public interface ReservationMapper {

    @Insert("insert station values (#{lngX}, #{latY}, #{positionName})")
    void addRoster(ReservationMapper reservationMapper);
}
