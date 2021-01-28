package com.deloitte.harness.dao;

import java.util.List;

import com.deloitte.harness.model.TestCase;
import com.deloitte.harness.model.TestStep;
import com.deloitte.harness.model.TestSuite;

public interface TestHarnessDao {

	int createTestSuite(TestSuite testSuite, String user, String timestamp);
	
	int createTestCase(TestCase testCase, int testsuiteId, String user, String timestamp);
	
	int updateTestCase(TestCase testCase, String user, String timestamp);
	
	int updateTestStep(TestStep testStep, String user, String timestamp);
	
	List<TestCase> getTestCase(int testcaseId);
	
	List<TestStep> getTestStep(int teststepId);	
	
	List<TestSuite> getTestSuite(int testsuiteId);
	
	List<TestSuite> getAllTestSuite(String user);
  
	List<TestCase> getAllTestCase(String user);
	
	List<TestStep> getAllTestStep(String user);
	
	int createTestStep(TestStep testStep, int testcaseId, String user, String timestamp);
	
	List<TestSuite> checkTestSuiteName(String testSuiteName);
	
	List<TestCase> checkTestCaseName(String testCaseName);
}
