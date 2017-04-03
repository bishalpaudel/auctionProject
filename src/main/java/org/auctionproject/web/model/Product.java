package org.auctionproject.web.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Bishal Paudel on 3/2/17.
 */
@Entity
public class Product {

    public enum PRODUCTSTATUS {ACTIVE, SOLD, ARCHIVED}

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String model;

    @NotEmpty
    private String brand;


    @ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.MERGE)
    @JoinColumn(name="category_id")
    private Category category;

    @NotEmpty
    private String description;

    private Double directBuyPrice;

    @NotEmpty
    private Double initialBidAmount;

    @NotEmpty
    private Double minBidIncrementAmount;

    @NotEmpty
    private Date auctionStartDate;

    @NotEmpty
    private Date auctionEndDate;

    @NotEmpty
    private PRODUCTSTATUS status;

    @OneToMany
    @JoinColumn(
            name = "product_id",
            nullable = false
    )
    private List<Bid> bids = new ArrayList<>();

    @ManyToOne
    private User owner;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getDirectBuyPrice() {
        return directBuyPrice;
    }

    public void setDirectBuyPrice(Double directBuyPrice) {
        this.directBuyPrice = directBuyPrice;
    }

    public Double getInitialBidAmount() {
        return initialBidAmount;
    }

    public void setInitialBidAmount(Double initialBidAmount) {
        this.initialBidAmount = initialBidAmount;
    }

    public Double getMinBidIncrementAmount() {
        return minBidIncrementAmount;
    }

    public void setMinBidIncrementAmount(Double minBidIncrementAmount) {
        this.minBidIncrementAmount = minBidIncrementAmount;
    }

    public Date getAuctionStartDate() {
        return auctionStartDate;
    }

    public void setAuctionStartDate(Date auctionStartDate) {
        this.auctionStartDate = auctionStartDate;
    }

    public Date getAuctionEndDate() {
        return auctionEndDate;
    }

    public void setAuctionEndDate(Date auctionEndDate) {
        this.auctionEndDate = auctionEndDate;
    }

    public PRODUCTSTATUS getStatus() {
        return status;
    }

    public void setStatus(PRODUCTSTATUS status) {
        this.status = status;
    }


    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
