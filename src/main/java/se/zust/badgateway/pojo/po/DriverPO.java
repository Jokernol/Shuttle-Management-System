package se.zust.badgateway.pojo.po;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 韩成峰
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverPO {
    private String id;
    private String name;
    private String address;
    private String telephone;
    private Integer age;
    private Integer drivingExperience;
}
