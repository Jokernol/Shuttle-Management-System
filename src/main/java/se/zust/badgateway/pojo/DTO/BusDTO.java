package se.zust.badgateway.pojo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author zhu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusDTO {
    private Integer seat;
    private String brand;
    private String insuranceDate;
    private String drivingLicense;
    private Integer appointments;
    private LocalDateTime registerTime;
}
