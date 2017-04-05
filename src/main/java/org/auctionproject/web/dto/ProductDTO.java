package org.auctionproject.web.dto;

import org.auctionproject.web.model.Category;
import org.auctionproject.web.model.Product;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Bishal Paudel on 4/4/17.
 */
public class ProductDTO {

    @NotNull
    @Length(min = Product.MIN_LENGTH_TITLE)
    private String title;

    @Length(min = Product.MIN_LENGTH_MODEL)
    private String model;

    @Length(min = Product.MIN_LENGTH_BRAND)
    private String brand;

    /* TODO: validate if category exists in database */
    @NotNull
    private Category category;

    private String description;

    private Double directBuyPrice;

    @DecimalMin("0.1")
    @NotNull
    private Double initialBidAmount;

    @DecimalMin("0.1")
    @NotNull
    private Double minBidIncrementAmount;

    @Future
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date auctionStartDate;

    @Future
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date auctionEndDate;

    private Product.PRODUCTSTATUS status;





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

    public Product.PRODUCTSTATUS getStatus() {
        return status;
    }

    public void setStatus(Product.PRODUCTSTATUS status) {
        this.status = status;
    }

 }
