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
import models.Categorie;

/**
 *
 * @author user
 */
public class DaoArticle  implements IDao<Article> {
    private final String SQL_INSERT="INSERT INTO `article` ( `reference`,`libelle`, `stock`, `prix`,`categorie_id`) VALUES (?,?,?,?,?)";
    private final String SQL_SELECT_ALL="select art.id,reference,art.libelle,stock,prix,cat.libelle from article art,categorie cat where categorie_id=? and cat.id=art.classe_id";
    private final String SQL_SELECT_ARTICLE="select * from article where  reference=?";
    private DaoMySql mysql;

    public DaoArticle() {
        mysql=new DaoMySql();
    }
    
    public int insert(Article article){
        
            int nbreLigne=0;
         try {   
            //insertion
            
            //1-chargement du driver etouvrir connexion
            mysql.ouvrirConnexionBD();
            //preparer la requete
            mysql.preparerRequete(SQL_INSERT);
            //(facultative) Remplacer les variables de la requete par les valeurs
            //un objet vers la base de données
            mysql.getPs().setString(1, article.getReference());
            mysql.getPs().setString(2, article.getLibelle());
            mysql.getPs().setInt(3, article.getStock());
            mysql.getPs().setInt(4, article.getPrix());
            mysql.getPs().setInt(5, article.getCategorie().getId());
            //Executer la requete
            //insert,select,update
            nbreLigne=mysql.executeMisAJour();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoArticle.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            mysql.closeConnection();
        }
        
    return nbreLigne;  
    } 
    public List<Article> findByCategorie(Categorie categorie){
        List<Article> lArticles=new ArrayList<>();
        //recuperation
        
        try {
            //1 ouvrir la connexion
            mysql.ouvrirConnexionBD();
            //2 preparer la requete
            mysql.preparerRequete(SQL_SELECT_ALL);
            //vérification des parametres et injection dans la requete
            mysql.getPs().setInt(1,categorie.getId());
            //execution de la requete
            ResultSet rs=mysql.executeSelect();
            //etape de recuperation des informations de la requete
            while(rs.next()){
                //recuperer les données des articles
                Article art=new Article();
                art.setId(rs.getInt("id"));
                art.setReference(rs.getString("reference"));
                art.setLibelle(rs.getString("libelle"));
                art.setStock(rs.getInt("stock"));
                art.setPrix(rs.getInt("prix"));
                //recuperer les données de la categorie
                Categorie cat=new Categorie();
                cat.setLibelle(rs.getString("libelle"));
                //faire la relation
                art.setCategorie(cat);
                //ajouter l'étudiant dans la liste
                lArticles.add(art);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoPersonne.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            mysql.closeConnection();
        }
        return lArticles;
    }
     public Article findArticleByReference(String reference){
        Article article=null;
        //Recherche
        
        try {
             //1 ouvrir la connexion
            mysql.ouvrirConnexionBD();
            //2 preparer la requete
            mysql.preparerRequete(SQL_SELECT_ARTICLE);
            mysql.getPs().setString(1, reference);
            ResultSet rs=mysql.executeSelect();
            if(rs.next()){
                article=new Article();
                article.setId(rs.getInt("id"));
                article.setReference(rs.getString("reference"));
                article.setLibelle(rs.getString("libelle"));
                article.setStock(rs.getInt("stock"));
                article.setPrix(rs.getInt("prix"));
                Categorie categorie=new Categorie();
                categorie.setId(rs.getInt("id"));
                categorie.setLibelle(rs.getString("libelle"));
             
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoPersonne.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            mysql.closeConnection();
        }
        return article;
    }
}
