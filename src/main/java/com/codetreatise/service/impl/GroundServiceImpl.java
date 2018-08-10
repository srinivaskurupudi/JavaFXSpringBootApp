package com.codetreatise.service.impl;

import com.codetreatise.bean.Country;
import com.codetreatise.bean.Ground;
import com.codetreatise.repository.GroundRepository;
import com.codetreatise.service.GroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroundServiceImpl implements GroundService {

    @Autowired
    private GroundRepository repository;
    @Override
    public Ground save(Ground entity) {
        return repository.save(entity);
    }

    @Override
    public Ground update(Ground entity) {
        return null;
    }

    @Override
    public void delete(Ground entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void deleteInBatch(List<Ground> entities) {

    }

    @Override
    public Ground find(Long id) {
        return null;
    }

    @Override
    public List<Ground> findAll() {
        return null;
    }

    @Override
    public List<String> findCountry() {
        return repository.findCountry();
    }

    @Override
    public Long findId(String countryName) {
        return repository.findId(countryName);
    }

}
