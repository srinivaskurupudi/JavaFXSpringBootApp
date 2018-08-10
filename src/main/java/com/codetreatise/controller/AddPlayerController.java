package com.codetreatise.controller;

import com.codetreatise.bean.NewPlayer;
import com.codetreatise.config.StageManager;
import com.codetreatise.service.NewPlayerService;
import com.codetreatise.view.FxmlView;
import com.jfoenix.controls.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@Controller
public class AddPlayerController implements Initializable {
    @Lazy
    @Autowired
    private StageManager stageManager;
    @Autowired
    private NewPlayerService newPlayerService;

    @FXML
    private JFXTextField playerName;
    @FXML
    private JFXComboBox<String> playerCountry;
    @FXML
    private JFXDatePicker playerBirth;
    @FXML
    private JFXTextArea playerDesc;
    @FXML
    private Label playerNamelbl;
    @FXML
    private Label playerCountrylbl;
    @FXML
    private Label playerBirthlbl;
    @FXML
    private Label successMessage;

    @FXML
    void addPlayer(ActionEvent event) {
        if(playerName.getText().isEmpty()){
            playerNamelbl.setText("Please Enter Player Name");
            playerName.requestFocus();
        }
        LocalDate date = playerBirth.getValue();
        if(date.toString().isEmpty()){
            playerBirthlbl.setText("Please Select Player Birth Date");
            playerBirth.requestFocus();
        }
        NewPlayer newPlayer = new NewPlayer();
        if(!playerName.getText().isEmpty()){
            try {
            newPlayer.setPlayerName(getPlayerName());
            newPlayer.setPlayerCountry(getPlayerCountry());
            newPlayer.setPlayerDOB(date.toString());
            newPlayer.setPlayerDescription(getPlayerDesc());
            newPlayerService.save(newPlayer);
            }catch (Exception e){
            e.printStackTrace();
            }
            playerName.clear();
            playerDesc.clear();
            successMessage.setText("New Player Record Inserted Successfully....!!");
        }
    }
    @FXML
    void addCountry(ActionEvent event) { stageManager.switchScene(FxmlView.COUNTRY);}

    @FXML
    void cancel(ActionEvent event) {stageManager.switchScene(FxmlView.DASHBOARD); }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<String> contries = new ArrayList<>();
        for (String contriesList : newPlayerService.findCountry()){
            contries.add(contriesList);
        }
        playerCountry.getItems().addAll(contries);
    }
    @FXML
    void getPlayerName(KeyEvent event) {
    playerNamelbl.setText("");
    }
    public String getPlayerName() {
        return playerName.getText();
    }

    public String  getPlayerCountry() {
        return playerCountry.getValue();
    }

    public String  getPlayerDesc() {
        return playerDesc.getText();
    }
}
