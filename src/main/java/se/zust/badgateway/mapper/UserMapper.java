package se.zust.badgateway.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import se.zust.badgateway.pojo.po.UserPO;

import java.util.List;

/**
 * @author zhu
 */
public interface UserMapper {
    @Select("select * from user where id = #{id}")
    UserPO getUserById(String id);

    @Select("select * from user where user_name = #{userName}")
    UserPO getUserByUserName(String userName);

    @Select("select * from user")
    List<UserPO> listUser();

    @Insert("insert user values (#{id}, #{name}, #{password}, #{identity}, #{telephone})")
    void insertUser(UserPO userPO);

    @Delete("delete from user where id = #{id}")
    void deleteUserById(String id);

    @Update("update user " +
        "set name = #{name}, password = #{password}, identity = #{identity}, telephone = #{telephone} " +
        "where id = #{id}"
    )
    void updateUser(UserPO userPO);
}
