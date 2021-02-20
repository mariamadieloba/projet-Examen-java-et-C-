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
public class Details {
    private Article article;
    private Commande commande;
    private int qteCommande;
    private int prix;
    private int montant;

    public Details() {
    }

    public Details(int qteCommande, int prix, int montant,Article article, Commande commande) {
        this.qteCommande = qteCommande;
        this.prix = prix;
        this.montant = montant;
        this.article = article;
        this.commande = commande;
        
    }

    public Details(Article article, Commande commande) {
        this.article = article;
        this.commande = commande;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public int getQteCommande() {
        return qteCommande;
    }

    public void setQteCommande(int qteCommande) {
        this.qteCommande = qteCommande;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }
    
}
