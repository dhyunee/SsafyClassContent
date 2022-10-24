package com.ssafy.ws05.step3;

public class BookTest {

	public static void main(String[] args) {
		Bookmanager bookmanager=new Bookmanager();
		System.out.println(bookmanager.getSize());
		
		bookmanager.add(new Book("1111","java","홍길동","홍출판",50000,"java 관련"));
		bookmanager.add(new Book("2222","oop","오길동","오출판",60000,"oop 관련"));
		bookmanager.add(new Book("3333","ssafy","사길동","사출판",70000,"ssafy 관련"));
		bookmanager.add(new Magazine("4444","ssafy 잡지","사길동","팔출판",80000,"ssafy 관련",2022,12));
		
		System.out.println(bookmanager.getSize());
		
		System.out.println("***도서 목록***");
		for(Book book:bookmanager.getList()) {
			System.out.println(book);
		}
		
		System.out.println("***도서 조회***");
		Book b=bookmanager.searchByIsbn("3333");
		System.out.println(b);
	
		System.out.println("***도서 삭제***");
		bookmanager.remove("2222");
		for(Book book:bookmanager.getList()){
			System.out.println(book);
		}
		System.out.println(bookmanager.getSize());
	}
}
