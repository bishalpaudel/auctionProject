package org.auctionproject.web.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.auctionproject.web.enums.Status;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Asset {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long assetId;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.MERGE)
	@JoinColumn(name="category_id")
	private Category category;
	
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="user_id")
	private User user;
	@Column(nullable = false)
	@OneToMany(cascade=CascadeType.ALL,mappedBy="asset",fetch = FetchType.EAGER)
	private List<ProductImage> ProductImage;	
	@NotEmpty
	private String name;
	@NotEmpty
	private String model;
	@NotEmpty
	private String brand;
	
	@NotEmpty
	private String description;
	
	
	private double minimumBidAmount;
	
	private double maximumBidAmount;
	
	@Temporal(value = TemporalType.DATE)
	@DateTimeFormat(pattern="MM-dd-yyyy")
	private Date bidStartDate;
	
	@Temporal(value = TemporalType.DATE)
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date bidEndDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "Status")
	private Status status;
	
//	MultipartFile image1;
//	MultipartFile image2;
//	MultipartFile image3;
	
	
	
	public long getAssetId() {
		return assetId;
	}
	public Asset(long assetId, Category category, User user, String name, String model, String brand, String description,
		long minimumBidAmount, long maximumBidAmount, Date bidStartDate, Date bidEndDate, Status status) {
	super();
	this.assetId = assetId;
	this.category = category;
	this.user = user;
	this.name = name;
	this.model = model;
	this.brand = brand;
	this.description = description;
	this.minimumBidAmount = minimumBidAmount;
	this.maximumBidAmount = maximumBidAmount;
	this.bidStartDate = bidStartDate;
	this.bidEndDate = bidEndDate;
	this.status = status;
}
	
	public Asset() {
		super();
	}
	public void setAssetId(long assetId) {
		this.assetId = assetId;
	}
	
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getMinimumBidAmount() {
		return minimumBidAmount;
	}
	public void setMinimumBidAmount(double minimumBidAmount) {
		this.minimumBidAmount = minimumBidAmount;
	}
	public double getMaximumBidAmount() {
		return maximumBidAmount;
	}
	public void setMaximumBidAmount(double maximumBidAmount) {
		this.maximumBidAmount = maximumBidAmount;
	}
	public Date getBidStartDate() {
		return bidStartDate;
	}
	public void setBidStartDate(Date bidStartDate) {
		this.bidStartDate = bidStartDate;
	}
	public Date getBidEndDate() {
		return bidEndDate;
	}
	public void setBidEndDate(Date bidEndDate) {
		this.bidEndDate = bidEndDate;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public List<ProductImage> getProductImage() {
		return ProductImage;
	}
	public void setProductImage(List<ProductImage> productImage) {
		ProductImage = productImage;
	}
	@Override
	public String toString() {
		return "Asset [assetId=" + assetId + ", category=" + category + ", user=" + user + ", ProductImage="
				+ ProductImage + ", name=" + name + ", model=" + model + ", brand=" + brand + ", description="
				+ description + ", minimumBidAmount=" + minimumBidAmount + ", maximumBidAmount=" + maximumBidAmount
				+ ", bidStartDate=" + bidStartDate + ", bidEndDate=" + bidEndDate + ", status=" + status + "]";
	}
	
	
	
}
