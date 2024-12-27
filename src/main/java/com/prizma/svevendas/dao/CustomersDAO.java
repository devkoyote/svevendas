/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prizma.svevendas.dao;

import com.prizma.svevendas.jdbc.ConnectionDatabase;
import com.prizma.svevendas.model.Customers;
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
public class CustomersDAO {

    // Connection JDBC
    Connection con;

    public CustomersDAO() {
        this.con = new ConnectionDatabase().putConnection();
    }

    public void save(Customers ctm) {
        try {

            String sql = "INSERT INTO tb_clientes(nome, rg, cpf, email, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado)" + ""
                    + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

            // Prepared Statement connection
            PreparedStatement pst = con.prepareStatement(sql);
            // GET object to model
            pst.setString(1, ctm.getName());
            pst.setString(2, ctm.getRg());
            pst.setString(3, ctm.getCpf());
            pst.setString(4, ctm.getEmail());
            pst.setString(5, ctm.getPhone());
            pst.setString(6, ctm.getMovel());
            pst.setString(7, ctm.getCep());
            pst.setString(8, ctm.getAddress());
            pst.setInt(9, ctm.getNumberHouse());
            pst.setString(10, ctm.getComplement());
            pst.setString(11, ctm.getStreet());
            pst.setString(12, ctm.getCity());
            pst.setString(13, ctm.getState());

            // Execute put data
            pst.execute();
            pst.close();
            JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar salvar Cliente: " + e);
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
            if(rs.next()) {
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
            JOptionPane.showMessageDialog(null, "Erro a pesquisa cliente: " +e);
        }
        
        return null;
    }
    
    // Method List 
    public List<Customers> listCustomer() {
        List<Customers> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tb_clientes";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            // use next
            while(rs.next()) {
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
            JOptionPane.showMessageDialog(null, "Erro ao listar: "+e);
        }
        return null;
    }

}
