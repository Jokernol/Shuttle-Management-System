package se.zust.badgateway.mapper;

import se.zust.badgateway.pojo.Bus;

import java.util.List;

public interface BusMapper {
    Bus getBusById(String id);
    List<Bus> listBus();
    void deleteBusById(String id);
    void updateBus(Bus bus);
}
