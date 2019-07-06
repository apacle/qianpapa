package com.admin.mapper;

import com.admin.entity.Repay;
import com.admin.entity.RepayExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface RepayMapper {
    /**
     *
     * @mbggenerated
     */
    @SelectProvider(type=RepaySqlProvider.class, method="countByExample")
    int countByExample(RepayExample example);

    /**
     *
     * @mbggenerated
     */
    @DeleteProvider(type=RepaySqlProvider.class, method="deleteByExample")
    int deleteByExample(RepayExample example);

    /**
     *
     * @mbggenerated
     */
    @Delete({
        "delete from repays",
        "where repay_id = #{repayId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer repayId);

    /**
     *
     * @mbggenerated
     */
    @Insert({
        "insert into repays (loan_id, user_id, ",
        "user_nickname, customer_id, ",
        "customer_name, repay_amount, ",
        "repay_status, create_time, ",
        "modify_time)",
        "values (#{loanId,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{userNickname,jdbcType=VARCHAR}, #{customerId,jdbcType=INTEGER}, ",
        "#{customerName,jdbcType=VARCHAR}, #{repayAmount,jdbcType=DECIMAL}, ",
        "#{repayStatus,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{modifyTime,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys=true,keyProperty="repayId")
    int insert(Repay record);

    /**
     *
     * @mbggenerated
     */
    @InsertProvider(type=RepaySqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="repayId")
    int insertSelective(Repay record);

    /**
     *
     * @mbggenerated
     */
    @SelectProvider(type=RepaySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="repay_id", property="repayId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="loan_id", property="loanId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_nickname", property="userNickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.INTEGER),
        @Result(column="customer_name", property="customerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="repay_amount", property="repayAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="repay_status", property="repayStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Repay> selectByExampleWithRowbounds(RepayExample example, RowBounds rowBounds);

    /**
     *
     * @mbggenerated
     */
    @SelectProvider(type=RepaySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="repay_id", property="repayId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="loan_id", property="loanId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_nickname", property="userNickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.INTEGER),
        @Result(column="customer_name", property="customerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="repay_amount", property="repayAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="repay_status", property="repayStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Repay> selectByExample(RepayExample example);

    /**
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "repay_id, loan_id, user_id, user_nickname, customer_id, customer_name, repay_amount, ",
        "repay_status, create_time, modify_time",
        "from repays",
        "where repay_id = #{repayId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="repay_id", property="repayId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="loan_id", property="loanId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_nickname", property="userNickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.INTEGER),
        @Result(column="customer_name", property="customerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="repay_amount", property="repayAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="repay_status", property="repayStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP)
    })
    Repay selectByPrimaryKey(Integer repayId);

    /**
     *
     * @mbggenerated
     */
    @UpdateProvider(type=RepaySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Repay record, @Param("example") RepayExample example);

    /**
     *
     * @mbggenerated
     */
    @UpdateProvider(type=RepaySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Repay record, @Param("example") RepayExample example);

    /**
     *
     * @mbggenerated
     */
    @UpdateProvider(type=RepaySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Repay record);

    /**
     *
     * @mbggenerated
     */
    @Update({
        "update repays",
        "set loan_id = #{loanId,jdbcType=INTEGER},",
          "user_id = #{userId,jdbcType=INTEGER},",
          "user_nickname = #{userNickname,jdbcType=VARCHAR},",
          "customer_id = #{customerId,jdbcType=INTEGER},",
          "customer_name = #{customerName,jdbcType=VARCHAR},",
          "repay_amount = #{repayAmount,jdbcType=DECIMAL},",
          "repay_status = #{repayStatus,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "modify_time = #{modifyTime,jdbcType=TIMESTAMP}",
        "where repay_id = #{repayId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Repay record);
}