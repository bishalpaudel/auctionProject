package org.auctionproject.web.dto;

import org.auctionproject.web.model.User;
import org.auctionproject.web.validation.ValidEmail;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Basic;
import javax.validation.constraints.NotNull;

/**
 * Created by bishal on 3/30/17.
 */

public class UserDTO {

    private Long userId;

    @Length(min = User.MIN_LENGTH_USERNAME, max = User.MAX_LENGTH_USERNAME)
    private String userName = "";

    @NotEmpty
    @Length(min = User.MIN_LENGTH_FULLNAME, max = User.MAX_LENGTH_FULLNAME)
    private String fullName = "";

    @NotNull
    @NotEmpty
    @ValidEmail
    @Length(max = User.MAX_LENGTH_EMAIL_ADDRESS)
    private String email = "";

    @Length(min=User.MIN_LENGTH_PASSWORD, max=User.MAX_LENGTH_PASSWORD)
    private String password = "";

    /* TODO: add custom validation for repeat-password*/
    private String repeatPassword = "";

    @Length(min = User.MIN_LENGTH_PHONE)
    private String phone = "";

    /* TODO: add validation for street*/
    private String street = "";

    /* TODO: add validation for city */
    private String city = "";

    /* TODO: add validation for state */
    private String state = "";

    /* TODO: add validation for zip */
    private String zip = "";

    /* TODO: add validation for country */
    private String country = "";


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
