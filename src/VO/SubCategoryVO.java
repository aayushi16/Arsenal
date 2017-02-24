package VO;

import java.io.Serializable;

public class SubCategoryVO implements Serializable {

		
		private int subcat_id;
		private String subcat_name;
		private String subcat_description;
		
		private CategoryVO categoryVO;
		
		public int getSubcat_id() {
			return subcat_id;
		}
		public CategoryVO getCategoryVO() {
			return categoryVO;
		}
		public void setCategoryVO(CategoryVO categoryVO) {
			this.categoryVO = categoryVO;
		}
		public void setSubcat_id(int subcat_id) {
			this.subcat_id = subcat_id;
		}
		public String getSubcat_name() {
			return subcat_name;
		}
		public void setSubcat_name(String subcat_name) {
			this.subcat_name = subcat_name;
		}
		public String getSubcat_description() {
			return subcat_description;
		}
		public void setSubcat_description(String subcat_description) {
			this.subcat_description = subcat_description;
		}
	
		

}
