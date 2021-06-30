package se.zust.badgateway.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 王怀瑾
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPO {
    private String id;
    private String name;
    private String password;
    private String identity;
    private String telephone;
}
