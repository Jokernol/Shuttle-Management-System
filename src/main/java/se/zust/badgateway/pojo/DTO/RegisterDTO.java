package se.zust.badgateway.pojo.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 韩成峰
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {
    private String username;
    private String password;
    private String identity;
    private String telephone;
}
