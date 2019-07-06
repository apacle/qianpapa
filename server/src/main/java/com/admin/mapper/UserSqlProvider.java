package com.admin.mapper;

import com.admin.entity.User;
import com.admin.entity.UserExample;
import com.admin.entity.UserExample.Criteria;
import com.admin.entity.UserExample.Criterion;

import java.util.List;
import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class UserSqlProvider {

    /**
     *
     * @mbggenerated
     */
    public String countByExample(UserExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("users");
        applyWhere(example, false);
        return SQL();
    }

    /**
     *
     * @mbggenerated
     */
    public String deleteByExample(UserExample example) {
        BEGIN();
        DELETE_FROM("users");
        applyWhere(example, false);
        return SQL();
    }

    /**
     *
     * @mbggenerated
     */
    public String insertSelective(User record) {
        BEGIN();
        INSERT_INTO("users");
        
        if (record.getUserPassword() != null) {
            VALUES("user_password", "#{userPassword,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            VALUES("user_name", "#{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getUserNickname() != null) {
            VALUES("user_nickname", "#{userNickname,jdbcType=VARCHAR}");
        }
        
        if (record.getUserPhone() != null) {
            VALUES("user_phone", "#{userPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getUserEmail() != null) {
            VALUES("user_email", "#{userEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getUserSex() != null) {
            VALUES("user_sex", "#{userSex,jdbcType=INTEGER}");
        }
        
        if (record.getUserRole() != null) {
            VALUES("user_role", "#{userRole,jdbcType=VARCHAR}");
        }
        
        if (record.getUserUrl() != null) {
            VALUES("user_url", "#{userUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getUserAvater() != null) {
            VALUES("user_avater", "#{userAvater,jdbcType=VARCHAR}");
        }
        
        if (record.getUserIntro() != null) {
            VALUES("user_intro", "#{userIntro,jdbcType=VARCHAR}");
        }
        
        if (record.getUserStatus() != null) {
            VALUES("user_status", "#{userStatus,jdbcType=INTEGER}");
        }
        
        if (record.getUserAddress() != null) {
            VALUES("user_address", "#{userAddress,jdbcType=VARCHAR}");
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
    public String selectByExample(UserExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("user_id");
        } else {
            SELECT("user_id");
        }
        SELECT("user_password");
        SELECT("user_name");
        SELECT("user_nickname");
        SELECT("user_phone");
        SELECT("user_email");
        SELECT("user_sex");
        SELECT("user_role");
        SELECT("user_url");
        SELECT("user_avater");
        SELECT("user_intro");
        SELECT("user_status");
        SELECT("user_address");
        SELECT("create_time");
        SELECT("modify_time");
        FROM("users");
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
        User record = (User) parameter.get("record");
        UserExample example = (UserExample) parameter.get("example");
        
        BEGIN();
        UPDATE("users");
        
        if (record.getUserId() != null) {
            SET("user_id = #{record.userId,jdbcType=INTEGER}");
        }
        
        if (record.getUserPassword() != null) {
            SET("user_password = #{record.userPassword,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        }
        
        if (record.getUserNickname() != null) {
            SET("user_nickname = #{record.userNickname,jdbcType=VARCHAR}");
        }
        
        if (record.getUserPhone() != null) {
            SET("user_phone = #{record.userPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getUserEmail() != null) {
            SET("user_email = #{record.userEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getUserSex() != null) {
            SET("user_sex = #{record.userSex,jdbcType=INTEGER}");
        }
        
        if (record.getUserRole() != null) {
            SET("user_role = #{record.userRole,jdbcType=VARCHAR}");
        }
        
        if (record.getUserUrl() != null) {
            SET("user_url = #{record.userUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getUserAvater() != null) {
            SET("user_avater = #{record.userAvater,jdbcType=VARCHAR}");
        }
        
        if (record.getUserIntro() != null) {
            SET("user_intro = #{record.userIntro,jdbcType=VARCHAR}");
        }
        
        if (record.getUserStatus() != null) {
            SET("user_status = #{record.userStatus,jdbcType=INTEGER}");
        }
        
        if (record.getUserAddress() != null) {
            SET("user_address = #{record.userAddress,jdbcType=VARCHAR}");
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
        UPDATE("users");
        
        SET("user_id = #{record.userId,jdbcType=INTEGER}");
        SET("user_password = #{record.userPassword,jdbcType=VARCHAR}");
        SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        SET("user_nickname = #{record.userNickname,jdbcType=VARCHAR}");
        SET("user_phone = #{record.userPhone,jdbcType=VARCHAR}");
        SET("user_email = #{record.userEmail,jdbcType=VARCHAR}");
        SET("user_sex = #{record.userSex,jdbcType=INTEGER}");
        SET("user_role = #{record.userRole,jdbcType=VARCHAR}");
        SET("user_url = #{record.userUrl,jdbcType=VARCHAR}");
        SET("user_avater = #{record.userAvater,jdbcType=VARCHAR}");
        SET("user_intro = #{record.userIntro,jdbcType=VARCHAR}");
        SET("user_status = #{record.userStatus,jdbcType=INTEGER}");
        SET("user_address = #{record.userAddress,jdbcType=VARCHAR}");
        SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("modify_time = #{record.modifyTime,jdbcType=TIMESTAMP}");
        
        UserExample example = (UserExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     *
     * @mbggenerated
     */
    public String updateByPrimaryKeySelective(User record) {
        BEGIN();
        UPDATE("users");
        
        if (record.getUserPassword() != null) {
            SET("user_password = #{userPassword,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            SET("user_name = #{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getUserNickname() != null) {
            SET("user_nickname = #{userNickname,jdbcType=VARCHAR}");
        }
        
        if (record.getUserPhone() != null) {
            SET("user_phone = #{userPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getUserEmail() != null) {
            SET("user_email = #{userEmail,jdbcType=VARCHAR}");
        }
        
        if (record.getUserSex() != null) {
            SET("user_sex = #{userSex,jdbcType=INTEGER}");
        }
        
        if (record.getUserRole() != null) {
            SET("user_role = #{userRole,jdbcType=VARCHAR}");
        }
        
        if (record.getUserUrl() != null) {
            SET("user_url = #{userUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getUserAvater() != null) {
            SET("user_avater = #{userAvater,jdbcType=VARCHAR}");
        }
        
        if (record.getUserIntro() != null) {
            SET("user_intro = #{userIntro,jdbcType=VARCHAR}");
        }
        
        if (record.getUserStatus() != null) {
            SET("user_status = #{userStatus,jdbcType=INTEGER}");
        }
        
        if (record.getUserAddress() != null) {
            SET("user_address = #{userAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyTime() != null) {
            SET("modify_time = #{modifyTime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("user_id = #{userId,jdbcType=INTEGER}");
        
        return SQL();
    }

    /**
     *
     * @mbggenerated
     */
    protected void applyWhere(UserExample example, boolean includeExamplePhrase) {
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