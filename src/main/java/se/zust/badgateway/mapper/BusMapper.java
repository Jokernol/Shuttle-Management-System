package se.zust.badgateway.mapper;

import se.zust.badgateway.pojo.po.BusPO;

import java.util.List;

/**
 * @author 25878
 */
public interface BusMapper {
    BusPO getBusById(String id);

    List<BusPO> listBus();

    int addBus(BusPO busPO);

    int  deleteBusById(String id);

    int  updateBus(BusPO busPO);
}
