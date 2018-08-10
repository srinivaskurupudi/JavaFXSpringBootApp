package com.codetreatise.bean;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "MatchInformation")
public class MatchInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "MatchId")
    private int matchId;
    @Column(name = "country")
    private String country;
    @Column(name = "Ground")
    private String ground;
    @Column(name = "CountriesPlaying")
    private String countriesPlaying;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGround() {
        return ground;
    }

    public void setGround(String ground) {
        this.ground = ground;
    }

    public String getCountriesPlaying() {
        return countriesPlaying;
    }

    public void setCountriesPlaying(String countriesPlaying) {
        this.countriesPlaying = countriesPlaying;
    }
}
