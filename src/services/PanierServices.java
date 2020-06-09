/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Entities.Panier;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.statics;
/**
 *
 * @author laoui
 */
public class PanierServices {
    
    
    public ArrayList<Panier> panier;
    public Panier the_Panier;
    public static PanierServices instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private PanierServices() {
         req = new ConnectionRequest();
    }

    public static PanierServices getInstance() {
        if (instance == null) {
            instance = new PanierServices();
        }
        return instance;
    }
    
    
        
      public Panier getPanierById(int idPanier){
        String url = "http://localhost/symfony-api/web/app_dev.php/api/panier/" + idPanier;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                System.out.println(new String(req.getResponseData()));
                the_Panier = parsePanierDetails(new String(req.getResponseData()));
                
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return the_Panier;
    }
   
    public Panier parsePanierDetails(String jsonText){
        try {
           // System.out.println(jsonText);
            the_Panier = new Panier();
            JSONParser j = new JSONParser();
            //System.out.println("1");
            Map<String,Object> panierListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
                                     
                int total=Integer.parseInt(panierListJson.get("total").toString());
                the_Panier.setTotal(total);
               
                int id=Integer.parseInt(panierListJson.get("id").toString());
                the_Panier.setId(id);

                int user_id=Integer.parseInt(panierListJson.get("utilisateur_id").toString());
                the_Panier.setId(user_id);

        } catch (IOException ex) {
            
        }
        return the_Panier;
    }

   public void ajoutPanier(Panier p) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/symfony-api/web/app_dev.php/api/panier/new?"
                + "id="+p.getId()
                + "&utilisateur_id=" + p.getUser_id()
                +"&total=" + p.getTotal();
        
        con.setUrl(Url);

        System.out.println("this is ajouterPanier");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    } 
  
}
