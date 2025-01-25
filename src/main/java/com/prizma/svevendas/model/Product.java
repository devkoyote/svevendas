/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prizma.svevendas.model;

/**
 *
 * @author Daniel Koyote
 */
public class Product {

    private int id;
    private String describe;
    private double price;
    private int qtd_Stock;
    private Suppliers suppliers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQtd_Stock() {
        return qtd_Stock;
    }

    public void setQtd_Stock(int qtd_Stock) {
        this.qtd_Stock = qtd_Stock;
    }

    public Suppliers getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Suppliers suppliers) {
        this.suppliers = suppliers;
    }
    
    
    
}
