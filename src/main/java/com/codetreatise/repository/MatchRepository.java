package com.codetreatise.repository;

import com.codetreatise.bean.MatchInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<MatchInformation, Long> {
}
