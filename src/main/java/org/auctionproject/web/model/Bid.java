package org.auctionproject.web.model;

import java.util.Date;

import javax.persistence.*;

/**
 * Created by bishal on 3/2/17.
 * 
 * Changes by Swoven: This is just an example, to test the configuration, 
 * configuration is tested both for hibernate and spring and both are working
 */

@Entity
public class Bid {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private Double amount;
	private Date date;

//	@ManyToOne
//	private Product product;

	@ManyToOne
    private User user;

//	public Product getProduct() {
//		return product;
//	}
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	public Double getAmount() {
	return amount;
}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	
}
