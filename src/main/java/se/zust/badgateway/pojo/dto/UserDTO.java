package se.zust.badgateway.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String name;
    private String password;
}
