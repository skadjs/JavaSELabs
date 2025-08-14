package workshop.book.entity;

public class Publication {
	
	private String title;
	private String publicationDate;
	private int page;
	private int price;
	
	public Publication() {
		
	}
	
	public Publication(String title, String publicationDate, int page, int price) {
		super();
		this.title = title;
		this.publicationDate = publicationDate;
		this.page = page;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return this.title;
	}
}
