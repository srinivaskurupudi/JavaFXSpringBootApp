package com.codetreatise.bean;

import javax.persistence.*;

@Entity
@Table(name = "PlayerScores")
public class PlayerScore {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "PlayerScoreId")
    private int playerScoreId;
}
