package com.fileupload;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.json.JSONObject;
import org.testng.annotations.AfterSuite;

import com.configurations.Constants;
import com.configurations.*;
import com.restassured.services.ReportPaths;
import com.utilities.BaseClass;
@SuppressWarnings("unused")
public class ReportUpload extends BaseClass {
	String primaryInfo = "";
	private String projectPath = System.getProperty("user.dir");
	private String reportsPath = projectPath + File.separator + "APIReports" + File.separator + ReportPaths.reportPathName;
	private String resultCount;
	private String reportstatus;


	/*
	 * Uploading file to server
	 * @moduleId 
	 * @testCaseId
	 * @userID
	 * @testsetId
	 * @moduleDescription
	 */

	@AfterSuite
	public void uploadFile() throws Exception {
		System.out.println("primary info : " + Constants.PRIMARY_INFO);
		try {
			JSONObject primaryInfoObj = new JSONObject(Constants.PRIMARY_INFO);
			boolean is_web = primaryInfoObj.optBoolean("is_web");
			String mobile = primaryInfoObj.optString("mobile_platform");
			String moduleDescription = primaryInfoObj.optString("module_description");
			if(mobile.equalsIgnoreCase("Android") || mobile.equalsIgnoreCase("iOS")) {
				reportsPath = projectPath + File.separator + "MobileReports" + File.separator + ReportPaths.reportPathName;	
				resultCount = (Constants.TOTAL_TC - Constants.TOTAL_TC_FAILED) + " PASS / " + Constants.TOTAL_TC_FAILED + " FAIL";
				reportstatus = "";		
			} else if(is_web) {
				reportsPath = projectPath + File.separator + "WebReports" + File.separator + ReportPaths.reportPathName;	
				resultCount  = getTestcasesFailCount(reportsPath);
				//resultCount = (Constants.TOTAL_TC - Constants.TOTAL_TC_FAILED) + " PASS / " + Constants.TOTAL_TC_FAILED + " FAIL";
				reportstatus = "";
			} else {
				resultCount = ExtentConfigurations.getDatasetResultCount();
				reportstatus = Constants.testName;
			}
			
			System.err.println(Constants.testName);
			String client_timezoneId = primaryInfoObj.optString("client_timezone_id");
			String report_upload_url = primaryInfoObj.optString("report_upload_url");
			String testcaseId = primaryInfoObj.optString("testcase_id");
			String moduleId = primaryInfoObj.optString("module_id");
			String subModuleId = primaryInfoObj.isNull("sub_module_id") ? null : primaryInfoObj.optString("sub_module_id");
			String testsetId = primaryInfoObj.optString("testset_id").equals("0") ? "" : primaryInfoObj.optString("testset_id");
			String userId = primaryInfoObj.optString("user_id");
		    String executedUserId = primaryInfoObj.optString("executed_user_id");
			System.out.println("testcaseid" + testcaseId + ",\nmodule_id" + moduleId + ",\ntestset_id" + testsetId
					+ ",\nuser_id" + userId + ",\nresult" + resultCount + ",\nreportStatus" + Constants.testName);
			new FileUploaderClient().uploadFile(report_upload_url, reportsPath, userId,executedUserId, testcaseId, testsetId, moduleId, subModuleId, is_web, resultCount, Constants.testName, mobile, client_timezoneId);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String getTestcasesFailCount(String filePath){
		int passcount = 0;
		int failcount = 0;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(filePath));
			String line = reader.readLine();
		
			
			while (line != null) {
			
				if(line.contains("test-status label right outline capitalize pass")) {
					System.out.println(line);
					passcount = passcount +1;
				}
				if(line.contains("test-status label right outline capitalize fail")) {
					System.out.println(line);
					failcount = failcount +1;
				}
				
				
				// read next line
				line = reader.readLine();
			}
			System.out.println(passcount + "fail " +failcount);
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return passcount +  " PASS / " + failcount + " FAIL";
		
	}

}
