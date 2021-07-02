package se.zust.badgateway.mapper;

import se.zust.badgateway.pojo.po.BusPO;
import se.zust.badgateway.pojo.po.RosterPO;

import java.util.List;

public interface RosterMapper {
    RosterPO getRosterById(String id);

    List<RosterPO> listRoster();

    void addRoster(RosterPO rosterPO);

    void deleteRosterById(String id);

    void updateRoster(RosterPO rosterPO);

    List<RosterPO> getRosterList(String positionName);
}
