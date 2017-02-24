package VO;

import java.io.Serializable;

public class UserDetailsVO implements Serializable {

	private int user1_id;
	private int user1_no;
	private String first_name;
	private String last_name;
	private String address1;
	private String address2;
	private long contact_no;
	private String email_id;
	private String post;
	private int gun1_no;
	private UserVO userVO;
	public int getUser1_id() {
		return user1_id;
	}
	public void setUser1_id(int user1_id) {
		this.user1_id = user1_id;
	}
	public int getUser1_no() {
		return user1_no;
	}
	public void setUser1_no(int user1_no) {
		this.user1_no = user1_no;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public long getContact_no() {
		return contact_no;
	}
	public void setContact_no(long contact_no) {
		this.contact_no = contact_no;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public int getGun1_no() {
		return gun1_no;
	}
	public void setGun1_no(int gun1_no) {
		this.gun1_no = gun1_no;
	}
	public UserVO getUserVO() {
		return userVO;
	}
	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
	

}
