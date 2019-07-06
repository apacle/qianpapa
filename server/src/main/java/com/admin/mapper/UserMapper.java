package com.admin.mapper;

import com.admin.entity.User;
import com.admin.entity.UserExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface UserMapper {
    /**
     *
     * @mbggenerated
     */
    @SelectProvider(type=UserSqlProvider.class, method="countByExample")
    int countByExample(UserExample example);

    /**
     *
     * @mbggenerated
     */
    @DeleteProvider(type=UserSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserExample example);

    /**
     *
     * @mbggenerated
     */
    @Delete({
        "delete from users",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer userId);

    /**
     *
     * @mbggenerated
     */
    @Insert({
        "insert into users (user_password, user_name, ",
        "user_nickname, user_phone, ",
        "user_email, user_sex, ",
        "user_role, user_url, ",
        "user_avater, user_intro, ",
        "user_status, user_address, ",
        "create_time, modify_time)",
        "values (#{userPassword,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR}, ",
        "#{userNickname,jdbcType=VARCHAR}, #{userPhone,jdbcType=VARCHAR}, ",
        "#{userEmail,jdbcType=VARCHAR}, #{userSex,jdbcType=INTEGER}, ",
        "#{userRole,jdbcType=VARCHAR}, #{userUrl,jdbcType=VARCHAR}, ",
        "#{userAvater,jdbcType=VARCHAR}, #{userIntro,jdbcType=VARCHAR}, ",
        "#{userStatus,jdbcType=INTEGER}, #{userAddress,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{modifyTime,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys=true,keyProperty="userId")
    int insert(User record);

    /**
     *
     * @mbggenerated
     */
    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="userId")
    int insertSelective(User record);

    /**
     *
     * @mbggenerated
     */
    @SelectProvider(type=UserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_password", property="userPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_nickname", property="userNickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_phone", property="userPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_email", property="userEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_sex", property="userSex", jdbcType=JdbcType.INTEGER),
        @Result(column="user_role", property="userRole", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_url", property="userUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_avater", property="userAvater", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_intro", property="userIntro", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_status", property="userStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="user_address", property="userAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<User> selectByExampleWithRowbounds(UserExample example, RowBounds rowBounds);

    /**
     *
     * @mbggenerated
     */
    @SelectProvider(type=UserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_password", property="userPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_nickname", property="userNickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_phone", property="userPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_email", property="userEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_sex", property="userSex", jdbcType=JdbcType.INTEGER),
        @Result(column="user_role", property="userRole", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_url", property="userUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_avater", property="userAvater", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_intro", property="userIntro", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_status", property="userStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="user_address", property="userAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<User> selectByExample(UserExample example);

    /**
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "user_id, user_password, user_name, user_nickname, user_phone, user_email, user_sex, ",
        "user_role, user_url, user_avater, user_intro, user_status, user_address, create_time, ",
        "modify_time",
        "from users",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_password", property="userPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_nickname", property="userNickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_phone", property="userPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_email", property="userEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_sex", property="userSex", jdbcType=JdbcType.INTEGER),
        @Result(column="user_role", property="userRole", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_url", property="userUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_avater", property="userAvater", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_intro", property="userIntro", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_status", property="userStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="user_address", property="userAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP)
    })
    User selectByPrimaryKey(Integer userId);

    /**
     *
     * @mbggenerated
     */
    @UpdateProvider(type=UserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     *
     * @mbggenerated
     */
    @UpdateProvider(type=UserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     *
     * @mbggenerated
     */
    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    /**
     *
     * @mbggenerated
     */
    @Update({
        "update users",
        "set user_password = #{userPassword,jdbcType=VARCHAR},",
          "user_name = #{userName,jdbcType=VARCHAR},",
          "user_nickname = #{userNickname,jdbcType=VARCHAR},",
          "user_phone = #{userPhone,jdbcType=VARCHAR},",
          "user_email = #{userEmail,jdbcType=VARCHAR},",
          "user_sex = #{userSex,jdbcType=INTEGER},",
          "user_role = #{userRole,jdbcType=VARCHAR},",
          "user_url = #{userUrl,jdbcType=VARCHAR},",
          "user_avater = #{userAvater,jdbcType=VARCHAR},",
          "user_intro = #{userIntro,jdbcType=VARCHAR},",
          "user_status = #{userStatus,jdbcType=INTEGER},",
          "user_address = #{userAddress,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "modify_time = #{modifyTime,jdbcType=TIMESTAMP}",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
}