package backend2023.Bookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// categoryid and name

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long categoryid;
	private String name;
	
	
	public Category(String name) {
		super();
		this.name = name;
	}

	public Category(Long categoryid, String name) {
		super();
		this.categoryid = categoryid;
		this.name = name;
	}

	public Category() {
		super();
	}

	public Long getCategoryid() {
		return categoryid;
	}

	public String getName() {
		return name;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category [categoryid=" + categoryid + ", name=" + name + "]";
	}
	
	
	
	

}
