/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prizma.svevendas.dao;

import com.prizma.svevendas.jdbc.ConnectionDatabase;
import com.prizma.svevendas.model.Customers;
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

            String sql = "INSERT INTO tb_produtos(descricao, preco, qtd_estoque, for_id)" + ""
                    + " VALUES(?,?,?,?)";

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

            String sql = "UPDATE tb_produtos SET descricao=?, preco=?, qtd_estoque=?, for_id=?";

            // Prepared Statement connection
            PreparedStatement pst = con.prepareStatement(sql);
            // GET object to model
            pst.setString(1, prd.getDescribe());
            pst.setDouble(2, prd.getPrice());
            pst.setInt(3, prd.getQtd_Stock());
            pst.setInt(4, prd.getSuppliers().getId()); // foreing key
            
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
    public Customers Search(String name) {
        try {
            String sql = "SELECT * FROM tb_clientes WHERE nome=?";
            // Prepared Statement with connection
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            // ResultSet to get query
            ResultSet rs = pst.executeQuery();
            Customers ctm = new Customers();
            // IF RESULT -> NEXT (names of columns database)
            if (rs.next()) {
                ctm.setId(rs.getInt("id"));
                ctm.setName(rs.getString("nome"));
                ctm.setRg(rs.getString("rg"));
                ctm.setCpf(rs.getString("cpf"));
                ctm.setEmail(rs.getString("email"));
                ctm.setPhone(rs.getString("telefone"));
                ctm.setMovel(rs.getString("celular"));
                ctm.setCep(rs.getString("cep"));
                ctm.setAddress(rs.getString("endereco"));
                ctm.setNumberHouse(rs.getInt("numero"));
                ctm.setComplement(rs.getString("complemento"));
                ctm.setStreet(rs.getString("bairro"));
                ctm.setCity(rs.getString("cidade"));
                ctm.setState(rs.getString("estado"));

            }
            return ctm;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro a pesquisa cliente: " + e);
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
    public List<Customers> listSearchFilter(String name) {
        List<Customers> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tb_clientes WHERE nome like ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();

            // use next
            while (rs.next()) {
                // add new Customer
                Customers ctm = new Customers();
                ctm.setId(rs.getInt("id"));
                ctm.setName(rs.getString("nome"));
                ctm.setRg(rs.getString("rg"));
                ctm.setCpf(rs.getString("cpf"));
                ctm.setEmail(rs.getString("email"));
                ctm.setPhone(rs.getString("telefone"));
                ctm.setMovel(rs.getString("celular"));
                ctm.setCep(rs.getString("cep"));
                ctm.setAddress(rs.getString("endereco"));
                ctm.setNumberHouse(rs.getInt("numero"));
                ctm.setComplement(rs.getString("complemento"));
                ctm.setStreet(rs.getString("bairro"));
                ctm.setCity(rs.getString("cidade"));
                ctm.setState(rs.getString("estado"));
                // add customer in list
                list.add(ctm);
            }
            return list;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + e);
        }
        return null;
    }

}
