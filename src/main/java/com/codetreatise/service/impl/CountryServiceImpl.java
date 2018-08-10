package com.codetreatise.service.impl;

import com.codetreatise.bean.Country;
import com.codetreatise.repository.CountryRepository;
import com.codetreatise.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;
    @Override
    public Country save(Country entity) {
        return countryRepository.save(entity);
    }

    @Override
    public Country update(Country entity) {
        return null;
    }

    @Override
    public void delete(Country entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void deleteInBatch(List<Country> entities) {

    }

    @Override
    public Country find(Long id) {
        return null;
    }

    @Override
    public List<Country> findAll() {
        return null;
    }
}
