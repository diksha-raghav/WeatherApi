package com.dao.util;

import java.util.List;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;

import com.dao.Service.DistrictService;
import com.dao.Service.StateJSONService;
import com.dao.Service.SubDistrictService;
import com.mode.entities.IntermediaryDetails;
import com.mode.entities.User_Registration;

public class QuotationUtils {

	public static String ValidateQuotation(User_Registration user, IntermediaryDetails id) {
		String error = "";

		if (nullcheck(user.getLevel()))
			error += "Level field is empty,\n";

		if (nullcheck(user.getState()))
			error += "State field is empty,\n";
		else {
			String state = user.getState();
			if (!ValidState(state.toUpperCase()))
				error += "State does not exist,\n";
			else {
				if (nullcheck(user.getDistrict()))
					error += "District field is empty,\n";
				else {
					String district = user.getDistrict();
					if (!ValidDistrict(state.toUpperCase(), district.toUpperCase()))
						error += "District does not belong to state,\n";
					else {
						if (nullcheck(user.getL4()))
							error += "L4 field is empty,\n";
						else {
							String subdistrict = user.getL4();
							////// //System.out.println(subdistrict);
							if (!ValidSubdistrict(state.toUpperCase(), district.toUpperCase(), subdistrict))
								error += "Subdistrict does not belong to district,\n";
						}
					}
				}
			}
		}

		if (nullcheck(user.getL5()))
			error += "L5 field is empty,\n";

		if (nullcheck(user.getUser()))
			error += "User field is empty,\n";

		if (nullcheck(user.getDesignation()))
			error += "Designation field is empty,\n";

		if (nullcheck(user.getDob()))
			error += "DOB field is empty,\n";

		if (nullcheck(user.getMobile1()))
			error += "Mobile Number field is empty,\n";
		else {
			String mobile1 = user.getMobile1();
			if (!ValidateMobile(mobile1))
				error += "Invalid Mobile Number,\n";
		}

		String mobile2 = user.getMobile2();
		if (!nullcheckForMobile(mobile2)) {
			if (!ValidateMobile(mobile2))
				error += "Invalid Alternate Mobile Number,\n";
		}

		if (nullcheck(user.getEmail()))
			error += "Email field is empty,\n";
		else {
			String email = user.getEmail();
			if (!ValidateEmail(email))
				error += "Invalid Email,\n";
		}

		if (nullcheck(user.getOffice_location()))
			error += "Office Location field is empty,\n";

		if (nullcheck(user.getExp_crop_ins_year()))
			error += "Experience in crop insurance in years field is empty,\n";

		if (nullcheck(user.getExp_crop_ins_month()))
			error += "Experience in crop insurance in months field is empty,\n";

		if (nullcheck(user.getGender()))
			error += "Gender field is empty,\n";

		if (nullcheck(id.getIntermediaryType()))
			error += "IntermediaryType field is empty,\n";

		String dob = user.getDob();
		// if(!ValidateDOB(dob))
		// error+="Invalid DOB";

		if (error.equals(""))
			error += "Success";
		// TODO Auto-generated method stub
		return error;
	}

