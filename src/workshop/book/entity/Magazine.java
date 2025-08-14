package workshop.book.entity;

public class Magazine extends Publication {
	
	private String publishingPeriod;

	public Magazine() {
		
	}

	public Magazine(String title, String publicationDate, int page, int price, String publishingPeriod) {
		super(title, publicationDate, page, price);
		this.publishingPeriod = publishingPeriod;
	}

	public String getPublishingPeriod() {
		return publishingPeriod;
	}

	public void setPublishingPeriod(String publishingPeriod) {
		this.publishingPeriod = publishingPeriod;
	}
}
