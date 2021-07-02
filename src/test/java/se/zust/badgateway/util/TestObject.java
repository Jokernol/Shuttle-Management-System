package se.zust.badgateway.util;

import org.junit.Test;
import se.zust.badgateway.pojo.DTO.LoginDTO;

public class TestObject {
    @Test
    public void Test() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUsername("1");
        loginDTO.setPassword("1");
        System.out.println(loginDTO.toString());
        System.out.println(ObjectUtils.isAnyFiledNull(loginDTO));
    }
}
