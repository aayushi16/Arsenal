package VO;

import java.io.Serializable;

public class UserVO implements Serializable {
		
		private int user_id;
		private String user_name;
		private String password;
		private String email;
		private String status;
		private String user_post;
		
		public int getUser_id() {
			return user_id;
		}
		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}
		public String getUser_name() {
			return user_name;
		}
		public void setUser_name(String user_name) {
			this.user_name = user_name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
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
		public String getUser_post() {
			return user_post;
		}
		public void setUser_post(String user_post) {
			this.user_post = user_post;
		}
		
		
}
