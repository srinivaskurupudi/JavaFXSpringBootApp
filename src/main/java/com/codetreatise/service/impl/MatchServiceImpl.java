package com.codetreatise.service.impl;

import com.codetreatise.bean.MatchInformation;
import com.codetreatise.repository.MatchRepository;
import com.codetreatise.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MatchServiceImpl implements MatchService {
    @Autowired
    private MatchRepository matchRepository;
    @Override
    public MatchInformation save(MatchInformation entity) {
        return matchRepository.save(entity);
    }

    @Override
    public MatchInformation update(MatchInformation entity) {
        return null;
    }

    @Override
    public void delete(MatchInformation entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void deleteInBatch(List<MatchInformation> entities) {

    }

    @Override
    public MatchInformation find(Long id) {
        return null;
    }

    @Override
    public List<MatchInformation> findAll() {
        return null;
    }
}
