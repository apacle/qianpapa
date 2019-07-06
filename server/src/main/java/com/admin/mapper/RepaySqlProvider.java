package com.admin.mapper;

import com.admin.entity.Repay;
import com.admin.entity.RepayExample;
import com.admin.entity.RepayExample.Criteria;
import com.admin.entity.RepayExample.Criterion;

import java.util.List;
import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class RepaySqlProvider {

    /**
     *
     * @mbggenerated
     */
    public String countByExample(RepayExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("repays");
        applyWhere(example, false);
        return SQL();
    }

    /**
     *
     * @mbggenerated
     */
    public String deleteByExample(RepayExample example) {
        BEGIN();
        DELETE_FROM("repays");
        applyWhere(example, false);
        return SQL();
    }

    /**
     *
     * @mbggenerated
     */
    public String insertSelective(Repay record) {
        BEGIN();
        INSERT_INTO("repays");
        
        if (record.getLoanId() != null) {
            VALUES("loan_id", "#{loanId,jdbcType=INTEGER}");
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
        
        if (record.getRepayAmount() != null) {
            VALUES("repay_amount", "#{repayAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getRepayStatus() != null) {
            VALUES("repay_status", "#{repayStatus,jdbcType=INTEGER}");
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
    public String selectByExample(RepayExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("repay_id");
        } else {
            SELECT("repay_id");
        }
        SELECT("loan_id");
        SELECT("user_id");
        SELECT("user_nickname");
        SELECT("customer_id");
        SELECT("customer_name");
        SELECT("repay_amount");
        SELECT("repay_status");
        SELECT("create_time");
        SELECT("modify_time");
        FROM("repays");
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
        Repay record = (Repay) parameter.get("record");
        RepayExample example = (RepayExample) parameter.get("example");
        
        BEGIN();
        UPDATE("repays");
        
        if (record.getRepayId() != null) {
            SET("repay_id = #{record.repayId,jdbcType=INTEGER}");
        }
        
        if (record.getLoanId() != null) {
            SET("loan_id = #{record.loanId,jdbcType=INTEGER}");
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
        
        if (record.getRepayAmount() != null) {
            SET("repay_amount = #{record.repayAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getRepayStatus() != null) {
            SET("repay_status = #{record.repayStatus,jdbcType=INTEGER}");
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
        UPDATE("repays");
        
        SET("repay_id = #{record.repayId,jdbcType=INTEGER}");
        SET("loan_id = #{record.loanId,jdbcType=INTEGER}");
        SET("user_id = #{record.userId,jdbcType=INTEGER}");
        SET("user_nickname = #{record.userNickname,jdbcType=VARCHAR}");
        SET("customer_id = #{record.customerId,jdbcType=INTEGER}");
        SET("customer_name = #{record.customerName,jdbcType=VARCHAR}");
        SET("repay_amount = #{record.repayAmount,jdbcType=DECIMAL}");
        SET("repay_status = #{record.repayStatus,jdbcType=INTEGER}");
        SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("modify_time = #{record.modifyTime,jdbcType=TIMESTAMP}");
        
        RepayExample example = (RepayExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     *
     * @mbggenerated
     */
    public String updateByPrimaryKeySelective(Repay record) {
        BEGIN();
        UPDATE("repays");
        
        if (record.getLoanId() != null) {
            SET("loan_id = #{loanId,jdbcType=INTEGER}");
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
        
        if (record.getRepayAmount() != null) {
            SET("repay_amount = #{repayAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getRepayStatus() != null) {
            SET("repay_status = #{repayStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyTime() != null) {
            SET("modify_time = #{modifyTime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("repay_id = #{repayId,jdbcType=INTEGER}");
        
        return SQL();
    }

    /**
     *
     * @mbggenerated
     */
    protected void applyWhere(RepayExample example, boolean includeExamplePhrase) {
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