/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prizma.svevendas.model;

/**
 *
 * @author Daniel Koyote
 */
public class Employees extends Customers {
    private String passwd;
    private String position;
    private String levelAccess;
    
    public String getPasswd() {
        return passwd;
    }
    
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    
    public String getPosition() {
        return position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }
    
    public String getLevelAccess() {
        return levelAccess;
    }
    
    public void setLevelAccess(String levelAccess) {
        this.levelAccess = levelAccess;
    }
    
}
