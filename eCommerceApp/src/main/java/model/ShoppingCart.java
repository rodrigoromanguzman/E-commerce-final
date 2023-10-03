/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.*;

/**
 *
 * @author rodrigoroman
 */
public class ShoppingCart {
    private List<Transaction> cart;
    
    public ShoppingCart(){
        cart = new ArrayList();
    }

    public List<Transaction> getCart() {
        return cart;
    }
    
    public void addTransactionToCart(Transaction newTransaction){
        cart.add(newTransaction); 
    }
    public void removeById(String id){
        cart.removeIf(item->item.getId().equals(id));
    }
}
