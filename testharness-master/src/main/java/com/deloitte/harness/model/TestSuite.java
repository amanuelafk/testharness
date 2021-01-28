package com.deloitte.harness.model;

import java.util.ArrayList;
import java.util.List;

public class TestSuite {

  private String testsuiteId;  
  private String testsuiteName;
  private String testsuiteDesc;
  private List<TestCase> testCase = new ArrayList();
  
  public String getTestsuiteId() {
	return testsuiteId;
  }

  public void setTestsuiteId(String testsuiteId) {
	this.testsuiteId = testsuiteId;
  }
  
  public List getTestCase() {
	return testCase;
  }

  public void setTestCase(TestCase testCase) {
	this.testCase.add(testCase);
  }

  public String getTestsuiteName() {
	return testsuiteName;
  }
  
  public void setTestsuiteName(String testsuiteName) {
	this.testsuiteName = testsuiteName;
  }
  
  public String getTestsuiteDesc() {
	return testsuiteDesc;
  }
  
  public void setTestsuiteDesc(String testsuiteDesc) {
	this.testsuiteDesc = testsuiteDesc;
  } 
  
}
