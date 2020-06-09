/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Entities.Task;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import utils.statics;

/**
 *
 * @author laoui
 */
public class ServiceTask {
    
    public boolean resultOK;
    public boolean addTask(Task t){
        String URL = statics.Base_URL+"/commande/"+t.getName()+"/"+t.getStatus();
        ConnectionRequest req = new ConnectionRequest(URL);
        req.addResponseListener(new ActionListener<NetworkEvent>(){
            
             @Override
        public void actionPerformed(NetworkEvent evt){
            resultOK=req.getResponseCode()==200;
        }
    });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    
}
