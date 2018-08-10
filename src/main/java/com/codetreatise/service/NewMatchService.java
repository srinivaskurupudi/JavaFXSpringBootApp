package com.codetreatise.service;

import com.codetreatise.bean.AddMatch;
import com.codetreatise.generic.GenericService;

import java.util.List;

public interface NewMatchService extends GenericService<AddMatch> {
    List<String> findGround();
    List<String> findCountries();
    List<String> findPlayersByCountry(String countryName);
}
