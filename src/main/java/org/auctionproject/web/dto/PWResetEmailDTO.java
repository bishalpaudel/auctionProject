package org.auctionproject.web.dto;

import org.auctionproject.web.model.User;
import org.auctionproject.web.validation.EmailAlreadyExists;
import org.auctionproject.web.validation.ValidEmail;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by bishal on 3/31/17.
 */
public class PWResetEmailDTO {
    @NotNull
    @NotEmpty
    @ValidEmail
    @EmailAlreadyExists
    @Length(max = User.MAX_LENGTH_EMAIL_ADDRESS)
    private String email = "";

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
