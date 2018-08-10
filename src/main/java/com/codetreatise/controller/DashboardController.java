package com.codetreatise.controller;

import com.codetreatise.config.StageManager;
import com.codetreatise.view.FxmlView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class DashboardController {

    @Lazy
    @Autowired
    private StageManager stageManager;

    @FXML
    private Label message;

    @FXML
    private void country(ActionEvent event) {
        stageManager.switchScene(FxmlView.COUNTRY);
    }

    @FXML
    private void ground(ActionEvent event) {
        stageManager.switchScene(FxmlView.GROUND);
    }

    @FXML
    private void player(ActionEvent event) { stageManager.switchScene(FxmlView.PLAYERSCORE); }

    @FXML
    private void addPlayer(ActionEvent event) { stageManager.switchScene(FxmlView.ADDPLAYER);}

    @FXML
    private void addMatch(ActionEvent event) { stageManager.switchScene(FxmlView.ADDMATCH);}
}
