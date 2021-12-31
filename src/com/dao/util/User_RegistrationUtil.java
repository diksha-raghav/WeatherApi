package com.dao.util;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.log4j.Logger;
import org.apache.poi.poifs.filesystem.EntryNode;

import com.mode.entities.User_Registration;
import com.model.dao.DetailsDao;

@MultipartConfig
public class User_RegistrationUtil {
	final static Logger logger = Logger.getLogger(User_RegistrationUtil.class);
	String path = DetailsDao.fetch_path();
	private static final String dir1 = "pan_pass_aadhar";
	private static final String dir2 = "photo";
	// int EmpID = DetailsDao.getEmpID();

	// private static final int NULL = 0;

	public int User_Registration_method(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String level = request.getParameter("level");
		String State = request.getParameter("state");
		String District = request.getParameter("district");
		String l5 = request.getParameter("l5");
		String l4 = request.getParameter("subdistrict");
		String User = request.getParameter("User");
		String Designation = request.getParameter("designation");
		String dob = request.getParameter("dob");
		String mobile1 = request.getParameter("mobile1");
		String mobile2 = request.getParameter("mobile2");
		String email = request.getParameter("email");
		String education_qualification = request.getParameter("education_qualification");
		String office_location = request.getParameter("office_location");
		int exp_crop_ins_month = Integer.parseInt(request.getParameter("exp_crop_ins_month"));
		int exp_crop_ins_year = Integer.parseInt(request.getParameter("exp_crop_ins_year"));

		// String photo_card=request.getParameter("photo_card");

		Part part_photocard = request.getPart("photo_card");
		String fileName_photocard = part_photocard.getSubmittedFileName();
		// ////////////System.out.println(fileName_photocard);

		/*
		 * String fileName_photocard = null; String relative_loc_photocard = null;
		 * ServletFileUpload uploader = new ServletFileUpload(new
		 * DiskFileItemFactory()); if (ServletFileUpload.isMultipartContent(request)) {
		 * try { List<FileItem> useritems = uploader.parseRequest(request); for
		 * (FileItem item : useritems) { if (item.isFormField()) { fileName_photocard =
		 * item.getName(); String loc_photocard = path + File.separator + EmpID +
		 * File.separator + dir1 + File.separator + fileName_photocard;
		 * relative_loc_photocard = EmpID + File.separator + dir1 + File.separator +
		 * fileName_photocard; ////////////System.out.println(loc_photocard);
		 * 
		 * File file_photocard = new File(loc_photocard); file_photocard.mkdirs();
		 * 
		 * item.write(file_photocard); } } }catch(Exception e) { String message =
		 * "";for(StackTraceElement stackTraceElement :
		 * Thread.currentThread().getStackTrace()) { message = message +
		 * System.lineSeparator() + stackTraceElement.toString(); }
		 * logger.error(e+System.lineSeparator()+message); } }
		 */

		String card_id = request.getParameter("card_id");
		String gender = request.getParameter("gender");
//		String card_photo = request.getParameter("card_photo");
		String bank_account_number = request.getParameter("bank_num");

		// String photo=request.getParameter("photo");

		Part part_photo = request.getPart("photo");
		String fileName_photo = part_photo.getSubmittedFileName();
		// ////////////System.out.println(fileName_photo);

		String banf_ifsc = request.getParameter("banf_ifsc");
		String bank_name = request.getParameter("bank_name");
		String bank_branch = request.getParameter("bank_branch");
		String bank_state = request.getParameter("bank_state");
		String bank_branch_address = request.getParameter("bank_branch_address");

		/*
		 * String level="FDV"; String State="CCCD"; String District="CC"; String
		 * l5="BHHGV"; String l4="GGXS"; String User="HSXHKJSA"; String
		 * Designation="HHNN"; String dob="2015-11-11"; int mobile1=45; int mobile2=12;
		 * String email="HHFR"; String education_qualification="BBHH"; String
		 * office_location="JJNHN"; int exp_crop_ins_year=74; int exp_crop_ins_month=9;
		 * String photo_card="photo_card"; String card_id="card_id"; String
		 * gender="gender"; //String
		 * card_photo="C:\\Users\\Admin\\Desktop\\ep_pic\\course\\a.png"; //String
		 * photo="C:\\Users\\Admin\\Desktop\\ep_pic\\course\\b.png"; String
		 * card_photo="NULL"; String photo="NULL"; String banf_ifsc="banf_ifsc"; String
		 * bank_name="bank_name"; String bank_branch="bank_branch"; String
		 * bank_state="bank_state"; String bank_branch_address="bank_branch_address";
		 */

		User_Registration ob = new User_Registration(level, State, District, l5, l4, User, Designation, dob, mobile1,
				mobile2, email, education_qualification, office_location, exp_crop_ins_year, exp_crop_ins_month,
				fileName_photocard, card_id, gender, bank_account_number, fileName_photo, banf_ifsc, bank_name,
				bank_branch, bank_state, bank_branch_address);
//		//////System.out.println(ob);
		ob.setEducation_qualification(request.getParameter("educational_qualification"));
		ob.setDesignation(request.getParameter("designation"));
		DetailsDao ob1 = new DetailsDao();
		try {
			int EmpID = ob1.insert(ob);
			// //////System.out.println("emp id"+EmpID);
			if (EmpID == 1062) {
				return 1062;
			} else if (EmpID != 0) {
				// //////////System.out.println("done");
				uploadFile(EmpID, part_photocard, part_photo);
				return 1;
			} else {
				return 0;
			}
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			String message = "";
			for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
				message = message + System.lineSeparator() + stackTraceElement.toString();
			}
			logger.error(e + System.lineSeparator() + message);
			return 0;
		}

	}

	public void uploadFile(int EmpID, Part part_photocard, Part part_photo) throws IOException, SQLException {
		String fileName_photocard = part_photocard.getSubmittedFileName();
		String loc_photocard = path + File.separator + EmpID + File.separator + dir1 + File.separator
				+ fileName_photocard;

		String relative_loc_photocard = EmpID + File.separator + dir1 + File.separator + fileName_photocard;
//////////System.out.println(loc_photocard);

		File path_photocard = new File(loc_photocard);
		path_photocard.mkdirs();
		// ////////////System.out.println(path_photocard);
		if (fileName_photocard != null && !"".equals(fileName_photocard)) {
			part_photocard.write(loc_photocard);
		}

		String fileName_photo = part_photo.getSubmittedFileName();
		String loc_photo = path + File.separator + EmpID + File.separator + dir2 + File.separator + fileName_photo;
		// //////System.out.println("the loc phot is "+loc_photo);
		String relative_loc_photo = EmpID + File.separator + dir2 + File.separator + fileName_photo;
		// //////System.out.println(loc_photo);

		File path_photo = new File(loc_photo);
		path_photo.mkdirs();
		// //////System.out.println(path_photo);
		if (fileName_photo != null && !"".equals(fileName_photo)) {
			part_photo.write(loc_photo);
		}

		int pass = DetailsDao.update_path(EmpID, relative_loc_photocard, relative_loc_photo);
		/*
		 * if (pass == 1) { // //////////System.out.println("Fields updated"); } else { //
		 * //////////System.out.println("Fields not updated"); }
		 */
	}

}
