/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;




public class Inventory {

    private List<Product> inventory;

    public Inventory() {
        inventory = new ArrayList<>();
        populateInventory();
    }

    public List<Product> getInventory() {
        return inventory;
    }

    public void addProductToInventory(Product newProduct) {
        inventory.add(newProduct);
    }

    public void removeProductFromInventory(String id) {
        inventory.removeIf(item -> item.getId().equals(id));
    }

    public Product getProductById(String id) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getId().equals(id)) {
                return inventory.get(i);
            }
        }
        return null;
    }
    
public static List<Product> readProductsFromUrl(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = httpURLConnection.getInputStream()) {
            return objectMapper.readValue(inputStream, objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
        } finally {
            httpURLConnection.disconnect();
        }
    }
   
   public  void populateInventory() {
        try {
             List<Product> products = Arrays.asList(
    new Product("Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops", "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg", "men's clothing", 109.95),
    new Product("Mens Casual Premium Slim Fit T-Shirts", "https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_.jpg", "men's clothing", 22.3),
    new Product("Mens Cotton Jacket", "https://fakestoreapi.com/img/71li-ujtlUL._AC_UX679_.jpg", "men's clothing", 55.99),
    new Product("Mens Casual Slim Fit", "https://fakestoreapi.com/img/71YXzeOuslL._AC_UY879_.jpg", "men's clothing", 15.99),
    new Product("John Hardy Women's Legends Naga Gold & Silver Dragon Station Chain Bracelet", "https://fakestoreapi.com/img/71pWzhdJNwL._AC_UL640_QL65_ML3_.jpg", "jewelery", 695),
    new Product("Solid Gold Petite Micropave", "https://fakestoreapi.com/img/61sbMiUnoGL._AC_UL640_QL65_ML3_.jpg", "jewelery", 168),
    new Product("White Gold Plated Princess", "https://fakestoreapi.com/img/71YAIFU48IL._AC_UL640_QL65_ML3_.jpg", "jewelery", 9.99),
    new Product("Pierced Owl Rose Gold Plated Stainless Steel Double", "https://fakestoreapi.com/img/51UDEzMJVpL._AC_UL640_QL65_ML3_.jpg", "jewelery", 10.99),
    new Product("WD 2TB Elements Portable External Hard Drive - USB 3.0", "https://fakestoreapi.com/img/61IBBVJvSDL._AC_SY879_.jpg", "electronics", 64),
    new Product("SanDisk SSD PLUS 1TB Internal SSD - SATA III 6 Gb/s", "https://fakestoreapi.com/img/61U7T1koQqL._AC_SX679_.jpg", "electronics", 109),
    new Product("Silicon Power 256GB SSD 3D NAND A55 SLC Cache Performance Boost SATA III 2.5", "https://fakestoreapi.com/img/71kWymZ+c+L._AC_SX679_.jpg", "electronics", 109),
    new Product("WD 4TB Gaming Drive Works with Playstation 4 Portable External Hard Drive", "https://fakestoreapi.com/img/61mtL65D4cL._AC_SX679_.jpg", "electronics", 114),
    new Product("Acer SB220Q bi 21.5 inches Full HD (1920 x 1080) IPS Ultra-Thin", "https://fakestoreapi.com/img/81QpkIctqPL._AC_SX679_.jpg", "electronics", 599),
    new Product("Samsung 49-Inch CHG90 144Hz Curved Gaming Monitor (LC49HG90DMNXZA) – Super Ultrawide Screen QLED", "https://fakestoreapi.com/img/81Zt42ioCgL._AC_SX679_.jpg", "electronics", 999.99),
    new Product("BIYLACLESEN Women's 3-in-1 Snowboard Jacket Winter Coats", "https://fakestoreapi.com/img/51Y5NI-I5jL._AC_UX679_.jpg", "women's clothing", 56.99),
    new Product("Lock and Love Women's Removable Hooded Faux Leather Moto Biker Jacket", "https://fakestoreapi.com/img/81XH0e8fefL._AC_UY879_.jpg", "women's clothing", 29.95),
    new Product("Rain Jacket Women Windbreaker Striped Climbing Raincoats", "https://fakestoreapi.com/img/71HblAHs5xL._AC_UY879_-2.jpg", "women's clothing", 39.99),
    new Product("MBJ Women's Solid Short Sleeve Boat Neck V", "https://fakestoreapi.com/img/71z3kpMAYsL._AC_UY879_.jpg", "women's clothing", 9.85),
    new Product("Opna Women's Short Sleeve Moisture", "https://fakestoreapi.com/img/51eg55uWmdL._AC_UX679_.jpg", "women's clothing", 7.95),
    new Product("DANVOUY Womens T Shirt Casual Cotton Short", "https://fakestoreapi.com/img/61pHAEJ4NML._AC_UX679_.jpg", "women's clothing", 12.99)
);
            this.inventory.addAll(products);
        } catch (Exception e) {
            e.printStackTrace();
        }
   }

}
