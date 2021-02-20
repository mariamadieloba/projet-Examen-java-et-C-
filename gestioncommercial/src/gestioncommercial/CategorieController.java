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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author user
 */
public class CategorieController implements Initializable {

    @FXML
    private TableView<?> tblvCategories;
    @FXML
    private TableColumn<?, ?> tblcId;
    @FXML
    private TableColumn<?, ?> tblcLibelle;
    @FXML
    private TableView<?> tblvArticles;
    @FXML
    private TableColumn<?, ?> tblcReference;
    @FXML
    private TableColumn<?, ?> tblcLibelleArticle;
    @FXML
    private TableColumn<?, ?> tblcQuantité;
    @FXML
    private TableColumn<?, ?> tblcPrix;
    @FXML
    private TextField txtLibelle;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleCreerCategorie(ActionEvent event) {
    }
    
}
