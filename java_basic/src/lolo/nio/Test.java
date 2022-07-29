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

		// ���� ����
		{
			Path file = Paths
					.get("C:" + File.separator + "Niotest" + File.separator + "temp" + File.separator + "test.txt");
			try {
				Files.createFile(file);
				System.out.println("���� ����");
			} catch (FileAlreadyExistsException e) {
				System.out.println("������ �̹� ����");
			} catch (IOException e) {

				e.printStackTrace();
			}

		}

		// ���� ����
		{
			Path folder = Paths.get("C:\\Niotest\\sub");
			try {
				Files.createDirectory(folder);
				System.out.println("���� ����");
			} catch (FileAlreadyExistsException e) {
				System.out.println("������ �̹� ����");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// ���� ����
//		{
//			Path file = Paths.get("C:\\Niotest\\temp\\text.txt");
//			try {
//				Files.delete(file);
//				System.out.println("���� ����");
//			} catch (NoSuchFileException e) {
//				System.out.println("������ ����");
//			} catch (IOException e) {
//
//				e.printStackTrace();
//			}
//
//		}

		// ��������
//		{
//			Path folder = Paths.get("C:\\Niotest\\sub");
//			try {
//				Files.delete(folder);
//				System.out.println("���� ����");
//			} catch (NoSuchFileException e) {
//				System.out.println("������ �����ϴ�.");
//			} catch (DirectoryNotEmptyException e) {
//				System.out.println("������ ������� �ʽ��ϴ�");
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}

		// ���� ,���� Ȯ��
		{
			Path file = Paths
					.get("C:" + File.separator + "Niotest" + File.separator + "temp" + File.separator + "test.txt");
			Path folder = Paths.get("C:\\Niotest\\sub");
			System.out.println(Files.exists(file));
			System.out.println(Files.exists(folder));

			System.out.println(Files.isDirectory(file));
			System.out.println(Files.isDirectory(folder));

			System.out.println(Files.isReadable(file));
			System.out.println(Files.isReadable(folder));// is �迭 �ſ� ����

		}

		// ���� ����
		{
			Path file = Paths
					.get("C:" + File.separator + "Niotest" + File.separator + "temp" + File.separator + "test.txt");

			String content = "�ȳ��ϼ���";
			try {
				Files.write(file, content.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
