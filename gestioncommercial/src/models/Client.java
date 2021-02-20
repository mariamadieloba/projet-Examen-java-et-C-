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
public class Client extends Personne{
    private int telephone;
    private String adresse;

    public Client() {
        super();
        type="client";
    }

    public Client(int telephone, String adresse, int id, String nom, String prenom) {
        super(id, nom, prenom);
        this.telephone = telephone;
        this.adresse = adresse;
        type="client";
    }

    public Client(int telephone, String adresse, String nom, String prenom) {
        super(nom, prenom);
        this.telephone = telephone;
        this.adresse = adresse;
        type="client";
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return super.toString()+"Adresse:"+adresse; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
