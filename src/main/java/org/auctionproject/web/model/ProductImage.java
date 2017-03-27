package org.auctionproject.web.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class ProductImage {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ImageID;	
	private String ProductName;	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="asset",nullable=false)
	private Asset asset;
	
	
	
	public int getImageID() {
		return ImageID;
	}



	public void setImageID(int imageID) {
		ImageID = imageID;
	}



	public String getProductName() {
		return ProductName;
	}



	public void setProductName(String productName) {
		ProductName = productName;
	}



	public Asset getAsset() {
		return asset;
	}



	public void setAsset(Asset asset) {
		this.asset = asset;
	}



	@Override
	public String toString() {
		return "ProductImage [ImageID=" + ImageID + ", ProductName=" + ProductName + "]";
	}
	

}
