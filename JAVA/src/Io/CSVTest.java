package Io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class CSVTest {

	public static void main(String[] args) {
		List<Emp> empList=new ArrayList<>();
		empList.add(new Emp("111","홍길동",40000));
		empList.add(new Emp("222","이길동",30000));
		empList.add(new Emp("333","김길동",15000));
		empList.add(new Emp("444","박길동",10000));
		empList.add(new Emp("555","여길동",20000));
		
		
		//csv 파일 생성
		String filePath="c:"+File.separator+"SSAFY";
		String fileName="empList.csf";
		
		//폴더 없으면 생성해라
		File file=new File(filePath);//경로, 폴더
		if(!(file.exists())) {
			file.mkdir();
		}
		
		//Autoclosable interface inplements함  ->()안에 객체 생성 try-resource block 사용
		//encoding:MS949로 변경-->엑셀에서 한글이 안꺠진다.
		try (
				BufferedWriter br=new BufferedWriter(
						new OutputStreamWriter(
								new FileOutputStream(filePath+File.separator+fileName),"MS949"));
			){
		
			
			for(Emp emp:empList) {
				br.write(emp.getEmpId()+"^"+emp.getEmpNm()+"^"+emp.getSalary());
				br.newLine();
			}
			br.flush();
			System.out.println("파일이 생성되었습니다.");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}	
	

}
class Emp{
	private String empId;
	private String empNm;
	private int salary;
	public Emp() {}

	public Emp(String empId,String empNm,int salary) {
		super();
		this.empId=empId;
		this.empNm=empNm;
		this.salary=salary;
	}
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
	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", empNm=" + empNm + ", salary=" + salary + "]";
	}
	
}