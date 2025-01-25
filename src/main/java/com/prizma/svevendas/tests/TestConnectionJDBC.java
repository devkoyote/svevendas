/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prizma.svevendas.tests;

import com.prizma.svevendas.jdbc.ConnectionDatabase;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author alenc
 */
public class TestConnectionJDBC {

    public static void main(String[] args) {

        try {
            new ConnectionDatabase().putConnection();
            JOptionPane.showMessageDialog(null, "Conectado ao banco de dados");
            
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados" + e.getMessage());
        }
    }
}
