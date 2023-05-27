package com.example.pdfgenerator.model;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class Invoice {
    String seller;
    String sellerGstin;
    String sellerAddress;
    String buyer;
    String buyerGstin;
    String buyerAddress;
//
    List<Item> items;


    public Invoice() {
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getBuyerGstin() {
        return buyerGstin;
    }

    public void setBuyerGstin(String buyerGstin) {
        this.buyerGstin = buyerGstin;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }

    public Invoice(String seller, String sellerGstin, String sellerAddress, String buyer, String buyerGstin, String buyerAddress, List<Item> items) {
        this.seller = seller;
        this.sellerGstin = sellerGstin;
        this.sellerAddress = sellerAddress;
        this.buyer = buyer;
        this.buyerGstin = buyerGstin;
        this.buyerAddress = buyerAddress;
        this.items = items;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getSellerGstin() {
        return sellerGstin;
    }

    public void setSellerGstin(String sellerGstin) {
        this.sellerGstin = sellerGstin;
    }

    public String getSellerAddress() {
        return sellerAddress;
    }

    public void setSellerAddress(String sellerAddress) {
        this.sellerAddress = sellerAddress;
    }

    public List<Item> getItems() {
        return this.items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
