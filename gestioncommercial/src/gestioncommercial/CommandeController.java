/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncommercial;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author user
 */
public class CommandeController implements Initializable {

    @FXML
    private TextField txtPrenom;
    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtTelephone;
    @FXML
    private TextField txtAdresse;
    @FXML
    private TextField txtNomClient;
    @FXML
    private TextField txtPrenomClient;
    @FXML
    private TextField txtAdresseClient;
    @FXML
    private TextField txtTelephoneClient;
    @FXML
    private TextField txtLibelle;
    @FXML
    private TextField txtQuantiteStock;
    @FXML
    private TextField txtQuantiteCommande;
    @FXML
    private TextField txtReference;
    @FXML
    private TableView<?> tblvDetails;
    @FXML
    private TableColumn<?, ?> tblcId;
    @FXML
    private TableColumn<?, ?> tblcLibelle;
    @FXML
    private TableColumn<?, ?> tblcQuantiteCommande;
    @FXML
    private TableColumn<?, ?> tblcPrix;
    @FXML
    private TableColumn<?, ?> tblcMontant;
    @FXML
    private TextField txtNumero;
    @FXML
    private DatePicker txtDate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnCreerCommande(ActionEvent event) {
    }

    @FXML
    private void btnRechercherClient(ActionEvent event) {
    }

    @FXML
    private void btnEnregistrerCommande(ActionEvent event) {
    }
    
}
