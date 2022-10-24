package com.ssafy.ws04.step03;

import java.util.Arrays;


public class Bookmanager {
	private static int Max_size=100;
	Book[]books =new Book[Max_size];
	///1~100: 현재 null
	private int size=0;
	private boolean find;
	
	public int getSize() {
		return this.size;
	}
	
	public void add(Book book) {
		if(size<Max_size)books[size++]=book;
	}
	int order;
	//isbn은 자료구조에서 유일하다.
	public void remove(String isbn) {
		//배열을 순회하며 isbn이 같은 book 객체 제거
		for(int i=0;i<size;i++) {
			if(books[i].getIsbn().equals(isbn)) {
//				//만약에 책 등록한 순서가 유지
//				find=true;
//				order=i;
//				break;
				//아니면 그냥 맨 마지막 거 거기에 넣어버림
				books[i]=books[size-1];
				books[size-1]=null;
				size--;
				break;
			}
		}
//		for(int i=order;i<size-1;i++) {
//			books[i]=books[i+1];
//		}
	}
	public Book[] getList(){
		return Arrays.copyOfRange(books, 0,size);
		
	}
	
	public Book searchByIsbn(String isbn) {
		for(int i=0;i<size;i++) {
			if(books[i].getIsbn().equals(isbn)) {
				return books[i];
			}
		}
		return null;
	}
}
