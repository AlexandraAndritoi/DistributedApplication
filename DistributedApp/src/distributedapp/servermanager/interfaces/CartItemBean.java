/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributedapp.servermanager.interfaces;

import java.io.Serializable;

/**
 *
 * @author Alexandra
 */
public class CartItemBean implements Serializable{
	
    private static final long serialVersionUID = 1L;
    
    private String title;
    private String description;
    private double unitCost;
    private int quantity;
    private double totalCost;
     
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String description() {
        return description;
    }
    public void setModelDescription(String description) {
        this.description = description;
    }
    public double getUnitCost() {
        return unitCost;
    }
    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getTotalCost() {
        return totalCost;
    }
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
