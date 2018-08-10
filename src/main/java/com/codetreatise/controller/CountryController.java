package com.codetreatise.controller;

import com.codetreatise.bean.Country;
import com.codetreatise.config.StageManager;
import com.codetreatise.service.CountryService;
import com.codetreatise.view.FxmlView;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class CountryController implements Initializable{

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
	@FXML
	private AnchorPane countryBox;

	@FXML
	private JFXTextField countryName;

	@FXML
	private JFXTextArea countryDescription;

	@FXML
	private JFXButton countrybtn;

	@FXML
	private JFXButton countrybtn1;

	@FXML
	private Label successMessage;

	@FXML
	private Label nameLabel;

	@Autowired
	private CountryService countryService;

	@Lazy
	@Autowired
	private StageManager stageManager;

	@FXML
	void addCountry(ActionEvent event) {
		if(countryName.getText().isEmpty()){
			nameLabel.setText("Please Enter Country Name");
			countryName.requestFocus();
		}
	if(!countryName.getText().isEmpty()) {
		try {
			Country country = new Country();
			country.setCountryName(getCountryName());
			country.setCountryDescription(getCountryDescription());
			countryService.save(country);
		} catch (Exception e) {
			e.printStackTrace();
		}
		countryName.clear();
		countryDescription.clear();
		successMessage.setText("Country Inserted Successfully....!!!");
	 }
	}

	@FXML
	void cancel(ActionEvent event) {
		stageManager.switchScene(FxmlView.DASHBOARD);
	}

	@FXML
	void getCountryName(KeyEvent event) {
    successMessage.setText("");
    nameLabel.setText("");
	}

	public String getCountryName() {
		return countryName.getText();
	}

	public String getCountryDescription() {
		return countryDescription.getText();
	}
}
