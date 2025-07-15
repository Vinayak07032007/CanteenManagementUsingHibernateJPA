package com.vinayak.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "foodorders")
public class Order 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "total_price")
    private Double totalPrice = 0.0;

    public Order() 
    {

    }

    public Order(String studentName, String itemName, Integer quantity, Double totalPrice) 
    {
        this.studentName = studentName;
        this.itemName = itemName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public int getId() 
    {
        return id;
    }

    public String getStudentName() 
    {
        return studentName;
    }

    public String getItemName() 
    {
        return itemName;
    }

    public Integer getQuantity() 
    {
        return quantity;
    }

    public Double getTotalPrice() 
    {
        return totalPrice;
    }

   
    public void setStudentName(String studentName) 
    {
        this.studentName = studentName;
    }

    public void setItemName(String itemName) 
    {
        this.itemName = itemName;
    }

    public void setQuantity(Integer quantity) 
    {
        this.quantity = quantity;
    }

    public void setTotalPrice(Double totalPrice) 
    {
        this.totalPrice = totalPrice;
    }
}
