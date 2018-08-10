package com.codetreatise.repository;

import com.codetreatise.bean.AddMatch;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddMatchRepository extends CrudRepository<AddMatch, Long> {
    @Query(value = "Select GroundName from Ground" )
    List<String> findGround();

    @Query(value = "Select countryName from Country" )
    List<String> findCountries();

    @Query(value = "Select playerName from NewPlayer where playerCountry = ?1 " )
    List<String> findPlayersByCountry(String countryName);

    @Override
    Optional<AddMatch> findById(Long aLong);
}
