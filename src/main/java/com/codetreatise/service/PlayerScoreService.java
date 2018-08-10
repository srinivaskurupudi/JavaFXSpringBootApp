package com.codetreatise.service;

import com.codetreatise.bean.PlayerScore;
import com.codetreatise.generic.GenericService;

import java.util.List;

public interface PlayerScoreService extends GenericService<PlayerScore> {
    List<String> findPlayer();
    List<String> findGroundByCountry(String countryName);
    List<String> findCountryByPlayer(String playerNameContry);
}
