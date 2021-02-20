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
import models.Admin;
import models.Client;
import models.Personne;
import models.Profil;
import models.User;

/**
 *
 * @author user
 */
public class DaoPersonne implements IDao<Personne>{
    private final String SQL_INSERT="INSERT INTO`personne` ( `profil_id`,`type`, `nom`, `prenom`,`login`,`pwd`,`telephone`,`adresse`) VALUES (?,?,?,?,?,?,?,?)";
    private final String SQL_SELECT_ALL_USER="select p.id,profil_id,nom,prenom,login,libelle from personne p,profil pro where profil_id=? and pro.id=p.profil_id";
    private final String SQL_SELECT_CLIENT="select * from personne where  telephone=?";
    private final String SQL_SELECT_USER="select * from personne where  type='User'";
    private final String SQL_SELECT_CONNECT="select * from personne where login=? and pwd=?";
     private DaoMySql mysql;

    public DaoPersonne() {
        mysql=new DaoMySql();
    }
    @Override
   public int insert(Personne pers){
         int nbreLigne=0;
        //Traitement Insertion
         try {
            //1-chargement du driver etouvrir connexion
            mysql.ouvrirConnexionBD();
            //preparer la requete
            mysql.preparerRequete(SQL_INSERT);
            //(facultative) Remplacer les variables de la requete par les valeurs
            //un objet vers la base de données
            mysql.getPs().setInt(1, ((User)pers).getProfil().getId());
             mysql.getPs().setString(2, pers.getType());
            mysql.getPs().setString(3, pers.getNom());
             mysql.getPs().setString(4, pers.getPrenom());
             mysql.getPs().setString(5, ((User)pers).getLogin());
             mysql.getPs().setString(6, ((User)pers).getPwd());
              mysql.getPs().setInt(7, ((Client)pers).getTelephone());
             mysql.getPs().setString(8, ((Client)pers).getAdresse());
               
            //Executer la requete
            //insert,select,update
            nbreLigne=mysql.executeMisAJour();
        } catch (SQLException ex) {
            Logger.getLogger(DaoPersonne.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            mysql.closeConnection();
        }
        return nbreLigne;
    }
    public List<User> findAll(Profil profil){
        List<User>lUsers=new ArrayList<>(); 
            try{
                    mysql.ouvrirConnexionBD();
                    mysql.preparerRequete(SQL_SELECT_ALL_USER);
                    //Executer la requete
                     mysql.getPs().setInt(1,profil.getId());
                    //une requete select() retourne toujours un resultset
                    ResultSet rs=mysql.executeSelect();
                    //Parcourir le resultat de la requete
                    while(rs.next()){
                     User user = new User();
                           //parcours et hydratation des elements
                           //BD vers objet
                           /*
                            rs.getInt("id"),
                           rs.getString("libelle"),
                           rs.getInt("nbre"));
                           */
                           user.setId(rs.getInt("id"));
                           user.setNom(rs.getString("nom"));
                           user.setPrenom(rs.getString("prenom"));
                           user.setLogin(rs.getString("login"));
                        Profil pro=new Profil();
                        pro.setLibelle(rs.getString("libelle"));
                        user.setProfil(pro);
                           //ajout dans la liste
                           lUsers.add(user);
                    }
            }catch (SQLException ex) {
                Logger.getLogger(DaoPersonne.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
            mysql.closeConnection();
        }
        //Remplir la liste
        return lUsers;
    }

      public Client findClientByTelephone(int telephone){
        Client client=null;
        //Recherche
        
        try {
             //1 ouvrir la connexion
            mysql.ouvrirConnexionBD();
            //2 preparer la requete
            mysql.preparerRequete(SQL_SELECT_CLIENT);
            mysql.getPs().setInt(1, telephone);
            ResultSet rs=mysql.executeSelect();
            if(rs.next()){
                client=new Client();
                client.setId(rs.getInt("id"));
                client.setNom(rs.getString("nom"));
                client.setPrenom(rs.getString("prenom"));
                client.setAdresse(rs.getString("adresse"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoPersonne.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            mysql.closeConnection();
        }
        return client;
    }
     public List<User> findUser(User user){
        List<User>lUsers=new ArrayList<>();
        try{
                    mysql.ouvrirConnexionBD();
                    mysql.preparerRequete(SQL_SELECT_USER);
                    //Executer la requete
                     mysql.getPs().setString(1, ((Personne)user).getType());
                    //une requete select() retourne toujours un resultset
                    ResultSet rs=mysql.executeSelect();
                    
                    //Parcourir le resultat de la requete
                    while(rs.next()){
                     user = new User();
                           //parcours et hydratation des elements
                           //BD vers objet
                           /*
                            rs.getInt("id"),
                           rs.getString("libelle"),
                           rs.getInt("nbre"));
                           */
                           user.setId(rs.getInt("id"));
                           user.setNom(rs.getString("nom"));
                           user.setPrenom(rs.getString("prenom"));
                           
                           //ajout dans la liste
                           lUsers.add(user);
                    }
            }catch (SQLException ex) {
                Logger.getLogger(DaoPersonne.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
            mysql.closeConnection();
        }
        //Remplir la liste
        return lUsers;
    }
    public Personne findUserConnect(String login,String pwd){
        Personne personne=null;
        
        try {
            mysql.ouvrirConnexionBD();
            //2 preparer la requete
            mysql.preparerRequete(SQL_SELECT_CONNECT);
            mysql.getPs().setString(1, login);
            mysql.getPs().setString(2, pwd);
            ResultSet rs=mysql.executeSelect();
            if(rs.next()){
                if(rs.getString("type").trim().compareTo("User")==0){
                    personne=new User();
                     personne.setId(rs.getInt("id"));
                     personne.setNom(rs.getString("nom"));
                     personne.setPrenom(rs.getString("prenom"));
                }else{
                    personne=new Admin(); 
                     personne.setId(rs.getInt("id"));
                     personne.setNom(rs.getString("nom"));
                     personne.setPrenom(rs.getString("prenom"));
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoPersonne.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            mysql.closeConnection();
        }

        return personne;
    }
  
     /*
     public int insertUser(User user){
        int nbreLigne=0;
        //Traitement Insertion
         try {
            //1-chargement du driver etouvrir connexion
            mysql.ouvrirConnexionBD();
            //preparer la requete
            mysql.preparerRequete(SQL_INSERT);
            //(facultative) Remplacer les variables de la requete par les valeurs
            //un objet vers la base de données
            mysql.getPs().setString(2, user.getType());
             mysql.getPs().setString(3, user.getNom());
              mysql.getPs().setString(4, user.getPrenom());
              mysql.getPs().setString(5, user.getLogin());
              mysql.getPs().setString(6, user.getPwd());
               mysql.getPs().setInt(1, user.getProfil().getId());
            //Executer la requete
            //insert,select,update
            nbreLigne=mysql.executeMisAJour();
        } catch (SQLException ex) {
            Logger.getLogger(DaoProfil.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            mysql.closeConnection();
        }
        return nbreLigne;   
    }
    public int insertClient(Client clt){
        int nbreLigne=0;
        //Traitement Insertion
         try {
            //1-chargement du driver etouvrir connexion
            mysql.ouvrirConnexionBD();
            //preparer la requete
            mysql.preparerRequete(SQL_INSERT);
            //(facultative) Remplacer les variables de la requete par les valeurs
            //un objet vers la base de données
            mysql.getPs().setString(2, clt.getType());
             mysql.getPs().setString(3, clt.getNom());
              mysql.getPs().setString(4, clt.getPrenom());
              mysql.getPs().setInt(7, clt.getTelephone());
              mysql.getPs().setString(8, clt.getAdresse());
               
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
   */
   
}
