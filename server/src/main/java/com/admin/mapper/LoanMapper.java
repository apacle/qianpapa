package com.admin.mapper;

import com.admin.entity.Loan;
import com.admin.entity.LoanExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface LoanMapper {
    /**
     *
     * @mbggenerated
     */
    @SelectProvider(type=LoanSqlProvider.class, method="countByExample")
    int countByExample(LoanExample example);

    /**
     *
     * @mbggenerated
     */
    @DeleteProvider(type=LoanSqlProvider.class, method="deleteByExample")
    int deleteByExample(LoanExample example);

    /**
     *
     * @mbggenerated
     */
    @Delete({
        "delete from loans",
        "where loan_id = #{loanId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer loanId);

    /**
     *
     * @mbggenerated
     */
    @Insert({
        "insert into loans (loan_name, user_id, ",
        "user_nickname, customer_id, ",
        "customer_name, loan_type, ",
        "loan_fee, load_interest, ",
        "loan_amount, loan_total_amount, ",
        "loan_repay_amount, loan_status, ",
        "loan_end_date, create_time, ",
        "modify_time)",
        "values (#{loanName,jdbcType=VARCHAR}, #{userId,jdbcType=INTEGER}, ",
        "#{userNickname,jdbcType=VARCHAR}, #{customerId,jdbcType=INTEGER}, ",
        "#{customerName,jdbcType=VARCHAR}, #{loanType,jdbcType=INTEGER}, ",
        "#{loanFee,jdbcType=DECIMAL}, #{loadInterest,jdbcType=DECIMAL}, ",
        "#{loanAmount,jdbcType=DECIMAL}, #{loanTotalAmount,jdbcType=DECIMAL}, ",
        "#{loanRepayAmount,jdbcType=DECIMAL}, #{loanStatus,jdbcType=INTEGER}, ",
        "#{loanEndDate,jdbcType=DATE}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{modifyTime,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys=true,keyProperty="loanId")
    int insert(Loan record);

    /**
     *
     * @mbggenerated
     */
    @InsertProvider(type=LoanSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="loanId")
    int insertSelective(Loan record);

    /**
     *
     * @mbggenerated
     */
    @SelectProvider(type=LoanSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="loan_id", property="loanId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="loan_name", property="loanName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_nickname", property="userNickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.INTEGER),
        @Result(column="customer_name", property="customerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="loan_type", property="loanType", jdbcType=JdbcType.INTEGER),
        @Result(column="loan_fee", property="loanFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="load_interest", property="loadInterest", jdbcType=JdbcType.DECIMAL),
        @Result(column="loan_amount", property="loanAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="loan_total_amount", property="loanTotalAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="loan_repay_amount", property="loanRepayAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="loan_status", property="loanStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="loan_end_date", property="loanEndDate", jdbcType=JdbcType.DATE),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Loan> selectByExampleWithRowbounds(LoanExample example, RowBounds rowBounds);

    /**
     *
     * @mbggenerated
     */
    @SelectProvider(type=LoanSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="loan_id", property="loanId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="loan_name", property="loanName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_nickname", property="userNickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.INTEGER),
        @Result(column="customer_name", property="customerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="loan_type", property="loanType", jdbcType=JdbcType.INTEGER),
        @Result(column="loan_fee", property="loanFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="load_interest", property="loadInterest", jdbcType=JdbcType.DECIMAL),
        @Result(column="loan_amount", property="loanAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="loan_total_amount", property="loanTotalAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="loan_repay_amount", property="loanRepayAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="loan_status", property="loanStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="loan_end_date", property="loanEndDate", jdbcType=JdbcType.DATE),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Loan> selectByExample(LoanExample example);

    /**
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "loan_id, loan_name, user_id, user_nickname, customer_id, customer_name, loan_type, ",
        "loan_fee, load_interest, loan_amount, loan_total_amount, loan_repay_amount, ",
        "loan_status, loan_end_date, create_time, modify_time",
        "from loans",
        "where loan_id = #{loanId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="loan_id", property="loanId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="loan_name", property="loanName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_nickname", property="userNickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.INTEGER),
        @Result(column="customer_name", property="customerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="loan_type", property="loanType", jdbcType=JdbcType.INTEGER),
        @Result(column="loan_fee", property="loanFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="load_interest", property="loadInterest", jdbcType=JdbcType.DECIMAL),
        @Result(column="loan_amount", property="loanAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="loan_total_amount", property="loanTotalAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="loan_repay_amount", property="loanRepayAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="loan_status", property="loanStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="loan_end_date", property="loanEndDate", jdbcType=JdbcType.DATE),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time", property="modifyTime", jdbcType=JdbcType.TIMESTAMP)
    })
    Loan selectByPrimaryKey(Integer loanId);

    /**
     *
     * @mbggenerated
     */
    @UpdateProvider(type=LoanSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Loan record, @Param("example") LoanExample example);

    /**
     *
     * @mbggenerated
     */
    @UpdateProvider(type=LoanSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Loan record, @Param("example") LoanExample example);

    /**
     *
     * @mbggenerated
     */
    @UpdateProvider(type=LoanSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Loan record);

    /**
     *
     * @mbggenerated
     */
    @Update({
        "update loans",
        "set loan_name = #{loanName,jdbcType=VARCHAR},",
          "user_id = #{userId,jdbcType=INTEGER},",
          "user_nickname = #{userNickname,jdbcType=VARCHAR},",
          "customer_id = #{customerId,jdbcType=INTEGER},",
          "customer_name = #{customerName,jdbcType=VARCHAR},",
          "loan_type = #{loanType,jdbcType=INTEGER},",
          "loan_fee = #{loanFee,jdbcType=DECIMAL},",
          "load_interest = #{loadInterest,jdbcType=DECIMAL},",
          "loan_amount = #{loanAmount,jdbcType=DECIMAL},",
          "loan_total_amount = #{loanTotalAmount,jdbcType=DECIMAL},",
          "loan_repay_amount = #{loanRepayAmount,jdbcType=DECIMAL},",
          "loan_status = #{loanStatus,jdbcType=INTEGER},",
          "loan_end_date = #{loanEndDate,jdbcType=DATE},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "modify_time = #{modifyTime,jdbcType=TIMESTAMP}",
        "where loan_id = #{loanId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Loan record);
}