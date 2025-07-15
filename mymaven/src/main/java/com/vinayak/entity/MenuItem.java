package com.vinayak.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "menus")
public class MenuItem 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fooditem")
    private String fooditem;

    @Column(name = "price")
    private double price;

    @Column(name = "stock")
    private int stock;

    public MenuItem() 
    {
        
    }

    public MenuItem(String fooditem, double price, int stock) 
    {
        this.fooditem = fooditem;
        this.price = price;
        this.stock = stock;
    }

  
    public int getId() 
    {
        return id;
    }

    public String getFooditem() 
    {
        return fooditem;
    }

    public void setFooditem(String fooditem) 
    {
        this.fooditem = fooditem;
    }

    public double getPrice() 
    {
        return price;
    }

    public void setPrice(double price) 
    {
        this.price = price;
    }

    public int getStock() 
    {
        return stock;
    }

    public void setStock(int stock) 
    {
        this.stock = stock;
    }
}
