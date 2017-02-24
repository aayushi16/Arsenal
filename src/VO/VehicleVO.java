package VO;

import java.io.Serializable;

public class VehicleVO implements Serializable {

	private int vehicle_id;
	private int vehicle_no;
	private String vehicle_name;
	private String vehicle_description;
	
	private CategoryVO categoryVO;
	private UserVO userVO;
	public int getVehicle_id() {
		return vehicle_id;
	}
	public void setVehicle_id(int vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	public int getVehicle_no() {
		return vehicle_no;
	}
	public void setVehicle_no(int vehicle_no) {
		this.vehicle_no = vehicle_no;
	}
	public String getVehicle_name() {
		return vehicle_name;
	}
	public void setVehicle_name(String vehicle_name) {
		this.vehicle_name = vehicle_name;
	}
	public String getVehicle_description() {
		return vehicle_description;
	}
	public void setVehicle_description(String vehicle_description) {
		this.vehicle_description = vehicle_description;
	}
	public CategoryVO getCategoryVO() {
		return categoryVO;
	}
	public void setCategoryVO(CategoryVO categoryVO) {
		this.categoryVO = categoryVO;
	}
	public UserVO getUserVO() {
		return userVO;
	}
	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
	
	
}
