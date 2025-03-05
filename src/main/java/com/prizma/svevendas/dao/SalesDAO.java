/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prizma.svevendas.dao;

import com.prizma.svevendas.jdbc.ConnectionDatabase;
import com.prizma.svevendas.model.Customers;
import com.prizma.svevendas.model.Sales;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
    
    public List<Sales>HistorySales(LocalDate start_date, LocalDate end_date){
        try {
            List<Sales>list = new ArrayList<>();
            String sql = "SELECT v.id, c.nome, date_format(v.data_venda, '%d%m%Y') AS data_formatada, v.total_venda, v.observacoes FROM tb_vendas AS v INNER JOIN tb_clientes AS c ON(v.cliente_id=c.id) WHERE v.data_venda BETWEEN ? AND ?";
            
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, start_date.toString());
            pst.setString(2, end_date.toString());
            
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                Sales sale = new Sales();
                Customers ctm = new Customers();
                sale.setId(rs.getInt("v.id"));
                ctm.setName(rs.getString("c.nome"));
                sale.setCustomers(ctm);
                sale.setDate(rs.getString("data_formatada"));
                sale.setTotal_sales(rs.getDouble("v.total_venda"));
                sale.setObservations(rs.getString("v.observacoes"));
                list.add(sale);
            }
            return list;    
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar historico de venda! "+e);
        }
        
    } 

}
