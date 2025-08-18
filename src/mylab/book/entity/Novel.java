package mylab.book.entity;

public class Novel extends Publication {
    private String author; // 저자명
    private String genre;  // 장르

    public Novel() {
        super();
    }

    public Novel(String title, String publishDate, int page, int price, String author, String genre) {
        super(title, publishDate, page, price); // 부모 생성자 호출
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return super.toString() + " [소설] 저자:" + author + ", 장르:" + genre + ", " + getPage() + "쪽, " + getPrice() + "원, 출판일:" + getPublishDate();
    }
}
