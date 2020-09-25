package com.amarsoft.ysshao.demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SysHead {

	private String serviceCode;
	private String serviceName;
	private String clientSystemId;
	private String serverSystemId;
	private int serviceMode = 0;
	private String requestTime;
	private String responseTime;
	private String terminalAddress;
	private String terminalType;
	private String operationId;
	private String clientLocale = "zh_CN.UTF-8";
	private String orgId;
	private String userId;
	private String responseCode;
	private String responseMessage;
	private Map expMap =  new ConcurrentHashMap<String, Object>();
	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getClientSystemId() {
		return clientSystemId;
	}
	public void setClientSystemId(String clientSystemId) {
		this.clientSystemId = clientSystemId;
	}
	public String getServerSystemId() {
		return serverSystemId;
	}
	public void setServerSystemId(String serverSystemId) {
		this.serverSystemId = serverSystemId;
	}
	public int getServiceMode() {
		return serviceMode;
	}
	public void setServiceMode(int serviceMode) {
		this.serviceMode = serviceMode;
	}
	public String getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}
	public String getResponseTime() {
		return responseTime;
	}
	public void setResponseTime(String responseTime) {
		this.responseTime = responseTime;
	}
	public String getTerminalAddress() {
		return terminalAddress;
	}
	public void setTerminalAddress(String terminalAddress) {
		this.terminalAddress = terminalAddress;
	}
	public String getTerminalType() {
		return terminalType;
	}
	public void setTerminalType(String terminalType) {
		this.terminalType = terminalType;
	}
	public String getOperationId() {
		return operationId;
	}
	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}
	public String getClientLocale() {
		return clientLocale;
	}
	public void setClientLocale(String clientLocale) {
		this.clientLocale = clientLocale;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	public void setExpfileds(String name,String value){
		expMap.put(name, value);
	}
	
}
