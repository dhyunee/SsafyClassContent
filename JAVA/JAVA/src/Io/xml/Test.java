package Io.xml;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Test {

	public static void main(String[] args) throws Exception{
		File file =new File("./src/Io/xml/emp-list.xml");
		EmplistSaxHandler handler=new EmplistSaxHandler();
		//SAXParser는 xml 파일과 그 파일을 처리할 수 있는 handler 입력받아서 처리
		SAXParserFactory saxparserfactory=SAXParserFactory.newInstance();
		SAXParser saxparser=saxparserfactory.newSAXParser();
		saxparser.parse(file, handler);//xml 문서를 시작 태그, 종료 태그, 텍스트 노드를 만나면 전달된 handler 해당 메소드 호출
		
		
		List<emp>emplist=handler.getEmpList();
		
		for(emp ep:emplist) {
			System.out.println(ep);
		}
	}

}
