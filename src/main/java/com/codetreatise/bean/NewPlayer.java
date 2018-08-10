package com.codetreatise.bean;

import javax.persistence.*;

@Entity
@Table(name = "Players")
public class NewPlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "PlayerId")
    private int playerid;
    @Column(name = "PlayerName")
    private String playerName;

    @Column(name = "PlayerCountry")
    private String playerCountry;
    @Column(name = "PlayerDOB")
    private String playerDOB;
    @Column(name = "PlayerDescription")
    private String playerDescription;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerCountry() {
        return playerCountry;
    }

    public void setPlayerCountry(String playerCountry) {
        this.playerCountry = playerCountry;
    }

    public String getPlayerDOB() {
        return playerDOB;
    }

    public void setPlayerDOB(String playerDOB) {
        this.playerDOB = playerDOB;
    }

    public String getPlayerDescription() {
        return playerDescription;
    }

    public void setPlayerDescription(String playerDescription) {
        this.playerDescription = playerDescription;
    }
}
