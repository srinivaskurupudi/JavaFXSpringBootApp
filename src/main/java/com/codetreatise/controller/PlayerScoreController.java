package com.codetreatise.controller;

import com.codetreatise.bean.Ground;
import com.codetreatise.bean.MatchInformation;
import com.codetreatise.config.StageManager;
import com.codetreatise.service.GroundService;
import com.codetreatise.service.MatchService;
import com.codetreatise.service.PlayerScoreService;
import com.codetreatise.view.FxmlView;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
public class PlayerScoreController implements Initializable {
    @Autowired
    private PlayerScoreService playerScoreService;
    @Autowired
    private MatchService matchService;
    @Autowired
    private GroundService groundService;
    @Lazy
    @Autowired
    private StageManager stageManager;

    @FXML
    private JFXComboBox<String> playerNames;
    @FXML
    private JFXComboBox<String> playerCountry;
    @FXML
    private JFXComboBox<String> countryPlaying;
    @FXML
    private JFXComboBox<String> playingGround;
    @FXML
    private JFXComboBox<String> playingAgainst;

    @FXML
    private JFXTextField totalScore;
    @FXML
    private JFXTextField one;
    @FXML
    private JFXTextField two;
    @FXML
    private JFXTextField three;
    @FXML
    private JFXTextField four;
    @FXML
    private JFXTextField five;
    @FXML
    private JFXTextField six;
    @FXML
    private JFXTextField fifty;
    @FXML
    private JFXTextField hundred;

    @FXML
    private void cancel(ActionEvent event) {
        stageManager.switchScene(FxmlView.DASHBOARD);
    }

    @FXML
    private void getGrounds(ActionEvent event) {
        ObservableList<String> playingGrounds = FXCollections.observableArrayList();
        for (String playingGroundList : playerScoreService.findGroundByCountry(countryPlaying.getValue())) {
            playingGrounds.add(playingGroundList);
        }
        playingGround.getItems().clear();
        playingGround.getItems().setAll(playingGrounds);
    }

    @FXML
    void playerNameAction(ActionEvent event) {
        playerCountry.getItems().clear();
        playerCountry.getItems().setAll(playerScoreService.findCountryByPlayer(playerNames.getValue()));
        playerCountry.getSelectionModel().selectFirst();

        ObservableList<String> contries = FXCollections.observableArrayList();
        for (String listcountries : groundService.findCountry()) {
            contries.add(listcountries);
        }
        playingAgainst.getItems().clear();
        playingAgainst.getItems().setAll(contries);
        playingAgainst.getItems().removeAll(playerScoreService.findCountryByPlayer(playerNames.getValue()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> players = FXCollections.observableArrayList();
        for (String player : playerScoreService.findPlayer()) {
            players.add(player);
        }
        playerNames.getItems().addAll(players);

        ObservableList<String> contries = FXCollections.observableArrayList();
        for (String listcountries : groundService.findCountry()) {
            contries.add(listcountries);
        }
        countryPlaying.getItems().addAll(contries);
        countryPlaying.getItems().remove(playerScoreService.findCountryByPlayer(playerNames.getValue()));

        totalScore.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                int newValueUpdate = Integer.parseInt(newValue);
                if(newValueUpdate >= 50 && newValueUpdate <100){
                    fifty.setText("1");
                    hundred.setText("");
                }
                if (newValueUpdate >= 100){
                    hundred.setText("1");
                    fifty.setText("");
                }
                if(newValueUpdate < 50){
                    fifty.setText("");
                    hundred.setText("");
                }
            }
        });
        one.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                    totalScore.setText(String.valueOf(getTotalScore()));
            }
        });
        two.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                int score = 0;
                score = getTotalScore();
                totalScore.setText(String.valueOf(score));
            }
        });
        three.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                int score = 0;
                score = getTotalScore();
                totalScore.setText(String.valueOf(score));
            }
        });
        four.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                int score = 0;
                score = getTotalScore();
                totalScore.setText(String.valueOf(score));
            }
        });
        five.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                int score = 0;
                score = getTotalScore();
                totalScore.setText(String.valueOf(score));
            }
        });
        six.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                int score = 0;
                score = getTotalScore();
                totalScore.setText(String.valueOf(score));
            }
        });
    }

    private int getTotalScore(){
        int ones = 0;
        try {
            ones = Integer.parseInt(one.getText());
        }catch(NumberFormatException nfe){

        }
        int twos = 0;
        try {
            twos =  Integer.parseInt(two.getText())*2;
        }catch(NumberFormatException nfe){

        }
        int threes = 0;
        try {
            threes =  Integer.parseInt(three.getText())*3;
        }catch(NumberFormatException nfe){

        }
        int fours = 0;
        try {
            fours =  Integer.parseInt(four.getText())*4;
        }catch(NumberFormatException nfe){

        }
        int fives = 0;
        try {
            fives =  Integer.parseInt(five.getText())*5;
        }catch(NumberFormatException nfe){

        }
        int sixes = 0;
        try {
            sixes =  Integer.parseInt(six.getText())*6;
        }catch(NumberFormatException nfe){

        }
        return ones + twos + threes + fours + fives + sixes;
    }


    @FXML
    void addScore(ActionEvent event) {
        Ground ground = new Ground();
        MatchInformation matchInformation = new MatchInformation();
        matchInformation.setCountry(getPlayerCountry());
        matchInformation.setGround(getPlayingGround());
        matchInformation.setCountriesPlaying(getPlayerCountry() + "vs" + getPlayingAgainst());
        matchService.save(matchInformation);
    }

    public String getPlayerCountry() {
        return playerCountry.getValue();
    }

    public String getPlayingGround() {
        return playingGround.getValue();
    }

    public String getPlayingAgainst() {
        return playingAgainst.getValue();
    }
}
