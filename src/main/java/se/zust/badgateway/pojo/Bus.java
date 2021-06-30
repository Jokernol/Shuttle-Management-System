package se.zust.badgateway.pojo;

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
public class Bus {
    private String brand;
    private String id;
    private String seat;
    private String insuranceDate;
    private String drivingLicense;
    private Integer appointments;
    private LocalDateTime registerTime;
}
