package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Model model= new Model(); 
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtACorr;

    @FXML
    private TextArea txtAErr;

    @FXML
    private TextField txtAnagramma;

    @FXML
    void btnAnagrammi(ActionEvent event) {
    	txtACorr.setText(model.paroleGiuste(txtAnagramma.getText()).toString());
    	txtAErr.setText(model.paroleSbagliate(txtAnagramma.getText()).toString());
    }

    @FXML
    void btnReset(ActionEvent event) {
    	txtACorr.clear();
    	txtAErr.clear();
    	txtAnagramma.clear();
    }
    
    public void setModel(Model model) {
		this.model=model; 
		
	}

    @FXML
    void initialize() {
        assert txtACorr != null : "fx:id=\"txtACorr\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAErr != null : "fx:id=\"txtAErr\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagramma != null : "fx:id=\"txtAnagramma\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}
