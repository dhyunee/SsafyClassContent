package Io.xml;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXParseException;


import jdk.internal.org.xml.sax.Attributes;
import jdk.internal.org.xml.sax.SAXException;
import jdk.internal.org.xml.sax.helpers.DefaultHandler;

public class EmplistSaxHandler extends DefaultHandler {
	
	List<emp>emplist=new ArrayList<>();
	private emp ep;
	private String data;

	
	
	@Override
	public void startElement(String uri, String localName, String qName,Attributes attributes)
			throws SAXException {
		if(qName.equals("ep")) {
			ep=new emp();
		}
	}

	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch(qName) {
		case "emp-id":ep.setEmpId(data); break;
		case "emp-nm":ep.setEmpNm(data); break;
		case "salary":ep.setSalary(Integer.parseInt(data)); break;
		case "emp-dt":ep.setEnterDt(LocalDate.parse(data)); break;
		case "emp":emplist.add(ep);break;
		}
	}
	
	@Override
	public void characters(char []ch, int start, int length) throws SAXException {
		this.data=new String(ch,start,length);
	}
	public List<emp> getEmpList(){
		return this.emplist;
	}
}
