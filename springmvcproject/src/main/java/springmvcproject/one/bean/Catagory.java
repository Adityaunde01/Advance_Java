package springmvcproject.one.bean;

public class Catagory {
	Integer id;
	String name;
	String desc;
	String imageUrl;
	
	public Catagory() {
		// TODO Auto-generated constructor stub
	}

	public Catagory(Integer id, String name, String desc, String imageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.imageUrl = imageUrl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "Catagory [id=" + id + ", name=" + name + ", desc=" + desc + ", imageUrl=" + imageUrl + "]";
	}
	
	
	
	
}
