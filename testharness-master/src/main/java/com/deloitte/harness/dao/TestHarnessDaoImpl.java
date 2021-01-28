package com.deloitte.harness.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.deloitte.harness.model.TestCase;
import com.deloitte.harness.model.TestStep;
import com.deloitte.harness.model.TestSuite;

public class TestHarnessDaoImpl implements TestHarnessDao {

  @Autowired
  DataSource datasource;

  @Autowired
  JdbcTemplate jdbcTemplate;
  
  public int createTestSuite(TestSuite testSuite, String user, String timestamp) {
	    String sql = "insert into T002_TEST_SUITE(TEST_SUITE_NAME, TEST_SUITE_DESC,"
	    		+ "CREATE_USER, CREATE_TIMESTAMP, UPDATE_USER, UPDATE_TIMESTAMP) "
	    		+ "values(?,?,?,?,?,?)";

	    return jdbcTemplate.update(sql, new Object[] {testSuite.getTestsuiteName(), 
	    		testSuite.getTestsuiteDesc(), user, timestamp, null, null});
  }

  public int createTestCase(TestCase testCase, int testsuiteId, String user, String timestamp) {
    String sql = "insert into T003_TEST_CASE(TEST_SUITE_ID, TEST_CASE_NAME,"
    		+ "TEST_CASE_DESC, CREATE_USER, CREATE_TIMESTAMP, UPDATE_USER, UPDATE_TIMESTAMP) "
    		+ "values(?,?,?,?,?,?,?)";

    return jdbcTemplate.update(sql, new Object[] {testsuiteId, testCase.getTestcaseName(), 
    		testCase.getTestcaseDesc(), user, timestamp, null, null});
  }
  
  public int updateTestCase(TestCase testCase, String user, String timestamp) {
	    String sql = "update T003_TEST_CASE set TEST_CASE_NAME = ?, TEST_CASE_DESC = ?, "
	    		+ "UPDATE_USER = ?, UPDATE_TIMESTAMP = ? where TEST_CASE_ID = ?";	    		

	    return jdbcTemplate.update(sql, new Object[] {testCase.getTestcaseName(), 
	    		testCase.getTestcaseDesc(), user, timestamp, testCase.getTestcaseId()});
  }

  public int updateTestStep(TestStep testStep, String user, String timestamp) {
	    String sql = "update T004_TEST_STEPS set STEP_NAME = ?, "+ 
	    			 "ELEMENT_TYPE = ?, ELEMENT_LOC_TYPE = ?, ELEMENT_LOC = ?, ACTION = ?, " + 
	    			 "WAIT_TYPE = ?, WAIT_TIME = ?, IS_ACTIVE = ?, " +
	    			 "UPDATE_USER = ?, UPDATE_TIMESTAMP = ? where TEST_STEP_ID = ?";	    		

	    return jdbcTemplate.update(sql, new Object[] {testStep.getStepName(), 
	    		testStep.getElementType(), testStep.getElementLocType(), testStep.getElementLoc(),
	    		testStep.getAction(), testStep.getWaitType(), testStep.getWaitTime(), 
	    		testStep.getIsActive(), user, timestamp, testStep.getTeststepId()});
  }
  
  public List<TestCase> getTestCase(int testcaseId) {
	    String sql = "select * from T003_TEST_CASE where TEST_CASE_ID = ?";

	    List<TestCase> testcaseList = jdbcTemplate.query(sql, new Object[]{testcaseId}, 
	    		new TestCaseMapper());

        return testcaseList;
  }
  
  public List<TestStep> getTestStep(int teststepId) {
	    String sql = "select * from T004_TEST_STEPS where TEST_STEP_ID = ?";

	    List<TestStep> teststepList = jdbcTemplate.query(sql, new Object[]{teststepId}, 
	    		new TestStepMapper());

      return teststepList;
  }
  
  public List<TestSuite> getTestSuite(int testsuiteId) {
	    String sql = "select * from T002_TEST_SUITE where TEST_SUITE_ID = ?";

	    List<TestSuite> testsuiteList = jdbcTemplate.query(sql, new Object[]{testsuiteId}, 
	    		new TestSuiteMapper());

      return testsuiteList;
  }
  
