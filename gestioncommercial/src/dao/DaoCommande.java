/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Commande;

/**
 *
 * @author user
 */
public class DaoCommande  implements IDao<Commande>{
        private final String SQL_INSERT="INSERT INTO `commande` ( `numero`,`date_commande`,`client_id`) VALUES (?,?,?)";
        private DaoMySql mysql;

    public DaoCommande() {
        mysql=new DaoMySql();
    }
     public int insert(Commande cmd){
        
            int nbreLigne=0;
         try {   
            //insertion
            
            //1-chargement du driver etouvrir connexion
            mysql.ouvrirConnexionBD();
            //preparer la requete
            mysql.preparerRequete(SQL_INSERT);
            //(facultative) Remplacer les variables de la requete par les valeurs
            //un objet vers la base de données
            mysql.getPs().setString(1, cmd.getNumero());
            mysql.getPs().setString(2, cmd.getDateCmd());
            mysql.getPs().setInt(3, cmd.getClient().getId());
            //Executer la requete
            //insert,select,update
            nbreLigne=mysql.executeMisAJour();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoCommande.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            mysql.closeConnection();
        }
        
    return nbreLigne;  
    } 
        
    
}
