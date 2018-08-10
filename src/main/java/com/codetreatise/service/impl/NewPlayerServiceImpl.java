package com.codetreatise.service.impl;

import com.codetreatise.bean.NewPlayer;
import com.codetreatise.repository.NewPlayerRepository;
import com.codetreatise.service.NewPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewPlayerServiceImpl implements NewPlayerService {
    @Autowired
    private NewPlayerRepository newPlayerRepository;
    @Override
    public List<String> findCountry() {
        return newPlayerRepository.findCountry();
    }

    @Override
    public NewPlayer save(NewPlayer entity) {
        return newPlayerRepository.save(entity);
    }

    @Override
    public NewPlayer update(NewPlayer entity) {
        return null;
    }

    @Override
    public void delete(NewPlayer entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void deleteInBatch(List<NewPlayer> entities) {

    }

    @Override
    public NewPlayer find(Long id) {
        return null;
    }

    @Override
    public List<NewPlayer> findAll() {
        return null;
    }
}
