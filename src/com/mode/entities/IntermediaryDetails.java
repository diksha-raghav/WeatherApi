package com.mode.entities;

public class IntermediaryDetails {

	/*@Override
	public String toString() {
		return "ProductIntermediaryDetails [intermediaryType=" + intermediaryType + ", intermediaryMail="
				+ intermediaryMail + ", intermediaryName=" + intermediaryName + ", intSpocName=" + intSpocName
				+ ", intermediaryAddress=" + intermediaryAddress + ", intermediaryMobile=" + intermediaryMobile + "]";
	}*/

	public void setIntermediaryType(String intermediaryType) {
		this.intermediaryType = intermediaryType;
	}

	public void setIntermediaryMail(String intermediaryMail) {
		this.intermediaryMail = intermediaryMail;
	}

	public void setIntermediaryName(String intermediaryName) {
		this.intermediaryName = intermediaryName;
	}

	public void setIntSpocName(String intSpocName) {
		this.intSpocName = intSpocName;
	}

	public void setIntermediaryAddress(String intermediaryAddress) {
		this.intermediaryAddress = intermediaryAddress;
	}

	public void setIntermediaryMobile(String intermediaryMobile) {
		this.intermediaryMobile = intermediaryMobile;
	}

	public void setIntermediaryId(String intermediaryId) {
		this.intermediaryId = intermediaryId;
	}

	private String intermediaryType, intermediaryMail, intermediaryName, intSpocName, intermediaryAddress;
	private String intermediaryMobile;
	private String intermediaryId;

	public String getIntermediaryMobile() {
		return intermediaryMobile;
	}

	public String getIntermediaryType() {
		return intermediaryType;
	}

	public String getIntermediaryMail() {
		return intermediaryMail;
	}

	public String getIntermediaryName() {
		return intermediaryName;
	}

	public String getIntSpocName() {
		return intSpocName;
	}

	public String getIntermediaryAddress() {
		return intermediaryAddress;
	}

	public String getIntermediaryId() {
		return intermediaryId;
	}

	public IntermediaryDetails() {

	}
	public void Display()
	{
		//////System.out.println(intSpocName);
		//////System.out.println( intermediaryName);
		//////System.out.println(intermediaryMail);
		//////System.out.println(intermediaryMobile);
		
		}

	public IntermediaryDetails(String intermediaryType, String intermediaryName, String intSpocName,
			String intermediaryMail, String intermediaryMobile, String intermediaryAddress) {
		
		this.intermediaryType = intermediaryType;
		this.intermediaryName = intermediaryName;
		this.intSpocName = intSpocName;
		this.intermediaryMail = intermediaryMail;
		this.intermediaryMobile = intermediaryMobile;
		this.intermediaryAddress = intermediaryAddress;
	}
	
	public IntermediaryDetails(String intermediaryId, String intermediaryName, String intSpocName,
			String intermediaryAddress, String intermediaryMobile, String intermediaryMail, String intermediaryType) {
		this.intermediaryId = intermediaryId;
		this.intermediaryName = intermediaryName;
		this.intSpocName = intSpocName;
		this.intermediaryAddress = intermediaryAddress;
		this.intermediaryMobile = intermediaryMobile;
		this.intermediaryMail = intermediaryMail;
		this.intermediaryType = intermediaryType;
	}
}
