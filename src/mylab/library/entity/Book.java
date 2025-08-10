package mylab.library.entity;

public class Book {
	private String title;
	private String author;
	private String isbn;
	private int publishYear;
	private boolean isAvailable;
	
	//기본생성자 -> 초기 생성 시 isAvailable = true
	public Book() {
		this.isAvailable = true;
	}
	
	//Constructor Overloading(생성자 중복정의)
	public Book(String title, String author, String isbn, int publishYear) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.publishYear = publishYear;
		this.isAvailable = true;
	}
	
	//title에 대한 getter, setter
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	//author에 대한 getter, setter
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	//isbn에 대한 getter, setter
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	//publishYear에 대한 getter, setter
	public int getPublishYear() {
		return publishYear;
	}
	
	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}
	
	//isAvailabl에 대한 getter, setter
	public boolean isAvailable() {
		return isAvailable;
	}
	
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	//도서 대출
	public boolean checkOut() {
		if(this.isAvailable = true) {
			this.isAvailable = false;
			return true;
		}
		return false;
	}
	
	//도서 반납
	public void returnBook() {
		this.isAvailable = true;
	}
	
	//도서 정보의 문자열을 표현
	public String toString() {
		String message = "책 제목: " + title + "\t저자: " + author + "\tISBN: " + isbn + "\t출판년도: " + publishYear + "\t대출 가능 여부: " + (isAvailable ? "가능" : "대출 중");
		return message;
	}
}
