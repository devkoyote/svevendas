/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prizma.svevendas.model;

/**
 *
 * @author Daniel Koyote
 */
public class Sales {

    private int id;
    private Customers customers; // foreing key 
    private String date;
    private double total_sales;
    private String observations;
    
    // Getter and Setter
    public int  getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public Customers getCustomers() {
        return customers;
    }
    
    public void Customers(Customers customers) {
        this.customers = customers;
    }
    
    public String getDate() {
        return date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    
    public double getTotal_Sales() {
        return total_sales;
    }
    
    public void setTotal_Sales(double totalSales) {
        this.total_sales = totalSales;
    }
    
    public String getObservations() {
        return observations;
    }
    
    public void setObservations(String observations) {
        this.observations = observations;
    }
    
    
}
