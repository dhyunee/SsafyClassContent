package Dto;

public class DongCodeDto {
	private String code,name, cityCode,cityName,gugunCode,gugunName;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSicoCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityname) {
		this.cityName = cityName;
	}

	public String getGuguncode() {
		return gugunCode;
	}

	public void setGuguncode(String gugunCode) {
		this.gugunCode = gugunCode;
	}

	public String getGugunName() {
		return gugunName;
	}

	public void setGugunName(String gugunName) {
		this.gugunName = gugunName;
	}

	@Override
	public String toString() {
		return "DongCodeDto [code=" + code + ", name=" + name + ", cityCode=" + cityCode + ", cityName=" + cityName
				+ ", gugunCode=" + gugunCode + ", gugunName=" + gugunName + "]";
	}
	
}
