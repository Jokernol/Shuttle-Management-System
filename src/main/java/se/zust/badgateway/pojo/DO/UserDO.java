package se.zust.badgateway.pojo.DO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDO {
    private String id;
    private String username;
    private String password;
    private String identity;
    private String telephone;
    private Integer type;
}
