package se.zust.badgateway.service;

import se.zust.badgateway.pojo.DTO.LoginDTO;

/**
 * @author zhu
 */
public interface SessionService {
    int login(LoginDTO loginDTO);
}
