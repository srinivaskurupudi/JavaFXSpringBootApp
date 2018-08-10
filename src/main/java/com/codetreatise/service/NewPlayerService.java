package com.codetreatise.service;

import com.codetreatise.bean.NewPlayer;
import com.codetreatise.generic.GenericService;

import java.util.List;

public interface NewPlayerService extends GenericService<NewPlayer> {
    List<String> findCountry();
}
