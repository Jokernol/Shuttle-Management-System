package se.zust.badgateway.mapper;

import se.zust.badgateway.pojo.po.UserPO;

import java.util.List;

/**
 * @author zhu
 */
public interface UserMapper {
    UserPO getUserById(String id);

    UserPO getUserByUserName(String userName);

    List<UserPO> listUser();

    void addUser(UserPO userPO);

    void deleteUserById(String id);

    void updateUser(UserPO userPO);
}
