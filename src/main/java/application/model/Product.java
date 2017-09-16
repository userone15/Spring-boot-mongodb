package application.model;

public class Product {

	private String id;
	private String name;
	private String imageUrl;
	private String price;
	
	Product(){
		
	}

	public Product(String id, String name, String imageUrl, String price) {
		this.id = id;
		this.name = name;
		this.imageUrl = imageUrl;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
}
