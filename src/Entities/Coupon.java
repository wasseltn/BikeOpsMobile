/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;


public class Coupon {
    
    String code;
    float pourcentage;

    public Coupon(String code, float pourcentage) {
        this.code = code;
        this.pourcentage = pourcentage;
        
    }

    public Coupon() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(float pourcentage) {
        this.pourcentage = pourcentage;
    }

    @Override
    public String toString() {
        return "Coupon{" + "code=" + code + ", pourcentage=" + pourcentage + '}';
    }
    
    
    
}
