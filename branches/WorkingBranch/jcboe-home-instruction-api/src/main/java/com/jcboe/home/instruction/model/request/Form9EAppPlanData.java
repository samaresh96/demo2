/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.model.request;

public class Form9EAppPlanData {
	private String indicator;
	private Integer id;
	private String planType;
	private String plan1;
	private String plan2;

	public Form9EAppPlanData() {
	}
	
	public Form9EAppPlanData(String indicator, Integer id, String planType, String plan1, String plan2) {
		this.indicator = indicator;
		this.id = id;
		this.planType = planType;
		this.plan1 = plan1;
		this.plan2 = plan2;
	}

	public String getIndicator() {
		return indicator;
	}

	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public String getPlan1() {
		return plan1;
	}

	public void setPlan1(String plan1) {
		this.plan1 = plan1;
	}

	public String getPlan2() {
		return plan2;
	}

	public void setPlan2(String plan2) {
		this.plan2 = plan2;
	}

	@Override
	public String toString() {
		return "Form9EAppPlanData [indicator=" + indicator + ", id=" + id + ", planType=" + planType + ", plan1="
				+ plan1 + ", plan2=" + plan2 + "]";
	}

}
