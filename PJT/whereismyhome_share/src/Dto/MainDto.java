package Dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


public class MainDto {

	//house deal
	private String dong,aptname,code,dealamount,buildyear,lat,lng,img;
	public String getdealAmount() {
		return dealamount;
	}
	public void setdealAmount(String dealamount) {
		this.dealamount = dealamount;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getAptname() {
		return aptname;
	}
	public void setAptname(String aptname) {
		this.aptname = aptname;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getBuildyear() {
		return buildyear;
	}
	public void setBuildyear(String buildyear) {
		this.buildyear = buildyear;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	
	
}