package com.admin.mapper;

import com.admin.entity.Marketing;
import com.admin.entity.MarketingExample;
import com.admin.entity.MarketingExample.Criteria;
import com.admin.entity.MarketingExample.Criterion;

import java.util.List;
import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class MarketingSqlProvider {

    /**
     *
     * @mbggenerated
     */
    public String countByExample(MarketingExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("marketing");
        applyWhere(example, false);
        return SQL();
    }

    /**
     *
     * @mbggenerated
     */
    public String deleteByExample(MarketingExample example) {
        BEGIN();
        DELETE_FROM("marketing");
        applyWhere(example, false);
        return SQL();
    }

    /**
     *
     * @mbggenerated
     */
    public String insertSelective(Marketing record) {
        BEGIN();
        INSERT_INTO("marketing");
        
        if (record.getMarketingName() != null) {
            VALUES("marketing_name", "#{marketingName,jdbcType=VARCHAR}");
        }
        
        if (record.getMarketingIcon() != null) {
            VALUES("marketing_icon", "#{marketingIcon,jdbcType=VARCHAR}");
        }
        
        if (record.getMarketingUrl() != null) {
            VALUES("marketing_url", "#{marketingUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getMarketingStatus() != null) {
            VALUES("marketing_status", "#{marketingStatus,jdbcType=INTEGER}");
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
    public String selectByExample(MarketingExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("marketing_id");
        } else {
            SELECT("marketing_id");
        }
        SELECT("marketing_name");
        SELECT("marketing_icon");
        SELECT("marketing_url");
        SELECT("marketing_status");
        SELECT("create_time");
        SELECT("modify_time");
        FROM("marketing");
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
        Marketing record = (Marketing) parameter.get("record");
        MarketingExample example = (MarketingExample) parameter.get("example");
        
        BEGIN();
        UPDATE("marketing");
        
        if (record.getMarketingId() != null) {
            SET("marketing_id = #{record.marketingId,jdbcType=INTEGER}");
        }
        
        if (record.getMarketingName() != null) {
            SET("marketing_name = #{record.marketingName,jdbcType=VARCHAR}");
        }
        
        if (record.getMarketingIcon() != null) {
            SET("marketing_icon = #{record.marketingIcon,jdbcType=VARCHAR}");
        }
        
        if (record.getMarketingUrl() != null) {
            SET("marketing_url = #{record.marketingUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getMarketingStatus() != null) {
            SET("marketing_status = #{record.marketingStatus,jdbcType=INTEGER}");
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
        UPDATE("marketing");
        
        SET("marketing_id = #{record.marketingId,jdbcType=INTEGER}");
        SET("marketing_name = #{record.marketingName,jdbcType=VARCHAR}");
        SET("marketing_icon = #{record.marketingIcon,jdbcType=VARCHAR}");
        SET("marketing_url = #{record.marketingUrl,jdbcType=VARCHAR}");
        SET("marketing_status = #{record.marketingStatus,jdbcType=INTEGER}");
        SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("modify_time = #{record.modifyTime,jdbcType=TIMESTAMP}");
        
        MarketingExample example = (MarketingExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     *
     * @mbggenerated
     */
    public String updateByPrimaryKeySelective(Marketing record) {
        BEGIN();
        UPDATE("marketing");
        
        if (record.getMarketingName() != null) {
            SET("marketing_name = #{marketingName,jdbcType=VARCHAR}");
        }
        
        if (record.getMarketingIcon() != null) {
            SET("marketing_icon = #{marketingIcon,jdbcType=VARCHAR}");
        }
        
        if (record.getMarketingUrl() != null) {
            SET("marketing_url = #{marketingUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getMarketingStatus() != null) {
            SET("marketing_status = #{marketingStatus,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyTime() != null) {
            SET("modify_time = #{modifyTime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("marketing_id = #{marketingId,jdbcType=INTEGER}");
        
        return SQL();
    }

    /**
     *
     * @mbggenerated
     */
    protected void applyWhere(MarketingExample example, boolean includeExamplePhrase) {
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