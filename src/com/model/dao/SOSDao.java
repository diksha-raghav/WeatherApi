package com.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.dao.util.DBUtil;
import com.mode.entities.SOS_Message;

public class SOSDao {
	final static Logger logger = Logger.getLogger(SOSDao.class);

	public static List<SOS_Message> fetch_sosdetails() throws SQLException {
		List<SOS_Message> sos_details = new ArrayList<>();
		Connection conn = null;
		try {
				
			conn = DBUtil.getConn(); 
			PreparedStatement ps = conn.prepareStatement("SELECT a.empID, a.ename, STR_TO_DATE(a.dateandtime,'%Y.%m.%d - %H:%i:%s IST'), a.loclatlong,a.REFID, a.contact_no, a.remark, a.flag1, a.flag2, a.flag3, b.State, c.username FROM dmdatabase.sos as a inner join dmdatabase.user_details as b on a.empID = b.empID inner join weather.state_master as c on b.state = c.state order by a.REFID"); 
			{
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					SOS_Message msg = new SOS_Message(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),rs.getString(12));
				
				//System.out.println(msg.toString());
					sos_details.add(msg);
				}
			}
		}
		 catch (Exception e) {
			String message = "";
			for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
				message = message + System.lineSeparator() + stackTraceElement.toString();
			}
			logger.error(e + System.lineSeparator() + message);
		}
		return sos_details;
	}
	
	public static boolean insert_ROremark(String remark, int refid) throws SQLException {
		System.out.println("in dao");
	    //Connection conn = DBUtil.getConnection();
		Connection conn = null;
	    System.out.println(remark+"  "+refid);
	    String query="update dmdatabase.sos set RO_remark=? where REFID = '"+refid+"' ";
	    
	    try 
	    {
	    	conn = DBUtil.getConn(); 
	    	PreparedStatement ps = conn.prepareStatement(query);
	      ps.setString(1, remark);
	      int status = ps.executeUpdate();
	      //System.out.println(status);
	      if(status != 0) {
	        return true;
	      }
	    } catch (Exception e) {
	      String message = "";
	      for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
	        message = message + System.lineSeparator() + stackTraceElement.toString();
	      }
	      logger.error(e + System.lineSeparator() + message);
	    }
	    return false;
	  }
	  
	public static boolean update_Resolvedstatus(List<Integer> refid) throws SQLException {
	    Connection conn = null;
	    System.out.println("dao called");
	    try {
	    	conn = DBUtil.getConn(); 
	    	//PreparedStatement ps
	      for(int i : refid) {
	    	PreparedStatement ps = conn.prepareStatement("update dmdatabase.sos set remark=? where REFID='"+i+"' ");
	        ps.setString(1, "Resolved");
	        int status = ps.executeUpdate();
	        if(status != 0) {
		        return true;
		    }
	      }
	    
	    } catch (Exception e) {
	      String message = "";
	      for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
	        message = message + System.lineSeparator() + stackTraceElement.toString();
	      }
	      logger.error(e + System.lineSeparator() + message);
	    }
	    return false;
	  }
	
	public static void main(String[] args) throws SQLException {
		List<SOS_Message> list = fetch_sosdetails();
		boolean hii=insert_ROremark("wow", 2) ;
		System.out.println(hii);
	}
}
