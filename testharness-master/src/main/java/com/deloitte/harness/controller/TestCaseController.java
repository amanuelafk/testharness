package com.deloitte.harness.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.deloitte.harness.model.TestCase;
import com.deloitte.harness.model.TestStep;
import com.deloitte.harness.model.TestSuite;
import com.deloitte.harness.service.TestHarnessService;

@Controller
public class TestCaseController {
  @Autowired
  public TestHarnessService testHarnessService;
   
  @RequestMapping(value = "/showTestHarnessHome", method = RequestMethod.GET)
  public ModelAndView showTestHarnessHome(HttpServletRequest request, HttpServletResponse response) {
	HttpSession session = request.getSession(false);	
	      
    ModelAndView mav = new ModelAndView("testharnesshome");
    
    return mav;
  }
  
  @RequestMapping(value = "/showTestSuite", method = RequestMethod.GET)
  public ModelAndView showTestSuite(HttpServletRequest request, HttpServletResponse response) {
	
	ModelAndView mav = new ModelAndView("testsuite");
    mav.addObject("testsuite", new TestSuite());
    
    return mav;
  }
  
  @RequestMapping(value = "/createTestSuite", method = RequestMethod.POST)
  public ModelAndView createTestSuite(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("testsuite") TestSuite testSuite) {
	  ModelAndView mav = null;	  
	  HttpSession session = request.getSession(false);
	  
	  String user = null;
	  if(session != null && session.getAttribute("user") != null) {
		  user = session.getAttribute("user").toString();
	  }
	  
	  boolean testSuiteNameExists = testHarnessService.checkTestSuiteName(testSuite.getTestsuiteName());
	  if(testSuiteNameExists) {
		  mav = new ModelAndView("testsuite");
	      mav.addObject("message", "Test suite name already exists");	      
	      return mav;
	  }
	  
	  testHarnessService.createTestSuite(testSuite, user);
	  testSuite.setTestsuiteName("");
	  testSuite.setTestsuiteDesc("");

	  mav = new ModelAndView("testsuite");
      mav.addObject("message", "Test suite created successfully");
      
      return mav;
  }
  
  @RequestMapping(value = "/getTestSuite", method = RequestMethod.POST)
  public ModelAndView getTestSuite(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("testsuite") TestSuite testSuite) {
	  ModelAndView mav = null;	  
	  HttpSession session = request.getSession(false);
	  
	  int testsuiteId = 0;	  
	  if(testSuite.getTestsuiteId() != null) {
		  testsuiteId = Integer.parseInt(testSuite.getTestsuiteId());
	  }
	  
	  List<TestSuite> testsuiteList = testHarnessService.getTestSuite(testsuiteId);
	  
	  mav = new ModelAndView("testsuite");
	  if(testsuiteList != null && testsuiteList.size() >0) {
		  mav.addObject("testsuite", testSuite);
	  }
      
      return mav;
  }

  
  private Map<String, String> getAllTestSuite(String user) {
	  	  
	  Map<String, String> testsuiteList = testHarnessService.getAllTestSuite(user);
	  
	  return testsuiteList;
  }

  private Map<String, String> getAllTestCase(String user) {
  	  
	  Map<String, String> testcaseList = testHarnessService.getAllTestCase(user);
	  
	  return testcaseList;
  }
  
  private Map<String, String> getAllTestStep(String user) {
  	  
	  Map<String, String> teststepList = testHarnessService.getAllTestStep(user);
	  
	  return teststepList;
  }
  @CrossOrigin
  @RequestMapping(value = "/showTestCase", method = RequestMethod.GET)
  public ModelAndView showTestCase(HttpServletRequest request, HttpServletResponse response) {
	HttpSession session = request.getSession(false);  
	
	String user = null;		
	if(session != null && session.getAttribute("user") != null) {
		  user = session.getAttribute("user").toString();
	}
	
	Map<String, String> testsuiteList = getAllTestSuite(user);  
          
    ModelAndView mav = new ModelAndView("testcase");
    mav.addObject("testcase", new TestCase());
    mav.addObject("testsuiteList", testsuiteList);
    
    return mav;
  }

