package com.mode.entities;

public class User_Registration {
	private String level;
	private String doc_type;


	public void setLevel(String level) {
		this.level = level;
	}

	public void setState(String state) {
		State = state;
	}

	public void setDistrict(String district) {
		District = district;
	}

	public void setL5(String l5) {
		this.l5 = l5;
	}

	public void setL4(String l4) {
		this.l4 = l4;
	}

	@Override
	public String toString() {
		return "User_Registration [level=" + level + ", doc_type=" + doc_type + ", State=" + State + ", District="
				+ District + ", l5=" + l5 + ", l4=" + l4 + ", User=" + User + ", Designation=" + Designation + ", dob="
				+ dob + ", mobile1=" + mobile1 + ", mobile2=" + mobile2 + ", email=" + email
				+ ", education_qualification=" + education_qualification + ", office_location=" + office_location
				+ ", exp_crop_ins_year=" + exp_crop_ins_year + ", exp_crop_ins_month=" + exp_crop_ins_month
				+ ", photo_card=" + photo_card + ", card_id=" + card_id + ", gender=" + gender
				+ ", bank_account_number=" + bank_account_number + ", photo=" + photo + ", banf_ifsc=" + banf_ifsc
				+ ", bank_name=" + bank_name + ", bank_branch=" + bank_branch + ", bank_state=" + bank_state
				+ ", bank_branch_address=" + bank_branch_address + "]";
	}

	public void setUser(String user) {
		User = user;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}
	
	public void setStatus(String status) {
		status = status;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}

	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEducation_qualification(String education_qualification) {
		this.education_qualification = education_qualification;
	}

	public void setOffice_location(String office_location) {
		this.office_location = office_location;
	}

	public void setExp_crop_ins_year(int exp_crop_ins_year) {
		this.exp_crop_ins_year = exp_crop_ins_year;
	}

	public void setExp_crop_ins_month(int exp_crop_ins_month) {
		this.exp_crop_ins_month = exp_crop_ins_month;
	}

