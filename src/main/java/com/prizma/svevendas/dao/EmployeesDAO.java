/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prizma.svevendas.dao;

import com.prizma.svevendas.jdbc.ConnectionDatabase;
import com.prizma.svevendas.model.Customers;
import com.prizma.svevendas.model.Employees;
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
public class EmployeesDAO {

    // Connection JDBC
    Connection con;

    public EmployeesDAO() {
        this.con = new ConnectionDatabase().putConnection();
    }

    public void save(Employees emp) {
        try {

            String sql = "INSERT INTO tb_funcionarios(nome, rg, cpf, email, senha, cargo, nivel_acesso, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado)" + ""
                    + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            // Prepared Statement connection
            PreparedStatement pst = con.prepareStatement(sql);
            // GET object to model
            pst.setString(1, emp.getName());
            pst.setString(2, emp.getRg());
            pst.setString(3, emp.getCpf());
            pst.setString(4, emp.getEmail());
            pst.setString(5, emp.getPasswd());
            pst.setString(6, emp.getPosition());
            pst.setString(7, emp.getLevelAccess());
            pst.setString(8, emp.getPhone());
            pst.setString(9, emp.getMovel());
            pst.setString(10, emp.getCep());
            pst.setString(11, emp.getAddress());
            pst.setInt(12, emp.getNumberHouse());
            pst.setString(13, emp.getComplement());
            pst.setString(14, emp.getStreet());
            pst.setString(15, emp.getCity());
            pst.setString(16, emp.getState());

            // Execute put data
            pst.execute();
            pst.close();
            JOptionPane.showMessageDialog(null, "Funcionário salvo com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar salvar Funcionário: " + e);
        }

    }

    public void edit(Employees emp) {
        try {

            String sql = "UPDATE tb_funcionarios SET nome=?, rg=?, cpf=?, email=?, senha=?, cargo=?, nivel_acesso=?, telefone=?, celular=?, cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? WHERE id=?";

            // Prepared Statement connection
            PreparedStatement pst = con.prepareStatement(sql);
            // GET object to model
            pst.setString(1, emp.getName());
            pst.setString(2, emp.getRg());
            pst.setString(3, emp.getCpf());
            pst.setString(4, emp.getEmail());
            pst.setString(5, emp.getPasswd());
            pst.setString(6, emp.getPosition());
            pst.setString(7, emp.getLevelAccess());
            pst.setString(8, emp.getPhone());
            pst.setString(9, emp.getMovel());
            pst.setString(10, emp.getCep());
            pst.setString(11, emp.getAddress());
            pst.setInt(12, emp.getNumberHouse());
            pst.setString(13, emp.getComplement());
            pst.setString(14, emp.getStreet());
            pst.setString(15, emp.getCity());
            pst.setString(16, emp.getState());
            pst.setInt(17, emp.getId());

            // Execute put data
            pst.execute();
            pst.close();
            JOptionPane.showMessageDialog(null, "Funcionário editado com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar editar funcionário: " + e);
        }

    }
    
    // Delete Customers
    public void delete(Employees emp) {
    
        try {
            String sql = "DELETE FROM tb_funcionarios WHERE id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, emp.getId());
            pst.execute();
            pst.close();
            JOptionPane.showMessageDialog(null, "Funcionário excluido com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir funcionário! " +e);
        }
    
    }

    // Search Customer
    public Employees Search(String name) {
        try {
            String sql = "SELECT * FROM tb_funcionarios WHERE nome=?";
            // Prepared Statement with connection
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            // ResultSet to get query
            ResultSet rs = pst.executeQuery();
            Employees emp = new Employees();
            // IF RESULT -> NEXT (names of columns database)
            if (rs.next()) {
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("nome"));
                emp.setRg(rs.getString("rg"));
                emp.setCpf(rs.getString("cpf"));
                emp.setEmail(rs.getString("email"));
                emp.setPhone(rs.getString("telefone"));
                emp.setMovel(rs.getString("celular"));
                emp.setCep(rs.getString("cep"));
                emp.setAddress(rs.getString("endereco"));
                emp.setNumberHouse(rs.getInt("numero"));
                emp.setComplement(rs.getString("complemento"));
                emp.setStreet(rs.getString("bairro"));
                emp.setCity(rs.getString("cidade"));
                emp.setState(rs.getString("estado"));

            }
            return emp;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro a pesquisa funcionário: " + e);
        }

        return null;
    }

    // Method List 
    public List<Employees> listEmployees() {
        List<Employees> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tb_funcionarios";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            // use next
            while (rs.next()) {
                // add new Customer
                Employees emp = new Employees();
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("nome"));
                emp.setRg(rs.getString("rg"));
                emp.setCpf(rs.getString("cpf"));
                emp.setEmail(rs.getString("email"));
                emp.setPasswd(rs.getString("senha"));
                emp.setPosition(rs.getString("cargo"));
                emp.setLevelAccess(rs.getString("nivel_acesso"));
                emp.setPhone(rs.getString("telefone"));
                emp.setMovel(rs.getString("celular"));
                emp.setCep(rs.getString("cep"));
                emp.setAddress(rs.getString("endereco"));
                emp.setNumberHouse(rs.getInt("numero"));
                emp.setComplement(rs.getString("complemento"));
                emp.setStreet(rs.getString("bairro"));
                emp.setCity(rs.getString("cidade"));
                emp.setState(rs.getString("estado"));
                // add customer in list
                list.add(emp);
            }
            return list;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + e);
        }
        return null;
    }

    // Search List 
    public List<Employees> listSearchFilter(String name) {
        List<Employees> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tb_funcionarios WHERE nome like ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();

            // use next
            while (rs.next()) {
                // add new Customer
                Employees emp = new Employees();
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("nome"));
                emp.setRg(rs.getString("rg"));
                emp.setCpf(rs.getString("cpf"));
                emp.setEmail(rs.getString("email"));
                emp.setPhone(rs.getString("telefone"));
                emp.setMovel(rs.getString("celular"));
                emp.setCep(rs.getString("cep"));
                emp.setAddress(rs.getString("endereco"));
                emp.setNumberHouse(rs.getInt("numero"));
                emp.setComplement(rs.getString("complemento"));
                emp.setStreet(rs.getString("bairro"));
                emp.setCity(rs.getString("cidade"));
                emp.setState(rs.getString("estado"));
                // add customer in list
                list.add(emp);
            }
            return list;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + e);
        }
        return null;
    }

}
