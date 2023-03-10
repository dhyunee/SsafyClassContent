package sevlet.datagokr;

public class HouseDeal {
	//xml item 한 개가 거레 한개에 해당
	//item 항목 전체 중에 필요한 항목만 sax를 이용해 걸러냄
	//법정동읍면동코드
	private int code;
	//법저동
	private String dong;
	//아파트 이름
	private String aptName;
	//거래 금액
	private String dealAmount;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getAptName() {
		return aptName;
	}
	public void setAptName(String aptName) {
		this.aptName = aptName;
	}
	public String getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}
	@Override
	public String toString() {
		return "HouserDeal [code=" + code + ", dong=" + dong + ", aptName=" + aptName + ", dealAmount=" + dealAmount
				+ "]";
	}

}
