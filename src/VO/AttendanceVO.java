package VO;

import java.io.Serializable;

public class AttendanceVO implements Serializable {
				
	
				private int att_id;
				private int in_time;
				private int out_time;
				private String date;
				private String details;
				private UserVO userVO;
				public int getAtt_id() {
					return att_id;
				}
				public void setAtt_id(int att_id) {
					this.att_id = att_id;
				}
				public int getIn_time() {
					return in_time;
				}
				public void setIn_time(int in_time) {
					this.in_time = in_time;
				}
				public int getOut_time() {
					return out_time;
				}
				public void setOut_time(int out_time) {
					this.out_time = out_time;
				}
				public String getDate() {
					return date;
				}
				public void setDate(String date) {
					this.date = date;
				}
				public String getDetails() {
					return details;
				}
				public void setDetails(String details) {
					this.details = details;
				}
				public UserVO getUserVO() {
					return userVO;
				}
				public void setUserVO(UserVO userVO) {
					this.userVO = userVO;
				}
			
}
