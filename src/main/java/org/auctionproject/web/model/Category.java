package org.auctionproject.web.model;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String description;

	@ManyToOne
    @JoinColumn(name="parent_id")
    private Category parentCategory;

	public Category getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

	public long getCategoryId() {
		return id;
	}

	public void setCategoryId(long categoryId) {
		this.id = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
