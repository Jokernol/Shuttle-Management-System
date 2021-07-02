package se.zust.badgateway.pojo.DO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 韩成峰
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverDO {
    private String id;
    private Integer age;
    private String name;
    private String address;
    private String telephone;
    private Integer drivingExperience;
}
