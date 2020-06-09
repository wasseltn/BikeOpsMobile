/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author laoui
 */
public class CommandeProduit {
    private int id;
    private int quantite;
    private int commande_id;
    private int produit_id;

    public CommandeProduit(int id, int quantite,int produit_id, int commande_id) {
        this.id = id;
        this.quantite = quantite;
        this.commande_id = commande_id;
        this.produit_id = produit_id;
        
    }

    public int getCommande_id() {
        return commande_id;
    }

    public void setCommande_id(int commande_id) {
        this.commande_id = commande_id;
    }

    public int getProduit_id() {
        return produit_id;
    }

    public void setProduit_id(int produit_id) {
        this.produit_id = produit_id;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "CommandeProduit{" + "id=" + id + ", quantite=" + quantite + ", commande_id=" + commande_id + ", produit_id=" + produit_id + '}';
    }

    
    
}
