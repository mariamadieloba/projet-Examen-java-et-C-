/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncommercial;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import metier.Service;
import models.Profil;
import models.User;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ProfilController implements Initializable {
     //mes attributs
        private Service metier;
        //observableList
        ObservableList<Profil> obProfils;
        ObservableList<User> obUsers;
    @FXML
    private Button handleCreerProfil;
    @FXML
    private TableColumn<String, Profil> tblcIdProfil;
    @FXML
    private TableColumn<String, Profil> tblcLibelleProfil;
    @FXML
    private TableColumn<String, User> tblcId;
    @FXML
    private TableColumn<String, User> tblcNom;
    @FXML
    private TableColumn<String, User> tblcPrenom;
    @FXML
    private TableColumn<String, User> tblcProfil;
    @FXML
    private TextField txtLibelle;
    @FXML
    private TableView<Profil> tblvProfil;
    @FXML
    private TableView<User> tblvUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
         metier=new Service();
        //chargement de l'observableList à partir de List de classe
        obProfils=FXCollections.observableArrayList(metier.listerProfil());
       loadTable();
    }    
     private void loadTable(){
         //la construction des cellules de la table
        tblcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblcLibelleProfil.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        
        //souscription de la tableview à l'observable
        tblvProfil.setItems(obProfils);
    }
    @FXML
    private void handleCreerProfil(ActionEvent event) {
          String libelle=txtLibelle.getText();
        Profil profil=new Profil(libelle);
        if(metier.creerProfil(profil)){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Classe ajoutée avec succés");
            alert.setTitle("Information");
            alert.show();
            //mettre à jour la tableview
            obProfils.add(profil);
        }else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Erreur Insertion");
            alert.setTitle("Erreur");
            alert.show();
        }
    }

    @FXML
    private void handleShowUser(MouseEvent event) {
        //recuperer la classe selectionnée
        Profil profilSelected=tblvProfil.getSelectionModel().getSelectedItem();
        obUsers=FXCollections.observableArrayList(metier.listerUsers(profilSelected));
        //construire les colonnes
         tblcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblcNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tblcPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        //souscription de la tableview à l'observable
        tblvUser.setItems(obUsers);
    }
    
}
