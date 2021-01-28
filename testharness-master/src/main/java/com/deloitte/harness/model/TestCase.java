package com.deloitte.harness.model;

public class TestCase {

  private String testsuiteId;	
  
  public String getTestsuiteId() {
	return testsuiteId;
  }

  public void setTestsuiteId(String testsuiteId) {
	this.testsuiteId = testsuiteId;
  }

  private String testcaseId;
  private String testcaseName;  
  private String testcaseDesc;
  
  public String getTestcaseId() {
	return testcaseId;
  }

  public void setTestcaseId(String testcaseId) {
	this.testcaseId = testcaseId;
  }
  
  public String getTestcaseName() {
	return testcaseName;
  }
  
  public void setTestcaseName(String testcaseName) {
	this.testcaseName = testcaseName;
  }
  
  public String getTestcaseDesc() {
	return testcaseDesc;
  }
  
  public void setTestcaseDesc(String testcaseDesc) {
	this.testcaseDesc = testcaseDesc;
  }
  
}
