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
public class Commande {
    private int id;
    private String numero;
    private String dateCmd;
    private Client client;

    public Commande() {
    }

    public Commande(int id, String numero, String dateCmd) {
        this.id = id;
        this.numero = numero;
        this.dateCmd = dateCmd;
    }

    public Commande(String numero, String dateCmd) {
        this.numero = numero;
        this.dateCmd = dateCmd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDateCmd() {
        return dateCmd;
    }

    public void setDateCmd(String dateCmd) {
        this.dateCmd = dateCmd;
    }

   
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Commande{" + "numero=" + numero + ", dateCmd=" + dateCmd + '}';
    }

   
    
    
}
