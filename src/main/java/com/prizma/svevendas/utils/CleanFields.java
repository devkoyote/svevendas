/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prizma.svevendas.utils;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author alenc
 */
public class CleanFields {

    public void cleanForm(JPanel container) {
        Component components[] = container.getComponents();
        // for -> components[]
        for(Component component : components) {
            if(component instanceof JTextField) {
                ((JTextField)component).setText(null);
            }
        }
    }
    
}
