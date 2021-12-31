package com.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.log4j.Logger;

import com.dao.util.DBUtil;
import com.dao.util.User_RegistrationUtil;
import com.mode.entities.IntermediaryDetails;
import com.mode.entities.User_Registration;

public class IntermediaryDao {
	static {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy");
		System.setProperty("current.date.time", dateFormat.format(new Date()));
	}
	final static Logger logger = Logger.getLogger(IntermediaryDao.class);

	static Map<String, List<String>> interMap = new HashMap<>();
	static Map<String, IntermediaryDetails> interDetailMap = new HashMap<>();

	public static Map<String, List<String>> loadIntermediary() {
		List<String> names = new ArrayList<String>();

		try (Connection con = DBUtil.getConnection_wfms();) {
			PreparedStatement ps = con.prepareStatement(
					"select * from intermediary_details where intermediary_type = ? order by intermediary_name asc");
			ps.setString(1, "Broker");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				IntermediaryDetails id = new IntermediaryDetails(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
				names.add(id.getIntermediaryName());
				interDetailMap.put(id.getIntermediaryName(), id);
			}
			interMap.put("Broker", names);
			////System.out.println(names.size());
			////System.out.println(interDetailMap.size());
			////System.out.println("Intermap" + interMap);

		} catch (Exception e) {
			String message = "";
			for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
				message = message + System.lineSeparator() + stackTraceElement.toString();
			}
			logger.error(e + System.lineSeparator() + message);
		}
		return interMap;
	}

	public static Map<String, List<String>> getInterMap() {
		return interMap;
	}

	public static Map<String, IntermediaryDetails> getInterMapDetails() {
		return interDetailMap;
	}

	public static int getParameters(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		// ////System.out.println("entered in get parameter");
		String level = request.getParameter("level");
		String State = request.getParameter("state");
		String District = request.getParameter("district");
		String l5 = request.getParameter("l5");
		String l4 = request.getParameter("subdistrict");
		String User = request.getParameter("User");
		String Designation = request.getParameter("designation");
		// ////System.out.println(Designation);
		String dob = request.getParameter("dob");
		String mobile1 = request.getParameter("mobile1");
		String mobile2 = request.getParameter("mobile2");
		String email = request.getParameter("email");
		String education_qualification = request.getParameter("education_qualification");
		String office_location = request.getParameter("office_location");
		int exp_crop_ins_month = Integer.parseInt(request.getParameter("exp_crop_ins_month"));
		int exp_crop_ins_year = Integer.parseInt(request.getParameter("exp_crop_ins_year"));

//		 String photo_card=request.getParameter("photo_card");

		Part part_photocard = request.getPart("photo_card");
		String fileName_photocard = part_photocard.getSubmittedFileName();

		String card_id = request.getParameter("card_id");
		////System.out.println("card id is " + card_id);
		String gender = request.getParameter("gender");
		String card_photo = request.getParameter("card_photo");
		String photo_card = request.getParameter("photo_card");
		// String photo=request.getParameter("photo");

		Part part_photo = request.getPart("photo");
		String fileName_photo = part_photo.getSubmittedFileName();
		// ////////System.out.println(fileName_photo);

		String banf_ifsc = request.getParameter("banf_ifsc");
		String bank_name = request.getParameter("bank_name");
		String bank_branch = request.getParameter("bank_branch");
		String bank_state = request.getParameter("bank_state");
		String bank_branch_address = request.getParameter("bank_branch_address");
		String doc_type = request.getParameter("doc_type");
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

		/*
		 * User_Registration ob = new User_Registration(level, State, District, l5, l4,
		 * User, Designation, dob, mobile1, mobile2, email, education_qualification,
		 * office_location, exp_crop_ins_year, exp_crop_ins_month, fileName_photocard,
		 * card_id, gender, card_photo, fileName_photo, banf_ifsc, bank_name,
		 * bank_branch, bank_state, bank_branch_address);
		 */
		////System.out.println(gender);
		User_Registration ob = new User_Registration();
		ob.setLevel(level);
		ob.setState(State);
		ob.setDistrict(District);
		ob.setL5(l5);
		ob.setL4(l4);
		ob.setUser(User);
		ob.setDesignation(Designation);
		ob.setDob(dob);
		ob.setMobile1(mobile1);
		ob.setMobile2(mobile2);
		ob.setEmail(email);
		ob.setEducation_qualification(education_qualification);
		ob.setOffice_location(office_location);
		ob.setExp_crop_ins_year(exp_crop_ins_year);
		ob.setExp_crop_ins_month(exp_crop_ins_month);
		ob.setDoc_type(doc_type);
		ob.setPhoto_card(photo_card);
		ob.setCard_id(card_id);
		ob.setGender(gender);
		ob.setBanf_ifsc(banf_ifsc);
		ob.setBank_name(bank_name);
		ob.setBank_branch(bank_branch);
		ob.setBank_state(bank_state);
		ob.setBank_branch_address(bank_branch_address);
		ob.setDoc_type(doc_type);

		/*
		 * public User_Registration(String level, String State, String District, String
		 * l5, String l4, String User, String Designation, String dob, String mobile1,
		 * String mobile2, String email, String education_qualification, String
		 * office_location, int exp_crop_ins_year, int exp_crop_ins_month, String
		 * photo_card, String card_id, String gender, String card_photo, String photo,
		 * String banf_ifsc, String bank_name, String bank_branch, String bank_state,
		 * String bank_branch_address, String doc_type); {
		 *//*
			 * this.level = level; this.State = State; this.District = District; this.l5 =
			 * l5; this.l4 = l4; this.User = User; this.Designation = Designation; this.dob
			 * = dob; this.mobile1 = mobile1; this.mobile2 = mobile2; this.email = email;
			 * this.education_qualification = education_qualification; this.office_location
			 * = office_location; this.exp_crop_ins_year = exp_crop_ins_year;
			 * this.exp_crop_ins_month = exp_crop_ins_month; this.photo_card = photo_card;
			 * this.card_id = card_id; this.gender = gender; this.bank_account_number =
			 * card_photo; this.photo = photo; this.banf_ifsc = banf_ifsc; this.bank_name =
			 * bank_name; this.bank_branch = bank_branch; this.bank_state = bank_state;
			 * this.bank_branch_address = bank_branch_address; this.doc_type = doc_type; }
			 */

		////System.out.println(ob);
		String inter_name = request.getParameter("intermediary_name");
		String inter_spoc = request.getParameter("int_spoc_name");
		String inter_address = request.getParameter("int_address");
		String inter_mobile = request.getParameter("int_phonenumber");
		String inter_mail = request.getParameter("int_emailid");
		String inter_type = request.getParameter("intermediary_type");

		IntermediaryDetails id = new IntermediaryDetails(inter_type, inter_name, inter_spoc, inter_mail, inter_mobile,
				inter_address);
		// ////System.out.println(id);
		int EmpID = insert(ob, id);
		if (EmpID == 1062) {
			return 1062;
		} else if (EmpID != 0) {
			// //////////System.out.println("done");
			User_RegistrationUtil ob1 = new User_RegistrationUtil();
			ob1.uploadFile(EmpID, part_photocard, part_photo);
			return 1;
		} else {
			return 0;
		}

		// //////System.out.println("in user registration");
		// DetailsDao ob1 = new DetailsDao();
		/*
		 * try { int EmpID = ob1.insert(ob); if (EmpID != 0) {
		 * ////////System.out.println("done"); User_RegistrationUtil.uploadFile(EmpID,
		 * part_photocard, part_photo); return true; } else { return false; } }
		 * 
		 * catch (SQLException e) { // TODO Auto-generated catch block logger.error(e);
		 * return false; }
		 */

	}

	public static int insert(User_Registration data, IntermediaryDetails id) throws SQLException {
		String revert = "invalid";
		Connection con = null;
		try {
			// ////System.out.println("entered in insert");
			con = DBUtil.getConn();
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(
					"insert into user_details(level,State,District,l5,l4,"
							+ "User,Designation,dob,mobile1,mobile2,email,education_qualification,"
							+ "office_location,exp_crop_ins_year,exp_crop_ins_month,photo_card,card_id,"
							+ "gender,bank_account_number,photo,banf_ifsc,bank_name,bank_branch,bank_state,"
							+ "bank_branch_address,doc_type,intermediary_name, intermediary_spoc, intermediary_address,"
							+ " intermediary_mobile, intermediary_mail, intermediary_type) "
							+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, data.getLevel());
			ps.setString(2, data.getState().toUpperCase());
			ps.setString(3, data.getDistrict());
			ps.setString(4, data.getL5());
			ps.setString(5, data.getL4());
			ps.setString(6, data.getUser());
			ps.setString(7, data.getDesignation());
			// Date startDate=(Date) new
			// SimpleDateFormat("yyyy-MM-dd").parse(data.getDob());
			// ps.setDate(8, startDate);
			ps.setString(8, data.getDob());
			ps.setString(9, data.getMobile1());
			ps.setString(10, data.getMobile2());
			ps.setString(11, data.getEmail());
			ps.setString(12, data.getEducation_qualification());
			ps.setString(13, data.getOffice_location());
			ps.setInt(14, data.getExp_crop_ins_year());
			ps.setInt(15, data.getExp_crop_ins_month());
			ps.setString(16, data.getPhoto_card());
			ps.setString(17, data.getCard_id());
			ps.setString(18, data.getGender());
			// FileInputStream fin = new FileInputStream(data.getCard_photo());
			// ps.setBlob(19, fin);
			ps.setString(19, data.getBank_account_number());
			// FileInputStream fin1 = new FileInputStream(data.getPhoto());
			// ps.setBlob(20, fin1);
			ps.setString(20, data.getPhoto());
			ps.setString(21, data.getBanf_ifsc());
			ps.setString(22, data.getBank_name());
			ps.setString(23, data.getBank_branch());
			ps.setString(24, data.getBank_state());
			ps.setString(25, data.getBank_branch_address());
			ps.setString(26, data.getDoc_type());
			ps.setString(27, id.getIntermediaryName());
			ps.setString(28, id.getIntSpocName());
			ps.setString(29, id.getIntermediaryAddress());
			ps.setString(30, id.getIntermediaryMobile());
			ps.setString(31, id.getIntermediaryMail());
			ps.setString(32, id.getIntermediaryType());
			// ps.setString(26, data.getRelative_loc_photocard());
			// ps.setString(27, data.getRelative_loc_photo());
			// ps.executeUpdate();
			int primkey = 0;
			if (ps.executeUpdate() > 0) {
				// , Statement.RETURN_GENERATED_KEYS
				// Retrieves any auto-generated keys created as a result of executing this
				// Statement object
				ResultSet generatedKeys = ps.getGeneratedKeys();
				if (generatedKeys.next()) {
					primkey = generatedKeys.getInt(1);
				}
				String sql = "INSERT INTO user_login(username,password,empID,active_deactive) VALUES("
						+ data.getMobile1() + ",MD5('" + data.getDob() + "')," + primkey + ",1)";
				// //////////System.out.println(sql);
				PreparedStatement ps1 = con.prepareStatement(sql);
				if (ps1.executeUpdate() > 0) {
					con.commit();
					con.setAutoCommit(true);
					return primkey;
				} else {
					return 0;
				}
				// System.out.print(primkey);
			}
			// int
			// Emp_Id=fetch_Emp_Id(data.getLevel(),data.getState(),data.getDistrict(),data.getL5(),data.getL4(),data.getUser(),data.getDesignation(),data.getDob(),data.getMobile1(),data.getMobile2(),data.getEmail(),data.getEducation_qualification(),data.getOffice_location(),data.getExp_crop_ins_year(),data.getExp_crop_ins_month(),data.getPhoto_card(),data.getCard_id(),data.getGender(),data.getCard_photo(),data.getPhoto(),data.getBanf_ifsc(),data.getBank_name(),data.getBank_branch(),data.getBank_state(),data.getBank_branch_address());
		} catch (SQLException e) {
			revert = "invalid";
			logger.error(e);
			if (e.getErrorCode() == 1062) {
				String message = "";
//				//////////System.out.println("in the exception and code is " + e.getErrorCode());
				for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
					message = message + System.lineSeparator() + stackTraceElement.toString();
				}
				logger.error(e + System.lineSeparator() + message);
				revert = "duplicate";
				con.rollback();
				return 1062;
			}
		} catch (Exception e) {
			logger.error(e);
			String message = "";
//			//////////System.out.println("in the exception and code is " + e.getErrorCode());
			for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
				message = message + System.lineSeparator() + stackTraceElement.toString();
			}
			logger.error(e + System.lineSeparator() + message);
			con.rollback();
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return 0;
	}

	public static void main(String args[]) {
		Map<String, List<String>> map1 = loadIntermediary();
		// getInterMapDetails();
		// ////System.out.println(getInterMap().size());
		// ////System.out.println(getInterMapDetails().size());
	}
}
