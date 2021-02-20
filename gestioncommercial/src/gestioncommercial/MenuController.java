/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncommercial;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class MenuController implements Initializable {

    @FXML
    private AnchorPane AnchorContent;
    @FXML
    private Button handleLoadViewUtilisateur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    public  void loadView(String view) throws IOException{
        //récupérer la vue
        AnchorPane viewLoading=FXMLLoader.load(getClass().getResource(view+".fxml"));
        //ajouter la vue dans le AnchorContent
        AnchorContent.getChildren().add(viewLoading);
    }

    @FXML
    private void handleLoadViewArticle(ActionEvent event) throws IOException {
         loadView("varticle");
    }

    @FXML
    private void handleLoadViewCategorie(ActionEvent event) throws IOException {
         loadView("vcategorie");
    }

    @FXML
    private void handleLoadViewCommande(ActionEvent event) throws IOException {
         loadView("vcommande");
    }

    @FXML
    private void handleLoadViewProfil(ActionEvent event) throws IOException {
         loadView("vprofil");
    }

    @FXML
    private void handleLoadViewUtilisateur(ActionEvent event) throws IOException {
         loadView("vinscription");
    }
    
}
