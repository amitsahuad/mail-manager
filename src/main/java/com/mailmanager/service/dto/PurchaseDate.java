package com.mailmanager.service.dto;

import java.time.LocalDate;

public class PurchaseDate {
    private String mail;
    private LocalDate purchaseDate;

    public String getMail() {
        return mail;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
