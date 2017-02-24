	package VO;

	import java.io.Serializable;

	public class MaintenanceVO implements Serializable {
					
		
					private int m_id;
					private UserVO to;
					private String description;
					private String created_date;
					private String modified_date;
					private String status;
					private UserVO userVO;
					public int getM_id() {
						return m_id;
					}
					public void setM_id(int m_id) {
						this.m_id = m_id;
					}
					public UserVO getTo() {
						return to;
					}
					public void setTo(UserVO to) {
						this.to = to;
					}
					public String getDescription() {
						return description;
					}
					public void setDescription(String description) {
						this.description = description;
					}
					public String getCreated_date() {
						return created_date;
					}
					public void setCreated_date(String created_date) {
						this.created_date = created_date;
					}
					public String getModified_date() {
						return modified_date;
					}
					public void setModified_date(String modified_date) {
						this.modified_date = modified_date;
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