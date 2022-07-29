package lolo.nio;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {

	public static void main(String[] args) {
		System.out.println(Charset.defaultCharset());

		// 파일 생성
		{
			Path file = Paths
					.get("C:" + File.separator + "Niotest" + File.separator + "temp" + File.separator + "test.txt");
			try {
				Files.createFile(file);
				System.out.println("파일 생성");
			} catch (FileAlreadyExistsException e) {
				System.out.println("파일이 이미 존재");
			} catch (IOException e) {

				e.printStackTrace();
			}

		}

		// 폴더 생성
		{
			Path folder = Paths.get("C:\\Niotest\\sub");
			try {
				Files.createDirectory(folder);
				System.out.println("폴더 생성");
			} catch (FileAlreadyExistsException e) {
				System.out.println("폴더가 이미 존재");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// 파일 삭제
//		{
//			Path file = Paths.get("C:\\Niotest\\temp\\text.txt");
//			try {
//				Files.delete(file);
//				System.out.println("파일 삭제");
//			} catch (NoSuchFileException e) {
//				System.out.println("파일이 없음");
//			} catch (IOException e) {
//
//				e.printStackTrace();
//			}
//
//		}

		// 폴더삭제
//		{
//			Path folder = Paths.get("C:\\Niotest\\sub");
//			try {
//				Files.delete(folder);
//				System.out.println("폴더 삭제");
//			} catch (NoSuchFileException e) {
//				System.out.println("파일이 없습니다.");
//			} catch (DirectoryNotEmptyException e) {
//				System.out.println("폴더가 비어있지 않습니다");
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}

		// 파일 ,폴더 확인
		{
			Path file = Paths
					.get("C:" + File.separator + "Niotest" + File.separator + "temp" + File.separator + "test.txt");
			Path folder = Paths.get("C:\\Niotest\\sub");
			System.out.println(Files.exists(file));
			System.out.println(Files.exists(folder));

			System.out.println(Files.isDirectory(file));
			System.out.println(Files.isDirectory(folder));

			System.out.println(Files.isReadable(file));
			System.out.println(Files.isReadable(folder));// is 계열 매우 많음

		}

		// 파일 쓰기
		{
			Path file = Paths
					.get("C:" + File.separator + "Niotest" + File.separator + "temp" + File.separator + "test.txt");

			String content = "안녕하세요";
			try {
				Files.write(file, content.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
