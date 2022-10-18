import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectionTest {

	public static void main(String[] args)throws Exception {
		//���� ���� MyReflection Ŭ������ ����� ���
//		MyReflection mr=new MyReflection();
//		mr.aboutMe();
		
		//Spring �� MyReflectionŬ������ ����� ��� by Spring
//		String className="MyReflection";
//		Class<?>myClass=Class.forName(className);
//		
//		//Reflectioin API
//		MyReflection mf=(MyReflection)myClass.getDeclaredConstructor().newInstance();
//		mf.aboutMe();
		
		//Spring �� MyReflectionŬ������ ����� ��� by �ܺ� ���� ����
		InputStream is=new FileInputStream("MyConfig.properties");
		Properties prop=new Properties();
		prop.load(is);
		
		String className=prop.getProperty("class.name");
		Class<?>myClass=Class.forName(className);
		
		//Reflectioin API
		MyReflection mf=(MyReflection)myClass.getDeclaredConstructor().newInstance();
		mf.aboutMe();
		
		//parameter & return
		Method m=myClass.getMethod("robot", int.class);
		String str=(String)m.invoke(mf, 80);
		System.out.println(str);
	}

}
