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
public class LineItem {
    
    private int id;
    private int quantite;
    private int panier_id;
    private int produit_id;

    public LineItem(int id, int quantite, int panier_id, int produit_id) {
        this.id = id;
        this.quantite = quantite;
        this.panier_id = panier_id;
        this.produit_id = produit_id;
    }

    public int getPanier_id() {
        return panier_id;
    }

    public void setPanier_id(int panier_id) {
        this.panier_id = panier_id;
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
        return "LineItem{" + "id=" + id + ", quantite=" + quantite + ", panier_id=" + panier_id + ", produit_id=" + produit_id + '}';
    }

   
    
    
}
