package com.codetreatise.service.impl;

import com.codetreatise.bean.PlayerScore;
import com.codetreatise.repository.PlayerScoreRepository;
import com.codetreatise.service.PlayerScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerScoreServiceImpl implements PlayerScoreService {

    @Autowired
    private PlayerScoreRepository playerScoreRepository;
    @Override
    public PlayerScore save(PlayerScore entity) {
        return null;
    }

    @Override
    public PlayerScore update(PlayerScore entity) {
        return null;
    }

    @Override
    public void delete(PlayerScore entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void deleteInBatch(List<PlayerScore> entities) {

    }

    @Override
    public PlayerScore find(Long id) {
        return null;
    }

    @Override
    public List<PlayerScore> findAll() {
        return null;
    }

    @Override
    public List<String> findPlayer() {
        return playerScoreRepository.findPlayer();
    }

    @Override
    public List<String> findGroundByCountry(String countryName) {
        return playerScoreRepository.findGroundByCountry(countryName);
    }

    @Override
    public List<String> findCountryByPlayer(String playerNameContry) {
        return playerScoreRepository.findCountryByPlayer(playerNameContry);
    }
}
