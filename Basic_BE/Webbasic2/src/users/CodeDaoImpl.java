package users;

import java.util.ArrayList;
import java.util.List;

public class CodeDaoImpl {
	List<CodeDto>getCodefList(String code){
		List<CodeDto>list=new ArrayList<CodeDto>();
		
		//connetion->preparedstatement->resultset
		//select code, code_name from code where group_code=?
		//return 되는 code, code_name=>codeDto여러 개를 list 담아서 return
		return list;
	}
	
}
