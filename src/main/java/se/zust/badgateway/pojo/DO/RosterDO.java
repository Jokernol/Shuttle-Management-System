package se.zust.badgateway.pojo.DO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author 王怀瑾
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RosterDO {
    private String id;
    private String busId;
    private String driverId;
    private String origin;
    private String destination;
    private LocalDateTime departureTime;
    private Integer rest;
}
