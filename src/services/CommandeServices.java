/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Entities.Commande;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.Map;



/**
 *
 * @author laoui
 */
public class CommandeServices {
    
    private String restEventURL =  "http://localhost/symfony-api/web/app_dev.php/api/";
    Commande commande;
    public boolean resultOK;
    private ConnectionRequest req;
     
      public void ajoutCommande(Commande c) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/symfony-api/web/app_dev.php/api/commande/new?"
                + "date="+c.getDate()
                +"&etat="+c.getEtat()
                +"&typePaiement"+c.getTypePaiment()
                +"&panier_id"+c.getPanier_id()
                +"&utilisateur_id"+c.getUser_id();
        
        con.setUrl(Url);

        System.out.println("test");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
      
    public Commande getCommandeById(int idCommande){
        String url = "http://localhost/symfony-api/web/app_dev.php/api/commande/" + idCommande;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                System.out.println(new String(req.getResponseData()));
                commande = parseCommandeDetails(new String(req.getResponseData()));
                
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return commande;
    }
   
    public Commande parseCommandeDetails(String jsonText){
        try {
           // System.out.println(jsonText);
            commande = new Commande();
            JSONParser j = new JSONParser();
            //System.out.println("1");
            Map<String,Object> panierListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
                                                    
                String etat = panierListJson.get("etat").toString();
                commande.setEtat(etat);

                int user_id=Integer.parseInt(panierListJson.get("utilisateur_id").toString());
                commande.setUser_id(user_id);
                
                 int panier_id=Integer.parseInt(panierListJson.get("panier_id").toString());
                commande.setPanier_id(panier_id);
                
                commande.setTypePaiment(panierListJson.get("panier_id").toString());

        } catch (IOException ex) {
            
        }
        return commande;
    }
    
    }
    

