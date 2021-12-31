package com.controllers.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import com.mode.entities.IntermediaryDetails;
import com.mode.entities.User_Registration;
import com.model.dao.DetailsDao;
import com.model.dao.EditDao;
import com.model.dao.IntermediaryDao;

@WebServlet(name = "editController", urlPatterns = { "/editController" })
@MultipartConfig
public class editController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public EditDao EditDao;
	final static Logger logger = Logger.getLogger(editController.class);
	String path = DetailsDao.fetch_path();
	private static final String dir1 = "pan_pass_aadhar";

	public void init() {
		EditDao = new EditDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		////System.out.println("doget called");
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "no-cache");
		String mobile1 = request.getParameter("mobile1");
		try {

			List<IntermediaryDetails> intermediaries = EditDao.listIntermediary(mobile1);
			////System.out.println(intermediaries.size());
//		request.setAttribute("users", users);
			request.setAttribute("intermediaries", intermediaries);

			//JSONObject broker_obj = new JSONObject();
			
			JSONObject broker_obj = new JSONObject();
			//broker_obj.put("Broker", IntermediaryDao.getInterMap().get("Broker"));
			//request.setAttribute("interMap", broker_obj);
			
			for (IntermediaryDetails dt : intermediaries) {
				broker_obj.put(dt.getIntermediaryType(), IntermediaryDao.getInterMap().get(dt.getIntermediaryType()));
			}
			request.setAttribute("interMap", broker_obj);

			List<User_Registration> users = EditDao.listUser(mobile1);
			//// //////System.out.println(users.size());
			request.setAttribute("users", users);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/app/Edit.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			logger.error(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			if(request.getParameter("btn_update")!= null) {
				////System.out.println("doPost called");
				User_Registration user = new User_Registration();
				IntermediaryDetails id = new IntermediaryDetails();
				String mobile1 = request.getParameter("mobile1");
				//////System.out.println(mobile1);
				int EmpID = com.model.dao.EditDao.getEmployeeID(mobile1);
				user.setLevel(request.getParameter("level"));
				user.setState(request.getParameter("state"));
				user.setDistrict(request.getParameter("district"));
				user.setL5(request.getParameter("l5"));
				user.setL4(request.getParameter("subdistrict"));
				user.setUser(request.getParameter("username"));
				user.setDesignation(request.getParameter("designation"));
				// Date startDate=(Date) new
				// SimpleDateFormat("yyyy-MM-dd").parse(data.getDob());
				// ps.setDate(8, startDate);
				user.setDob(request.getParameter("dob"));

				user.setMobile2(request.getParameter("mobile2"));
				user.setEmail(request.getParameter("email"));
				user.setEducation_qualification(request.getParameter("educational_qualification"));
				user.setOffice_location(request.getParameter("office_location"));
				user.setDoc_type(request.getParameter("doc_type"));
				user.setExp_crop_ins_year(Integer.parseInt(request.getParameter("exp_crop_ins_year")));
				user.setExp_crop_ins_month(Integer.parseInt(request.getParameter("exp_crop_ins_month")));
				// ps.setString(16, data.getPhoto_card());
				// ////System.out.println(path);
				Part part_photocard = request.getPart("photo_card");
				// ////System.out.println(part_photocard);
				String fileName_photocard = part_photocard.getSubmittedFileName();
				//////System.out.println(fileName_photocard);
				user.setPhoto_card(fileName_photocard);
				user.setCard_id(request.getParameter("card_id"));
				user.setGender(request.getParameter("gender"));
				// FileInputStream fin = new FileInputStream(data.getCard_photo());
				// ps.setBlob(19, fin);
				// user.setCard_photo(request.getParameter("card_photo"));
				// FileInputStream fin1 = new FileInputStream(data.getPhoto());
				// ps.setBlob(20, fin1);
				// user.setPhoto(request.getParameter("photo"));
				user.setBanf_ifsc(request.getParameter("banf_ifsc"));
				user.setBank_name(request.getParameter("bank_name"));
				user.setBank_branch(request.getParameter("bank_branch"));
				user.setBank_state(request.getParameter("bank_state"));
				user.setBank_branch_address(request.getParameter("bank_branch_address"));
				user.setMobile1(request.getParameter("mobile1"));
				id.setIntermediaryType(request.getParameter("intermediary_type"));
				id.setIntermediaryName(request.getParameter("intermediary_name"));
				//////System.out.println("intermediary_name");
				id.setIntSpocName(request.getParameter("int_spoc_name"));
				id.setIntermediaryMobile(request.getParameter("int_phonenumber"));
				id.setIntermediaryMail(request.getParameter("int_emailid"));
				id.setIntermediaryAddress(request.getParameter("int_address"));
					boolean x = false;
					if (fileName_photocard == "") {
						x = EditDao.updateUserWithouDoc(user, id);
						//////System.out.println("DB without File");
					}

					// boolean x = EditDao.updateUser(user);

					if (fileName_photocard != "") {
						x = EditDao.updateUser(user, id);
						//////System.out.println(x);
						uploadFile(EmpID, part_photocard);
						//////System.out.println("File Updated");
					}
					if (x == true) {
						//////System.out.println("Successfully updated");
						// RequestDispatcher dispatcher =
						////// request.getRequestDispatcher("app/view.jsp?status=valid");
						// dispatcher.forward(request, response);
						// uploadFile(EmpID, part_photocard);
						HttpServletResponse httpResponse = (HttpServletResponse) response;
						httpResponse.sendRedirect("app/Edit.jsp?status=valid");
					} else {
						//////System.out.println("Update Unsuccessful");
						HttpServletResponse httpResponse = (HttpServletResponse) response;
						httpResponse.sendRedirect("app/Edit.jsp?status=invalid");
					}
				}	
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error(e);
			}
	}

	public void uploadFile(int EmpID, Part part_photocard) throws IOException, SQLException {
		String fileName_photocard = part_photocard.getSubmittedFileName();
		String loc_photocard = path + File.separator + EmpID + File.separator + dir1 + File.separator
				+ fileName_photocard;

		String relative_loc_photocard = EmpID + File.separator + dir1 + File.separator + fileName_photocard;
		////System.out.println(loc_photocard);

		File path_photocard = new File(loc_photocard);
		path_photocard.mkdirs();
		// //////////System.out.println(path_photocard);
		if (fileName_photocard != null && !"".equals(fileName_photocard)) {
			part_photocard.write(loc_photocard);
		}
		int pass = com.model.dao.EditDao.update_path(EmpID, relative_loc_photocard);
		if (pass == 1) {
			// ////System.out.println("Fields updated");
		} else {
			// ////System.out.println("Fields not updated");
		}
	}
}
