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
public class Article {
    private int id;
    private String reference;
    private String libelle;
    private int stock;
    private int prix;
    private Categorie cat;

    public Article() {
    }

    public Article(int id, String reference, String libelle, int stock, int prix) {
        this.id = id;
        this.reference = reference;
        this.libelle = libelle;
        this.stock = stock;
        this.prix = prix;
    }

    public Article(String reference, String libelle, int stock, int prix) {
        this.reference = reference;
        this.libelle = libelle;
        this.stock = stock;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public Categorie getCategorie() {
        return cat;
    }

    public void setCategorie(Categorie cat) {
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "Article{" + "reference=" + reference + ", libelle=" + libelle + ", stock=" + stock + ", prix=" + prix +" Categorie:"+cat.getLibelle()+'}';
    }
    
    
}
