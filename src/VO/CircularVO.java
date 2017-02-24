package VO;

import java.io.Serializable;

public class CircularVO implements Serializable{

	private int circular_id;
	private String circular_title;
	private String circular_description;
	private String path;
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getCircular_id() {
		return circular_id;
	}
	public void setCircular_id(int circular_id) {
		this.circular_id = circular_id;
	}
	public String getCircular_title() {
		return circular_title;
	}
	public void setCircular_title(String circular_title) {
		this.circular_title = circular_title;
	}
	public String getCircular_description() {
		return circular_description;
	}
	public void setCircular_description(String circular_description) {
		this.circular_description = circular_description;
	}
	
	
}
