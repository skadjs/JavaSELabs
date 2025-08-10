package mylab.library.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
	private String name;
	private List<Book> books;
	
	//생성자(도서관 이름 초기화, 빈 도서 목록 생성)
	public Library(String name) {
		this.name = name;
		this.books = new ArrayList<Book>();
	}
	
	//도서 추가
	public void addBook(Book book) {
		this.books.add(book);
		System.out.println("도서가 추가되었습니다: " + book.getTitle());
	}
	
	//제목으로 도서 검색
	public Book findBookByTitle(String title) {
		for (Book book : books) {
			if (book.getTitle().contentEquals(title)) {
				return book;
			}
		}
		return null;
	}
	
	//저자로 도서 검색
	public List<Book> findBooksByAuthor(String author) {
		List<Book> result = new ArrayList<>(); // 결과를 담을 새 리스트 생성
        for (Book book : this.books) {
            if (book.getAuthor().equals(author)) {
                result.add(book); // 저자명이 일치하면 리스트에 추가
            }
        }
        return result;
	}
	
	//ISBN으로 도서 검색
	public Book findBookByISBN(String isbn) {
		for (Book book : books) {
			if (book.getIsbn().equals(isbn)) {
				return book;
			}
		}
		return null;
	}
	
	//ISBN으로 도서 대출
	public boolean checkOutBook(String isbn) {
		Book book = findBookByISBN(isbn);
		if (book != null) {
			return book.checkOut();
		}
		return false;
	}
	
	//ISBN으로 도서 반납
	public boolean returnBook(String isbn) {
		Book book = findBookByISBN(isbn);
        if (book != null && !book.isAvailable()) {
            book.returnBook();
            return true;
        }
        return false;
	}
	
	//대출 가능 도서 목록 반환
	public List<Book> getAvailableBooks() {
		List<Book> availableBooks = new ArrayList<>();
        for (Book book : this.books) {
            if (book.isAvailable()) { // 대출 가능한 책인지 확인
                availableBooks.add(book);
            }
        }
        return availableBooks;
	}
	
	//전체 도서 목록 반환
	public List<Book> getAllBooks() {
		return new ArrayList<>(books);
	}
	
	//전체 도서 수량 반환
	public int getTotalBooks() {
		return books.size();
	}
	
	//대출 가능 도서 수량 반환
	public int getAvailableBooksCount() {
		int count = 0;
        for (Book book : this.books) {
            if (book.isAvailable()) {
                count++;
            }
        }
        return count;
	}
	
	//대출 중 도서 수량 반환
	public int getBorrowedBooksCount() {
		return getTotalBooks() - getAvailableBooksCount();
	}
	
	public String getName() {
        return name;
    }
}
