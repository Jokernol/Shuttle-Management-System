package se.zust.badgateway.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import se.zust.badgateway.pojo.DO.UserDO;

import java.util.List;

/**
 * @author zhu
 */
public interface UserMapper {
    /**
     * get user by id
     *
     * @param id id
     * @return UserPO
     */
    @Select("select * from user where id = #{id}")
    UserDO getUserById(String id);

    /**
     * get user by username
     *
     * @param username username
     * @return UserPO
     */
    @Select("select * from user where username = #{username}")
    UserDO getUserByUserName(String username);

    /**
     * get all users
     *
     * @return List<UserPO>
     */
    @Select("select * from user")
    List<UserDO> listUser();

    /**
     * insert user
     *
     * @param userDO user
     */
    @Insert("insert user values (#{id}, #{username}, #{password}, #{identity}, #{telephone}, #{type})")
    void insertUser(UserDO userDO);

    /**
     * delete user by id
     *
     * @param id id
     */
    @Delete("delete from user where id = #{id}")
    void deleteUserById(String id);

    /**
     * update user
     *
     * @param userDO user
     */
    @Update("update user set username = #{username}, password = #{password}, identity = #{identity}, telephone = #{telephone}, type = #{type} where id = #{id}")
    void updateUser(UserDO userDO);
}
