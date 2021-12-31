package com.mode.entities;

public class SOS_Message {
	private int empID;
	private String ename;
	private String date;
	private String loclatlong;
	private int refid;
	private String contact;
	private String remark;
	private String flag1;
	private String flag2;
	private String flag3;
	private String state;
	private String username;
	
	public SOS_Message(int empID, String ename, String date, String loclatlong,int refid, String contact, String remark,
			String flag1, String flag2, String flag3, String state, String username) {
		super();
		this.empID = empID;
		this.ename = ename;
		this.date = date;
		this.loclatlong = loclatlong;
		this.refid=refid;
		this.contact = contact;
		this.remark = remark;
		this.flag1 = flag1;
		this.flag2 = flag2;
		this.flag3 = flag3;
		this.state = state;
		this.username = username;
	}
	
	public int getEmpID() {
		return empID;
	}
	
	public String getEname() {
		return ename;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getLoclatlong() {
		return loclatlong;
	}
	public int getRefid() {
		return refid;
	}
	
	public String getContact() {
		return contact;
	}
	
	public String getRemark() {
		return remark;
	}
	
	public String getFlag1() {
		return flag1;
	}
	
	public String getFlag2() {
		return flag2;
	}
	
	public String getFlag3() {
		return flag3;
	}
	
	public String getState() {
		return state;
	}
	
	public String getUsername() {
		return username;
	}

	@Override
	public String toString() {
		return "SOS_Message [empID=" + empID + ", ename=" + ename + ", date=" + date + ", loclatlong=" + loclatlong
				+ ", refid=" + refid + ", contact=" + contact + ", remark=" + remark + ", flag1=" + flag1 + ", flag2="
				+ flag2 + ", flag3=" + flag3 + ", state=" + state + ", username=" + username + "]";
	}

	
	
}
