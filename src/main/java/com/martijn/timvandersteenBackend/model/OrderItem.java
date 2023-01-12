package com.martijn.timvandersteenBackend.model;

import com.sun.istack.NotNull;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
@EntityListeners(AuditingEntityListener.class)
public class OrderItem {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "beschrijving")
    private String beschrijving;

    @Column(name = "kleur")
    private String kleur;
    @Column(name = "icon")
    private String icon;

    @Column(name = "eenheid")
    private String eenheid;

    @Column(name = "price")
    private double price;

    public OrderItem(){}
    public OrderItem(String name, String beschrijving, String kleur, String icon, String eenheid, double price) {
        this.name = name;
        this.beschrijving = beschrijving;
        this.kleur = kleur;
        this.icon = icon;
        this.eenheid = eenheid;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public String getKleur() {
        return kleur;
    }

    public void setKleur(String kleur) {
        this.kleur = kleur;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getEenheid() {
        return eenheid;
    }

    public void setEenheid(String eenheid) {
        this.eenheid = eenheid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
