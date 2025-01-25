/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prizma.svevendas.dao;

import com.prizma.svevendas.view.frmLoginSecurity;
import com.prizma.svevendas.view.frmMainScreen;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Koyote
 */
public class SecurityLoginDAO extends EmployeesDAO {
    
    public void accessSystem(String name, String passwd) {
        try {
            String sql = "SELECT nome, senha FROM tb_funcionarios WHERE nome=? AND senha=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, passwd);
            
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Confirmação do cadastro com sucesso!");;
                frmMainScreen fms = new frmMainScreen();
                fms.setVisible(true);
            }
            else {
                frmLoginSecurity fls = new frmLoginSecurity();
                JOptionPane.showMessageDialog(null, "Dados de cadastro incorretos! ");
                fls.setVisible(true);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "erro: " +e);
        }
    }
}
