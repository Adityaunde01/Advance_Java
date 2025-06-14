package onlineshophibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
@NamedQueries({
	@NamedQuery(name = "getByCatId",query = "from Product p where p.cat_id=:catID")
})
public class Product {
	
	@ManyToOne
	@JoinColumn(name = "category_id",insertable=false, updatable=false)
	Category catObj;
	@Id
	@Column(name = "id")
	private Integer pid;
	@Column(name = "category_id")
	private Integer cat_id;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String desc;
	@Column(name = "price")
	private Double price;
	@Column(name = "image_url")
	private String imgUrl;

	
	
	public Product() {
		super();
	}


	public Product(Integer pid, Integer cat_id, String name, String desc, Double price, String imgUrl) {
		super();
		this.pid = pid;
		this.cat_id = cat_id;
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.imgUrl = imgUrl;
	}


	public Integer getCat_id() {
		return cat_id;
	}


	public void setCat_id(Integer cat_id) {
		this.cat_id = cat_id;
	}


	public Integer getPid() {
		return pid;
	}


	public void setPid(Integer pid) {
		this.pid = pid;
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


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public String getImgUrl() {
		return imgUrl;
	}


	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}


	@Override
	public String toString() {
		return "Product [catObj=" + catObj + ", pid=" + pid + ", cat_id=" + cat_id + ", name=" + name + ", desc=" + desc
				+ ", price=" + price + ", imgUrl=" + imgUrl + "]";
	}


	
	
	
}
