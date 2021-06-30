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
public class BusPO {
    private String id;
    private String seat;
    private String brand;
    private String insuranceDate;
    private String drivingLicense;
    private Integer appointments;
    private LocalDateTime registerTime;
}
