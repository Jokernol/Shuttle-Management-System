package se.zust.badgateway.service;

import se.zust.badgateway.pojo.DO.UserDO;
import se.zust.badgateway.pojo.DTO.RegisterDTO;

/**
 * @author zhu
 */
public interface UserService {
    void register(RegisterDTO registerDTO);

}
