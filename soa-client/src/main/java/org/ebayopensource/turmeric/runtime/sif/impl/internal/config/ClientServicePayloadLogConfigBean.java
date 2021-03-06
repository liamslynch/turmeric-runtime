/*******************************************************************************
 * Copyright (c) 2006-2010 eBay Inc. All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *******************************************************************************/
package org.ebayopensource.turmeric.runtime.sif.impl.internal.config;

import java.util.HashMap;
import java.util.List;

import org.ebayopensource.turmeric.runtime.common.exceptions.ServiceException;
import org.ebayopensource.turmeric.runtime.common.impl.internal.config.FrameworkHandlerConfig;
import org.ebayopensource.turmeric.runtime.common.impl.pipeline.BaseLoggingHandler;

import com.ebay.kernel.bean.configuration.BeanPropertyInfo;
import com.ebay.kernel.bean.configuration.ConfigCategoryCreateException;
import com.ebay.kernel.configuration.ConfigurationException;

public class ClientServicePayloadLogConfigBean extends ClientServiceConfigBean {
	private static final long serialVersionUID = 7934173099185743611L;

	// Alias'ing with the LoggingHandler options, so that all handler options are listed in one place
	public static final String PROP_RequestPAYLOADLOG = BaseLoggingHandler.REQUEST_PAYLOAD_LOG_LEVEL;
	public static final String PROP_RequestPAYLOADCALLOG = "cal-request-payload-log-level";
	public static final String PROP_ResponsePAYLOADLOG = BaseLoggingHandler.RESPONSE_PAYLOAD_LOG_LEVEL;
	public static final String PROP_ResponsePAYLOADCALLOG = "cal-response-payload-log-level";
	public static final String PROP_PAYLOADMAXBYTES = "payload-max-bytes";

		
	public static final BeanPropertyInfo RequestPAYLOADCALLOG = createBeanPropertyInfo(
			"m_RequestPayloadCalLog", PROP_RequestPAYLOADCALLOG, true);
	public static final BeanPropertyInfo ResponsePAYLOADCALLOG = createBeanPropertyInfo(
			"m_ResponsePayloadCalLog", PROP_ResponsePAYLOADCALLOG, true);

	public static final BeanPropertyInfo RequestPAYLOADLOG = createBeanPropertyInfo(
			"m_RequestPayloadLog", PROP_RequestPAYLOADLOG, true);
	public static final BeanPropertyInfo ResponsePAYLOADLOG = createBeanPropertyInfo(
			"m_ResponsePayloadLog", PROP_ResponsePAYLOADLOG, true);

	public static final BeanPropertyInfo PAYLOADMAXBYTES = createBeanPropertyInfo(
			"m_PayloadMaxBytes", PROP_PAYLOADMAXBYTES, true);



	public static final int ONE_MB = 1024*1024;
	public static final int FOUR_KB = 4096;
	// modifiable properties
	private String m_RequestPayloadLog;
	private String m_RequestPayloadCalLog;

	private String m_ResponsePayloadLog;
	private String m_ResponsePayloadCalLog;
	private String  m_PayloadMaxBytes;


	ClientServicePayloadLogConfigBean(ClientConfigHolder config) throws ConfigCategoryCreateException, ConfigurationException, ServiceException {
		super(config);
		init(config, "PayloadLog");
		
	}

	public String getRequestPayloadLog() {
		if (m_RequestPayloadLog == null)
			return BaseLoggingHandler.PAYLOADLOG_ERRORONLY;

		return m_RequestPayloadLog;
	}

	public String getRequestPayloadCalLog() {
		if (m_RequestPayloadCalLog == null)
			return BaseLoggingHandler.PAYLOADLOG_ERRORONLY;

		return m_RequestPayloadCalLog;
	}

	public void setRequestPayloadLog(String value) {
		changeProperty(RequestPAYLOADLOG, m_RequestPayloadLog, value);
	}

	public void setRequestPayloadCalLog(String value) {
		changeProperty(RequestPAYLOADCALLOG, m_RequestPayloadCalLog, value);
	}

	public String getResponsePayloadLog() {
		if (m_ResponsePayloadLog == null)
			return BaseLoggingHandler.PAYLOADLOG_ERRORONLY;

		return m_ResponsePayloadLog;
	}

