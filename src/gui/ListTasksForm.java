/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.ui.FontImage;
import com.codename1.ui.Form;

/**
 *
 * @author laoui
 */
public class ListTasksForm extends Form{

    public ListTasksForm(Form previous) {
        setTitle("List tasks");
        
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK,e->previous.showBack());
    }
    
}
