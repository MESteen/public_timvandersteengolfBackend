package com.martijn.timvandersteenBackend.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "Coach")
@EntityListeners(AuditingEntityListener.class)
public class Coach {

    @Id
    @Column(name = "coach_id", unique = true)
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int coachId;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "type_of_coach")
    private String typeOfCoach;

    @Column(name = "insta_link")
    private String instaLink;

    @Column(name = "fb_link")
    private String fbLink;

    @Column(name = "twitter_link")
    private String twitterLink;
}