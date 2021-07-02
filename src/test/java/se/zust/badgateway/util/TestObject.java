package se.zust.badgateway.util;

import org.junit.Test;
import se.zust.badgateway.pojo.DTO.LoginDTO;

public class TestObject {
    @Test
    public void Test() {
        String url = "/users/get";
        System.out.println(url.split("/")[2]);
    }
}