	public String getResponsePayloadCalLog() {
		if (m_ResponsePayloadCalLog == null)
			return BaseLoggingHandler.PAYLOADLOG_ERRORONLY;

		return m_ResponsePayloadCalLog;
	}

	public void setResponsePayloadLog(String value) {
		changeProperty(ResponsePAYLOADLOG, m_ResponsePayloadLog, value);
	}

	public void setResponsePayloadCalLog(String value) {
		changeProperty(ResponsePAYLOADCALLOG, m_ResponsePayloadCalLog, value);
	}
	
	public String getPayloadMaxBytes() {
		return m_PayloadMaxBytes;
	}

	public void setPayloadMaxBytes(String value) {
		changeProperty(PAYLOADMAXBYTES, m_PayloadMaxBytes, value);
	}



	@Override
	protected void setDefaultsFromConfig(ClientConfigHolder config) {

		m_RequestPayloadLog = getRequestPayloadLog(config);
		m_RequestPayloadCalLog = getRequestPayloadCalLog(config);
		m_ResponsePayloadLog = getResponsePayloadLog(config);
		m_ResponsePayloadCalLog = getResponsePayloadCalLog(config);
		m_PayloadMaxBytes = getPayloadMaxBytes(config);
	}

	@Override
	protected void updateConfigHolder(ClientConfigHolder config) {
		updateConfigHolderOption(config, PROP_RequestPAYLOADLOG, m_RequestPayloadLog);
		updateConfigHolderOption(config, PROP_RequestPAYLOADCALLOG, m_RequestPayloadCalLog);
		updateConfigHolderOption(config, PROP_ResponsePAYLOADLOG, m_ResponsePayloadLog);
		updateConfigHolderOption(config, PROP_ResponsePAYLOADCALLOG, m_ResponsePayloadCalLog);
		updateConfigHolderOption(config, PROP_PAYLOADMAXBYTES, m_PayloadMaxBytes);
	}

	public static void updateConfigHolderOption(ClientConfigHolder holder, String property, String value ){
		List<FrameworkHandlerConfig> loggingHandlers = holder.getMessageProcessorConfig().getLoggingHandlers();
		boolean found = false;
		for (FrameworkHandlerConfig lh : loggingHandlers) {
			HashMap<String, String> options = lh.getOptions();
			for (String key : options.keySet()) {
				if (key.equalsIgnoreCase(property)) {
					options.put(key, value);
					found = true;
					break;
				}
			}
			if (found) break;
		}
	}

	public static String getConfigHolderOptionValue(ClientConfigHolder holder, String property ){
		List<FrameworkHandlerConfig> loggingHandlers = holder.getMessageProcessorConfig().getLoggingHandlers();
		boolean found = false;
		String value = null;
		for (FrameworkHandlerConfig lh : loggingHandlers) {
			HashMap<String, String> options = lh.getOptions();
			for (String key : options.keySet()) {
				if (key.equalsIgnoreCase(property)) {
					value = options.get(key);
					found = true;
					break;
				}
			}
			if (found) break;
		}

		return value;
	}

	private String getRequestPayloadLog(ClientConfigHolder config){
		String value = getConfigHolderOptionValue(config, PROP_RequestPAYLOADLOG);
		if (value == null)
			return BaseLoggingHandler.PAYLOADLOG_ON;

		return value;
	}

	private String getRequestPayloadCalLog(ClientConfigHolder config){
		String value = getConfigHolderOptionValue(config, PROP_RequestPAYLOADCALLOG);
		if (value == null)
			return BaseLoggingHandler.PAYLOADLOG_ON;

		return value;
	}

	private String getResponsePayloadCalLog(ClientConfigHolder config){
		String value = getConfigHolderOptionValue(config, PROP_ResponsePAYLOADCALLOG);
		if (value == null)
			return BaseLoggingHandler.PAYLOADLOG_OFF;

		return value;
	}

	private String getResponsePayloadLog(ClientConfigHolder config){
		String value = getConfigHolderOptionValue(config, PROP_ResponsePAYLOADLOG);
		if (value == null)
			return BaseLoggingHandler.PAYLOADLOG_OFF;

		return value;
	}
	
	private String getPayloadMaxBytes(ClientConfigHolder config){
		String value = getConfigHolderOptionValue(config, PROP_PAYLOADMAXBYTES);
		if (value == null)
			return String.valueOf(FOUR_KB);
		
		return value;
	}
}
