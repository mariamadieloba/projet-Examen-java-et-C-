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
import models.Article;
import models.Details;

/**
 *
 * @author user
 */
public class DaoDetails  implements IDao<Details> {
        private final String SQL_INSERT="INSERT INTO `details` ( `article_id`,`commande_id`,`qteCommande`,`prix`,`montant`) VALUES (?,?,?,?,?)";
         private final String SQL_SELECT_BY_COMMANDE="select article_id,libelle,qteCommande,prix,montant from article art,details det where article_id=? and art.id=det.article_id";
        private DaoMySql mysql;

    public DaoDetails() {
         mysql=new DaoMySql();
    }
      public int insert(Details details){
        int nbreLigne=0;
        try {
            //1-chargement du driver etouvrir connexion
            mysql.ouvrirConnexionBD();
            //preparer la requete
            mysql.preparerRequete(SQL_INSERT);
            //(facultative) Remplacer les variables de la requete par les valeurs
            //un objet vers la base de données
               mysql.getPs().setInt(1, details.getArticle().getId());
               mysql.getPs().setInt(2, details.getCommande().getId());
               mysql.getPs().setInt(3, details.getQteCommande());
               mysql.getPs().setInt(4, details.getPrix());
               mysql.getPs().setInt(5, details.getMontant());
            //Executer la requete
            //insert,select,update
            nbreLigne=mysql.executeMisAJour();
        } catch (SQLException ex) {
            Logger.getLogger(DaoDetails.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            mysql.closeConnection();
        }
         return nbreLigne;   
   
    }


 public List<Details> findByCommande(Details details){
        List<Details> lDetails=new ArrayList<>(); 
            try{
                    mysql.ouvrirConnexionBD();
                    mysql.preparerRequete(SQL_SELECT_BY_COMMANDE);
                    //Executer la requete
                     mysql.getPs().setInt(1,details.getArticle().getId());
                    //une requete select() retourne toujours un resultset
                    ResultSet rs=mysql.executeSelect();
                    //Parcourir le resultat de la requete
                    while(rs.next()){
                     Article article = new Article();
                           //parcours et hydratation des elements
                           //BD vers objet
                           /*
                            rs.getInt("id"),
                           rs.getString("libelle"),
                           rs.getInt("nbre"));
                           */
                           article.setId(rs.getInt("id"));
                           article.setLibelle(rs.getString("libelle"));
                        Details det=new Details();
                        det.setQteCommande(rs.getInt("qteCommande"));
                        det.setPrix(rs.getInt("prix"));
                        det.setMontant(rs.getInt("montant"));
                        det.setArticle(article);
                           //ajout dans la liste
                           lDetails.add(det);
                    }
            }catch (SQLException ex) {
                Logger.getLogger(DaoDetails.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
            mysql.closeConnection();
        }
        //Remplir la liste
        return lDetails;
    }
}