  @RequestMapping(value = "/createTestCase", method = RequestMethod.POST)
  public ModelAndView createTestCase(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("testcase") TestCase testCase) {
	  ModelAndView mav = null;
	  
	  int testsuiteId = 0;	  
	  if(testCase.getTestsuiteId() != null) {
		  testsuiteId = Integer.parseInt(testCase.getTestsuiteId());
	  }
	  
	  HttpSession session = request.getSession(false);
	  
	  String user = null;
	  if(session.getAttribute("user") != null) {
		  user = session.getAttribute("user").toString();
	  }
	  
	  Map<String, String> testsuiteList = getAllTestSuite(user);
	  
	  boolean testCaseNameExists = testHarnessService.checkTestCaseName(testCase.getTestcaseName());
	  if(testCaseNameExists) {
		  mav = new ModelAndView("testcase");
		  mav.addObject("testsuiteList", testsuiteList);
	      mav.addObject("message", "Test case name already exists");	      
	      return mav;
	  }
	  
	  testHarnessService.createTestCase(testCase, testsuiteId, user);
	  testCase.setTestcaseName("");
	  testCase.setTestcaseDesc("");	  
	  
	  mav = new ModelAndView("testcase");
	  mav.addObject("testsuiteList", testsuiteList);
      mav.addObject("message", "Test case created successfully");
      
      return mav;
  }
  
  @RequestMapping(value = "/updateTestCase", method = RequestMethod.POST)
  public ModelAndView updateTestCase(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("testcase") TestCase testCase) {
	  ModelAndView mav = null;  
	  
	  HttpSession session = request.getSession(false);
	  
	  String user = null;
	  if(session.getAttribute("user") != null) {
		  user = session.getAttribute("user").toString();
	  }
	  
	  testHarnessService.updateTestCase(testCase, user);
	  testCase.setTestcaseId("");
	  testCase.setTestcaseName("");
	  testCase.setTestcaseDesc("");
	  
	  Map<String, String> testsuiteList = getAllTestSuite(user);
	  
	  mav = new ModelAndView("testcase");
	  mav.addObject("testsuiteList", testsuiteList);
      mav.addObject("message", "Test case updated successfully");
      
      return mav;
  } 
  
  @RequestMapping(value = "/updateTestStep", method = RequestMethod.POST)
  public ModelAndView updateTestStep(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("teststep") TestStep testStep) {
	  ModelAndView mav = null;  
	  
	  HttpSession session = request.getSession(false);
	  
	  String user = null;
	  if(session.getAttribute("user") != null) {
		  user = session.getAttribute("user").toString();
	  }
	  
	  testHarnessService.updateTestStep(testStep, user);
	  
	  testStep.setTeststepId("");
	  testStep.setStepName("");
	  testStep.setElementType("");
	  testStep.setElementLocType("");
	  testStep.setElementLoc("");
	  testStep.setAction("");
	  testStep.setWaitType("");
	  testStep.setWaitTime("");
	  testStep.setIsActive(false);
	  
	  Map<String, String> testcaseList = getAllTestCase(user);
	  
	  mav = new ModelAndView("teststep");
	  mav.addObject("testcaseList", testcaseList);
      mav.addObject("message", "Test step updated successfully");
      
      return mav;
  }
  
  @RequestMapping(value = "/processTestCase", method = RequestMethod.POST)
  public ModelAndView processTestCase(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("testcase") TestCase testCase, @RequestParam(value = "testcase") String testcase) {
	  ModelAndView mav = null;	  
	  
	  String action = request.getParameter("testcase").toString();
	  if(action.equals("Save")) {
		  int testcaseId = 0;	  
		  if(testCase.getTestcaseId() != null && testCase.getTestcaseId().length() > 0) {
			  testcaseId = Integer.parseInt(testCase.getTestcaseId());
		  }
		  if(testcaseId == 0) {
			  mav = createTestCase(request, response, testCase);
		  }
		  else {
			  mav = updateTestCase(request, response, testCase);
		  }
	  }	
	  else if(action.equals("Search")) {
		  mav = getTestCase(request, response, testCase);
	  }
	  else if(action.equals("Home")) {
		  mav = showTestHarnessHome(request, response);
	  }	  
	  else if(action.equals("CreateTestStep")) {
		  mav = showTestStep(request, response);
	  }
	  
      return mav;
  }

