	package VO;
	import java.io.Serializable;

	public class VehicleallocationmpgVO implements Serializable{
		

					
					private int vmpg_id;
					private String assign_time;
					private String retrieve_time;
					private String assign_status;
					private String return_status;
					private String gasoline;
					private String kilometer;
					private VehicleVO vehicleVO;
					private UserVO userVO;
					public int getVmpg_id() {
						return vmpg_id;
					}
					public void setVmpg_id(int vmpg_id) {
						this.vmpg_id = vmpg_id;
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
					public String getGasoline() {
						return gasoline;
					}
					public void setGasoline(String gasoline) {
						this.gasoline = gasoline;
					}
					public String getKilometer() {
						return kilometer;
					}
					public void setKilometer(String kilometer) {
						this.kilometer = kilometer;
					}
					public VehicleVO getVehicleVO() {
						return vehicleVO;
					}
					public void setVehicleVO(VehicleVO vehicleVO) {
						this.vehicleVO = vehicleVO;
					}
					public UserVO getUserVO() {
						return userVO;
					}
					public void setUserVO(UserVO userVO) {
						this.userVO = userVO;
					}
					

}
