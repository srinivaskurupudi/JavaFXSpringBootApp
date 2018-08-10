package com.codetreatise.bean;

import javax.persistence.*;


@Entity
@Table(name = "Ground")
public class Ground {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "GroundId")
    private int groundId;
    @Column(name = "GroundName")
    private String GroundName;
    @Column(name = "GroundDescription")
    private String GroundDescription;
    @ManyToOne
    @JoinColumn(name = "CountryId")
    private Country country;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getGroundName() {
        return GroundName;
    }

    public void setGroundName(String groundName) {
        GroundName = groundName;
    }
    public String getGroundDescription() {
        return GroundDescription;
    }

    public void setGroundDescription(String groundDescription) {
        GroundDescription = groundDescription;
    }

}
