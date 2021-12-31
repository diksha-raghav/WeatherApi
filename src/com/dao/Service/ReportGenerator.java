package com.dao.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.sql.ResultSet;

public class ReportGenerator {
	
	Map<String, String[][]> formHeaders=new LinkedHashMap<String,String[][]>();
	
	
	

	public Map<String, String[][]> getFormHeaders() {
		return formHeaders;
	}




	public void setFormHeaders(Map<String, String[][]> formHeaders) {
		this.formHeaders = formHeaders;
	}




	public ReportGenerator()
	{
		formHeaders.put("bankcscdata", new String[][]{ 
			{"dateandtime","Date"},{"ename","Employee name"},{"Designation","Designation"},{"mobile1","Contact No."},{"state","State"},{"district","District"},{"tehsil","Tehsil"},{"village","Village"},{"visit","Visit Type"},{"bank_iifscode","Bank IFSCcode"},{"bank_name","Bank Name"},{"bank_branch_name","Bank Branch Name"},{"bank_branch_state","Bank Branch State"},{"bank_branch_address","Bank Branch Address"},{"loclatlong","Coordinates"},{"csc_ID","CSC ID"},{"csv_csc","CSV Address"},{"person_visited","Person Visited"},{"mobile_no","Mobile No"},{"landline","Landline"},{"activity_performed","Activity Performed"},{"follow_up","Follow Up"},{"type_of_meeting","Type Of Meeting"},{"no_of_loans","No Of Loans"},{"loan_sanctioned","Loan Sanctioned"},{"no_of_non_loans","No Of Non Loans"},{"farmers_insured","Farmers Insured"},{"premium_remitted","Premium Remitted"},{"CROPNAME","Crop Name"}
			,{"remark","Remark"},{"image","Image"},
		 });
		
		formHeaders.put("area_sown_report", new String[][] { 
			{"dateandtime","Date"}, {"ename","Employee Name"},{"Designation","Designation"},{"mobile1","Contact No."}, {"season","Season"},{"year","Year"}, {"state","State"}, {"district","District"}, {"taluka","Taluka"}, {"village","Village"}, {"location","Location"}, {"area_sown","Area Sown"}, {"sowing_status","Sowing Status"}, {"report_source","Report Source"},  {"CROPNAME","Crop Name"}
,{"remark","Remark"}, {"document","Document"}, {"other","Other"},
		 });
		
		formHeaders.put("awarenessdata", new String[][] { 
			{"dateandtime","Date"}, {"ename","Employee Name"},{"Designation","Designation"},{"mobile1","Contact No."}, {"state","State"}, {"district","District"}, {"taluka","Taluka"}, {"village","Village"}, {"loclatlong","Coordinates"}, {"campaigns","Campaigns"}, {"other","Other"}, {"noofofficials","No of Officials"}, {"noofparticipants","No of Participants"}, {"overview","Overview"},{"CROPNAME","Crop Name"}
			, {"image","Image"},
		 });
		
		formHeaders.put("cce_observationdata", new String[][] { 
			{"dateandtime","Date"}, {"ename","Employee Name"},{"Designation","Designation"},{"mobile1","Contact No."},{"season","Season"}, {"year_data","Year"},  {"state","State"}, {"district","District"}, {"taluka","Taluka"}, {"village","Village"}, {"loclatlong","Coordinates"}, {"product","Product"}, {"cce_part","CCE Part"}, {"fima_id","FIMA Id"}, {"moa_id","MOA Id"}, {"sg_id","Sg Id"}, {"agency_id","Agency Id"}, {"surveyno","Survey no "}, {"CROPNAME","Crop Name"}
			,{"remark","Remark"}, {"image","Image"},
		 });
		
		formHeaders.put("field_visit", new String[][] { 
			{"dateandtime","Date"}, {"ename","Employee Name"},{"Designation","Designation"},{"mobile1","Contact No."}, {"state","State"}, {"district","District"}, {"taluka","Taluka"}, {"village","Village"}, {"loclatlong","Coordinates"}, {"visit_type","Visit Type"}, {"visit_level","Visit Level"}, {"purpose","Purpose"}, {"visited_to","Visited To"}, {"other","Other"}, {"dis_point","DIS Point"}, {"venue","Venue"},{"CROPNAME","Crop Name"}
			, {"remark","Remark"}, {"image","Image"},
		 });
		
		formHeaders.put("general_investigationdata", new String[][] { {"dateandtime","Date"}, {"ename","Employee Name"},{"Designation","Designation"},{"mobile1","Contact No."}, {"season","Season"}, {"year_data","Year"}, {"state","State"}, {"district","District"}, {"taluka","Taluka"}, {"village","Village"}, {"loclatlong","Coordinates"}, {"product","Product"}, {"documentupload","Documentupload"}, {"CROPNAME","Crop Name"}
		,{"remark","Remark"}, {"image","Image"},
		 });
		
		formHeaders.put("ground_truthingdata", new String[][] { 
			{"dateandtime","Date"}, {"ename","Employee Name"},{"Designation","Designation"},{"mobile1","Contact No."}, {"season","Season"}, {"year_data","Year"}, {"state","State"}, {"district","District"}, {"taluka","Taluka"}, {"village","Village"}, {"loclatlong","Coordinates"}, {"assignmentno","FIMA Reference No."}, {"CROPNAME","Crop Name"}
			,{"remark","Remark"}, {"image","Image"},{"REFID","EEFID"},{"soil_type","Soil Type"}, {"crop_category","Crop Category"}, {"source_of_irrigation","Source of Irrigation"}, {"duration_of_crop","Duration of Crop"},{"sowing_month","Sowing Month"},{"sowing_week","Sowing Week"}, 
			{"stage_of_crop","Stage of Crop"}, {"height_of_crop","Height of Crop"},{"foliage_cover","Foliage Cover"}, {"crop_mix","Crop Mix"}, {"secondary_crop","Secondry Crop"}, {"proportion_primary_crop","Proportion Primary Crop"}, {"soil_moisture","Soil Moisture"}, {"is_moisture_stress","Is Moisture Stress"}, {"moisture_stress_reason","Moisture Stress Reason"}, {"crop_condition","Crop Condition"}, 
			{"is_crop_loss_observed","Is Crop Loss Observed"}, {"loss_percentage","Loss Percentage"}, {"cause_of_loss","Cause of Loss"}, {"harvest_month","Harvest Month"}, {"harvest_week","Harvet week"}, {"area_of_plot","Area of Plot"}, {"expected_yeild","Expected Yeild"}, {"overall_crop_condition","Overall Crop Condition"}, {"latitude1","Latitude 1"}, {"longitude1","Longitude 1"}, {"accuracy1","Accuracy 1"}, {"latitude2","Latitude 2"}, {"longitude2","Longitude 2"}, 
			{"accuracy2","Accuracy 2"}, {"image2","Image 2"}, {"latitude3","Latitude 3"}, {"longitude3","Lonitude 3"}, {"accuracy3","Accuracy 3"}, {"image3","Image 3"}, {"latitude4","Latitude 4"}, 
			{"longitude4","Longitude 4"}, {"accuracy4","Accuracy 4"}, {"image4","Image 4"}, {"survey_type","Survey Type"}, {"assignement_id","Assignment ID"}, {"taskid","Task ID"}, {"empID","Emp ID"},
		 });
		
		formHeaders.put("individual_lossdata", new String[][] { 
			{"dateandtime","Date"}, {"ename","Employee Name"},{"Designation","Designation"},{"mobile1","Contact No."},{"season","Season"}, {"year_data","Year"},  {"state","State"}, {"district","District"}, {"taluka","Taluka"}, {"village","Village"}, {"loclatlong","Coordinates"}, {"product","Product"}, {"ila_refid","Ila Ref ID"}, {"fima_id","FIMA ID"}, {"moa_id","MOA ID"}, {"sg_id","SG ID"}, {"agency_id","Agency ID"}, {"claim_intimation","Claim Intimation"}, {"ci_fima_id","CI FIMA ID"}, {"ci_moa_id","Ci MOA ID"}, {"ci_sg_id","Ci SG ID"}, {"farmername","Farmername"}, {"surveyno","Surveyno"}, {"calamitytype","Calamitytype"}, {"causeofloss","Cause of loss"}, {"specifyname","Specify Name"}, {"survey_type","Survey Type"},{"CROPNAME","Crop Name"}
			, {"remark","Remark"}, {"image","Image"},
		 });
		
		formHeaders.put("meetingdata", new String[][] { 
			{"dateandtime","Date"}, {"ename","Employee Name"},{"Designation","Designation"},{"mobile1","Contact No."}, {"state","State"}, {"district","District"}, {"taluka","Taluka"}, {"village","Village"}, {"loclatlong","Coordinates"}, {"meeting_organised_level","Meeting Organised Level"}, {"attended_organised","Attended Organised"}, {"typeofmeeting","Type of meeting"}, {"meeting_Name","Meeting Name"}, {"name_other","Name Other"}, {"conducted_participated_by","Conducted Participated By"}, {"conducted_participated_by_other","Conducted Participated By Other"}, {"purpose","Purpose"}, {"chaired_by","Chaired By"}, {"discussion_point","Discussion Point"}, {"no_of_participants","No Of Participants"}, {"venue","Venue"}, {"expense","Expense"},{"CROPNAME","Crop Name"}
			, {"remark","Remark"}, {"image","Image"},
		 });
		
		formHeaders.put("office_visit", new String[][] { 
			{"dateandtime","Date"}, {"ename","Employee Name"},{"Designation","Designation"},{"mobile1","Contact No."}, {"state","State"}, {"district","District"}, {"taluka","Taluka"}, {"village","Village"}, {"loclatlong","Coordinates"}, {"visit_type","Visit Type"}, {"visit_level","Visit Level"}, {"purpose","Purpose"}, {"visited_to","Visited To"}, {"other","Other"}, {"dis_point","Dis Point"}, {"venue","Venue"},{"CROPNAME","Crop Name"}
			, {"remark","Remark"}, {"image","Image"},
		 });
		
		formHeaders.put("publicity_materialsdata", new String[][] { 
			{"dateandtime","Date"}, {"ename","Employee Name"},{"Designation","Designation"},{"mobile1","Contact No."}, {"year_data","Year"}, {"state","State"}, {"district","District"}, {"taluka","Taluka"}, {"village","Village"}, {"loclatlong","Coordinates"}, {"material","Material"}, {"other","Other"}, {"stock_targeted","Stock Targeted"}, {"distributed_accomplished","Distributed Accomplished"},{"CROPNAME","Crop Name"}
			, {"remark","Remark"}, {"documentupload","Documentupload"}, {"image","Image"},
		 });
		
		formHeaders.put("weather_report", new String[][] { 
			{"dateandtime","Date"}, {"ename","Employee Name"},{"Designation","Designation"},{"mobile1","Contact No."}, {"season","Season"}, {"year","Year"}, {"state","State"}, {"district","District"}, {"taluka","Taluka"}, {"village","Village"}, {"location","Location"}, {"Incident_Date_Time","Incident Date Time"}, {"weather_parameter","Weather Parameter"}, {"other","Other"}, {"weather_readings","Weather Readings"}, {"report_source","Report Source"}, {"specify_other","Specify Other"},{"CROPNAME","Crop Name"}
			, {"remark","Remark"}, {"document","Document"},
		 });
		
		formHeaders.put("weather_station_inspection", new String[][] { 
			{"dateandtime","Date"}, {"ename","Employee Name"},{"Designation","Designation"},{"mobile1","Contact No."}, {"season","Season"}, {"year","Year"}, {"state","State"}, {"district","District"}, {"taluka","Taluka"}, {"village","Village"}, {"loclatlong","Coordinates"}, {"station_type","Station Type"}, {"other","Other"}, {"station_name","Station Name"}, {"station_address","Station Address"}, {"station_status","Station Status"},{"CROPNAME","Crop Name"}
			, {"remark","Remark"}, {"image","Image"},
		 });
	formHeaders.put("media_reports_publications", new String[][] { 
			{"dateandtime","Date"}, {"ename","Employee Name"}, {"Designation","Designation"},{"mobile1","Contact No."},{"season","Season"}, {"year","Year"},  {"state","State"}, {"district","District"}, {"taluka","Taluka"}, {"village","Village"}, {"location","Location"}, {"type","Type"}, {"report_description","Report Description"}, {"report_source","Report Source"}, {"other","Other"}, {"published_date","Published Date"}, {"CROPNAME","Crop Name"}, {"remark","Remark"}, {"document","Document"},
		 });
		formHeaders.put("insured_crop_verification", new String[][] { 
			{"dateandtime","Date"}, {"ename","Employee Name"}, {"Designation","Designation"},{"mobile1","Contact No."},{"season","Season"}, {"year","Year"},  {"state","State"}, {"district","District"}, {"taluka","Taluka"}, {"village","Village"}, {"location","Location"}, {"FIMA_CROPNAME","Fima Ref ID"}, {"insured_app_no","Insured App No"}, {"ia_moa_id","IA MOA ID"}, {"ia_sg_id","IA SG ID"}, {"farmer_name","Farmer Name"}, {"survey_subsurvey_no","Survey Subsurvey No"}, {"insured_crop","Insured Crop"}, {"area_sown","Area Sown"}, {"crop_condition","Crop Condition"}, {"CROPNAME","Crop Name"}, {"remark","Remark"}, {"image","Image"},
		 });
		


		
	}
	
	
	

}
