/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.Article;
import models.Categorie;
import models.Profil;
import models.User;


/**
 *
 * @author user
 */
public class TestDao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         // DaoCategorie daoCat=new DaoCategorie();
         //Categorie cat=new Categorie("Informatique");
        //daoCat.insert(cat);
       // DaoClasse daoClasse=new DaoClasse();
        //Classe classe=new Classe("IDC3",18);
        //daoClasse.insert(classe);
        //afficher les classes
       //daoCat.findAll().forEach((categorie) ->{
       // System.out.println(categorie);
    //});
         //List<Classe> classes=daoClasse.findAll();
       // for (Classe cl:classes){
      //      System.out.println(cl);
   // }
    DaoPersonne daoPers=new DaoPersonne();
   // List<User> lUsers=daoPers.findAll(profil);
     //  for (Professeur prof:classes){
        //    System.out.println(cl);
        //daoPers.findAll(new Profil(1)).forEach(System.out::println);
       System.out.println(daoPers.findClientByTelephone(773801205));
    }
    
    }