  public List<TestSuite> checkTestSuiteName(String testSuiteName) {
	    String sql = "select * from T002_TEST_SUITE where TEST_SUITE_NAME = ?";

	    List<TestSuite> testsuiteList = jdbcTemplate.query(sql, new Object[]{testSuiteName}, 
	    		new TestSuiteMapper());

      return testsuiteList;
  }
  
  public List<TestCase> checkTestCaseName(String testCaseName) {
	    String sql = "select * from T003_TEST_CASE where TEST_CASE_NAME = ?";

	    List<TestCase> testcaseList = jdbcTemplate.query(sql, new Object[]{testCaseName}, 
	    		new TestCaseMapper());

    return testcaseList;
  }
  
  public List<TestSuite> getAllTestSuite(String user) {
	  
	  String sql = "select * from T002_TEST_SUITE where CREATE_USER = ?";

	  List<TestSuite> testsuiteList = jdbcTemplate.query(sql, new Object[]{user}, 
	    		new TestSuiteMapper());

	  return testsuiteList;

  }
  
  public List<TestCase> getAllTestCase(String user) {
	  
	  String sql = "select * from T003_TEST_CASE where CREATE_USER = ?";

	  List<TestCase> testcaseList = jdbcTemplate.query(sql, new Object[]{user}, 
	    		new TestCaseMapper());

	  return testcaseList;

  }
  
  public List<TestStep> getAllTestStep(String user) {
	  
	  String sql = "select * from T004_TEST_STEPS where CREATE_USER = ?";

	  List<TestStep> teststepList = jdbcTemplate.query(sql, new Object[]{user}, 
	    		new TestStepMapper());

	  return teststepList;

  }
  
  public int createTestStep(TestStep testStep, int testcaseId, String user, String timestamp) {
	  	String sql = "insert into T004_TEST_STEPS(TEST_CASE_ID, STEP_NAME,"
	  			+ "ELEMENT_TYPE,ELEMENT_LOC_TYPE, ELEMENT_LOC, ACTION,"
	  			+ "WAIT_TYPE, WAIT_TIME, IS_ACTIVE," 
	    		+ "CREATE_USER, CREATE_TIMESTAMP, UPDATE_USER, UPDATE_TIMESTAMP) "
	    		+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

	    return jdbcTemplate.update(sql, new Object[] {testcaseId, testStep.getStepName(), 
	    		testStep.getElementType(), testStep.getElementLocType(),
	    		testStep.getElementLoc(), testStep.getAction(), testStep.getWaitType(),
	    		testStep.getWaitTime(), testStep.getIsActive(), user, timestamp, null, null});

  }


class TestCaseMapper implements RowMapper<TestCase> {

  public TestCase mapRow(ResultSet rs, int arg1) throws SQLException {
    TestCase testCase = new TestCase();

    testCase.setTestcaseId(rs.getString("TEST_CASE_ID"));
    testCase.setTestcaseName(rs.getString("TEST_CASE_NAME"));
    testCase.setTestcaseDesc(rs.getString("TEST_CASE_DESC"));    

    return testCase;
  }
}

class TestStepMapper implements RowMapper<TestStep> {

	  public TestStep mapRow(ResultSet rs, int arg1) throws SQLException {
	    TestStep testStep = new TestStep();

	    testStep.setTeststepId(rs.getString("TEST_STEP_ID"));
	    testStep.setStepName(rs.getString("STEP_NAME"));
	    testStep.setElementType(rs.getString("ELEMENT_TYPE"));
	    testStep.setElementLocType(rs.getString("ELEMENT_LOC_TYPE"));
	    testStep.setElementLoc(rs.getString("ELEMENT_LOC"));
	    testStep.setAction(rs.getString("ACTION"));
	    testStep.setWaitType(rs.getString("WAIT_TYPE"));
	    testStep.setWaitTime(rs.getString("WAIT_TIME"));
	    testStep.setIsActive(rs.getBoolean("IS_ACTIVE"));

	    return testStep;
	  }
}

  
  class TestSuiteMapper implements RowMapper<TestSuite> {

  public TestSuite mapRow(ResultSet rs, int arg1) throws SQLException {
	TestSuite testSuite = new TestSuite();
	    
	testSuite.setTestsuiteId(rs.getString("TEST_SUITE_ID"));
	testSuite.setTestsuiteName(rs.getString("TEST_SUITE_NAME"));
	testSuite.setTestsuiteDesc(rs.getString("TEST_SUITE_DESC"));    

    return testSuite;

	  }
  }
  
}