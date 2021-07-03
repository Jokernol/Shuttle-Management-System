package se.zust.badgateway.pojo.DTO;

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
public class RosterDTO {
    private String busId;
    private String driverId;
    private String origin;
    private String destination;
    private String departureTime;
    private Integer rest;
}
