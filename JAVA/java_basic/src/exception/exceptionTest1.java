package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class exceptionTest1 {

	public static void main(String[] args) throws IOException {
		// 내가 하려고 하는 말<=hello.txt 파일 읽고 싶음
//		FileInputStream fis=new FileInputStream("hello.txt");//throws FileNotFoundException방안 필요

		// #1 try-catch-(finally)
//		try {
//			FileInputStream fis = new FileInputStream("hello.txt");
//		} catch (FileNotFoundException e) {
//			System.out.println("Exceptioin: " + e.getMessage());
//			e.printStackTrace();// 발생된 예외에 대한 추적
//		}

//		// #2
//		FileInputStream fis =null;
//		try {
//			//Class.forName("java.lang.Object");
//			fis = new FileInputStream("hello.txt");
//			System.out.println("Inside Try Block");// 예외 발생하면 실행X
//			fis.getClass();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//			System.out.println("Inside Catch Block");
//			throw new IOException("AAA");
//			
//			
//			return;// main method 중단 시킴
//		} finally {
//			System.out.println("Always!!");// 항상 실행
//			try {
//				fis.close();
//			}catch(IOException e) {
//				e.printStackTrace();
//			}
//			
//		}
//
//		System.out.println("After try-catch");
////		Class.forName("hello");
////	
//		// 사용하고자 하는 코드에서 throws xxException이 존재하면 , 해당 예외에 대한 책임이 부과되낟.
//		// 1.직접 핸들링한다.
//		// 2.위로 이임한다.
//		// try-catch는? 1번

		// #2 위임

		// FileInputStream fis = new FileInputStream("hello.txt");
		System.out.println("Afger try-catch");

		// #4try-resource

		try (FileInputStream fis = new FileInputStream("hello.txt")) {

			System.out.println("Inside Try Block");// 예외 발생하면 실행X

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Inside Catch Block");
			throw new IOException("AAA");

		}

	}

}
