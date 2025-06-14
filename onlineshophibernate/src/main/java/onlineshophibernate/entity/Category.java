package onlineshophibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {
	@Id
	@Column(name = "id")
	int categoryId;
	@Column(name = "name")
	String catagoryName;
	@Column(name = "description")
	String categoryDesc;
	@Column(name = "image_url")
	String categoryImage;
	
	
	
	public Category() {
		super();
	}



	public Category(int categoryId, String catagoryName, String categoryDesc, String categoryImage) {
		super();
		this.categoryId = categoryId;
		this.catagoryName = catagoryName;
		this.categoryDesc = categoryDesc;
		this.categoryImage = categoryImage;
	}



	public int getCategoryId() {
		return categoryId;
	}



	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}



	public String getCatagoryName() {
		return catagoryName;
	}



	public void setCatagoryName(String catagoryName) {
		this.catagoryName = catagoryName;
	}



	public String getCategoryDesc() {
		return categoryDesc;
	}



	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}



	public String getCategoryImage() {
		return categoryImage;
	}



	public void setCategoryImage(String categoryImage) {
		this.categoryImage = categoryImage;
	}



	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", catagoryName=" + catagoryName + ", categoryDesc="
				+ categoryDesc + ", categoryImage=" + categoryImage + "]";
	}
	
	
	
}
