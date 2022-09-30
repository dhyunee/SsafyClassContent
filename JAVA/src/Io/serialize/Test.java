package Io.serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.WriteAbortedException;

public class Test {

	public static void main(String[] args) {
		//write
		Myclass mc=new Myclass();
		mc.n=10;
		mc.str="Hello";
		
		write(mc);

		//read
		Myclass mc2=read();
		System.out.println(mc2.n);
		System.out.println(mc2.str);
	}

	
	//객체 직렬화
	static void write(Myclass mc) {
		//ObjectOutputStream,ObjectInputStream
		try(
				ObjectOutputStream oos=new ObjectOutputStream(
						new FileOutputStream("Myclass.dot"));
			){
			oos.writeObject(mc);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	static Myclass read() {
		Myclass mc=null;
		try(
				ObjectInputStream ois=new ObjectInputStream(
						new FileInputStream("Myclass.dot"));
				){
			mc=(Myclass)ois.readObject();
		}catch(IOException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return mc;
	}
}
