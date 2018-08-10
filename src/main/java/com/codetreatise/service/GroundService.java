package com.codetreatise.service;

import com.codetreatise.bean.Country;
import com.codetreatise.bean.Ground;
import com.codetreatise.generic.GenericService;

import java.util.List;

public interface GroundService extends GenericService<Ground> {
List<String> findCountry();
    public Long findId(String countryName);
}
