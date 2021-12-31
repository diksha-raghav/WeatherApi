package com.dao.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mode.entities.SOS_Message;
import com.model.dao.SOSDao;

public class SOS_Service {

	public static List<SOS_Message> sosdetails() throws SQLException {
		// TODO Auto-generated method stub
		List<SOS_Message> sos_details = SOSDao.fetch_sosdetails();
		return sos_details;
	}
	
	public static boolean insertRemark(String remark, String ref) throws SQLException {
		System.out.println("in service");
		int refid = Integer.parseInt(ref);
	    boolean status = SOSDao.insert_ROremark(remark, refid);
	    return status;
	}
	
	public static boolean update_status(String[] refid) throws SQLException {
		System.out.println("service called");
		List<Integer> REF_ID = new ArrayList<>();
		for(int i=0; i<refid.length; i++) {
			String ref = refid[i];
			int rid = Integer.parseInt(ref);
			REF_ID.add(rid);
		}
	    boolean status = SOSDao.update_Resolvedstatus(REF_ID);
	    return status;
	  }
}
