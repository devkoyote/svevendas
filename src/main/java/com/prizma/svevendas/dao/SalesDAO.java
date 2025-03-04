/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prizma.svevendas.dao;

import com.prizma.svevendas.jdbc.ConnectionDatabase;
import com.prizma.svevendas.model.Sales;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Koyote
 */
public class SalesDAO {

    private Connection con;

    public SalesDAO() {
        this.con = new ConnectionDatabase().putConnection();
    }

    public void save(Sales sales) {
        try {
            String sql = "INSERT INTO tb_vendas (cliente_id, data_venda, total_venda, observacoes) VALUES(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            // Foreing key
            pst.setInt(1, sales.getCustomers().getId());
            pst.setString(2, sales.getDate());
            pst.setDouble(3, sales.getTotal_sales());
            pst.setString(4, sales.getObservations());
            pst.execute();
            pst.close();
            JOptionPane.showMessageDialog(null, "Venda realizada com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar venda ! " + e);
        }
    }

    public int returnLastSaleId() {
        try {
            int lastId = 0;
            String sql = "SELECT MAX(id) id FROM tb_vendas";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Sales sales = new Sales();
                sales.setId(rs.getInt("id"));
                lastId = sales.getId();
            }
            return lastId;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao retorna o ultimo id da venda!");
        }
    }

}
