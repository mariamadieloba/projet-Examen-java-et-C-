/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import dao.DaoArticle;
import dao.DaoCategorie;
import dao.DaoCommande;
import dao.DaoDetails;
import dao.DaoPersonne;
import dao.DaoProfil;
import java.util.List;
import models.Article;
import models.Categorie;
import models.Client;
import models.Commande;
import models.Details;
import models.Personne;
import models.Profil;
import models.User;

/**
 *
 * @author user
 */
public class Service {
    private DaoCategorie daoCategorie;
    private DaoArticle daoArticle;
    private DaoCommande daoCommande;
    private DaoProfil daoProfil;
    private DaoPersonne daoPersonne;
    private DaoDetails daoDetails;

    public Service() {
        daoCategorie=new DaoCategorie();
        daoArticle=new DaoArticle();
        daoCommande=new DaoCommande();
        daoProfil=new DaoProfil();
        daoPersonne=new DaoPersonne();
        daoDetails=new DaoDetails();
    }

    public boolean creerCategorie(Categorie categorie){
            int nbreLigne=daoCategorie.insert(categorie);
        return nbreLigne != 0;
            
    }
     public boolean creerProfil(Profil profil){
            int nbreLigne=daoProfil.insert(profil);
        return nbreLigne != 0;
            
    }
    public boolean creerArticle(Article article){
        int nbreLigne=daoArticle.insert(article);
        return nbreLigne != 0;
            
    }
    public boolean creerClient(Client client){
        return daoPersonne.insert(client)!=0;     
    }
     public boolean inscrire(User user){
        return daoPersonne.insert(user)!=0;     
    }
    public List<Profil> listerProfil(){
        return daoProfil.findAll();
    }
    public List<Categorie> listerCategorie(){
        return daoCategorie.findAll();
    }
   public List<User> listerUsers(Profil profil){
        return daoPersonne.findAll(profil);
    }
   public List<User> listerAllUsers(User user){
        return daoPersonne.findUser(user);
    }
   public List<Article> listerArticles(Categorie categorie){
        return daoArticle.findByCategorie(categorie);
    }
  
    public Client chercherClient(int telephone){
        return daoPersonne.findClientByTelephone(telephone);
    }
    public Article chercherArticle(String reference){
        return daoArticle.findArticleByReference(reference);
    }
    public boolean enregistrerCommande(Commande commande,Client client,Article article,int qteCommande,int prix,int montant){
        Details details=new Details(montant,prix,qteCommande,article,commande);
        return daoDetails.insert(details)!=0;   
    }
    public boolean creerCommande(Commande commande,Client client){
        if(client.getId()==0){
            int id= daoPersonne.insert(client);
            client.setId(id);
        }
        return daoCommande.insert(commande)!=0;
    }
    public List<Details> listerArticlesParCommande(Commande commande,Article article){
        Details details=new Details(article,commande);
        return daoDetails.findByCommande(details);
    }
    
    public Personne seConnecter(String login,String pwd){
        return daoPersonne.findUserConnect(login, pwd);
    }
    
}
