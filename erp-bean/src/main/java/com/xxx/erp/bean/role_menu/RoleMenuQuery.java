package com.xxx.erp.bean.role_menu;

import java.util.ArrayList;
import java.util.List;

public class RoleMenuQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public RoleMenuQuery() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo=pageNo;
        this.startRow = (pageNo-1)*this.pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setStartRow(Integer startRow) {
        this.startRow=startRow;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize=pageSize;
        this.startRow = (pageNo-1)*this.pageSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setFields(String fields) {
        this.fields=fields;
    }

    public String getFields() {
        return fields;
    }

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

        public Criteria andRoleuuidIsNull() {
            addCriterion("roleUuid is null");
            return (Criteria) this;
        }

        public Criteria andRoleuuidIsNotNull() {
            addCriterion("roleUuid is not null");
            return (Criteria) this;
        }

        public Criteria andRoleuuidEqualTo(Long value) {
            addCriterion("roleUuid =", value, "roleuuid");
            return (Criteria) this;
        }

        public Criteria andRoleuuidNotEqualTo(Long value) {
            addCriterion("roleUuid <>", value, "roleuuid");
            return (Criteria) this;
        }

        public Criteria andRoleuuidGreaterThan(Long value) {
            addCriterion("roleUuid >", value, "roleuuid");
            return (Criteria) this;
        }

        public Criteria andRoleuuidGreaterThanOrEqualTo(Long value) {
            addCriterion("roleUuid >=", value, "roleuuid");
            return (Criteria) this;
        }

        public Criteria andRoleuuidLessThan(Long value) {
            addCriterion("roleUuid <", value, "roleuuid");
            return (Criteria) this;
        }

        public Criteria andRoleuuidLessThanOrEqualTo(Long value) {
            addCriterion("roleUuid <=", value, "roleuuid");
            return (Criteria) this;
        }

        public Criteria andRoleuuidIn(List<Long> values) {
            addCriterion("roleUuid in", values, "roleuuid");
            return (Criteria) this;
        }

        public Criteria andRoleuuidNotIn(List<Long> values) {
            addCriterion("roleUuid not in", values, "roleuuid");
            return (Criteria) this;
        }

        public Criteria andRoleuuidBetween(Long value1, Long value2) {
            addCriterion("roleUuid between", value1, value2, "roleuuid");
            return (Criteria) this;
        }

        public Criteria andRoleuuidNotBetween(Long value1, Long value2) {
            addCriterion("roleUuid not between", value1, value2, "roleuuid");
            return (Criteria) this;
        }

        public Criteria andMenuuuidIsNull() {
            addCriterion("menuUuid is null");
            return (Criteria) this;
        }

        public Criteria andMenuuuidIsNotNull() {
            addCriterion("menuUuid is not null");
            return (Criteria) this;
        }

        public Criteria andMenuuuidEqualTo(Long value) {
            addCriterion("menuUuid =", value, "menuuuid");
            return (Criteria) this;
        }

        public Criteria andMenuuuidNotEqualTo(Long value) {
            addCriterion("menuUuid <>", value, "menuuuid");
            return (Criteria) this;
        }

        public Criteria andMenuuuidGreaterThan(Long value) {
            addCriterion("menuUuid >", value, "menuuuid");
            return (Criteria) this;
        }

        public Criteria andMenuuuidGreaterThanOrEqualTo(Long value) {
            addCriterion("menuUuid >=", value, "menuuuid");
            return (Criteria) this;
        }

        public Criteria andMenuuuidLessThan(Long value) {
            addCriterion("menuUuid <", value, "menuuuid");
            return (Criteria) this;
        }

        public Criteria andMenuuuidLessThanOrEqualTo(Long value) {
            addCriterion("menuUuid <=", value, "menuuuid");
            return (Criteria) this;
        }

        public Criteria andMenuuuidIn(List<Long> values) {
            addCriterion("menuUuid in", values, "menuuuid");
            return (Criteria) this;
        }

        public Criteria andMenuuuidNotIn(List<Long> values) {
            addCriterion("menuUuid not in", values, "menuuuid");
            return (Criteria) this;
        }

        public Criteria andMenuuuidBetween(Long value1, Long value2) {
            addCriterion("menuUuid between", value1, value2, "menuuuid");
            return (Criteria) this;
        }

        public Criteria andMenuuuidNotBetween(Long value1, Long value2) {
            addCriterion("menuUuid not between", value1, value2, "menuuuid");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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