  @CrossOrigin
  @RequestMapping(value = "/processTestSuite", method = RequestMethod.POST)
  public ModelAndView processTestSuite(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("testsuite") TestSuite testSuite, @RequestParam(value = "testsuite") String testsuite) {
	  ModelAndView mav = null;	  
	  
	  String action = request.getParameter("testsuite").toString();
	  if(action.equals("Save")) {		  
		  mav = createTestSuite(request, response, testSuite);		  
	  }	
	  else if(action.equals("Search")) {
		  mav = getTestSuite(request, response, testSuite);
	  }
	  else if(action.equals("Home")) {
		  mav = showTestHarnessHome(request, response);
	  }	  
	  else if(action.equals("CreateTestCase")) {
		  mav = showTestCase(request, response);
	  }
	  
      return mav;
  }
  
  @RequestMapping(value = "/processTestStep", method = RequestMethod.POST)
  public ModelAndView processTestStep(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("teststep") TestStep testStep, @RequestParam(value = "teststep") String teststep) {
	  ModelAndView mav = null;	  
	  
	  String action = request.getParameter("teststep").toString();
	  if(action.equals("Save")) {
		  int teststepId = 0;	  
		  if(testStep.getTeststepId() != null && testStep.getTeststepId().length() > 0) {
			  teststepId = Integer.parseInt(testStep.getTeststepId());
		  }
		  if(teststepId == 0) {
			  mav = createTestStep(request, response, testStep);
		  }
		  else {
			  mav = updateTestStep(request, response, testStep);
		  }
	  }	
	  else if(action.equals("Search")) {
		  mav = getTestStep(request, response, testStep);
	  }
	  else if(action.equals("Home")) {
		  mav = showTestHarnessHome(request, response);
	  }	  
	  
      return mav;
  }
  
  @RequestMapping(value = "/getTestCase", method = RequestMethod.POST)
  public ModelAndView getTestCase(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("testcase") TestCase testCase) {
	  ModelAndView mav = null;
	  
	  HttpSession session = request.getSession(false);
	  
	  String user = null;
	  if(session.getAttribute("user") != null) {
		  user = session.getAttribute("user").toString();
	  }
	  
	  int testcaseId = 0;	  
	  testcaseId = Integer.parseInt(testCase.getTestcaseId().toString());	  	  
	  
	  List<TestCase> testcaseList = testHarnessService.getTestCase(testcaseId);
	  Map<String, String> testsuiteList = getAllTestSuite(user);
	  
	  mav = new ModelAndView("testcase");
	  if(testcaseList != null && testcaseList.size() > 0) {
		  mav.addObject("testcase",testcaseList.get(0));	   
	  }
	  mav.addObject("testsuiteList", testsuiteList);
	  
      return mav;
  }
  
  @RequestMapping(value = "/showTestStep", method = RequestMethod.GET)
  public ModelAndView showTestStep(HttpServletRequest request, HttpServletResponse response) {
	HttpSession session = request.getSession(false);  
	
	String user = null;			
	if(session != null && session.getAttribute("user") != null) {
		  user = session.getAttribute("user").toString();
	}
	
	Map<String, String> testcaseList = getAllTestCase(user);  
	
	ModelAndView mav = new ModelAndView("teststep");
     
    /*List elementtypeList = getElementTypeList();
    List elementLocTypeList = getElementLocTypeList();
    List actionList = getActionList();
    List waittypeList = getWaittypeList();
    
    TestStep teststep = new TestStep();
    teststep.setElementtypeList(elementtypeList);
    teststep.setElementLocTypeList(elementLocTypeList);
    teststep.setActionList(actionList);
    teststep.setWaittypeList(waittypeList);
    */
    mav.addObject("teststep", new TestStep());
    mav.addObject("testcaseList", testcaseList);

    return mav;
  }
  
