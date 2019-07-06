package com.admin.mapper;

import com.admin.entity.Customer;
import com.admin.entity.CustomerExample;
import com.admin.entity.CustomerExample.Criteria;
import com.admin.entity.CustomerExample.Criterion;

import java.util.List;
import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class CustomerSqlProvider {

    /**
     *
     * @mbggenerated
     */
    public String countByExample(CustomerExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("customers");
        applyWhere(example, false);
        return SQL();
    }

    /**
     *
     * @mbggenerated
     */
    public String deleteByExample(CustomerExample example) {
        BEGIN();
        DELETE_FROM("customers");
        applyWhere(example, false);
        return SQL();
    }

    /**
     *
     * @mbggenerated
     */
    public String insertSelective(Customer record) {
        BEGIN();
        INSERT_INTO("customers");
        
        if (record.getUserId() != null) {
            VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getUserNickname() != null) {
            VALUES("user_nickname", "#{userNickname,jdbcType=VARCHAR}");
        }
        
        if (record.getMarketingId() != null) {
            VALUES("marketing_id", "#{marketingId,jdbcType=INTEGER}");
        }
        
        if (record.getCustomerName() != null) {
            VALUES("customer_name", "#{customerName,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerPhone() != null) {
            VALUES("customer_phone", "#{customerPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerEmail() != null) {
            VALUES("customer_email", "#{customerEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerJob() != null) {
            VALUES("customer_job", "#{customerJob,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerAddress() != null) {
            VALUES("customer_address", "#{customerAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerIncome() != null) {
            VALUES("customer_income", "#{customerIncome,jdbcType=INTEGER}");
        }
        
        if (record.getCustomerLine() != null) {
            VALUES("customer_line", "#{customerLine,jdbcType=INTEGER}");
        }
        
        if (record.getCustomerSex() != null) {
            VALUES("customer_sex", "#{customerSex,jdbcType=INTEGER}");
        }
        
        if (record.getCustomerStatus() != null) {
            VALUES("customer_status", "#{customerStatus,jdbcType=INTEGER}");
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
    public String selectByExample(CustomerExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("customer_id");
        } else {
            SELECT("customer_id");
        }
        SELECT("user_id");
        SELECT("user_nickname");
        SELECT("marketing_id");
        SELECT("customer_name");
        SELECT("customer_phone");
        SELECT("customer_email");
        SELECT("customer_job");
        SELECT("customer_address");
        SELECT("customer_income");
        SELECT("customer_line");
        SELECT("customer_sex");
        SELECT("customer_status");
        SELECT("create_time");
        SELECT("modify_time");
        FROM("customers");
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
        Customer record = (Customer) parameter.get("record");
        CustomerExample example = (CustomerExample) parameter.get("example");
        
        BEGIN();
        UPDATE("customers");
        
        if (record.getCustomerId() != null) {
            SET("customer_id = #{record.customerId,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            SET("user_id = #{record.userId,jdbcType=INTEGER}");
        }
        
        if (record.getUserNickname() != null) {
            SET("user_nickname = #{record.userNickname,jdbcType=VARCHAR}");
        }
        
        if (record.getMarketingId() != null) {
            SET("marketing_id = #{record.marketingId,jdbcType=INTEGER}");
        }
        
        if (record.getCustomerName() != null) {
            SET("customer_name = #{record.customerName,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerPhone() != null) {
            SET("customer_phone = #{record.customerPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerEmail() != null) {
            SET("customer_email = #{record.customerEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerJob() != null) {
            SET("customer_job = #{record.customerJob,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerAddress() != null) {
            SET("customer_address = #{record.customerAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerIncome() != null) {
            SET("customer_income = #{record.customerIncome,jdbcType=INTEGER}");
        }
        
        if (record.getCustomerLine() != null) {
            SET("customer_line = #{record.customerLine,jdbcType=INTEGER}");
        }
        
        if (record.getCustomerSex() != null) {
            SET("customer_sex = #{record.customerSex,jdbcType=INTEGER}");
        }
        
        if (record.getCustomerStatus() != null) {
            SET("customer_status = #{record.customerStatus,jdbcType=INTEGER}");
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
        UPDATE("customers");
        
        SET("customer_id = #{record.customerId,jdbcType=INTEGER}");
        SET("user_id = #{record.userId,jdbcType=INTEGER}");
        SET("user_nickname = #{record.userNickname,jdbcType=VARCHAR}");
        SET("marketing_id = #{record.marketingId,jdbcType=INTEGER}");
        SET("customer_name = #{record.customerName,jdbcType=VARCHAR}");
        SET("customer_phone = #{record.customerPhone,jdbcType=VARCHAR}");
        SET("customer_email = #{record.customerEmail,jdbcType=VARCHAR}");
        SET("customer_job = #{record.customerJob,jdbcType=VARCHAR}");
        SET("customer_address = #{record.customerAddress,jdbcType=VARCHAR}");
        SET("customer_income = #{record.customerIncome,jdbcType=INTEGER}");
        SET("customer_line = #{record.customerLine,jdbcType=INTEGER}");
        SET("customer_sex = #{record.customerSex,jdbcType=INTEGER}");
        SET("customer_status = #{record.customerStatus,jdbcType=INTEGER}");
        SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("modify_time = #{record.modifyTime,jdbcType=TIMESTAMP}");
        
        CustomerExample example = (CustomerExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     *
     * @mbggenerated
     */
    public String updateByPrimaryKeySelective(Customer record) {
        BEGIN();
        UPDATE("customers");
        
        if (record.getUserId() != null) {
            SET("user_id = #{userId,jdbcType=INTEGER}");
        }
        
        if (record.getUserNickname() != null) {
            SET("user_nickname = #{userNickname,jdbcType=VARCHAR}");
        }
        
        if (record.getMarketingId() != null) {
            SET("marketing_id = #{marketingId,jdbcType=INTEGER}");
        }
        
        if (record.getCustomerName() != null) {
            SET("customer_name = #{customerName,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerPhone() != null) {
            SET("customer_phone = #{customerPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerEmail() != null) {
            SET("customer_email = #{customerEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerJob() != null) {
            SET("customer_job = #{customerJob,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerAddress() != null) {
            SET("customer_address = #{customerAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomerIncome() != null) {
            SET("customer_income = #{customerIncome,jdbcType=INTEGER}");
        }
        
        if (record.getCustomerLine() != null) {
            SET("customer_line = #{customerLine,jdbcType=INTEGER}");
        }
        
        if (record.getCustomerSex() != null) {
            SET("customer_sex = #{customerSex,jdbcType=INTEGER}");
        }
        
        if (record.getCustomerStatus() != null) {
            SET("customer_status = #{customerStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyTime() != null) {
            SET("modify_time = #{modifyTime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("customer_id = #{customerId,jdbcType=INTEGER}");
        
        return SQL();
    }

    /**
     *
     * @mbggenerated
     */
    protected void applyWhere(CustomerExample example, boolean includeExamplePhrase) {
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