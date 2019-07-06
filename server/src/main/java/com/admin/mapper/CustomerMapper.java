package com.admin.mapper;

import com.admin.entity.Customer;
import com.admin.entity.CustomerExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface CustomerMapper {
    /**
     *
     * @mbggenerated
     */
    @SelectProvider(type=CustomerSqlProvider.class, method="countByExample")
    int countByExample(CustomerExample example);

    /**
     *
     * @mbggenerated
     */
    @DeleteProvider(type=CustomerSqlProvider.class, method="deleteByExample")
    int deleteByExample(CustomerExample example);

    /**
     *
     * @mbggenerated
     */
    @Delete({
        "delete from customers",
        "where customer_id = #{customerId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer customerId);

    /**
     *
     * @mbggenerated
     */
    @Insert({
        "insert into customers (user_id, user_nickname, ",
        "marketing_id, customer_name, ",
        "customer_phone, customer_email, ",
        "customer_job, customer_address, ",
        "customer_income, customer_line, ",
        "customer_sex, customer_status, ",
        "create_time, modify_time)",
        "values (#{userId,jdbcType=INTEGER}, #{userNickname,jdbcType=VARCHAR}, ",
        "#{marketingId,jdbcType=INTEGER}, #{customerName,jdbcType=VARCHAR}, ",
        "#{customerPhone,jdbcType=VARCHAR}, #{customerEmail,jdbcType=VARCHAR}, ",
        "#{customerJob,jdbcType=VARCHAR}, #{customerAddress,jdbcType=VARCHAR}, ",
        "#{customerIncome,jdbcType=INTEGER}, #{customerLine,jdbcType=INTEGER}, ",
        "#{customerSex,jdbcType=INTEGER}, #{customerStatus,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{modifyTime,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys=true,keyProperty="customerId")
    int insert(Customer record);

    /**
     *
     * @mbggenerated
     */
    @InsertProvider(type=CustomerSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="customerId")
    int insertSelective(Customer record);

    /**
     *
     * @mbggenerated
     */
    @SelectProvider(type=CustomerSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_nickname", property="userNickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="marketing_id", property="marketingId", jdbcType=JdbcType.INTEGER),
        @Result(column="customer_name", property="customerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_phone", property="customerPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_email", property="customerEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_job", property="customerJob", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_address", property="customerAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_income", property="customerIncome", jdbcType=JdbcType.INTEGER),
        @Result(column="customer_line", property="customerLine", jdbcType=JdbcType.INTEGER),
        @Result(column="customer_sex", property="customerSex", jdbcType=JdbcType.INTEGER),
        @Result(column="customer_status", property="customerStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Customer> selectByExampleWithRowbounds(CustomerExample example, RowBounds rowBounds);

    /**
     *
     * @mbggenerated
     */
    @SelectProvider(type=CustomerSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_nickname", property="userNickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="marketing_id", property="marketingId", jdbcType=JdbcType.INTEGER),
        @Result(column="customer_name", property="customerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_phone", property="customerPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_email", property="customerEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_job", property="customerJob", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_address", property="customerAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_income", property="customerIncome", jdbcType=JdbcType.INTEGER),
        @Result(column="customer_line", property="customerLine", jdbcType=JdbcType.INTEGER),
        @Result(column="customer_sex", property="customerSex", jdbcType=JdbcType.INTEGER),
        @Result(column="customer_status", property="customerStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Customer> selectByExample(CustomerExample example);

    /**
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "customer_id, user_id, user_nickname, marketing_id, customer_name, customer_phone, ",
        "customer_email, customer_job, customer_address, customer_income, customer_line, ",
        "customer_sex, customer_status, create_time, modify_time",
        "from customers",
        "where customer_id = #{customerId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_nickname", property="userNickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="marketing_id", property="marketingId", jdbcType=JdbcType.INTEGER),
        @Result(column="customer_name", property="customerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_phone", property="customerPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_email", property="customerEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_job", property="customerJob", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_address", property="customerAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_income", property="customerIncome", jdbcType=JdbcType.INTEGER),
        @Result(column="customer_line", property="customerLine", jdbcType=JdbcType.INTEGER),
        @Result(column="customer_sex", property="customerSex", jdbcType=JdbcType.INTEGER),
        @Result(column="customer_status", property="customerStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP)
    })
    Customer selectByPrimaryKey(Integer customerId);

    /**
     *
     * @mbggenerated
     */
    @UpdateProvider(type=CustomerSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

    /**
     *
     * @mbggenerated
     */
    @UpdateProvider(type=CustomerSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

    /**
     *
     * @mbggenerated
     */
    @UpdateProvider(type=CustomerSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Customer record);

    /**
     *
     * @mbggenerated
     */
    @Update({
        "update customers",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "user_nickname = #{userNickname,jdbcType=VARCHAR},",
          "marketing_id = #{marketingId,jdbcType=INTEGER},",
          "customer_name = #{customerName,jdbcType=VARCHAR},",
          "customer_phone = #{customerPhone,jdbcType=VARCHAR},",
          "customer_email = #{customerEmail,jdbcType=VARCHAR},",
          "customer_job = #{customerJob,jdbcType=VARCHAR},",
          "customer_address = #{customerAddress,jdbcType=VARCHAR},",
          "customer_income = #{customerIncome,jdbcType=INTEGER},",
          "customer_line = #{customerLine,jdbcType=INTEGER},",
          "customer_sex = #{customerSex,jdbcType=INTEGER},",
          "customer_status = #{customerStatus,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "modify_time = #{modifyTime,jdbcType=TIMESTAMP}",
        "where customer_id = #{customerId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Customer record);
}