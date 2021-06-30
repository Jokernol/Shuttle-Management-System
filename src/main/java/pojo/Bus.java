package pojo;

import lombok.*;

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
    private LocalDateTime registerTime;
    private String insuranceDate;
    private String drivingLicense;
    private int appointments;
}
