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
public class BusDO {
    private String id;
    private Integer seat;
    private String brand;
    private String insuranceDate;
    private String drivingLicense;
    private LocalDateTime registerTime;
}