	public static boolean nullcheck(String value) {
		if (value == null || value.equals(""))
			return true;
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean nullcheckForMobile(String value) {
		if (value == null || value.equals("") || "0".equals(value))
			return true;
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean nullcheck(Integer value) {
		if (value == Integer.MIN_VALUE)
			return true;
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean ValidState(String state) {
		JSONArray state_list = StateJSONService.getstatelistwithjsonarray();
		////// //System.out.println(state_list);
		if (state_list.contains(state))
			return true;
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean ValidDistrict(String state, String district) {
		JSONArray dist_list = DistrictService.getDistrict(state);
		if (dist_list.contains(district))
			return true;
		// TODO Auto-generated method stub
		return false;
	}

	private static boolean ValidSubdistrict(String state, String district, String subdistrict) {
		JSONArray subdist_list = SubDistrictService.getSubDistrict(state, district);
		////// //System.out.println(subdist_list);
		if (subdist_list.contains(subdistrict))
			return true;
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * private static boolean ValidateDOB(String dob) { String regex =
	 * "^(1[0-2]|0[1-9])-(3[01]" + "|[12][0-9]|0[1-9])-[0-9]{4}$"; Pattern pattern =
	 * Pattern.compile(regex); Matcher matcher = pattern.matcher((CharSequence)dob);
	 * return matcher.matches(); // TODO Auto-generated method stub }
	 */

	public static boolean ValidateMobile(String mobile) {
		String regex = "(0/91)?[6-9][0-9]{9}";
		return mobile.matches(regex);
	}

	public static boolean ValidateEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";
		Pattern pat = Pattern.compile(emailRegex);
		return pat.matcher(email).matches();
		// TODO Auto-generated method stub
	}

	public static String ValidateQuotationBasedOnState(User_Registration user, IntermediaryDetails id,
			List<String> state_user) {
		String error = "";

		if (nullcheck(user.getLevel()))
			error += "Level field is empty,\n";

		if (nullcheck(user.getState()))
			error += "State field is empty,\n";
		else {
			String state = user.getState();

			if (!state_user.contains(state.toUpperCase().trim()))
				error += "You don't have permission to insert user for this state . "
						+ "Contact Administrator for adding the state to your list ,\n";
			else {
				if (!ValidState(state.toUpperCase()))
					error += "State does not exist,\n";
				else {
					if (nullcheck(user.getDistrict()))
						error += "District field is empty,\n";
					else {
						String district = user.getDistrict();
						if (!ValidDistrict(state.toUpperCase(), district.toUpperCase()))
							error += "District does not belong to state,\n";
						else {
							if (nullcheck(user.getL4()))
								error += "L4 field is empty,\n";
							else {
								String subdistrict = user.getL4();
								//// //System.out.println(subdistrict);
								if (!ValidSubdistrict(state.toUpperCase(), district.toUpperCase(), subdistrict))
									error += "Subdistrict does not belong to district,\n";
							}
						}
					}
				}
			}

		}

		if (nullcheck(user.getL5()))
			error += "L5 field is empty,\n";

		if (nullcheck(user.getUser()))
			error += "User field is empty,\n";

		if (nullcheck(user.getDesignation()))
			error += "Designation field is empty,\n";

		if (nullcheck(user.getDob()))
			error += "DOB field is empty,\n";

		if (nullcheck(user.getMobile1()))
			error += "Mobile Number field is empty,\n";
		else {
			String mobile1 = user.getMobile1();
			if (!ValidateMobile(mobile1))
				error += "Invalid Mobile Number,\n";
		}

		String mobile2 = user.getMobile2();
		if (!nullcheck(mobile2)) {
			if (!ValidateMobile(mobile2))
				error += "Invalid Alternate Mobile Number,\n";
		}

		if (nullcheck(user.getEmail()))
			error += "Email field is empty,\n";
		else {
			String email = user.getEmail();
			if (!ValidateEmail(email))
				error += "Invalid Email,\n";
		}

		if (nullcheck(user.getOffice_location()))
			error += "Office Location field is empty,\n";

		if (nullcheck(user.getExp_crop_ins_year()))
			error += "Experience in crop insurance in years field is empty,\n";

		if (nullcheck(user.getExp_crop_ins_month()))
			error += "Experience in crop insurance in months field is empty,\n";

		if (nullcheck(user.getGender()))
			error += "Gender field is empty,\n";

		if (nullcheck(id.getIntermediaryType()))
			error += "IntermediaryType field is empty,\n";

		String dob = user.getDob();
		// if(!ValidateDOB(dob))
		// error+="Invalid DOB";

		if (error.equals(""))
			error += "Success";
		// TODO Auto-generated method stub
		return error;
	}
}
