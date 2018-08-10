package com.codetreatise.repository;

import com.codetreatise.bean.NewPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewPlayerRepository extends JpaRepository<NewPlayer, Long> {
    @Query(value = "Select countryName from Country")
    List<String> findCountry();
}
