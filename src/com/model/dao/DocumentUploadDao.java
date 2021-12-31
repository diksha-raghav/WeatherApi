package com.model.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Part;

import org.apache.log4j.Logger;

import com.dao.Service.MobileAjaxService;
import com.dao.util.DBUtil;

public class DocumentUploadDao {
	final static Logger logger = Logger.getLogger(DocumentUploadDao.class);

	String path = DetailsDao.fetch_path();
	private static final String dir1 = "pan_pass_aadhar";
	private static final String dir2 = "photo";

	public int inserted = 0, failed = 0;
	public String files_failed = "";

	public Map<String, Object> upload(List<Part> files) {
		Map resultMap = new HashMap<String, Integer>();
		try {

			for (Part part_photocard : files) {
				String filename = part_photocard.getSubmittedFileName();
				if (filename != null && !"".equals(filename)) {
					DocumentUploadDao d = new DocumentUploadDao();

					if (!check_file(filename)) {
						failed++;
						files_failed += filename;
						files_failed += " - Invalid document,\n\r";
						continue;
					}

					String[] detail = d.get_mobileno(part_photocard);
					String mobile = detail[0];
					String doctype = detail[1];
					// System.out.println(mobile+" and "+doctype);
					List mobileList = MobileAjaxService.getMobileList();
					ArrayList list = new ArrayList<>();
					list = d.get_id(mobile);

					if (d.check_mobileno(mobileList, mobile)) {
						if (doctype.equalsIgnoreCase("pan") || doctype.equalsIgnoreCase("passport")
								|| doctype.equalsIgnoreCase("aadhar")) {
							if (list.get(2) == null) {
								int empid = (int) list.get(0);
								int status = d.uploadDoc(part_photocard, empid, doctype);
								if (status == 1) {
									inserted++;
								} else {
									failed++;
									files_failed += filename;
									files_failed += " - Error in uploading document,\n\r";
								}
							} else {
								failed++;
								files_failed += filename;
								files_failed += " - Document already uploaded,\n\r";
							}
						} else if (doctype.equalsIgnoreCase("photo")) {
							if (list.get(1) == null) {
								int empid = (int) list.get(0);
								int status = d.uploadPhoto(part_photocard, empid);
								if (status == 1) {
									inserted++;
								} else {
									failed++;
									files_failed += filename;
									files_failed += " - Error in uploading photo,\n\r";
								}
							} else {
								failed++;
								files_failed += filename;
								files_failed += " - Photo already uploaded,\n\r";
							}
						} else {
							failed++;
							files_failed += filename;
							files_failed += " - Invalid document type,\n\r";
						}
					} else {
						failed++;
						files_failed += filename;
						files_failed += " - Mobile Number does not exist,\n\r";
					}
				}
			}
		} catch (Exception e) {
			logger.error(e);
		}
		/*
		 * System.out.println(inserted); System.out.println(failed);
		 * System.out.println(files_failed);
		 */
		resultMap.put("failed", failed);
		resultMap.put("passed", inserted);
		resultMap.put("FilesFailedMesasge", files_failed);

		return resultMap;
	}

	public boolean check_file(String filename) {
		if (filename.contains("_"))
			return true;
		// TODO Auto-generated method stub
		return false;
	}

	// TODO Auto-generated method stub

	public String[] get_mobileno(Part part_photocard) {
		String filename = part_photocard.getSubmittedFileName();
		String[] splitted_filename = filename.split("\\.");
		// TODO Auto-generated method stub
		// System.out.println(splitted_filename[0]);
		String[] phn_doc = splitted_filename[0].split("_");
		return phn_doc; // phn_doc[0]=phone number, phn_doc[1]=document name;
	}

	public Boolean check_mobileno(List mobileList, String mobile) {
		if (mobileList.contains(mobile))
			return true;
		return false;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList get_id(String mobile) throws SQLException {
		int id = 0;
		String photo = null, document = null;
		ArrayList ar = new ArrayList<>();
		try (Connection con = DBUtil.getConn()) {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(
					"select empID,relative_loc_photocard,relative_loc_photo from user_details where mobile1='" + mobile
							+ "'");
			if (rs.next()) {
				id = rs.getInt("empID");
				photo = rs.getString("relative_loc_photo");
				document = rs.getString("relative_loc_photocard");
			}
			ar.add(id);
			ar.add(photo);
			ar.add(document);
		} catch (Exception e) {
			logger.error(e);
		}
		return ar;
	}

	public int uploadDoc(Part part_photocard, int empid, String doctype) {
		int status = 0;
		try {
			String filename = part_photocard.getSubmittedFileName();
			String loc_photocard = path + File.separator + empid + File.separator + dir1 + File.separator + filename;
			String relative_loc_photocard = empid + File.separator + dir1 + File.separator + filename;
			File path_photocard = new File(loc_photocard);
			path_photocard.mkdirs();
			if (filename != null && !"".equals(filename)) {
				part_photocard.write(loc_photocard);
			}
			status = update_doc_path(empid, relative_loc_photocard, doctype);
		} catch (Exception e) {
			logger.error(e);
		}
		return status;
	}

	public int uploadPhoto(Part part_photocard, int empid) {
		int status = 0;
		try {
			String filename = part_photocard.getSubmittedFileName();
			String loc_photocard = path + File.separator + empid + File.separator + dir2 + File.separator + filename;
			String photocard = empid + File.separator + dir2 + File.separator + filename;
			File path_photocard = new File(loc_photocard);
			path_photocard.mkdirs();
			if (filename != null && !"".equals(filename)) {
				part_photocard.write(loc_photocard);
			}
			status = update_photo_path(empid, photocard);
		} catch (Exception e) {
			logger.error(e);
		}
		return status;
	}

	public int update_photo_path(int eid, String photocard) throws SQLException {
		try (Connection con = DBUtil.getConn()) {
			PreparedStatement pst = con
					.prepareStatement("update user_details set relative_loc_photo=? where empID ='" + eid + "' ");
			pst.setString(1, photocard);
			int success = pst.executeUpdate();
			if (success > 0) {
				return 1;
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return 0;
	}

	public int update_doc_path(int eid, String relative_loc_photocard, String doctype) throws SQLException {
		try (Connection con = DBUtil.getConn()) {
			PreparedStatement pst = con.prepareStatement(
					"update user_details set relative_loc_photocard=? , doc_type=? where empID ='" + eid + "' ");
			pst.setString(1, relative_loc_photocard);
			pst.setString(2, doctype);
			int success = pst.executeUpdate();
			if (success > 0) {
				return 1;
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return 0;
	}

}
