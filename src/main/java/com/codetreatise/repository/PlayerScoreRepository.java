package com.codetreatise.repository;

import com.codetreatise.bean.PlayerScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerScoreRepository extends JpaRepository<PlayerScore, Long> {
    @Query(value = "Select playerName from NewPlayer")
    List<String> findPlayer();

    @Query(value = "Select GroundName from Ground where GroundCountry = ?1 " )
    List<String> findGroundByCountry(String countryName);

    @Query(value = "Select playerCountry from NewPlayer where playerName = ?1 " )
    List<String> findCountryByPlayer(String playerNameContry);
}
