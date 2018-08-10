package com.codetreatise.service.impl;

import com.codetreatise.bean.AddMatch;
import com.codetreatise.repository.AddMatchRepository;
import com.codetreatise.service.NewMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewMatchServiceImpl implements NewMatchService {
    @Autowired
    private AddMatchRepository addMatchRepository;
    @Override
    public List<String> findGround() {
        return addMatchRepository.findGround();
    }

    @Override
    public List<String> findCountries() {
        return addMatchRepository.findCountries();
    }

    @Override
    public List<String> findPlayersByCountry(String countryName) {
        return addMatchRepository.findPlayersByCountry(countryName);
    }

    @Override
    public AddMatch save(AddMatch entity) {
        return null;
    }

    @Override
    public AddMatch update(AddMatch entity) {
        return null;
    }

    @Override
    public void delete(AddMatch entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void deleteInBatch(List<AddMatch> entities) {

    }

    @Override
    public AddMatch find(Long id) {
        return null;
    }

    @Override
    public List<AddMatch> findAll() {
        return null;
    }
}