	public void setPhoto_card(String photo_card) {
		this.photo_card = photo_card;
	}

	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public void setBanf_ifsc(String banf_ifsc) {
		this.banf_ifsc = banf_ifsc;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public void setBank_branch(String bank_branch) {
		this.bank_branch = bank_branch;
	}

	public void setBank_state(String bank_state) {
		this.bank_state = bank_state;
	}

	public void setBank_branch_address(String bank_branch_address) {
		this.bank_branch_address = bank_branch_address;
	}

	private String State;
	private String District;
	private String l5;
	private String l4;
	private String User;
	private String Designation;
	private String dob;
	private String mobile1;
	private String mobile2;
	private String email;
	private String education_qualification;
	private String office_location;
	private int exp_crop_ins_year;
	private int exp_crop_ins_month;
	private String photo_card;
	private String card_id;
	private String gender;
	private String bank_account_number;
	private String status;
	
	
	public String getBank_account_number() {
		return bank_account_number;
	}

	public void setBank_account_number(String bank_account_number) {
		this.bank_account_number = bank_account_number;
	}

	public User_Registration() {
		super();
	}

	private String photo;
	private String banf_ifsc;
	private String bank_name;
	private String bank_branch;
	private String bank_state;
	private String bank_branch_address;

	public User_Registration(String level, String State, String District, String l5, String l4, String User,
			String Designation, String dob, String mobile1, String mobile2, String email,
			String education_qualification, String office_location, int exp_crop_ins_year, int exp_crop_ins_month,
			String photo_card, String card_id, String gender, String card_photo, String photo, String banf_ifsc,
			String bank_name, String bank_branch, String bank_state, String bank_branch_address) {
		this.level = level;
		this.State = State;
		this.District = District;
		this.l5 = l5;
		this.l4 = l4;
		this.User = User;
		this.Designation = Designation;
		this.dob = dob;
		this.mobile1 = mobile1;
		this.mobile2 = mobile2;
		this.email = email;
		this.education_qualification = education_qualification;
		this.office_location = office_location;
		this.exp_crop_ins_year = exp_crop_ins_year;
		this.exp_crop_ins_month = exp_crop_ins_month;
		this.photo_card = photo_card;
		this.card_id = card_id;
		this.gender = gender;
		this.bank_account_number = card_photo;
		this.photo = photo;
		this.banf_ifsc = banf_ifsc;
		this.bank_name = bank_name;
		this.bank_branch = bank_branch;
		this.bank_state = bank_state;
		this.bank_branch_address = bank_branch_address;
	}

	public User_Registration(String mobile1, String user, String designation, String email, String gender, String state,
			String district, String status) {
		super();
		this.User = user;
		this.Designation = designation;
		this.mobile1 = mobile1;
		this.email = email;
		this.gender = gender;
		this.State = state;
		this.District = district;
		this.status = status;
	}

	public String getLevel() {
		return level;
	}

	public String getState() {
		return State;
	}

	public String getDistrict() {
		return District;
	}

	public String getL5() {
		return l5;
	}

	public String getL4() {
		return l4;
	}

	public String getUser() {
		return User;
	}

	public String getDesignation() {
		return Designation;
	}
	
	public String getStatus() {
		return status;
	}


	public String getDob() {
		return dob;
	}

	public String getMobile1() {
		return mobile1;
	}

	public String getMobile2() {
		return mobile2;
	}

	public String getEmail() {
		return email;
	}

	public String getEducation_qualification() {
		return education_qualification;
	}

	public String getOffice_location() {
		return office_location;
	}

	public int getExp_crop_ins_year() {
		return exp_crop_ins_year;
	}

	public int getExp_crop_ins_month() {
		return exp_crop_ins_month;
	}

	public String getPhoto_card() {
		return photo_card;
	}

	public String getCard_id() {
		return card_id;
	}

	public String getGender() {
		return gender;
	}

	public String getCard_photo() {
		return bank_account_number;
	}

	public String getPhoto() {
		return photo;
	}

	public String getBanf_ifsc() {
		return banf_ifsc;
	}

	public String getBank_name() {
		return bank_name;
	}

	public String getBank_branch() {
		return bank_branch;
	}

	public String getBank_state() {
		return bank_state;
	}

	public String getBank_branch_address() {
		return bank_branch_address;
	}

	public String getDoc_type() {
		return doc_type;
	}

	public void setDoc_type(String doc_type) {
		this.doc_type = doc_type;
	}

	/*
	 * public User_Registration createObject(String level, String State, String
	 * District, String l5, String l4, String User, String Designation, String dob,
	 * String mobile1, String mobile2, String email, String education_qualification,
	 * String office_location, int exp_crop_ins_year, int exp_crop_ins_month, String
	 * photo_card, String card_id, String gender, String card_photo, String photo,
	 * String banf_ifsc, String bank_name, String bank_branch, String bank_state,
	 * String bank_branch_address, String doc_type) { this.level = level; this.State
	 * = State; this.District = District; this.l5 = l5; this.l4 = l4; this.User =
	 * User; this.Designation = Designation; this.dob = dob; this.mobile1 = mobile1;
	 * this.mobile2 = mobile2; this.email = email; this.education_qualification =
	 * education_qualification; this.office_location = office_location;
	 * this.exp_crop_ins_year = exp_crop_ins_year; this.exp_crop_ins_month =
	 * exp_crop_ins_month; this.photo_card = photo_card; this.card_id = card_id;
	 * this.gender = gender; this.photo = photo; this.banf_ifsc = banf_ifsc;
	 * this.bank_name = bank_name; this.bank_branch = bank_branch; this.bank_state =
	 * bank_state; this.bank_branch_address = bank_branch_address; this.doc_type =
	 * doc_type; }
	 */
}
