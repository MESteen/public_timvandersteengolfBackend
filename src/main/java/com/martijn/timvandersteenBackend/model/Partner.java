package com.martijn.timvandersteenBackend.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "Partner")
@EntityListeners(AuditingEntityListener.class)
public class Partner {

    public Partner() {
    }

    public Partner(String brand, String image, String href) {
        this.brand = brand;
        this.image = image;
        this.href = href;
    }
    @Id
    @Column(name = "partner_id", unique = true)
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int partnerId;

    @Column(name = "brand")
    private String brand;

    @Column(name = "image")
    private String image;

    @Column(name = "href")
    private String href;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}


