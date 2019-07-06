package com.admin.mapper;

import com.admin.entity.Marketing;
import com.admin.entity.MarketingExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface MarketingMapper {
    /**
     *
     * @mbggenerated
     */
    @SelectProvider(type=MarketingSqlProvider.class, method="countByExample")
    int countByExample(MarketingExample example);

    /**
     *
     * @mbggenerated
     */
    @DeleteProvider(type=MarketingSqlProvider.class, method="deleteByExample")
    int deleteByExample(MarketingExample example);

    /**
     *
     * @mbggenerated
     */
    @Delete({
        "delete from marketing",
        "where marketing_id = #{marketingId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer marketingId);

    /**
     *
     * @mbggenerated
     */
    @Insert({
        "insert into marketing (marketing_name, marketing_icon, ",
        "marketing_url, marketing_status, ",
        "create_time, modify_time)",
        "values (#{marketingName,jdbcType=VARCHAR}, #{marketingIcon,jdbcType=VARCHAR}, ",
        "#{marketingUrl,jdbcType=VARCHAR}, #{marketingStatus,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{modifyTime,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys=true,keyProperty="marketingId")
    int insert(Marketing record);

    /**
     *
     * @mbggenerated
     */
    @InsertProvider(type=MarketingSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="marketingId")
    int insertSelective(Marketing record);

    /**
     *
     * @mbggenerated
     */
    @SelectProvider(type=MarketingSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="marketing_id", property="marketingId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="marketing_name", property="marketingName", jdbcType=JdbcType.VARCHAR),
        @Result(column="marketing_icon", property="marketingIcon", jdbcType=JdbcType.VARCHAR),
        @Result(column="marketing_url", property="marketingUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="marketing_status", property="marketingStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Marketing> selectByExampleWithRowbounds(MarketingExample example, RowBounds rowBounds);

    /**
     *
     * @mbggenerated
     */
    @SelectProvider(type=MarketingSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="marketing_id", property="marketingId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="marketing_name", property="marketingName", jdbcType=JdbcType.VARCHAR),
        @Result(column="marketing_icon", property="marketingIcon", jdbcType=JdbcType.VARCHAR),
        @Result(column="marketing_url", property="marketingUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="marketing_status", property="marketingStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Marketing> selectByExample(MarketingExample example);

    /**
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "marketing_id, marketing_name, marketing_icon, marketing_url, marketing_status, ",
        "create_time, modify_time",
        "from marketing",
        "where marketing_id = #{marketingId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="marketing_id", property="marketingId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="marketing_name", property="marketingName", jdbcType=JdbcType.VARCHAR),
        @Result(column="marketing_icon", property="marketingIcon", jdbcType=JdbcType.VARCHAR),
        @Result(column="marketing_url", property="marketingUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="marketing_status", property="marketingStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP)
    })
    Marketing selectByPrimaryKey(Integer marketingId);

    /**
     *
     * @mbggenerated
     */
    @UpdateProvider(type=MarketingSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Marketing record, @Param("example") MarketingExample example);

    /**
     *
     * @mbggenerated
     */
    @UpdateProvider(type=MarketingSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Marketing record, @Param("example") MarketingExample example);

    /**
     *
     * @mbggenerated
     */
    @UpdateProvider(type=MarketingSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Marketing record);

    /**
     *
     * @mbggenerated
     */
    @Update({
        "update marketing",
        "set marketing_name = #{marketingName,jdbcType=VARCHAR},",
          "marketing_icon = #{marketingIcon,jdbcType=VARCHAR},",
          "marketing_url = #{marketingUrl,jdbcType=VARCHAR},",
          "marketing_status = #{marketingStatus,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "modify_time = #{modifyTime,jdbcType=TIMESTAMP}",
        "where marketing_id = #{marketingId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Marketing record);
}