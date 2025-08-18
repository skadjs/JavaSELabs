package mylab.book.entity;

public class Magazine extends Publication {
    private String publishPeriod; // 발행주기 (예: "월간", "주간")

    public Magazine() {
        super();
    }

    public Magazine(String title, String publishDate, int page, int price, String publishPeriod) {
        super(title, publishDate, page, price); // 부모 생성자 호출
        this.publishPeriod = publishPeriod; // 자신만의 속성 초기화
    }

    public String getPublishPeriod() {
        return publishPeriod;
    }

    public void setPublishPeriod(String publishPeriod) {
        this.publishPeriod = publishPeriod;
    }

    @Override
    public String toString() {
        return super.toString() + " [잡지] 발행주기:" + publishPeriod + ", " + getPage() + "쪽, " + getPrice() + "원, 출판일:" + getPublishDate();
    }
}
