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
public class Panier {
    
    private int id;
   
    private int total;
    private int user_id;
    
    public Panier () {
        
    }

    public Panier(int id, int total,int user_id) {
        this.id = id;
        this.total = total;
        this.user_id = user_id;
    }

    public Panier(int total, int user_id) {
        this.total = total;
        this.user_id = user_id;
    }
    

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Panier{" + "id=" + id + ", total=" + total + ", user_id=" + user_id + '}';
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    
    
    
    
    
}
