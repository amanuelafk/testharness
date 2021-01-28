package com.deloitte.harness.service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.deloitte.harness.dao.TestHarnessDao;
import com.deloitte.harness.model.TestCase;
import com.deloitte.harness.model.TestStep;
import com.deloitte.harness.model.TestSuite;

public class TestHarnessServiceImpl implements TestHarnessService {

  @Autowired
  public TestHarnessDao testHarnessDao;
  
  public int createTestSuite(TestSuite testSuite, String user) {
	  
	return testHarnessDao.createTestSuite(testSuite, user, getTimestamp());
	  
  }

  public int createTestCase(TestCase testCase, int testsuiteId, String user) {
	  
    return testHarnessDao.createTestCase(testCase, testsuiteId, user, getTimestamp());
    
  }
  
  public int updateTestCase(TestCase testCase, String user) {
	  
	    return testHarnessDao.updateTestCase(testCase, user, getTimestamp());	    
  }
  
  public int updateTestStep(TestStep testStep, String user) {
	  
	    return testHarnessDao.updateTestStep(testStep, user, getTimestamp());	    
  }  
  
  public List<TestCase> getTestCase(int testcaseId) {
	  
	return testHarnessDao.getTestCase(testcaseId);
	
  }
  
  public List<TestSuite> getTestSuite(int testsuiteId) {
	  
	 return testHarnessDao.getTestSuite(testsuiteId);
	  
  }
  
  public List<TestStep> getTestStep(int teststepId) {
	  
		return testHarnessDao.getTestStep(teststepId);
		
  }
  
  public Map<String, String> getAllTestSuite(String user) {
	 Map<String, String> testsuiteList = new HashMap<String, String>();
	 
	 List<TestSuite> testSuiteListDB = testHarnessDao.getAllTestSuite(user);
	 for(TestSuite testSuite : testSuiteListDB ) {
		 testsuiteList.put(testSuite.getTestsuiteId(), testSuite.getTestsuiteName());
	 }
	  
	 return testsuiteList;
	  
  }
  
  public Map<String, String> getAllTestCase(String user) {
	Map<String, String> testcaseList = new HashMap<String, String>();
		 
	List<TestCase> testCaseListDB = testHarnessDao.getAllTestCase(user);
	for(TestCase testCase : testCaseListDB ) {
		testcaseList.put(testCase.getTestcaseId(), testCase.getTestcaseName());
	}
	  
	return testcaseList; 	  
  }
  
  public Map<String, String> getAllTestStep(String user) {
		Map<String, String> teststepList = new HashMap<String, String>();
			 
		List<TestStep> testStepListDB = testHarnessDao.getAllTestStep(user);
		for(TestStep testStep : testStepListDB ) {
			teststepList.put(testStep.getTeststepId(), testStep.getStepName());
		}
		  
		return teststepList; 	  
  }
  
  public boolean checkTestSuiteName(String testSuiteName) {			 
	  	List<TestSuite> testSuiteListDB = testHarnessDao.checkTestSuiteName(testSuiteName);		
		
	  	if(testSuiteListDB != null && testSuiteListDB.size() > 0) {
	  		return true;
	  	}
	  	
		return false; 	  
  }
  
  public boolean checkTestCaseName(String testCaseName) {			 
	  	List<TestCase> testCaseListDB = testHarnessDao.checkTestCaseName(testCaseName);		
		
	  	if(testCaseListDB != null && testCaseListDB.size() > 0) {
	  		return true;
	  	}
	  	
		return false; 	  
  }
  
  public int createTestStep(TestStep testStep, int testcaseId, String user) {
	  
	  return testHarnessDao.createTestStep(testStep, testcaseId, user, getTimestamp());
	  
  }
  
  public String getTimestamp() {
	  long time = System.currentTimeMillis();
	  java.sql.Timestamp timestamp = new java.sql.Timestamp(time);
	  String formattedTs = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(timestamp);
      
	  return formattedTs;
  }

}
