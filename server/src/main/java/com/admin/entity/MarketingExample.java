package com.admin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MarketingExample {
    /**
     * marketing
     */
    protected String orderByClause;

    /**
     * marketing
     */
    protected boolean distinct;

    /**
     * marketing
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated
     */
    public MarketingExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * marketing null
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andMarketingIdIsNull() {
            addCriterion("marketing_id is null");
            return (Criteria) this;
        }

        public Criteria andMarketingIdIsNotNull() {
            addCriterion("marketing_id is not null");
            return (Criteria) this;
        }

        public Criteria andMarketingIdEqualTo(Integer value) {
            addCriterion("marketing_id =", value, "marketingId");
            return (Criteria) this;
        }

        public Criteria andMarketingIdNotEqualTo(Integer value) {
            addCriterion("marketing_id <>", value, "marketingId");
            return (Criteria) this;
        }

        public Criteria andMarketingIdGreaterThan(Integer value) {
            addCriterion("marketing_id >", value, "marketingId");
            return (Criteria) this;
        }

        public Criteria andMarketingIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("marketing_id >=", value, "marketingId");
            return (Criteria) this;
        }

        public Criteria andMarketingIdLessThan(Integer value) {
            addCriterion("marketing_id <", value, "marketingId");
            return (Criteria) this;
        }

        public Criteria andMarketingIdLessThanOrEqualTo(Integer value) {
            addCriterion("marketing_id <=", value, "marketingId");
            return (Criteria) this;
        }

        public Criteria andMarketingIdIn(List<Integer> values) {
            addCriterion("marketing_id in", values, "marketingId");
            return (Criteria) this;
        }

        public Criteria andMarketingIdNotIn(List<Integer> values) {
            addCriterion("marketing_id not in", values, "marketingId");
            return (Criteria) this;
        }

        public Criteria andMarketingIdBetween(Integer value1, Integer value2) {
            addCriterion("marketing_id between", value1, value2, "marketingId");
            return (Criteria) this;
        }

        public Criteria andMarketingIdNotBetween(Integer value1, Integer value2) {
            addCriterion("marketing_id not between", value1, value2, "marketingId");
            return (Criteria) this;
        }

        public Criteria andMarketingNameIsNull() {
            addCriterion("marketing_name is null");
            return (Criteria) this;
        }

        public Criteria andMarketingNameIsNotNull() {
            addCriterion("marketing_name is not null");
            return (Criteria) this;
        }

        public Criteria andMarketingNameEqualTo(String value) {
            addCriterion("marketing_name =", value, "marketingName");
            return (Criteria) this;
        }

        public Criteria andMarketingNameNotEqualTo(String value) {
            addCriterion("marketing_name <>", value, "marketingName");
            return (Criteria) this;
        }

        public Criteria andMarketingNameGreaterThan(String value) {
            addCriterion("marketing_name >", value, "marketingName");
            return (Criteria) this;
        }

        public Criteria andMarketingNameGreaterThanOrEqualTo(String value) {
            addCriterion("marketing_name >=", value, "marketingName");
            return (Criteria) this;
        }

        public Criteria andMarketingNameLessThan(String value) {
            addCriterion("marketing_name <", value, "marketingName");
            return (Criteria) this;
        }

        public Criteria andMarketingNameLessThanOrEqualTo(String value) {
            addCriterion("marketing_name <=", value, "marketingName");
            return (Criteria) this;
        }

        public Criteria andMarketingNameLike(String value) {
            addCriterion("marketing_name like", value, "marketingName");
            return (Criteria) this;
        }

        public Criteria andMarketingNameNotLike(String value) {
            addCriterion("marketing_name not like", value, "marketingName");
            return (Criteria) this;
        }

        public Criteria andMarketingNameIn(List<String> values) {
            addCriterion("marketing_name in", values, "marketingName");
            return (Criteria) this;
        }

        public Criteria andMarketingNameNotIn(List<String> values) {
            addCriterion("marketing_name not in", values, "marketingName");
            return (Criteria) this;
        }

        public Criteria andMarketingNameBetween(String value1, String value2) {
            addCriterion("marketing_name between", value1, value2, "marketingName");
            return (Criteria) this;
        }

        public Criteria andMarketingNameNotBetween(String value1, String value2) {
            addCriterion("marketing_name not between", value1, value2, "marketingName");
            return (Criteria) this;
        }

        public Criteria andMarketingIconIsNull() {
            addCriterion("marketing_icon is null");
            return (Criteria) this;
        }

        public Criteria andMarketingIconIsNotNull() {
            addCriterion("marketing_icon is not null");
            return (Criteria) this;
        }

        public Criteria andMarketingIconEqualTo(String value) {
            addCriterion("marketing_icon =", value, "marketingIcon");
            return (Criteria) this;
        }

        public Criteria andMarketingIconNotEqualTo(String value) {
            addCriterion("marketing_icon <>", value, "marketingIcon");
            return (Criteria) this;
        }

        public Criteria andMarketingIconGreaterThan(String value) {
            addCriterion("marketing_icon >", value, "marketingIcon");
            return (Criteria) this;
        }

        public Criteria andMarketingIconGreaterThanOrEqualTo(String value) {
            addCriterion("marketing_icon >=", value, "marketingIcon");
            return (Criteria) this;
        }

        public Criteria andMarketingIconLessThan(String value) {
            addCriterion("marketing_icon <", value, "marketingIcon");
            return (Criteria) this;
        }

        public Criteria andMarketingIconLessThanOrEqualTo(String value) {
            addCriterion("marketing_icon <=", value, "marketingIcon");
            return (Criteria) this;
        }

        public Criteria andMarketingIconLike(String value) {
            addCriterion("marketing_icon like", value, "marketingIcon");
            return (Criteria) this;
        }

        public Criteria andMarketingIconNotLike(String value) {
            addCriterion("marketing_icon not like", value, "marketingIcon");
            return (Criteria) this;
        }

        public Criteria andMarketingIconIn(List<String> values) {
            addCriterion("marketing_icon in", values, "marketingIcon");
            return (Criteria) this;
        }

        public Criteria andMarketingIconNotIn(List<String> values) {
            addCriterion("marketing_icon not in", values, "marketingIcon");
            return (Criteria) this;
        }

        public Criteria andMarketingIconBetween(String value1, String value2) {
            addCriterion("marketing_icon between", value1, value2, "marketingIcon");
            return (Criteria) this;
        }

        public Criteria andMarketingIconNotBetween(String value1, String value2) {
            addCriterion("marketing_icon not between", value1, value2, "marketingIcon");
            return (Criteria) this;
        }

        public Criteria andMarketingUrlIsNull() {
            addCriterion("marketing_url is null");
            return (Criteria) this;
        }

        public Criteria andMarketingUrlIsNotNull() {
            addCriterion("marketing_url is not null");
            return (Criteria) this;
        }

        public Criteria andMarketingUrlEqualTo(String value) {
            addCriterion("marketing_url =", value, "marketingUrl");
            return (Criteria) this;
        }

        public Criteria andMarketingUrlNotEqualTo(String value) {
            addCriterion("marketing_url <>", value, "marketingUrl");
            return (Criteria) this;
        }

        public Criteria andMarketingUrlGreaterThan(String value) {
            addCriterion("marketing_url >", value, "marketingUrl");
            return (Criteria) this;
        }

        public Criteria andMarketingUrlGreaterThanOrEqualTo(String value) {
            addCriterion("marketing_url >=", value, "marketingUrl");
            return (Criteria) this;
        }

        public Criteria andMarketingUrlLessThan(String value) {
            addCriterion("marketing_url <", value, "marketingUrl");
            return (Criteria) this;
        }

        public Criteria andMarketingUrlLessThanOrEqualTo(String value) {
            addCriterion("marketing_url <=", value, "marketingUrl");
            return (Criteria) this;
        }

        public Criteria andMarketingUrlLike(String value) {
            addCriterion("marketing_url like", value, "marketingUrl");
            return (Criteria) this;
        }

        public Criteria andMarketingUrlNotLike(String value) {
            addCriterion("marketing_url not like", value, "marketingUrl");
            return (Criteria) this;
        }

        public Criteria andMarketingUrlIn(List<String> values) {
            addCriterion("marketing_url in", values, "marketingUrl");
            return (Criteria) this;
        }

        public Criteria andMarketingUrlNotIn(List<String> values) {
            addCriterion("marketing_url not in", values, "marketingUrl");
            return (Criteria) this;
        }

        public Criteria andMarketingUrlBetween(String value1, String value2) {
            addCriterion("marketing_url between", value1, value2, "marketingUrl");
            return (Criteria) this;
        }

        public Criteria andMarketingUrlNotBetween(String value1, String value2) {
            addCriterion("marketing_url not between", value1, value2, "marketingUrl");
            return (Criteria) this;
        }

        public Criteria andMarketingStatusIsNull() {
            addCriterion("marketing_status is null");
            return (Criteria) this;
        }

        public Criteria andMarketingStatusIsNotNull() {
            addCriterion("marketing_status is not null");
            return (Criteria) this;
        }

        public Criteria andMarketingStatusEqualTo(Integer value) {
            addCriterion("marketing_status =", value, "marketingStatus");
            return (Criteria) this;
        }

        public Criteria andMarketingStatusNotEqualTo(Integer value) {
            addCriterion("marketing_status <>", value, "marketingStatus");
            return (Criteria) this;
        }

        public Criteria andMarketingStatusGreaterThan(Integer value) {
            addCriterion("marketing_status >", value, "marketingStatus");
            return (Criteria) this;
        }

        public Criteria andMarketingStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("marketing_status >=", value, "marketingStatus");
            return (Criteria) this;
        }

        public Criteria andMarketingStatusLessThan(Integer value) {
            addCriterion("marketing_status <", value, "marketingStatus");
            return (Criteria) this;
        }

        public Criteria andMarketingStatusLessThanOrEqualTo(Integer value) {
            addCriterion("marketing_status <=", value, "marketingStatus");
            return (Criteria) this;
        }

        public Criteria andMarketingStatusIn(List<Integer> values) {
            addCriterion("marketing_status in", values, "marketingStatus");
            return (Criteria) this;
        }

        public Criteria andMarketingStatusNotIn(List<Integer> values) {
            addCriterion("marketing_status not in", values, "marketingStatus");
            return (Criteria) this;
        }

        public Criteria andMarketingStatusBetween(Integer value1, Integer value2) {
            addCriterion("marketing_status between", value1, value2, "marketingStatus");
            return (Criteria) this;
        }

        public Criteria andMarketingStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("marketing_status not between", value1, value2, "marketingStatus");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }
    }

    /**
     * marketing
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * marketing null
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}