package Io.xml;

import java.time.LocalDate;//java8<=java.utill.Date=>Calendar+SimpleDateFormat...

/**
 * @author admin
 *
 */
public class emp {
	private String empId;
	private String empNm;
	private int salary;
	private LocalDate enterDt;
	
	

	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpNm() {
		return empNm;
	}
	public void setEmpNm(String empNm) {
		this.empNm = empNm;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public LocalDate getEnterDt() {
		return enterDt;
	}
	public void setEnterDt(LocalDate enterDt) {
		this.enterDt = enterDt;
	}
	@Override
	public String toString() {
		return "emp [empId=" + empId + ", empNm=" + empNm + ", salary=" + salary + ", enterDt=" + enterDt + "]";
	}
	
	
}
