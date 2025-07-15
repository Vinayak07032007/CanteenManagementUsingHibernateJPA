package com.vinayak.service;

import com.vinayak.entity.Order;
import com.vinayak.util.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Scanner;

public class FoodOrderService 
{

    private final Scanner scanner = new Scanner(System.in);
    private final MenuManagementService menuService = new MenuManagementService();

    public void placeOrder() 
    {
        System.out.print("Enter your name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter food item name: ");
        String itemName = scanner.nextLine();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); 

        if (!menuService.isItemAvailable(itemName, quantity)) 
        {
            System.out.println(" Requested quantity not available or item not found.");
            return;
        }

        Order order = new Order();
        order.setStudentName(studentName);
        order.setItemName(itemName);
        order.setQuantity(quantity);

        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try 
        {
            tx.begin();
            em.persist(order);
            tx.commit();
            menuService.reduceStock(itemName, quantity);
            System.out.println("Order placed successfully.");
        } 
        catch (Exception e) 
        {
            if (tx.isActive()) tx.rollback();
            System.out.println("Failed to place order: " + e.getMessage());
        } 
        finally 
        {
            em.close();
        }
    }

    public void viewAllOrders() 
    {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();

        try 
        {
            TypedQuery<Order> query = em.createQuery("FROM Order", Order.class);
            List<Order> orders = query.getResultList();

            if (orders.isEmpty()) 
            {
                System.out.println(" No orders found.");
            } 
            else 
            {
                System.out.println(" Orders:");
                for (Order order : orders) 
                {
                    System.out.printf("Order ID: %d | Name: %s | Item: %s | Qty: %d\n",
                            order.getId(), order.getStudentName(),
                            order.getItemName(), order.getQuantity());
                }
            }
        } 
        finally 
        {
            em.close();
        }
    }
}
