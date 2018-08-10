package com.codetreatise.controller;

import com.codetreatise.config.StageManager;
import com.codetreatise.service.NewMatchService;
import com.codetreatise.service.PlayerScoreService;
import com.codetreatise.view.FxmlView;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class AddMatchController implements Initializable {

    @Autowired
    private NewMatchService newMatchService;
    @Lazy
    @Autowired
    private StageManager stageManager;
    @FXML
    private JFXTextField series;

    @FXML
    private JFXComboBox<String> venue;

    @FXML
    private JFXComboBox<String> countryone;

    @FXML
    private JFXComboBox<String> againstcountry;

    @FXML
    private JFXComboBox<String> countryPlayers;

    @FXML
    private JFXComboBox<String> againstCountryPlayers;

    @FXML
    private JFXDatePicker matchDate;

    @FXML
    private JFXTimePicker matchTime;

    @FXML
    private JFXComboBox<?> matchType;

    @FXML
    void cancel(ActionEvent event) {
        stageManager.switchScene(FxmlView.DASHBOARD);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> playingGrounds = FXCollections.observableArrayList();
        for (String playingGroundList : newMatchService.findGround()) {
            playingGrounds.add(playingGroundList);
        }
        venue.getItems().clear();
        venue.getItems().setAll(playingGrounds);

        ObservableList<String> countries = FXCollections.observableArrayList();
        for (String countriesList : newMatchService.findCountries()) {
            countries.add(countriesList);
        }
        countryone.getItems().clear();
        countryone.getItems().setAll(countries);
        againstcountry.getItems().clear();
        againstcountry.getItems().setAll(countries);
    }

    @FXML
    void getCountry(ActionEvent event) {
        ObservableList<String> countries = FXCollections.observableArrayList();
        for (String countriesList : newMatchService.findCountries()) {
            countries.add(countriesList);
        }
        againstcountry.getItems().setAll(countries);
        againstcountry.getItems().remove(countryone.getValue());
        System.out.println(countryone.getId());

        ObservableList<String> players = FXCollections.observableArrayList();
        for (String playersList : newMatchService.findPlayersByCountry(countryone.getValue())) {
            players.add(playersList);
        }
        countryPlayers.getItems().clear();
        countryPlayers.getItems().setAll(players);
    }

    @FXML
    void getAgainstCountry(ActionEvent event) {
        ObservableList<String> countries = FXCollections.observableArrayList();
        for (String countriesList : newMatchService.findCountries()) {
            countries.add(countriesList);
        }
        countryone.getItems().setAll(countries);
        countryone.getItems().remove(againstcountry.getValue());

        ObservableList<String> players = FXCollections.observableArrayList();
        for (String playersList : newMatchService.findPlayersByCountry(againstcountry.getValue())) {
            players.add(playersList);
        }
        againstCountryPlayers.getItems().clear();
        againstCountryPlayers.getItems().setAll(players);
    }
}
