/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prizma.svevendas.dao;

import com.prizma.svevendas.jdbc.ConnectionDatabase;
import com.prizma.svevendas.model.ItemSales;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Daniel Koyote
 */
public class ItemSaleDAO {

    private Connection conn;
    
    public ItemSaleDAO() {
        this.conn = new ConnectionDatabase().putConnection();
    }
    
    public void save(ItemSales item) {
        try {
            String sql = "INSERT INTO tb_itensvendas(venda_id, produto_id, qtd, subtotal) VALUES (?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, item.getSales().getId());
            pst.setInt(2, item.getProduct().getId());
            pst.setInt(3, item.getQuantity());
            pst.setDouble(4, item.getSubtotal());
            pst.execute();
            pst.close();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar os itens da venda!");
        }
    }
    
}
