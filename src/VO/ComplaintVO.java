	package VO;

	import java.io.Serializable;

	public class ComplaintVO implements Serializable {
					
		
					private int c_id;
					private String complaint_name;
					private String complaint_type;
					private String complaint_date;
					private String message;
					private String reply;
					private String email;
					private String status;
					private UserVO userVO;
					public int getC_id() {
						return c_id;
					}
					public void setC_id(int c_id) {
						this.c_id = c_id;
					}
					public String getComplaint_name() {
						return complaint_name;
					}
					public void setComplaint_name(String complaint_name) {
						this.complaint_name = complaint_name;
					}
					public String getComplaint_type() {
						return complaint_type;
					}
					public void setComplaint_type(String complaint_type) {
						this.complaint_type = complaint_type;
					}
					public String getComplaint_date() {
						return complaint_date;
					}
					public void setComplaint_date(String complaint_date) {
						this.complaint_date = complaint_date;
					}
					public String getMessage() {
						return message;
					}
					public void setMessage(String message) {
						this.message = message;
					}
					public String getReply() {
						return reply;
					}
					public void setReply(String reply) {
						this.reply = reply;
					}
					public String getEmail() {
						return email;
					}
					public void setEmail(String email) {
						this.email = email;
					}
					public String getStatus() {
						return status;
					}
					public void setStatus(String status) {
						this.status = status;
					}
					public UserVO getUserVO() {
						return userVO;
					}
					public void setUserVO(UserVO userVO) {
						this.userVO = userVO;
					}
					
}