  @RequestMapping(value = "/createTestStep", method = RequestMethod.POST)
  public ModelAndView createTestStep(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("teststep") TestStep testStep) {
	  ModelAndView mav = null;
	  
	  int testcaseId = 0;	  
	  if(testStep.getTestcaseId() != null) {
		  testcaseId = Integer.parseInt(testStep.getTestcaseId());
	  }
	  
	  HttpSession session = request.getSession(false);
	  
	  String user = null;
	  if(session.getAttribute("user") != null) {
		  user = session.getAttribute("user").toString();
	  }
	  
	  Map<String, String> testcaseList = getAllTestCase(user);
	  
	  testHarnessService.createTestStep(testStep, testcaseId, user);
	  testStep.setTeststepId("");
	  testStep.setStepName("");
	  testStep.setElementType("");
	  testStep.setElementLocType("");
	  testStep.setElementLoc("");
	  testStep.setAction("");
	  testStep.setWaitType("");
	  testStep.setWaitTime("");
	  testStep.setIsActive(false);	  
	  
	  mav = new ModelAndView("teststep");
	  mav.addObject("testcaseList", testcaseList);
      mav.addObject("message", "Test step created successfully");
      
      return mav;
  }
  
  @RequestMapping(value = "/getTestStep", method = RequestMethod.POST)
  public ModelAndView getTestStep(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("teststep") TestStep testStep) {
	  ModelAndView mav = null;
	  
	  HttpSession session = request.getSession(false);
	  
	  String user = null;
	  if(session.getAttribute("user") != null) {
		  user = session.getAttribute("user").toString();
	  }
	  
	  int teststepId = 0;	  
	  teststepId = Integer.parseInt(testStep.getTeststepId().toString());	  	  
	  
	  List<TestStep> teststepList = testHarnessService.getTestStep(teststepId);
	  Map<String, String> testcaseList = getAllTestCase(user);
	  
	  mav = new ModelAndView("teststep");
	  if(teststepList != null && teststepList.size() > 0) {
		  mav.addObject("teststep",teststepList.get(0));	   
	  }
	  mav.addObject("testcaseList", testcaseList);
	  
      return mav;
  }
  
  @ModelAttribute("elementtypeList")
  private Map<String, String> getElementTypeList() {
	  Map<String, String> elementtypeList = new HashMap<String, String>();
	  elementtypeList.put("T","Text Field");
	  elementtypeList.put("C","CheckBox");
	  elementtypeList.put("R","Radio");
	  elementtypeList.put("L", "List");
	  elementtypeList.put("A","Text Area");
	  
	  return elementtypeList;
  }
  
  @ModelAttribute("elementLocTypeList")
  private Map<String, String> getElementLocTypeList() {
	  Map<String, String> elementLocTypeList = new HashMap<String, String>();
	  elementLocTypeList.put("X","XPATH");
	  elementLocTypeList.put("C","CSS");
	  elementLocTypeList.put("I","ID");
	  elementLocTypeList.put("N","NAME");
	  
	  return elementLocTypeList;
  }
  
  @ModelAttribute("actionList")
  private Map<String, String> getActionList() {
	  Map<String, String> actionList = new HashMap<String, String>();
	  actionList.put("S","Send Keys");
	  actionList.put("C","Click");
	  actionList.put("O","Context Click");
	  actionList.put("M","Move To");
	  actionList.put("N","Navigate To");
	  
	  return actionList;
  }

  @ModelAttribute("waittypeList")
  private Map<String, String> getWaittypeList() {
	  Map<String, String> waittypeList = new HashMap<String, String>();
	  waittypeList.put("E","Explicit Wait");
	  waittypeList.put("I","Implicit Wait");
	  waittypeList.put("F","Fluent Wait");
	  
	  return waittypeList;
  }
  
}
