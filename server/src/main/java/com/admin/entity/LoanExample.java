package com.admin.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class LoanExample {
    /**
     * loans
     */
    protected String orderByClause;

    /**
     * loans
     */
    protected boolean distinct;

    /**
     * loans
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated
     */
    public LoanExample() {
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
     * loans null
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andLoanIdIsNull() {
            addCriterion("loan_id is null");
            return (Criteria) this;
        }

        public Criteria andLoanIdIsNotNull() {
            addCriterion("loan_id is not null");
            return (Criteria) this;
        }

        public Criteria andLoanIdEqualTo(Integer value) {
            addCriterion("loan_id =", value, "loanId");
            return (Criteria) this;
        }

        public Criteria andLoanIdNotEqualTo(Integer value) {
            addCriterion("loan_id <>", value, "loanId");
            return (Criteria) this;
        }

        public Criteria andLoanIdGreaterThan(Integer value) {
            addCriterion("loan_id >", value, "loanId");
            return (Criteria) this;
        }

        public Criteria andLoanIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("loan_id >=", value, "loanId");
            return (Criteria) this;
        }

        public Criteria andLoanIdLessThan(Integer value) {
            addCriterion("loan_id <", value, "loanId");
            return (Criteria) this;
        }

        public Criteria andLoanIdLessThanOrEqualTo(Integer value) {
            addCriterion("loan_id <=", value, "loanId");
            return (Criteria) this;
        }

        public Criteria andLoanIdIn(List<Integer> values) {
            addCriterion("loan_id in", values, "loanId");
            return (Criteria) this;
        }

        public Criteria andLoanIdNotIn(List<Integer> values) {
            addCriterion("loan_id not in", values, "loanId");
            return (Criteria) this;
        }

        public Criteria andLoanIdBetween(Integer value1, Integer value2) {
            addCriterion("loan_id between", value1, value2, "loanId");
            return (Criteria) this;
        }

        public Criteria andLoanIdNotBetween(Integer value1, Integer value2) {
            addCriterion("loan_id not between", value1, value2, "loanId");
            return (Criteria) this;
        }

        public Criteria andLoanNameIsNull() {
            addCriterion("loan_name is null");
            return (Criteria) this;
        }

        public Criteria andLoanNameIsNotNull() {
            addCriterion("loan_name is not null");
            return (Criteria) this;
        }

        public Criteria andLoanNameEqualTo(String value) {
            addCriterion("loan_name =", value, "loanName");
            return (Criteria) this;
        }

        public Criteria andLoanNameNotEqualTo(String value) {
            addCriterion("loan_name <>", value, "loanName");
            return (Criteria) this;
        }

        public Criteria andLoanNameGreaterThan(String value) {
            addCriterion("loan_name >", value, "loanName");
            return (Criteria) this;
        }

        public Criteria andLoanNameGreaterThanOrEqualTo(String value) {
            addCriterion("loan_name >=", value, "loanName");
            return (Criteria) this;
        }

        public Criteria andLoanNameLessThan(String value) {
            addCriterion("loan_name <", value, "loanName");
            return (Criteria) this;
        }

        public Criteria andLoanNameLessThanOrEqualTo(String value) {
            addCriterion("loan_name <=", value, "loanName");
            return (Criteria) this;
        }

        public Criteria andLoanNameLike(String value) {
            addCriterion("loan_name like", value, "loanName");
            return (Criteria) this;
        }

        public Criteria andLoanNameNotLike(String value) {
            addCriterion("loan_name not like", value, "loanName");
            return (Criteria) this;
        }

        public Criteria andLoanNameIn(List<String> values) {
            addCriterion("loan_name in", values, "loanName");
            return (Criteria) this;
        }

        public Criteria andLoanNameNotIn(List<String> values) {
            addCriterion("loan_name not in", values, "loanName");
            return (Criteria) this;
        }

        public Criteria andLoanNameBetween(String value1, String value2) {
            addCriterion("loan_name between", value1, value2, "loanName");
            return (Criteria) this;
        }

        public Criteria andLoanNameNotBetween(String value1, String value2) {
            addCriterion("loan_name not between", value1, value2, "loanName");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNicknameIsNull() {
            addCriterion("user_nickname is null");
            return (Criteria) this;
        }

        public Criteria andUserNicknameIsNotNull() {
            addCriterion("user_nickname is not null");
            return (Criteria) this;
        }

        public Criteria andUserNicknameEqualTo(String value) {
            addCriterion("user_nickname =", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameNotEqualTo(String value) {
            addCriterion("user_nickname <>", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameGreaterThan(String value) {
            addCriterion("user_nickname >", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("user_nickname >=", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameLessThan(String value) {
            addCriterion("user_nickname <", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameLessThanOrEqualTo(String value) {
            addCriterion("user_nickname <=", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameLike(String value) {
            addCriterion("user_nickname like", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameNotLike(String value) {
            addCriterion("user_nickname not like", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameIn(List<String> values) {
            addCriterion("user_nickname in", values, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameNotIn(List<String> values) {
            addCriterion("user_nickname not in", values, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameBetween(String value1, String value2) {
            addCriterion("user_nickname between", value1, value2, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameNotBetween(String value1, String value2) {
            addCriterion("user_nickname not between", value1, value2, "userNickname");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNull() {
            addCriterion("customer_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNotNull() {
            addCriterion("customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdEqualTo(Integer value) {
            addCriterion("customer_id =", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotEqualTo(Integer value) {
            addCriterion("customer_id <>", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThan(Integer value) {
            addCriterion("customer_id >", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("customer_id >=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThan(Integer value) {
            addCriterion("customer_id <", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThanOrEqualTo(Integer value) {
            addCriterion("customer_id <=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIn(List<Integer> values) {
            addCriterion("customer_id in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotIn(List<Integer> values) {
            addCriterion("customer_id not in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdBetween(Integer value1, Integer value2) {
            addCriterion("customer_id between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("customer_id not between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIsNull() {
            addCriterion("customer_name is null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIsNotNull() {
            addCriterion("customer_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameEqualTo(String value) {
            addCriterion("customer_name =", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotEqualTo(String value) {
            addCriterion("customer_name <>", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThan(String value) {
            addCriterion("customer_name >", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThanOrEqualTo(String value) {
            addCriterion("customer_name >=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThan(String value) {
            addCriterion("customer_name <", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThanOrEqualTo(String value) {
            addCriterion("customer_name <=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLike(String value) {
            addCriterion("customer_name like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotLike(String value) {
            addCriterion("customer_name not like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIn(List<String> values) {
            addCriterion("customer_name in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotIn(List<String> values) {
            addCriterion("customer_name not in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameBetween(String value1, String value2) {
            addCriterion("customer_name between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotBetween(String value1, String value2) {
            addCriterion("customer_name not between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andLoanTypeIsNull() {
            addCriterion("loan_type is null");
            return (Criteria) this;
        }

        public Criteria andLoanTypeIsNotNull() {
            addCriterion("loan_type is not null");
            return (Criteria) this;
        }

        public Criteria andLoanTypeEqualTo(Integer value) {
            addCriterion("loan_type =", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeNotEqualTo(Integer value) {
            addCriterion("loan_type <>", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeGreaterThan(Integer value) {
            addCriterion("loan_type >", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("loan_type >=", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeLessThan(Integer value) {
            addCriterion("loan_type <", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeLessThanOrEqualTo(Integer value) {
            addCriterion("loan_type <=", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeIn(List<Integer> values) {
            addCriterion("loan_type in", values, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeNotIn(List<Integer> values) {
            addCriterion("loan_type not in", values, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeBetween(Integer value1, Integer value2) {
            addCriterion("loan_type between", value1, value2, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("loan_type not between", value1, value2, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanFeeIsNull() {
            addCriterion("loan_fee is null");
            return (Criteria) this;
        }

        public Criteria andLoanFeeIsNotNull() {
            addCriterion("loan_fee is not null");
            return (Criteria) this;
        }

        public Criteria andLoanFeeEqualTo(BigDecimal value) {
            addCriterion("loan_fee =", value, "loanFee");
            return (Criteria) this;
        }

        public Criteria andLoanFeeNotEqualTo(BigDecimal value) {
            addCriterion("loan_fee <>", value, "loanFee");
            return (Criteria) this;
        }

        public Criteria andLoanFeeGreaterThan(BigDecimal value) {
            addCriterion("loan_fee >", value, "loanFee");
            return (Criteria) this;
        }

        public Criteria andLoanFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_fee >=", value, "loanFee");
            return (Criteria) this;
        }

        public Criteria andLoanFeeLessThan(BigDecimal value) {
            addCriterion("loan_fee <", value, "loanFee");
            return (Criteria) this;
        }

        public Criteria andLoanFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_fee <=", value, "loanFee");
            return (Criteria) this;
        }

        public Criteria andLoanFeeIn(List<BigDecimal> values) {
            addCriterion("loan_fee in", values, "loanFee");
            return (Criteria) this;
        }

        public Criteria andLoanFeeNotIn(List<BigDecimal> values) {
            addCriterion("loan_fee not in", values, "loanFee");
            return (Criteria) this;
        }

        public Criteria andLoanFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_fee between", value1, value2, "loanFee");
            return (Criteria) this;
        }

        public Criteria andLoanFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_fee not between", value1, value2, "loanFee");
            return (Criteria) this;
        }

        public Criteria andLoadInterestIsNull() {
            addCriterion("load_interest is null");
            return (Criteria) this;
        }

        public Criteria andLoadInterestIsNotNull() {
            addCriterion("load_interest is not null");
            return (Criteria) this;
        }

        public Criteria andLoadInterestEqualTo(BigDecimal value) {
            addCriterion("load_interest =", value, "loadInterest");
            return (Criteria) this;
        }

        public Criteria andLoadInterestNotEqualTo(BigDecimal value) {
            addCriterion("load_interest <>", value, "loadInterest");
            return (Criteria) this;
        }

        public Criteria andLoadInterestGreaterThan(BigDecimal value) {
            addCriterion("load_interest >", value, "loadInterest");
            return (Criteria) this;
        }

        public Criteria andLoadInterestGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("load_interest >=", value, "loadInterest");
            return (Criteria) this;
        }

        public Criteria andLoadInterestLessThan(BigDecimal value) {
            addCriterion("load_interest <", value, "loadInterest");
            return (Criteria) this;
        }

        public Criteria andLoadInterestLessThanOrEqualTo(BigDecimal value) {
            addCriterion("load_interest <=", value, "loadInterest");
            return (Criteria) this;
        }

        public Criteria andLoadInterestIn(List<BigDecimal> values) {
            addCriterion("load_interest in", values, "loadInterest");
            return (Criteria) this;
        }

        public Criteria andLoadInterestNotIn(List<BigDecimal> values) {
            addCriterion("load_interest not in", values, "loadInterest");
            return (Criteria) this;
        }

        public Criteria andLoadInterestBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("load_interest between", value1, value2, "loadInterest");
            return (Criteria) this;
        }

        public Criteria andLoadInterestNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("load_interest not between", value1, value2, "loadInterest");
            return (Criteria) this;
        }

        public Criteria andLoanAmountIsNull() {
            addCriterion("loan_amount is null");
            return (Criteria) this;
        }

        public Criteria andLoanAmountIsNotNull() {
            addCriterion("loan_amount is not null");
            return (Criteria) this;
        }

        public Criteria andLoanAmountEqualTo(BigDecimal value) {
            addCriterion("loan_amount =", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountNotEqualTo(BigDecimal value) {
            addCriterion("loan_amount <>", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountGreaterThan(BigDecimal value) {
            addCriterion("loan_amount >", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_amount >=", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountLessThan(BigDecimal value) {
            addCriterion("loan_amount <", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_amount <=", value, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountIn(List<BigDecimal> values) {
            addCriterion("loan_amount in", values, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountNotIn(List<BigDecimal> values) {
            addCriterion("loan_amount not in", values, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_amount between", value1, value2, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_amount not between", value1, value2, "loanAmount");
            return (Criteria) this;
        }

        public Criteria andLoanTotalAmountIsNull() {
            addCriterion("loan_total_amount is null");
            return (Criteria) this;
        }

        public Criteria andLoanTotalAmountIsNotNull() {
            addCriterion("loan_total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andLoanTotalAmountEqualTo(BigDecimal value) {
            addCriterion("loan_total_amount =", value, "loanTotalAmount");
            return (Criteria) this;
        }

        public Criteria andLoanTotalAmountNotEqualTo(BigDecimal value) {
            addCriterion("loan_total_amount <>", value, "loanTotalAmount");
            return (Criteria) this;
        }

        public Criteria andLoanTotalAmountGreaterThan(BigDecimal value) {
            addCriterion("loan_total_amount >", value, "loanTotalAmount");
            return (Criteria) this;
        }

        public Criteria andLoanTotalAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_total_amount >=", value, "loanTotalAmount");
            return (Criteria) this;
        }

        public Criteria andLoanTotalAmountLessThan(BigDecimal value) {
            addCriterion("loan_total_amount <", value, "loanTotalAmount");
            return (Criteria) this;
        }

        public Criteria andLoanTotalAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_total_amount <=", value, "loanTotalAmount");
            return (Criteria) this;
        }

        public Criteria andLoanTotalAmountIn(List<BigDecimal> values) {
            addCriterion("loan_total_amount in", values, "loanTotalAmount");
            return (Criteria) this;
        }

        public Criteria andLoanTotalAmountNotIn(List<BigDecimal> values) {
            addCriterion("loan_total_amount not in", values, "loanTotalAmount");
            return (Criteria) this;
        }

        public Criteria andLoanTotalAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_total_amount between", value1, value2, "loanTotalAmount");
            return (Criteria) this;
        }

        public Criteria andLoanTotalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_total_amount not between", value1, value2, "loanTotalAmount");
            return (Criteria) this;
        }

        public Criteria andLoanRepayAmountIsNull() {
            addCriterion("loan_repay_amount is null");
            return (Criteria) this;
        }

        public Criteria andLoanRepayAmountIsNotNull() {
            addCriterion("loan_repay_amount is not null");
            return (Criteria) this;
        }

        public Criteria andLoanRepayAmountEqualTo(BigDecimal value) {
            addCriterion("loan_repay_amount =", value, "loanRepayAmount");
            return (Criteria) this;
        }

        public Criteria andLoanRepayAmountNotEqualTo(BigDecimal value) {
            addCriterion("loan_repay_amount <>", value, "loanRepayAmount");
            return (Criteria) this;
        }

        public Criteria andLoanRepayAmountGreaterThan(BigDecimal value) {
            addCriterion("loan_repay_amount >", value, "loanRepayAmount");
            return (Criteria) this;
        }

        public Criteria andLoanRepayAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_repay_amount >=", value, "loanRepayAmount");
            return (Criteria) this;
        }

        public Criteria andLoanRepayAmountLessThan(BigDecimal value) {
            addCriterion("loan_repay_amount <", value, "loanRepayAmount");
            return (Criteria) this;
        }

        public Criteria andLoanRepayAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_repay_amount <=", value, "loanRepayAmount");
            return (Criteria) this;
        }

        public Criteria andLoanRepayAmountIn(List<BigDecimal> values) {
            addCriterion("loan_repay_amount in", values, "loanRepayAmount");
            return (Criteria) this;
        }

        public Criteria andLoanRepayAmountNotIn(List<BigDecimal> values) {
            addCriterion("loan_repay_amount not in", values, "loanRepayAmount");
            return (Criteria) this;
        }

        public Criteria andLoanRepayAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_repay_amount between", value1, value2, "loanRepayAmount");
            return (Criteria) this;
        }

        public Criteria andLoanRepayAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_repay_amount not between", value1, value2, "loanRepayAmount");
            return (Criteria) this;
        }

        public Criteria andLoanStatusIsNull() {
            addCriterion("loan_status is null");
            return (Criteria) this;
        }

        public Criteria andLoanStatusIsNotNull() {
            addCriterion("loan_status is not null");
            return (Criteria) this;
        }

        public Criteria andLoanStatusEqualTo(Integer value) {
            addCriterion("loan_status =", value, "loanStatus");
            return (Criteria) this;
        }

        public Criteria andLoanStatusNotEqualTo(Integer value) {
            addCriterion("loan_status <>", value, "loanStatus");
            return (Criteria) this;
        }

        public Criteria andLoanStatusGreaterThan(Integer value) {
            addCriterion("loan_status >", value, "loanStatus");
            return (Criteria) this;
        }

        public Criteria andLoanStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("loan_status >=", value, "loanStatus");
            return (Criteria) this;
        }

        public Criteria andLoanStatusLessThan(Integer value) {
            addCriterion("loan_status <", value, "loanStatus");
            return (Criteria) this;
        }

        public Criteria andLoanStatusLessThanOrEqualTo(Integer value) {
            addCriterion("loan_status <=", value, "loanStatus");
            return (Criteria) this;
        }

        public Criteria andLoanStatusIn(List<Integer> values) {
            addCriterion("loan_status in", values, "loanStatus");
            return (Criteria) this;
        }

        public Criteria andLoanStatusNotIn(List<Integer> values) {
            addCriterion("loan_status not in", values, "loanStatus");
            return (Criteria) this;
        }

        public Criteria andLoanStatusBetween(Integer value1, Integer value2) {
            addCriterion("loan_status between", value1, value2, "loanStatus");
            return (Criteria) this;
        }

        public Criteria andLoanStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("loan_status not between", value1, value2, "loanStatus");
            return (Criteria) this;
        }

        public Criteria andLoanEndDateIsNull() {
            addCriterion("loan_end_date is null");
            return (Criteria) this;
        }

        public Criteria andLoanEndDateIsNotNull() {
            addCriterion("loan_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andLoanEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("loan_end_date =", value, "loanEndDate");
            return (Criteria) this;
        }

        public Criteria andLoanEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("loan_end_date <>", value, "loanEndDate");
            return (Criteria) this;
        }

        public Criteria andLoanEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("loan_end_date >", value, "loanEndDate");
            return (Criteria) this;
        }

        public Criteria andLoanEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("loan_end_date >=", value, "loanEndDate");
            return (Criteria) this;
        }

        public Criteria andLoanEndDateLessThan(Date value) {
            addCriterionForJDBCDate("loan_end_date <", value, "loanEndDate");
            return (Criteria) this;
        }

        public Criteria andLoanEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("loan_end_date <=", value, "loanEndDate");
            return (Criteria) this;
        }

        public Criteria andLoanEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("loan_end_date in", values, "loanEndDate");
            return (Criteria) this;
        }

        public Criteria andLoanEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("loan_end_date not in", values, "loanEndDate");
            return (Criteria) this;
        }

        public Criteria andLoanEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("loan_end_date between", value1, value2, "loanEndDate");
            return (Criteria) this;
        }

        public Criteria andLoanEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("loan_end_date not between", value1, value2, "loanEndDate");
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
     * loans
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * loans null
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