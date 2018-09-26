package com.wx.dev.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TblCorpinfoExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table tbl_corpinfo
	 * @mbggenerated  Mon Nov 21 16:09:46 CST 2016
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table tbl_corpinfo
	 * @mbggenerated  Mon Nov 21 16:09:46 CST 2016
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table tbl_corpinfo
	 * @mbggenerated  Mon Nov 21 16:09:46 CST 2016
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tbl_corpinfo
	 * @mbggenerated  Mon Nov 21 16:09:46 CST 2016
	 */
	public TblCorpinfoExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tbl_corpinfo
	 * @mbggenerated  Mon Nov 21 16:09:46 CST 2016
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tbl_corpinfo
	 * @mbggenerated  Mon Nov 21 16:09:46 CST 2016
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tbl_corpinfo
	 * @mbggenerated  Mon Nov 21 16:09:46 CST 2016
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tbl_corpinfo
	 * @mbggenerated  Mon Nov 21 16:09:46 CST 2016
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tbl_corpinfo
	 * @mbggenerated  Mon Nov 21 16:09:46 CST 2016
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tbl_corpinfo
	 * @mbggenerated  Mon Nov 21 16:09:46 CST 2016
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tbl_corpinfo
	 * @mbggenerated  Mon Nov 21 16:09:46 CST 2016
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tbl_corpinfo
	 * @mbggenerated  Mon Nov 21 16:09:46 CST 2016
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tbl_corpinfo
	 * @mbggenerated  Mon Nov 21 16:09:46 CST 2016
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tbl_corpinfo
	 * @mbggenerated  Mon Nov 21 16:09:46 CST 2016
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table tbl_corpinfo
	 * @mbggenerated  Mon Nov 21 16:09:46 CST 2016
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

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
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

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andCorpidIsNull() {
			addCriterion("corpId is null");
			return (Criteria) this;
		}

		public Criteria andCorpidIsNotNull() {
			addCriterion("corpId is not null");
			return (Criteria) this;
		}

		public Criteria andCorpidEqualTo(String value) {
			addCriterion("corpId =", value, "corpid");
			return (Criteria) this;
		}

		public Criteria andCorpidNotEqualTo(String value) {
			addCriterion("corpId <>", value, "corpid");
			return (Criteria) this;
		}

		public Criteria andCorpidGreaterThan(String value) {
			addCriterion("corpId >", value, "corpid");
			return (Criteria) this;
		}

		public Criteria andCorpidGreaterThanOrEqualTo(String value) {
			addCriterion("corpId >=", value, "corpid");
			return (Criteria) this;
		}

		public Criteria andCorpidLessThan(String value) {
			addCriterion("corpId <", value, "corpid");
			return (Criteria) this;
		}

		public Criteria andCorpidLessThanOrEqualTo(String value) {
			addCriterion("corpId <=", value, "corpid");
			return (Criteria) this;
		}

		public Criteria andCorpidLike(String value) {
			addCriterion("corpId like", value, "corpid");
			return (Criteria) this;
		}

		public Criteria andCorpidNotLike(String value) {
			addCriterion("corpId not like", value, "corpid");
			return (Criteria) this;
		}

		public Criteria andCorpidIn(List<String> values) {
			addCriterion("corpId in", values, "corpid");
			return (Criteria) this;
		}

		public Criteria andCorpidNotIn(List<String> values) {
			addCriterion("corpId not in", values, "corpid");
			return (Criteria) this;
		}

		public Criteria andCorpidBetween(String value1, String value2) {
			addCriterion("corpId between", value1, value2, "corpid");
			return (Criteria) this;
		}

		public Criteria andCorpidNotBetween(String value1, String value2) {
			addCriterion("corpId not between", value1, value2, "corpid");
			return (Criteria) this;
		}

		public Criteria andCorpsecretIsNull() {
			addCriterion("corpSecret is null");
			return (Criteria) this;
		}

		public Criteria andCorpsecretIsNotNull() {
			addCriterion("corpSecret is not null");
			return (Criteria) this;
		}

		public Criteria andCorpsecretEqualTo(String value) {
			addCriterion("corpSecret =", value, "corpsecret");
			return (Criteria) this;
		}

		public Criteria andCorpsecretNotEqualTo(String value) {
			addCriterion("corpSecret <>", value, "corpsecret");
			return (Criteria) this;
		}

		public Criteria andCorpsecretGreaterThan(String value) {
			addCriterion("corpSecret >", value, "corpsecret");
			return (Criteria) this;
		}

		public Criteria andCorpsecretGreaterThanOrEqualTo(String value) {
			addCriterion("corpSecret >=", value, "corpsecret");
			return (Criteria) this;
		}

		public Criteria andCorpsecretLessThan(String value) {
			addCriterion("corpSecret <", value, "corpsecret");
			return (Criteria) this;
		}

		public Criteria andCorpsecretLessThanOrEqualTo(String value) {
			addCriterion("corpSecret <=", value, "corpsecret");
			return (Criteria) this;
		}

		public Criteria andCorpsecretLike(String value) {
			addCriterion("corpSecret like", value, "corpsecret");
			return (Criteria) this;
		}

		public Criteria andCorpsecretNotLike(String value) {
			addCriterion("corpSecret not like", value, "corpsecret");
			return (Criteria) this;
		}

		public Criteria andCorpsecretIn(List<String> values) {
			addCriterion("corpSecret in", values, "corpsecret");
			return (Criteria) this;
		}

		public Criteria andCorpsecretNotIn(List<String> values) {
			addCriterion("corpSecret not in", values, "corpsecret");
			return (Criteria) this;
		}

		public Criteria andCorpsecretBetween(String value1, String value2) {
			addCriterion("corpSecret between", value1, value2, "corpsecret");
			return (Criteria) this;
		}

		public Criteria andCorpsecretNotBetween(String value1, String value2) {
			addCriterion("corpSecret not between", value1, value2, "corpsecret");
			return (Criteria) this;
		}

		public Criteria andCorpnameIsNull() {
			addCriterion("corpName is null");
			return (Criteria) this;
		}

		public Criteria andCorpnameIsNotNull() {
			addCriterion("corpName is not null");
			return (Criteria) this;
		}

		public Criteria andCorpnameEqualTo(String value) {
			addCriterion("corpName =", value, "corpname");
			return (Criteria) this;
		}

		public Criteria andCorpnameNotEqualTo(String value) {
			addCriterion("corpName <>", value, "corpname");
			return (Criteria) this;
		}

		public Criteria andCorpnameGreaterThan(String value) {
			addCriterion("corpName >", value, "corpname");
			return (Criteria) this;
		}

		public Criteria andCorpnameGreaterThanOrEqualTo(String value) {
			addCriterion("corpName >=", value, "corpname");
			return (Criteria) this;
		}

		public Criteria andCorpnameLessThan(String value) {
			addCriterion("corpName <", value, "corpname");
			return (Criteria) this;
		}

		public Criteria andCorpnameLessThanOrEqualTo(String value) {
			addCriterion("corpName <=", value, "corpname");
			return (Criteria) this;
		}

		public Criteria andCorpnameLike(String value) {
			addCriterion("corpName like", value, "corpname");
			return (Criteria) this;
		}

		public Criteria andCorpnameNotLike(String value) {
			addCriterion("corpName not like", value, "corpname");
			return (Criteria) this;
		}

		public Criteria andCorpnameIn(List<String> values) {
			addCriterion("corpName in", values, "corpname");
			return (Criteria) this;
		}

		public Criteria andCorpnameNotIn(List<String> values) {
			addCriterion("corpName not in", values, "corpname");
			return (Criteria) this;
		}

		public Criteria andCorpnameBetween(String value1, String value2) {
			addCriterion("corpName between", value1, value2, "corpname");
			return (Criteria) this;
		}

		public Criteria andCorpnameNotBetween(String value1, String value2) {
			addCriterion("corpName not between", value1, value2, "corpname");
			return (Criteria) this;
		}

		public Criteria andAccesstokenIsNull() {
			addCriterion("accessToken is null");
			return (Criteria) this;
		}

		public Criteria andAccesstokenIsNotNull() {
			addCriterion("accessToken is not null");
			return (Criteria) this;
		}

		public Criteria andAccesstokenEqualTo(String value) {
			addCriterion("accessToken =", value, "accesstoken");
			return (Criteria) this;
		}

		public Criteria andAccesstokenNotEqualTo(String value) {
			addCriterion("accessToken <>", value, "accesstoken");
			return (Criteria) this;
		}

		public Criteria andAccesstokenGreaterThan(String value) {
			addCriterion("accessToken >", value, "accesstoken");
			return (Criteria) this;
		}

		public Criteria andAccesstokenGreaterThanOrEqualTo(String value) {
			addCriterion("accessToken >=", value, "accesstoken");
			return (Criteria) this;
		}

		public Criteria andAccesstokenLessThan(String value) {
			addCriterion("accessToken <", value, "accesstoken");
			return (Criteria) this;
		}

		public Criteria andAccesstokenLessThanOrEqualTo(String value) {
			addCriterion("accessToken <=", value, "accesstoken");
			return (Criteria) this;
		}

		public Criteria andAccesstokenLike(String value) {
			addCriterion("accessToken like", value, "accesstoken");
			return (Criteria) this;
		}

		public Criteria andAccesstokenNotLike(String value) {
			addCriterion("accessToken not like", value, "accesstoken");
			return (Criteria) this;
		}

		public Criteria andAccesstokenIn(List<String> values) {
			addCriterion("accessToken in", values, "accesstoken");
			return (Criteria) this;
		}

		public Criteria andAccesstokenNotIn(List<String> values) {
			addCriterion("accessToken not in", values, "accesstoken");
			return (Criteria) this;
		}

		public Criteria andAccesstokenBetween(String value1, String value2) {
			addCriterion("accessToken between", value1, value2, "accesstoken");
			return (Criteria) this;
		}

		public Criteria andAccesstokenNotBetween(String value1, String value2) {
			addCriterion("accessToken not between", value1, value2,
					"accesstoken");
			return (Criteria) this;
		}

		public Criteria andCreatedateIsNull() {
			addCriterion("createDate is null");
			return (Criteria) this;
		}

		public Criteria andCreatedateIsNotNull() {
			addCriterion("createDate is not null");
			return (Criteria) this;
		}

		public Criteria andCreatedateEqualTo(Date value) {
			addCriterion("createDate =", value, "createdate");
			return (Criteria) this;
		}

		public Criteria andCreatedateNotEqualTo(Date value) {
			addCriterion("createDate <>", value, "createdate");
			return (Criteria) this;
		}

		public Criteria andCreatedateGreaterThan(Date value) {
			addCriterion("createDate >", value, "createdate");
			return (Criteria) this;
		}

		public Criteria andCreatedateGreaterThanOrEqualTo(Date value) {
			addCriterion("createDate >=", value, "createdate");
			return (Criteria) this;
		}

		public Criteria andCreatedateLessThan(Date value) {
			addCriterion("createDate <", value, "createdate");
			return (Criteria) this;
		}

		public Criteria andCreatedateLessThanOrEqualTo(Date value) {
			addCriterion("createDate <=", value, "createdate");
			return (Criteria) this;
		}

		public Criteria andCreatedateIn(List<Date> values) {
			addCriterion("createDate in", values, "createdate");
			return (Criteria) this;
		}

		public Criteria andCreatedateNotIn(List<Date> values) {
			addCriterion("createDate not in", values, "createdate");
			return (Criteria) this;
		}

		public Criteria andCreatedateBetween(Date value1, Date value2) {
			addCriterion("createDate between", value1, value2, "createdate");
			return (Criteria) this;
		}

		public Criteria andCreatedateNotBetween(Date value1, Date value2) {
			addCriterion("createDate not between", value1, value2, "createdate");
			return (Criteria) this;
		}

		public Criteria andUpddateIsNull() {
			addCriterion("updDate is null");
			return (Criteria) this;
		}

		public Criteria andUpddateIsNotNull() {
			addCriterion("updDate is not null");
			return (Criteria) this;
		}

		public Criteria andUpddateEqualTo(Date value) {
			addCriterion("updDate =", value, "upddate");
			return (Criteria) this;
		}

		public Criteria andUpddateNotEqualTo(Date value) {
			addCriterion("updDate <>", value, "upddate");
			return (Criteria) this;
		}

		public Criteria andUpddateGreaterThan(Date value) {
			addCriterion("updDate >", value, "upddate");
			return (Criteria) this;
		}

		public Criteria andUpddateGreaterThanOrEqualTo(Date value) {
			addCriterion("updDate >=", value, "upddate");
			return (Criteria) this;
		}

		public Criteria andUpddateLessThan(Date value) {
			addCriterion("updDate <", value, "upddate");
			return (Criteria) this;
		}

		public Criteria andUpddateLessThanOrEqualTo(Date value) {
			addCriterion("updDate <=", value, "upddate");
			return (Criteria) this;
		}

		public Criteria andUpddateIn(List<Date> values) {
			addCriterion("updDate in", values, "upddate");
			return (Criteria) this;
		}

		public Criteria andUpddateNotIn(List<Date> values) {
			addCriterion("updDate not in", values, "upddate");
			return (Criteria) this;
		}

		public Criteria andUpddateBetween(Date value1, Date value2) {
			addCriterion("updDate between", value1, value2, "upddate");
			return (Criteria) this;
		}

		public Criteria andUpddateNotBetween(Date value1, Date value2) {
			addCriterion("updDate not between", value1, value2, "upddate");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table tbl_corpinfo
	 * @mbggenerated  Mon Nov 21 16:09:46 CST 2016
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

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tbl_corpinfo
     *
     * @mbggenerated do_not_delete_during_merge Mon Nov 21 15:22:42 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}