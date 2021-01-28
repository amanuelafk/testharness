package com.deloitte.harness.model;

import java.util.ArrayList;
import java.util.List;

public class TestStep {

	private String testcaseId;  
	private String teststepId;
	private String stepName;  
	private String elementType;
	private String elementLocType;
	private String elementLoc;
	private String action;
	private String waitType;
	private String waitTime;
	private Boolean isActive;
	private List elementtypeList = new ArrayList();
	private List elementLocTypeList = new ArrayList();
	private List actionList = new ArrayList();
	private List waittypeList = new ArrayList();
  
	public String getTestcaseId() {
		return testcaseId;
	}
	
	public void setTestcaseId(String testcaseId) {
		this.testcaseId = testcaseId;
	}
	
	public String getTeststepId() {
		return teststepId;
	}
	
	public void setTeststepId(String teststepId) {
		this.teststepId = teststepId;
	}
	
	public String getStepName() {
		return stepName;
	}
	
	public void setStepName(String stepName) {
		this.stepName = stepName;
	}
	
	public String getElementType() {
		return elementType;
	}
	
	public void setElementType(String elementType) {
		this.elementType = elementType;
	}
	
	public String getElementLocType() {
		return elementLocType;
	}
	
	public void setElementLocType(String elementLocType) {
		this.elementLocType = elementLocType;
	}
	
	public String getElementLoc() {
		return elementLoc;
	}
	
	public void setElementLoc(String elementLoc) {
		this.elementLoc = elementLoc;
	}
	
	public String getAction() {
		return action;
	}
	
	public void setAction(String action) {
		this.action = action;
	}
	
	public String getWaitType() {
		return waitType;
	}
	
	public void setWaitType(String waitType) {
		this.waitType = waitType;
	}
	
	public String getWaitTime() {
		return waitTime;
	}
	
	public void setWaitTime(String waitTime) {
		this.waitTime = waitTime;
	}	

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public List getElementtypeList() {
		return elementtypeList;
	}

	public void setElementtypeList(List elementtypeList) {
		this.elementtypeList = elementtypeList;
	}

	public List getElementLocTypeList() {
		return elementLocTypeList;
	}

	public void setElementLocTypeList(List elementLocTypeList) {
		this.elementLocTypeList = elementLocTypeList;
	}

	public List getActionList() {
		return actionList;
	}

	public void setActionList(List actionList) {
		this.actionList = actionList;
	}

	public List getWaittypeList() {
		return waittypeList;
	}

	public void setWaittypeList(List waittypeList) {
		this.waittypeList = waittypeList;
	}	
}
