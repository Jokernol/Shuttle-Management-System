package se.zust.badgateway.pojo.po;

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
public class RosterPO {
    private String id;
    private String driver;
    private String group;
    private LocalDateTime departureTime;
}
