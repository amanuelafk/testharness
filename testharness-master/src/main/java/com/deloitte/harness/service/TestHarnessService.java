package com.deloitte.harness.service;

import java.util.List;
import java.util.Map;

import com.deloitte.harness.model.TestCase;
import com.deloitte.harness.model.TestStep;
import com.deloitte.harness.model.TestSuite;

public interface TestHarnessService {

	int createTestSuite(TestSuite testSuite, String user);
	
	int createTestCase(TestCase testCase, int testsuiteId, String user);
	
	int updateTestCase(TestCase testCase, String user);
	
	int updateTestStep(TestStep testStep, String user);
	
	List<TestCase> getTestCase(int testcaseId);
	
	List<TestSuite> getTestSuite(int testsuiteId);
	
	List<TestStep> getTestStep(int testcaseId);
	
	Map<String, String> getAllTestSuite(String user);
	
	Map<String, String> getAllTestCase(String user);
	
	Map<String, String> getAllTestStep(String user);
	
	int createTestStep(TestStep testStep, int testcaseId, String user);
	
	boolean checkTestSuiteName(String testSuiteName);
	
	boolean checkTestCaseName(String testCaseName);
	
}
