	package VO;
	import java.io.Serializable;

	public class VehicleallocationVO {
		

					
					private int stock2_id;
					private UserVO to;
					private String quantity;
					private String assign_time;
					private String retrieve_time;
					private String assign_status;
					private String return_status;
					private String gasoline;
					private String kilometer;
					private VehicleVO vehicleVO;
					private UserVO userVO;
					public int getStock2_id() {
						return stock2_id;
					}
					public void setStock2_id(int stock2_id) {
						this.stock2_id = stock2_id;
					}
					public UserVO getTo() {
						return to;
					}
					public void setTo(UserVO to) {
						this.to = to;
					}
					public String getQuantity() {
						return quantity;
					}
					public void setQuantity(String quantity) {
						this.quantity = quantity;
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
