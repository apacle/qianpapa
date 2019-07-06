package com.admin.mapper;

import com.admin.entity.Loan;
import com.admin.entity.LoanExample;
import com.admin.entity.LoanExample.Criteria;
import com.admin.entity.LoanExample.Criterion;

import java.util.List;
import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class LoanSqlProvider {

    /**
     *
     * @mbggenerated
     */
    public String countByExample(LoanExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("loans");
        applyWhere(example, false);
        return SQL();
    }

    /**
     *
     * @mbggenerated
     */
    public String deleteByExample(LoanExample example) {
        BEGIN();
        DELETE_FROM("loans");
        applyWhere(example, false);
        return SQL();
    }

    /**
     *
     * @mbggenerated
     */
    public String insertSelective(Loan record) {
        BEGIN();
        INSERT_INTO("loans");
        
        if (record.getLoanName() != null) {
            VALUES("loan_name", "#{loanName,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getUserNickname() != null) {
            VALUES("user_nickname", "#{userNickname,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerId() != null) {
            VALUES("customer_id", "#{customerId,jdbcType=INTEGER}");
        }
        
        if (record.getCustomerName() != null) {
            VALUES("customer_name", "#{customerName,jdbcType=VARCHAR}");
        }
        
        if (record.getLoanType() != null) {
            VALUES("loan_type", "#{loanType,jdbcType=INTEGER}");
        }
        
        if (record.getLoanFee() != null) {
            VALUES("loan_fee", "#{loanFee,jdbcType=DECIMAL}");
        }
        
        if (record.getLoadInterest() != null) {
            VALUES("load_interest", "#{loadInterest,jdbcType=DECIMAL}");
        }
        
        if (record.getLoanAmount() != null) {
            VALUES("loan_amount", "#{loanAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getLoanTotalAmount() != null) {
            VALUES("loan_total_amount", "#{loanTotalAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getLoanRepayAmount() != null) {
            VALUES("loan_repay_amount", "#{loanRepayAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getLoanStatus() != null) {
            VALUES("loan_status", "#{loanStatus,jdbcType=INTEGER}");
        }
        
        if (record.getLoanEndDate() != null) {
            VALUES("loan_end_date", "#{loanEndDate,jdbcType=DATE}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyTime() != null) {
            VALUES("modify_time", "#{modifyTime,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    /**
     *
     * @mbggenerated
     */
    public String selectByExample(LoanExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("loan_id");
        } else {
            SELECT("loan_id");
        }
        SELECT("loan_name");
        SELECT("user_id");
        SELECT("user_nickname");
        SELECT("customer_id");
        SELECT("customer_name");
        SELECT("loan_type");
        SELECT("loan_fee");
        SELECT("load_interest");
        SELECT("loan_amount");
        SELECT("loan_total_amount");
        SELECT("loan_repay_amount");
        SELECT("loan_status");
        SELECT("loan_end_date");
        SELECT("create_time");
        SELECT("modify_time");
        FROM("loans");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     *
     * @mbggenerated
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        Loan record = (Loan) parameter.get("record");
        LoanExample example = (LoanExample) parameter.get("example");
        
        BEGIN();
        UPDATE("loans");
        
        if (record.getLoanId() != null) {
            SET("loan_id = #{record.loanId,jdbcType=INTEGER}");
        }
        
        if (record.getLoanName() != null) {
            SET("loan_name = #{record.loanName,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            SET("user_id = #{record.userId,jdbcType=INTEGER}");
        }
        
        if (record.getUserNickname() != null) {
            SET("user_nickname = #{record.userNickname,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerId() != null) {
            SET("customer_id = #{record.customerId,jdbcType=INTEGER}");
        }
        
        if (record.getCustomerName() != null) {
            SET("customer_name = #{record.customerName,jdbcType=VARCHAR}");
        }
        
        if (record.getLoanType() != null) {
            SET("loan_type = #{record.loanType,jdbcType=INTEGER}");
        }
        
        if (record.getLoanFee() != null) {
            SET("loan_fee = #{record.loanFee,jdbcType=DECIMAL}");
        }
        
        if (record.getLoadInterest() != null) {
            SET("load_interest = #{record.loadInterest,jdbcType=DECIMAL}");
        }
        
        if (record.getLoanAmount() != null) {
            SET("loan_amount = #{record.loanAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getLoanTotalAmount() != null) {
            SET("loan_total_amount = #{record.loanTotalAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getLoanRepayAmount() != null) {
            SET("loan_repay_amount = #{record.loanRepayAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getLoanStatus() != null) {
            SET("loan_status = #{record.loanStatus,jdbcType=INTEGER}");
        }
        
        if (record.getLoanEndDate() != null) {
            SET("loan_end_date = #{record.loanEndDate,jdbcType=DATE}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyTime() != null) {
            SET("modify_time = #{record.modifyTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     *
     * @mbggenerated
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("loans");
        
        SET("loan_id = #{record.loanId,jdbcType=INTEGER}");
        SET("loan_name = #{record.loanName,jdbcType=VARCHAR}");
        SET("user_id = #{record.userId,jdbcType=INTEGER}");
        SET("user_nickname = #{record.userNickname,jdbcType=VARCHAR}");
        SET("customer_id = #{record.customerId,jdbcType=INTEGER}");
        SET("customer_name = #{record.customerName,jdbcType=VARCHAR}");
        SET("loan_type = #{record.loanType,jdbcType=INTEGER}");
        SET("loan_fee = #{record.loanFee,jdbcType=DECIMAL}");
        SET("load_interest = #{record.loadInterest,jdbcType=DECIMAL}");
        SET("loan_amount = #{record.loanAmount,jdbcType=DECIMAL}");
        SET("loan_total_amount = #{record.loanTotalAmount,jdbcType=DECIMAL}");
        SET("loan_repay_amount = #{record.loanRepayAmount,jdbcType=DECIMAL}");
        SET("loan_status = #{record.loanStatus,jdbcType=INTEGER}");
        SET("loan_end_date = #{record.loanEndDate,jdbcType=DATE}");
        SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("modify_time = #{record.modifyTime,jdbcType=TIMESTAMP}");
        
        LoanExample example = (LoanExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     *
     * @mbggenerated
     */
    public String updateByPrimaryKeySelective(Loan record) {
        BEGIN();
        UPDATE("loans");
        
        if (record.getLoanName() != null) {
            SET("loan_name = #{loanName,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            SET("user_id = #{userId,jdbcType=INTEGER}");
        }
        
        if (record.getUserNickname() != null) {
            SET("user_nickname = #{userNickname,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerId() != null) {
            SET("customer_id = #{customerId,jdbcType=INTEGER}");
        }
        
        if (record.getCustomerName() != null) {
            SET("customer_name = #{customerName,jdbcType=VARCHAR}");
        }
        
        if (record.getLoanType() != null) {
            SET("loan_type = #{loanType,jdbcType=INTEGER}");
        }
        
        if (record.getLoanFee() != null) {
            SET("loan_fee = #{loanFee,jdbcType=DECIMAL}");
        }
        
        if (record.getLoadInterest() != null) {
            SET("load_interest = #{loadInterest,jdbcType=DECIMAL}");
        }
        
        if (record.getLoanAmount() != null) {
            SET("loan_amount = #{loanAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getLoanTotalAmount() != null) {
            SET("loan_total_amount = #{loanTotalAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getLoanRepayAmount() != null) {
            SET("loan_repay_amount = #{loanRepayAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getLoanStatus() != null) {
            SET("loan_status = #{loanStatus,jdbcType=INTEGER}");
        }
        
        if (record.getLoanEndDate() != null) {
            SET("loan_end_date = #{loanEndDate,jdbcType=DATE}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyTime() != null) {
            SET("modify_time = #{modifyTime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("loan_id = #{loanId,jdbcType=INTEGER}");
        
        return SQL();
    }

    /**
     *
     * @mbggenerated
     */
    protected void applyWhere(LoanExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}