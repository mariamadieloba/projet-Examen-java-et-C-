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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.TouchEvent;
import metier.Service;
import models.Profil;
import models.User;

/**
 * FXML Controller class
 *
 * @author user
 */
public class InscriptionController implements Initializable {
    //mes attributs
        private Service metier;
        //observableList
        ObservableList<User> obUsers;
         ObservableList<Profil> obProfils;
    @FXML
    private TextField txtLogin;
    @FXML
    private TextField txtPrenom;
    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtPwd;
    @FXML
    private ComboBox<Profil> cmbProfil;
    @FXML
    private TableView<User> tblvUsers;
    @FXML
    private TableColumn<User, String> tblcNom;
    @FXML
    private TableColumn<User, String> tblcPrenom;
    @FXML
    private TableColumn<User, String> tblcProfil;
    @FXML
    private TableColumn<User, String> tblcId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        metier=new Service();
        //chargement de l'observableList à partir de List de classe
        obProfils=FXCollections.observableArrayList(metier.listerProfil());
        cmbProfil.setItems(obProfils);
        obUsers=FXCollections.observableArrayList(metier.listerAllUsers(user));
      loadTable();
    } 
    private void loadTable(){
         //la construction des cellules de la table
        tblcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblcNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tblcPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
         tblcProfil.setCellValueFactory(new PropertyValueFactory<>("nomProfil"));
        //souscription de la tableview à l'observable
        tblvUsers.setItems(obUsers);
    } 
        

    @FXML
    private void handleCreerUser(ActionEvent event) {
          String nom=txtNom.getText();
         String prenom=txtPrenom.getText();
         String login=txtLogin.getText();
         String pwd=txtPwd.getText();
         Profil profil=this.cmbProfil.getValue();
         User user=new User(nom,prenom,login,pwd);
         user.setProfil(profil);
        if(metier.inscrire(user)){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Etudiant inscrit avec succés");
            alert.setTitle("Information");
            alert.show();
            //mettre à jour la tableview
            obUsers.add(user);
        }else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Erreur Insertion");
            alert.setTitle("Erreur");
            alert.show();
        }
    }

    @FXML
    private void handleAffiche(TouchEvent event) {
    }
    
}
