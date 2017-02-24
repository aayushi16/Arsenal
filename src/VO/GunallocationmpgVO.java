
	package VO;
	import java.io.Serializable;

	public class GunallocationmpgVO implements Serializable{
		

					
					private int gmpg_id;
					private String assign_time;
					private String retrieve_time;
					private String assign_status;
					private String return_status;
					private String no_bullets;
					private String return_bullets;
					private GunVO gunVO;
					private UserVO userVO;
					public int getGmpg_id() {
						return gmpg_id;
					}
					public void setGmpg_id(int gmpg_id) {
						this.gmpg_id = gmpg_id;
					}
					public String getAssign_time() {
						return assign_time;
					}
					public void setAssign_time(String assign_time) {
						this.assign_time = assign_time;
					}
					public String getRetrieve_time() {
						return retrieve_time;
					}
					public void setRetrieve_time(String retrieve_time) {
						this.retrieve_time = retrieve_time;
					}
					public String getAssign_status() {
						return assign_status;
					}
					public void setAssign_status(String assign_status) {
						this.assign_status = assign_status;
					}
					public String getReturn_status() {
						return return_status;
					}
					public void setReturn_status(String return_status) {
						this.return_status = return_status;
					}
					public String getNo_bullets() {
						return no_bullets;
					}
					public void setNo_bullets(String no_bullets) {
						this.no_bullets = no_bullets;
					}
					public String getReturn_bullets() {
						return return_bullets;
					}
					public void setReturn_bullets(String return_bullets) {
						this.return_bullets = return_bullets;
					}
					public GunVO getGunVO() {
						return gunVO;
					}
					public void setGunVO(GunVO gunVO) {
						this.gunVO = gunVO;
					}
					public UserVO getUserVO() {
						return userVO;
					}
					public void setUserVO(UserVO userVO) {
						this.userVO = userVO;
					}
					
					
		}