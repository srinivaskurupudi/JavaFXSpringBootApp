package com.codetreatise.controller;

import com.codetreatise.bean.Country;
import com.codetreatise.bean.Ground;
import com.codetreatise.config.StageManager;
import com.codetreatise.service.GroundService;
import com.codetreatise.view.FxmlView;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.*;

@Controller
public class GroundController implements Initializable {
    @Lazy
    @Autowired
    private StageManager stageManager;
    @FXML
    private JFXTextField groundName;
    @FXML
    private JFXComboBox<String> groundCountry;
    @FXML
    private JFXTextArea groundDesc;
    @FXML
    private Label successMessage;
    @FXML
    private Label groundNameLbl;

    @Autowired
    private GroundService groundService;

    @FXML
    private void addGround(ActionEvent event) {
        if (groundName.getText().isEmpty()) {
            groundNameLbl.setText("Please Enter Ground Name.");
            groundName.requestFocus();
        }
        Ground addNewGround = new Ground();
        if (!groundName.getText().isEmpty()) {
            try {
                addNewGround.setGroundName(getGroundName());
                addNewGround.setGroundDescription(getGroundDesc());
                Country country = new Country();
                country.setCountryId(getGroundCountryId());
                addNewGround.setCountry(country);
                groundService.save(addNewGround);
            } catch (Exception e) {

            }
            successMessage.setText("New Ground Added Successfully...!!");
            groundName.clear();
            groundDesc.clear();
        }
    }
    @FXML
    private void addCountry(ActionEvent event) {
    stageManager.switchScene(FxmlView.COUNTRY);
    }

    @FXML
    void getGroundName(KeyEvent event) {
    successMessage.setText("");
    groundNameLbl.setText("");
    }
    @FXML
    private void cancel(ActionEvent event) {
        stageManager.switchScene(FxmlView.DASHBOARD);
    }

    public String getGroundName() {
        return groundName.getText();
    }

    public Long getGroundCountryId() { return groundService.findId(groundCountry.getValue()); }

    public String getGroundDesc() {
        return groundDesc.getText();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<String> contries = new ArrayList<>();
        for (String listcountries : groundService.findCountry()) {

            contries.add(listcountries);
        }
        groundCountry.getItems().addAll(contries);
    }
}
