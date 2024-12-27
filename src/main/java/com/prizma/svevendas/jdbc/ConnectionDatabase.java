/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prizma.svevendas.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author alenc
 */
public class ConnectionDatabase {

    // URL = MYSQL CONNECTION
    final private String url = "jdbc:mysql://localhost/svevendas";
    final private String user = "root";
    final private String passwd = "hitler321";

    // Call class Connection sql and put connection
    public Connection putConnection() {
        try {
            return DriverManager.getConnection(url, user, passwd);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar: " + e);
        }
        return null;
    }
}
