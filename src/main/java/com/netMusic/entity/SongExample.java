package com.netMusic.entity;

import java.util.ArrayList;
import java.util.List;

public class SongExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SongExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCommentThreadIdIsNull() {
            addCriterion("comment_thread_id is null");
            return (Criteria) this;
        }

        public Criteria andCommentThreadIdIsNotNull() {
            addCriterion("comment_thread_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommentThreadIdEqualTo(String value) {
            addCriterion("comment_thread_id =", value, "commentThreadId");
            return (Criteria) this;
        }

        public Criteria andCommentThreadIdNotEqualTo(String value) {
            addCriterion("comment_thread_id <>", value, "commentThreadId");
            return (Criteria) this;
        }

        public Criteria andCommentThreadIdGreaterThan(String value) {
            addCriterion("comment_thread_id >", value, "commentThreadId");
            return (Criteria) this;
        }

        public Criteria andCommentThreadIdGreaterThanOrEqualTo(String value) {
            addCriterion("comment_thread_id >=", value, "commentThreadId");
            return (Criteria) this;
        }

        public Criteria andCommentThreadIdLessThan(String value) {
            addCriterion("comment_thread_id <", value, "commentThreadId");
            return (Criteria) this;
        }

        public Criteria andCommentThreadIdLessThanOrEqualTo(String value) {
            addCriterion("comment_thread_id <=", value, "commentThreadId");
            return (Criteria) this;
        }

        public Criteria andCommentThreadIdLike(String value) {
            addCriterion("comment_thread_id like", value, "commentThreadId");
            return (Criteria) this;
        }

        public Criteria andCommentThreadIdNotLike(String value) {
            addCriterion("comment_thread_id not like", value, "commentThreadId");
            return (Criteria) this;
        }

        public Criteria andCommentThreadIdIn(List<String> values) {
            addCriterion("comment_thread_id in", values, "commentThreadId");
            return (Criteria) this;
        }

        public Criteria andCommentThreadIdNotIn(List<String> values) {
            addCriterion("comment_thread_id not in", values, "commentThreadId");
            return (Criteria) this;
        }

        public Criteria andCommentThreadIdBetween(String value1, String value2) {
            addCriterion("comment_thread_id between", value1, value2, "commentThreadId");
            return (Criteria) this;
        }

        public Criteria andCommentThreadIdNotBetween(String value1, String value2) {
            addCriterion("comment_thread_id not between", value1, value2, "commentThreadId");
            return (Criteria) this;
        }

        public Criteria andMp3urlIsNull() {
            addCriterion("mp3url is null");
            return (Criteria) this;
        }

        public Criteria andMp3urlIsNotNull() {
            addCriterion("mp3url is not null");
            return (Criteria) this;
        }

        public Criteria andMp3urlEqualTo(String value) {
            addCriterion("mp3url =", value, "mp3url");
            return (Criteria) this;
        }

        public Criteria andMp3urlNotEqualTo(String value) {
            addCriterion("mp3url <>", value, "mp3url");
            return (Criteria) this;
        }

        public Criteria andMp3urlGreaterThan(String value) {
            addCriterion("mp3url >", value, "mp3url");
            return (Criteria) this;
        }

        public Criteria andMp3urlGreaterThanOrEqualTo(String value) {
            addCriterion("mp3url >=", value, "mp3url");
            return (Criteria) this;
        }

        public Criteria andMp3urlLessThan(String value) {
            addCriterion("mp3url <", value, "mp3url");
            return (Criteria) this;
        }

        public Criteria andMp3urlLessThanOrEqualTo(String value) {
            addCriterion("mp3url <=", value, "mp3url");
            return (Criteria) this;
        }

        public Criteria andMp3urlLike(String value) {
            addCriterion("mp3url like", value, "mp3url");
            return (Criteria) this;
        }

        public Criteria andMp3urlNotLike(String value) {
            addCriterion("mp3url not like", value, "mp3url");
            return (Criteria) this;
        }

        public Criteria andMp3urlIn(List<String> values) {
            addCriterion("mp3url in", values, "mp3url");
            return (Criteria) this;
        }

        public Criteria andMp3urlNotIn(List<String> values) {
            addCriterion("mp3url not in", values, "mp3url");
            return (Criteria) this;
        }

        public Criteria andMp3urlBetween(String value1, String value2) {
            addCriterion("mp3url between", value1, value2, "mp3url");
            return (Criteria) this;
        }

        public Criteria andMp3urlNotBetween(String value1, String value2) {
            addCriterion("mp3url not between", value1, value2, "mp3url");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andRecordIdIsNull() {
            addCriterion("record_id is null");
            return (Criteria) this;
        }

        public Criteria andRecordIdIsNotNull() {
            addCriterion("record_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecordIdEqualTo(Integer value) {
            addCriterion("record_id =", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotEqualTo(Integer value) {
            addCriterion("record_id <>", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThan(Integer value) {
            addCriterion("record_id >", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("record_id >=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThan(Integer value) {
            addCriterion("record_id <", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThanOrEqualTo(Integer value) {
            addCriterion("record_id <=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdIn(List<Integer> values) {
            addCriterion("record_id in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotIn(List<Integer> values) {
            addCriterion("record_id not in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdBetween(Integer value1, Integer value2) {
            addCriterion("record_id between", value1, value2, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotBetween(Integer value1, Integer value2) {
            addCriterion("record_id not between", value1, value2, "recordId");
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