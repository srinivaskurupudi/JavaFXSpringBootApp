package com.codetreatise.bean;

import javax.persistence.*;

@Entity
@Table(name = "Match")
public class AddMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Match_Id")
    private Long MatchId;
}
