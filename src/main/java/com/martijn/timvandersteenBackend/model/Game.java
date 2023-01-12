package com.martijn.timvandersteenBackend.model;


import com.sun.istack.NotNull;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Game")
@EntityListeners(AuditingEntityListener.class)
public class Game {

    public Game(){}

    public Game(String courseNaam, String wedstrijdNaam, int aantalDagen, String wedstrijdBaanImage, String wedstrijdLink, String baanLogo, Date datum, boolean gespeeld) {
        this.courseNaam = courseNaam;
        this.wedstrijdNaam = wedstrijdNaam;
        this.aantalDagen = aantalDagen;
        this.wedstrijdBaanImage = wedstrijdBaanImage;
        this.wedstrijdLink = wedstrijdLink;
        this.baanLogo = baanLogo;
        this.datum = datum;
        this.gespeeld = gespeeld;
    }

    @Id
    @Column(name = "wedstrijd_id", unique = true)
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int wedstrijdId;
    @NotNull
    @Column(name = "course_naam")
    private String courseNaam;

    @NotNull
    @Column(name = "wedstrijd_naam")
    private String wedstrijdNaam;

    @Column(name = "aantal_dagen")
    private Integer aantalDagen;
    @Column(name = "wedstrijdbaan_image")
    private String wedstrijdBaanImage;

    @Column(name = "wedstrijd_link")
    private String wedstrijdLink;

    @Column(name = "baan_logo")
    private String baanLogo;

    @Column(name = "datum")
    private Date datum;

    @Column(name = "gespeeld")
    private Boolean gespeeld;


    public String getCourseNaam() {
        return courseNaam;
    }

    public void setCourseNaam(String courseNaam) {
        this.courseNaam = courseNaam;
    }

    public String getWedstrijdNaam() {
        return wedstrijdNaam;
    }

    public void setWedstrijdNaam(String wedstrijdNaam) {
        this.wedstrijdNaam = wedstrijdNaam;
    }

    public Integer getAantalDagen() {
        return aantalDagen;
    }

    public void setAantalDagen(Integer aantalDagen) {
        this.aantalDagen = aantalDagen;
    }

    public String getWedstrijdBaanImage() {
        return wedstrijdBaanImage;
    }

    public void setWedstrijdBaanImage(String wedstrijdBaanImage) {
        this.wedstrijdBaanImage = wedstrijdBaanImage;
    }

    public String getWedstrijdLink() {
        return wedstrijdLink;
    }

    public void setWedstrijdLink(String wedstrijdLink) {
        this.wedstrijdLink = wedstrijdLink;
    }

    public String getBaanLogo() {
        return baanLogo;
    }

    public void setBaanLogo(String baanLogo) {
        this.baanLogo = baanLogo;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Boolean getGespeeld() {
        return gespeeld;
    }

    public void setGespeeld(Boolean gespeeld) {
        this.gespeeld = gespeeld;
    }
}
