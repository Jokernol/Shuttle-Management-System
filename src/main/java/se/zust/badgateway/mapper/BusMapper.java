package se.zust.badgateway.mapper;

import se.zust.badgateway.pojo.po.BusPO;

import java.util.List;

public interface BusMapper {
    BusPO getBusById(String id);

    List<BusPO> listBus();

    void addBus(BusPO busPO);

    void deleteBusById(String id);

    void updateBus(BusPO busPO);
}
