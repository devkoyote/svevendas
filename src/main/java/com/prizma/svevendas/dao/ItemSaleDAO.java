/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prizma.svevendas.dao;

import com.prizma.svevendas.jdbc.ConnectionDatabase;
import com.prizma.svevendas.model.ItemSales;
import com.prizma.svevendas.model.Product;
import com.prizma.svevendas.model.Sales;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
    
    public List<ItemSales>listItems(int sales_id){
        try {
            List<ItemSales>list = new ArrayList<>();
            String sql = "SELECT p.id, p.descricao, i.qtd, p.preco, i.subtotal FROM tb_itensvendas AS i INNER JOIN tb_produtos AS p ON(i.produto_id=p.id) WHERE i.venda_id=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, sales_id);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                ItemSales item = new ItemSales();
                Product prd = new Product();
                
                prd.setId(rs.getInt("p.id"));
                item.setProduct(prd); // foreing key item -> product
                prd.setDescribe(rs.getString("p.descricao"));
                item.setQuantity(rs.getInt("i.qtd"));
                prd.setPrice(rs.getDouble("p.preco"));
                item.setSubtotal(rs.getInt("i.subtotal"));
                list.add(item);
                
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException("Não foi possivel criar a lista de itens "+e);
        }
    }
    
}
