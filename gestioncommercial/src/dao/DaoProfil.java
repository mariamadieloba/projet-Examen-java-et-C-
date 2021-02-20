/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Profil;

/**
 *
 * @author user
 */
public class DaoProfil  implements IDao<Profil> {
         private final String SQL_INSERT="INSERT INTO`Profil` ( `libelle`) VALUES (?)";
         private final String SQL_SELECT_ALL="select * from profil";
         private DaoMySql mysql;

    public DaoProfil() {
         mysql=new DaoMySql();
    }
     @Override
    public int insert(Profil profil){
        int nbreLigne=0;
        
         //insertion
           
        try {
            //1-chargement du driver etouvrir connexion
            mysql.ouvrirConnexionBD();
            //preparer la requete
            mysql.preparerRequete(SQL_INSERT);
            //(facultative) Remplacer les variables de la requete par les valeurs
            //un objet vers la base de données
            mysql.getPs().setString(1, profil.getLibelle());
            //Executer la requete
            //insert,select,update
            nbreLigne=mysql.executeMisAJour();
        } catch (SQLException ex) {
            Logger.getLogger(DaoCategorie.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            mysql.closeConnection();
        }
         return nbreLigne;  
        
    }
     public List<Profil> findAll(){
        List<Profil>lProfils=new ArrayList<>(); 
            try{
                    mysql.ouvrirConnexionBD();
                    mysql.preparerRequete(SQL_SELECT_ALL);
                    //Executer la requete
                    //une requete select() retourne toujours un resultset
                    ResultSet rs=mysql.executeSelect();
                    //Parcourir le resultat de la requete
                    while(rs.next()){
                     Profil profil = new Profil();
                           //parcours et hydratation des elements
                           //BD vers objet
                           /*
                            rs.getInt("id"),
                           rs.getString("libelle"),
                           rs.getInt("nbre"));
                           */
                           profil.setId(rs.getInt("id"));
                           profil.setLibelle(rs.getString("libelle"));
                         
                           //ajout dans la liste
                           lProfils.add(profil);
                    }
            }catch (SQLException ex) {
                Logger.getLogger(DaoCategorie.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
            mysql.closeConnection();
        }
        //Remplir la liste
        return lProfils;
    }
    
    
}
