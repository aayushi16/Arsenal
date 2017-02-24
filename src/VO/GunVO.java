package VO;

import java.io.Serializable;

public class GunVO implements Serializable {

			
			private int gun_id;
			private int gun_no;
			private String gun_name;
			private String gun_description;
			private String latitude;
			private String longitude;
			
			private CategoryVO categoryVO;
			private UserVO userVO;
			public int getGun_id() {
				return gun_id;
			}
			public void setGun_id(int gun_id) {
				this.gun_id = gun_id;
			}
			public int getGun_no() {
				return gun_no;
			}
			public void setGun_no(int gun_no) {
				this.gun_no = gun_no;
			}
			public String getGun_name() {
				return gun_name;
			}
			public void setGun_name(String gun_name) {
				this.gun_name = gun_name;
			}
			public String getGun_description() {
				return gun_description;
			}
			public void setGun_description(String gun_description) {
				this.gun_description = gun_description;
			}
			public String getLatitude() {
				return latitude;
			}
			public void setLatitude(String latitude) {
				this.latitude = latitude;
			}
			public String getLongitude() {
				return longitude;
			}
			public void setLongitude(String longitude) {
				this.longitude = longitude;
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
