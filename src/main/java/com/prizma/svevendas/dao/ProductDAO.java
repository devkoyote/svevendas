/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prizma.svevendas.dao;

import com.prizma.svevendas.jdbc.ConnectionDatabase;
import com.prizma.svevendas.model.Product;
import com.prizma.svevendas.model.Suppliers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author alenc
 */
public class ProductDAO {

    // Connection JDBC
    Connection con;

    public ProductDAO() {
        this.con = new ConnectionDatabase().putConnection();
    }

    public void save(Product prd) {
        try {

            String sql = "INSERT INTO tb_produtos(descricao, preco, qtd_estoque, for_id)"
                    + "VALUES(?,?,?,?)";

            // Prepared Statement connection
            PreparedStatement pst = con.prepareStatement(sql);
            // GET object to model
            pst.setString(1, prd.getDescribe());
            pst.setDouble(2, prd.getPrice());
            pst.setInt(3, prd.getQtd_Stock());
            pst.setInt(4, prd.getSuppliers().getId()); // foreign key
            // Execute put data
            pst.execute();
            pst.close();
            JOptionPane.showMessageDialog(null, "Produto salvo com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar salvar Produto: " + e);
        }

    }

    public void edit(Product prd) {
        try {

            String sql = "UPDATE tb_produtos SET descricao=?, preco=?, qtd_estoque=?, for_id=? WHERE id=?";

            // Prepared Statement connection
            PreparedStatement pst = con.prepareStatement(sql);
            // GET object to model
            pst.setString(1, prd.getDescribe());
            pst.setDouble(2, prd.getPrice());
            pst.setInt(3, prd.getQtd_Stock());
            pst.setInt(4, prd.getSuppliers().getId()); // foreing key
            pst.setInt(5, prd.getId());
            
            // Execute put data
            pst.execute();
            pst.close();
            JOptionPane.showMessageDialog(null, "Produto editado com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar editar Produto: " + e);
        }

    }
    
    // Delete Customers
    public void delete(Product prd) {
    
        try {
            String sql = "DELETE FROM tb_produtos WHERE id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, prd.getId());
            pst.execute();
            pst.close();
            JOptionPane.showMessageDialog(null, "Produto excluido com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir Produto! " +e);
        }
    
    }

    // Search Customer
    public Product Search(String name) {
        try {
            String sql = "SELECT p.id, p.descricao, p.preco, p.qtd_estoque, f.nome FROM tb_produtos AS p INNER JOIN tb_fornecedores AS f ON(p.for_id=f.id) WHERE p.descricao = ?";
            // Prepared Statement with connection
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            // ResultSet to get query
            ResultSet rs = pst.executeQuery();
            Product prd = new Product();
            // Suppliers
            Suppliers sup = new Suppliers();
            // IF RESULT -> NEXT (names of columns database)
            if (rs.next()) {
                prd.setId(rs.getInt("p.id"));
                prd.setDescribe(rs.getString("p.descricao"));
                prd.setPrice(rs.getDouble("p.preco"));
                prd.setQtd_Stock(rs.getInt("p.qtd_estoque"));
                sup.setName(rs.getString("f.nome"));
                // config suppliers
                prd.setSuppliers(sup);
                
            }
            return prd;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar produto: " + e);
        }

        return null;
    }

    // Method List 
    public List<Product> listProduct() {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT p.id, p.descricao, p.preco, p.qtd_estoque, f.nome FROM tb_produtos AS p INNER JOIN tb_fornecedores AS f ON(p.for_id=f.id)";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            // use next
            while (rs.next()) {
                // add new Product
                Product prd = new Product();
                Suppliers sup = new Suppliers();
                prd.setId(rs.getInt("p.id"));
                prd.setDescribe(rs.getString("p.descricao"));
                prd.setPrice(rs.getDouble("p.preco"));
                prd.setQtd_Stock(rs.getInt("p.qtd_estoque"));
                sup.setName(rs.getString("f.nome"));
                prd.setSuppliers(sup); // pass the  foreing key
                // add product in list
                list.add(prd);
            }
            return list;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + e);
        }
        return null;
    }

    // Search List 
    public List<Product> listSearchFilter(String name) {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT p.id, p.descricao, p.preco, p.qtd_estoque, f.nome FROM tb_produtos AS p INNER JOIN tb_fornecedores AS f ON(p.for_id=f.id) WHERE p.descricao like ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();

            // use next
            while (rs.next()) {
                // add new Customer
                Product prd = new Product();
                Suppliers sup = new Suppliers();
                
                prd.setId(rs.getInt("p.id"));
                prd.setDescribe(rs.getString("p.descricao"));
                prd.setPrice(rs.getDouble("p.preco"));
                prd.setQtd_Stock(rs.getInt("p.qtd_estoque"));
                
                sup.setName(rs.getString("f.nome"));
                prd.setSuppliers(sup);
                // add product in list
                list.add(prd);
            }
            return list;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + e);
        }
        return null;
    }

}
