/*
 * Copyright (C) YYYY-YYYY XXXXXXXXXXXXX
 * mailto:AAAA@DDDD.COM
 *
 */
package com.jcboe.home.instruction.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * 
 * Date: 09-Dec-2022 Class: TimeMgmtConfig.java Purpose: v
 *
 */
public class HomeInstructionConfig implements Serializable {

	private static final long serialVersionUID = -5521332406459558253L;

	@JsonProperty("configID")
	private int configId;
	private String configKey;
	private String configValue;
	@JsonProperty("IsActive")
	private boolean active;

	public HomeInstructionConfig() {
	}

	public HomeInstructionConfig(int configId, String configKey, String configValue, boolean active) {
		this.configId = configId;
		this.configKey = configKey;
		this.configValue = configValue;
		this.active = active;
	}

	public int getConfigId() {
		return configId;
	}

	public void setConfigId(int configId) {
		this.configId = configId;
	}

	public String getConfigKey() {
		return configKey;
	}

	public void setConfigKey(String configKey) {
		this.configKey = configKey;
	}

	public String getConfigValue() {
		return configValue;
	}

	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "AthPrtlConfig [configId=" + configId + ", configKey=" + configKey + ", configValue=" + configValue
				+ ", active=" + active + "]";
	}

}
