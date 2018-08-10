package com.codetreatise.repository;

import com.codetreatise.bean.Country;
import com.codetreatise.bean.Ground;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroundRepository extends JpaRepository<Ground, Long> {
    @Query(value = "Select countryName from Country")
    List<String> findCountry();

    @Query(value = "Select countryId from Country where countryName = ?1")
    public Long findId(String countryName);
}
