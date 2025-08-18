package mylab.book.entity;

public class ReferenceBook extends Publication {
    private String field; // 전문 분야

    public ReferenceBook() {
        super();
    }

    public ReferenceBook(String title, String publishDate, int page, int price, String field) {
        super(title, publishDate, page, price); // 부모 생성자 호출
        this.field = field;
    }

    // Getter 및 Setter
    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return super.toString() + " [참고서] 분야:" + field + ", " + getPage() + "쪽, " + getPrice() + "원, 출판일:" + getPublishDate();
    }
}
