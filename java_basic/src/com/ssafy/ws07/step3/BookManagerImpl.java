package com.ssafy.ws07.step3;

import java.util.ArrayList;
import java.util.List;

/**
 * 도서리스트를 배열로 유지하며 관리하는 클래스
 */
public class BookManagerImpl implements IBookManager {
	/**
	 * 관리할 최대 도서 수
	 */
	private static int MAX_SIZE = 100;
	/**
	 * 관리할 도서 리스트
	 */
	// private Book[] books = new Book[MAX_SIZE];
	/**
	 * 현재 등록된 도서 수
	 */

	private List<Book> books = new ArrayList<>();
	// private int size;

	public int getSize() {
		// return this.size;
		return this.books.size();
	}

	// singleton 패턴으로 return 해주는 객체의 type은 BookManagerImpl임
	// 현 시점(nterface 적용한)멤버변수나 메소드가 내부용도, 외부용도 구별 가능
	// BookManagerImpl입장: 굳이 전체를 넘길 필요가 있나?
	// BookTest입장: BookManagerImple의 구현한 기능만 관심있음
//	private static BookManagerImpl instance = new BookManagerImpl();
//	private BookManagerImpl(){}
//	public static BookManagerImpl getInstance() {
//		return instance;
//	}

	private static IBookManager instance = new BookManagerImpl();

	private BookManagerImpl() {
	}

	public static IBookManager getInstance() {
		return instance;
	}

	/**
	 * 도서를 도서리스트에 추가한다.
	 * 
	 * @param book : 추가할 도서
	 */
	public void add(Book book) {
		// if (size < MAX_SIZE)
		// books[size++] = book;
		books.add(book);
	}

	/**
	 * 고유번호로 해당 도서를 도서리스트에서 삭제한다.
	 * 
	 * @param isbn : 삭제할 도서의 고유번호
	 */
	public void remove(String isbn) {
//		for (int i = 0; i < size; ++i) {
//			// 삭제할 도서를 찾았다면 해당 도서 위치에 배열의 제일 마지막 도서를 복사
//			if (books[i].getIsbn().equals(isbn)) {
//				books[i] = books[size - 1];
//				books[size - 1] = null; // 삭제된 도서 위치 null 처리
//				--size; // 등록된 도서 수 감소
//				break;
//			}
//		}
		int size = books.size();
		for (int i = 0; i < size; i++) {
			if (books.get(i).getIsbn().equals(isbn)) {
				books.remove(i);
				break;
			}
		}
	}

	/**
	 * 등록된 도서리스트를 반환한다.
	 * 
	 * @return 등록된 전체 도서리스트
	 */
	public Book[] getList() {
		// return Arrays.copyOfRange(books, 0, size);
		Book[] result = new Book[books.size()];
		return books.toArray(result);// result 배열에 복사 후 return

	}

	/**
	 * 고유번호로 해당 도서를 조회한다.
	 * 
	 * @param isbn : 조회할 도서의 고유번호
	 * @return 고유번호에 해당하는 도서
	 */
	public Book searchByIsbn(String isbn) {
//		for (int i = 0; i <size; ++i) {
//			if (books[i].getIsbn().equals(isbn))
//				return books[i];
//		}
		// return null;
		for (Book book : books) {
			if (book.getIsbn().equals(isbn))
				return book;
		}
		return null;
	}

	/**
	 * 도서 제목을 포함하고 있는 도서리스트를 반환한다.
	 * 
	 * @param title : 조회할 도서의 제목
	 * @return
	 */
	public Book[] searchByTitle(String title) {
//		int count = 0;
//		for (int i = 0; i < size; ++i) { // 도서 제목을 포함하는 도서의 개수 카운트
//			if (books[i].getTitle().contains(title))
//				++count;
//		}
//		Book[] result = new Book[count]; // 결과 카운트만큼 배열 생성
//		int idx = 0;
//		for (int i = 0; i < size; ++i) {
//			if (books[i].getTitle().contains(title)) { // 도서 제목을 포함하는 도서만 배열에 담기
//				result[idx++] = books[i];
//			}
//		}
//		return result;

		ArrayList<Book> tmp = new ArrayList<>();
		for (Book book : books) {
			if (book.getTitle().contains(title))
				tmp.add(book);
		}
		Book[] result = new Book[tmp.size()];
		return tmp.toArray(result);
	}

	/**
	 * 잡지리스트를 반환한다.
	 * 
	 * @return 잡지리스트
	 */
	public Magazine[] getMagazines() {
//		int count = 0;
//		for (int i = 0; i < size; ++i) { // 잡지 개수 카운트
//			if (books[i] instanceof Magazine)
//				++count;
//		}
//		Magazine[] result = new Magazine[count]; // 결과 카운트만큼 배열 생성
//		int idx = 0;
//		for (int i = 0; i < size; ++i) {
//			if (books[i] instanceof Magazine) { // 잡지만 배열에 담기
//				result[idx++] = (Magazine) books[i];
//			}
//		}
//		return result;

		ArrayList<Magazine> tmp = new ArrayList<>();
		for (Book book : books) {
			if (book instanceof Magazine)
				tmp.add((Magazine) book);
		}
		Magazine[] result = new Magazine[tmp.size()];
		return tmp.toArray(result);
	}

	/**
	 * 잡지가 아닌 도서리스트를 반환한다.
	 * 
	 * @return 잡지가 아닌 도서리스트
	 */
	public Book[] getBooks() {
//		int count = 0;
//		for (int i = 0; i < size; ++i) {
//			if (!(books[i] instanceof Magazine))
//				++count;
//		}
//
//		Book[] result = new Book[count];
//		int idx = 0;
//		for (int i = 0; i < size; ++i) {
//			if (!(books[i] instanceof Magazine)) {
//				result[idx++] = books[i];
//			}
//		}
//		return result;
		ArrayList<Book> tmp = new ArrayList<>();
		for (Book book : books) {
			if (!(book instanceof Magazine))
				tmp.add(book);
		}
		Book[] result = new Book[tmp.size()];
		return tmp.toArray(result);
	}

	/**
	 * 도서리스트의 가격의 총합을 반환한다.
	 * 
	 * @return 모든 도서 가격의 총합
	 */
	public int getTotalPrice() {
//		int total = 0;
//		for (int i = 0; i < size; ++i) {
//			total += books[i].getPrice();
//		}
//		return total;

		int total = 0;
		for (Book book : books) {
			total += book.getPrice();
		}
		return total;
	}

	/**
	 * 도서가격의 평균을 반환한다.
	 * 
	 * @return 모든 도서 가격의 평균
	 */
	public double getPriceAvg() {
		// return (double) getTotalPrice() / size;

		return (double) getTotalPrice() / books.size();
	}

	@Override
	public void sell(String isbn, int quantity) throws ISBNNotFoundException, QuantityException {
		// TODO Auto-generated method stub
		Book book = searchByIsbn(isbn);
		if (book == null)
			throw new ISBNNotFoundException(isbn);
		int res = book.getQuantity() - quantity;
		if (res < 0)
			throw new QuantityException();
		book.setQuantity(res);
	}

	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		// TODO Auto-generated method stub
		Book book = searchByIsbn(isbn);
		if (book == null)
			throw new ISBNNotFoundException(isbn);
		book.setQuantity(book.getQuantity() + quantity);

	}
}
