/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author user
 */
public class User extends Personne {
    private String login;
    private String pwd;
    private Profil profil;
    private String nomProfil;

    public User() {
        type="User";
        
    }

   

    public User(String login, String pwd, int id, String nom, String prenom) {
        super(id, nom, prenom);
        this.login = login;
        this.pwd = pwd;
        type="User";
    }

  

    public User(String login, String pwd, String nom, String prenom) {
        super(nom, prenom);
        this.login = login;
        this.pwd = pwd;
        type="User";
    }

   

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
        this.nomProfil=profil.getLibelle();
    }
    
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return super.toString()+" profil:"+profil.getLibelle(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
