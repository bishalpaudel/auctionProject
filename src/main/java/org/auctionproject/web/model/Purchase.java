package org.auctionproject.web.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Bishal Paudel on 3/2/17.
 */
@Entity
public class Purchase {
    public enum PURCHASETYPES {AUCTION, DIRECTBUY}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private User buyer;

    private PURCHASETYPES type;

    private Date date;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public PURCHASETYPES getType() {
        return type;
    }

    public void setType(PURCHASETYPES type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
