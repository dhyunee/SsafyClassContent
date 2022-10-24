package com.ssafy.ws05.step3;

public class Book {
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", price=" + price + ", desc=" + desc + "]";
	}
	public String isbn;
	public String title;
	public String author;
	public String publisher;
	public int price;
	public String desc;
	
	public class book{
		
	}
	protected Book(String isbn, String title, String author, String publisher, int price,String desc) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc=desc;
	}
	
	protected String getIsbn() {
		return isbn;
	}
	protected void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	protected String getTitle() {
		return title;
	}
	protected void setTitle(String title) {
		this.title = title;
	}
	protected String getAuthor() {
		return author;
	}
	protected void setAuthor(String author) {
		this.author = author;
	}
	protected String getPublisher() {
		return publisher;
	}
	protected void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	protected int getPrice() {
		return price;
	}
	protected void setPrice(int price) {
		this.price = price;
	}
	protected String getDesc() {
		return desc;
	}
	protected void setDesc(String desc) {
		this.desc = desc;
	}

}
