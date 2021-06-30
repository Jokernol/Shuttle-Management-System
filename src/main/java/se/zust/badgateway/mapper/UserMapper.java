package se.zust.badgateway.mapper;

import org.apache.ibatis.annotations.Select;
import se.zust.badgateway.pojo.User;

/**
 * @author zhu
 */
public interface UserMapper {
    @Select("SELECT * FROM blog WHERE id = #{id}")
    User getUserById(String id);
    @Select("SELECT * FROM blog WHERE id = #{id}")
    User getUserByUserName(String userName);
    @Select("SELECT * FROM blog WHERE id = #{id}")
    void deleteUserById(String id);
    @Select("SELECT * FROM blog WHERE id = #{id}")
    void updateUser(User user);
}
