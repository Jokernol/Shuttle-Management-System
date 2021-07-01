package se.zust.badgateway.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import se.zust.badgateway.pojo.po.UserPO;

import java.util.List;

/**
 * @author zhu
 */
public interface UserMapper {
    @Select("select * from user where id = #{id}")
    UserPO getUserById(String id);

    UserPO getUserByUserName(String userName);

    @Select("select * from user")
    List<UserPO> listUser();

    @Insert("insert user(id,name,password,identity,telephone) values (#{id}, #{name}, #{password}, #{identity}, #{telephone})")
    void addUser(UserPO userPO);

    void deleteUserById(String id);

    void updateUser(UserPO userPO);
}
