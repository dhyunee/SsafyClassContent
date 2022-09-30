package com.ssafy.ws05.step3;

import java.util.Arrays;

//Book ->instanceof Book:true
//Magazine ->instanceof Book:ture

//Magazine->instanceof Magazine: true
//Book->instanceof Magazine: false
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
	public Book[] searchByTitle(String title) {
		//몇 개인지 알아야 배열 생성->2번 작업
		//#1 순회하면서 몇개인지 확인 결과 count 변수에 담는다 ->count 만큼 배열 생성
		//#2 순회하면서 배열에 담는다.
		//문자열 부분일치???어떻게 처리할지
		int cnt=0;
		for(int i=0;i<size;i++) {
			if(books[i].getTitle().contains(title)) {
				cnt++;
			}
		}
		Book[]result=new Book[cnt];
		int idx=0;
		for(int i=0;i<size;i++) {
			if(books[i].getTitle().contains(title))result[idx++]=books[i];
		}
		return result;
	}
	
	public Magazine[] getMagazines() {
		int cnt=0;
		for(int i=0;i<size;i++) {
			if(books[i] instanceof Magazine) {
				cnt++;
			}
		}
		Magazine[]result=new Magazine[cnt];
		int idx=0;
		for(int i=0;i<size;i++) {
			if(books[i] instanceof Magazine)result[idx++]=(Magazine)books[i];
		}
		return result;
	}
	
	public Book[] getBooks() {
		int cnt=0;
		for(int i=0;i<size;i++) {
			if(!(books[i] instanceof Magazine)) {
				cnt++;
			}
		}
		Book[]result=new Book[cnt];
		int idx=0;
		for(int i=0;i<size;i++) {
			if(!(books[i] instanceof Magazine))result[idx++]=books[i];
		}
		return result;
	}
	public int getTotalPrice() {
		int total=0;
		for(int i=0;i<size;i++) {
			total+=books[i].getPrice();
			
		}
		return total;
	}
	public double getPriceAvg() {
		
		return getTotalPrice()/size;
	}
}