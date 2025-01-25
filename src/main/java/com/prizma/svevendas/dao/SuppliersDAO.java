/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prizma.svevendas.dao;

import com.prizma.svevendas.jdbc.ConnectionDatabase;
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
public class SuppliersDAO {

    // Connection JDBC
    Connection con;

    public SuppliersDAO() {
        this.con = new ConnectionDatabase().putConnection();
    }

    public void save(Suppliers sup) {
        try {

            String sql = "INSERT INTO tb_fornecedores(nome, cnpj, email, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado)" + ""
                    + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

            // Prepared Statement connection
            PreparedStatement pst = con.prepareStatement(sql);
            // GET object to model
            pst.setString(1, sup.getName());
            pst.setString(2, sup.getCnpj());
            pst.setString(3, sup.getEmail());
            pst.setString(4, sup.getPhone());
            pst.setString(5, sup.getMovel());
            pst.setString(6, sup.getCep());
            pst.setString(7, sup.getAddress());
            pst.setInt(8, sup.getNumberHouse());
            pst.setString(9, sup.getComplement());
            pst.setString(10, sup.getStreet());
            pst.setString(11, sup.getCity());
            pst.setString(12, sup.getState());

            // Execute put data
            pst.execute();
            pst.close();
            JOptionPane.showMessageDialog(null, "Fornecedores salvo com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar salvar Fornecedores: " + e);
        }

    }

    public void edit(Suppliers sup) {
        try {

            String sql = "UPDATE tb_fornecedores SET nome=?, cnpj=?, email=?, telefone=?, celular=?, cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? WHERE id=?";

            // Prepared Statement connection
            PreparedStatement pst = con.prepareStatement(sql);
            // GET object to model
            pst.setString(1, sup.getName());
            pst.setString(2, sup.getCnpj());
            pst.setString(3, sup.getEmail());
            pst.setString(4, sup.getPhone());
            pst.setString(5, sup.getMovel());
            pst.setString(6, sup.getCep());
            pst.setString(7, sup.getAddress());
            pst.setInt(8, sup.getNumberHouse());
            pst.setString(9, sup.getComplement());
            pst.setString(10, sup.getStreet());
            pst.setString(11, sup.getCity());
            pst.setString(12, sup.getState());
            pst.setInt(13, sup.getId());

            // Execute put data
            pst.execute();
            pst.close();
            JOptionPane.showMessageDialog(null, "Fornecedor editado com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar editar fornecedor: " + e);
        }

    }
    
    // Delete Customers
    public void delete(Suppliers sup) {
    
        try {
            String sql = "DELETE FROM tb_fornecedores WHERE id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, sup.getId());
            pst.execute();
            pst.close();
            JOptionPane.showMessageDialog(null, "Fornecedor excluido com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir fornecedor! " +e);
        }
    
    }

    // Search Suppliers
    public Suppliers Search(String name) {
        try {
            String sql = "SELECT * FROM tb_fornecedores WHERE nome=?";
            // Prepared Statement with connection
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            // ResultSet to get query
            ResultSet rs = pst.executeQuery();
            Suppliers sup = new Suppliers();
            // IF RESULT -> NEXT (names of columns database)
            if (rs.next()) {
                sup.setId(rs.getInt("id"));
                sup.setName(rs.getString("nome"));
                sup.setRg(rs.getString("cnpj"));
                sup.setEmail(rs.getString("email"));
                sup.setPhone(rs.getString("telefone"));
                sup.setMovel(rs.getString("celular"));
                sup.setCep(rs.getString("cep"));
                sup.setAddress(rs.getString("endereco"));
                sup.setNumberHouse(rs.getInt("numero"));
                sup.setComplement(rs.getString("complemento"));
                sup.setStreet(rs.getString("bairro"));
                sup.setCity(rs.getString("cidade"));
                sup.setState(rs.getString("estado"));

            }
            return sup;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar fornecedor: " + e);
        }

        return null;
    }

    // Method List 
    public List<Suppliers> listSuppliers() {
        List<Suppliers> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tb_fornecedores";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            // use next
            while (rs.next()) {
                // add new Customer
                Suppliers sup = new Suppliers();
                sup.setId(rs.getInt("id"));
                sup.setName(rs.getString("nome"));
                sup.setCnpj(rs.getString("cnpj"));
                sup.setEmail(rs.getString("email"));
                sup.setPhone(rs.getString("telefone"));
                sup.setMovel(rs.getString("celular"));
                sup.setCep(rs.getString("cep"));
                sup.setAddress(rs.getString("endereco"));
                sup.setNumberHouse(rs.getInt("numero"));
                sup.setComplement(rs.getString("complemento"));
                sup.setStreet(rs.getString("bairro"));
                sup.setCity(rs.getString("cidade"));
                sup.setState(rs.getString("estado"));
                // add customer in list
                list.add(sup);
            }
            return list;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + e);
        }
        return null;
    }

    // Search List 
    public List<Suppliers> listSearchFilter(String name) {
        List<Suppliers> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tb_fornecedores WHERE nome like ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();

            // use next
            while (rs.next()) {
                // add new Customer
                Suppliers sup = new Suppliers();
                sup.setId(rs.getInt("id"));
                sup.setName(rs.getString("nome"));
                sup.setRg(rs.getString("cnpj"));
                sup.setEmail(rs.getString("email"));
                sup.setPhone(rs.getString("telefone"));
                sup.setMovel(rs.getString("celular"));
                sup.setCep(rs.getString("cep"));
                sup.setAddress(rs.getString("endereco"));
                sup.setNumberHouse(rs.getInt("numero"));
                sup.setComplement(rs.getString("complemento"));
                sup.setStreet(rs.getString("bairro"));
                sup.setCity(rs.getString("cidade"));
                sup.setState(rs.getString("estado"));
                // add customer in list
                list.add(sup);
            }
            return list;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + e);
        }
        return null;
    }

}
