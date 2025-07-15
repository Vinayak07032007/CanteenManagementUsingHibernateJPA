package com.vinayak.service;

import com.vinayak.entity.MenuItem;
import com.vinayak.util.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Scanner;

public class MenuManagementService 
{

    private final Scanner scanner = new Scanner(System.in);

    public void addMenuItem() 
    {
        System.out.print("Enter food item name: ");
        String food = scanner.nextLine();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine(); 

        MenuItem item = new MenuItem();
        item.setFooditem(food);
        item.setPrice(price);
        item.setStock(stock);

        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try 
        {
            tx.begin();
            em.persist(item);
            tx.commit();
            System.out.println("Menu item added successfully.");
        } 
        catch (Exception e) 
        {
            if (tx.isActive()) tx.rollback();
            System.out.println("Error adding menu item: " + e.getMessage());
        } 
        finally 
        {
            em.close();
        }
    }

    public void viewMenuItems() 
    {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();

        try 
        {
            TypedQuery<MenuItem> query = em.createQuery("FROM MenuItem", MenuItem.class);
            List<MenuItem> items = query.getResultList();

            if (items.isEmpty()) {
                System.out.println(" No menu items found.");
            } 
            else 
            {
                System.out.println(" Menu Items:");
                for (MenuItem item : items) 
                {
                    System.out.printf("ID: %d | Item: %s | %.2f | Stock: %d\n",
                            item.getId(), item.getFooditem(), item.getPrice(), item.getStock());
                }
            }
        } 
        finally 
        {
            em.close();
        }
    }

    public boolean isItemAvailable(String itemName, int quantity) 
    {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();

        try 
        {
            TypedQuery<MenuItem> query = em.createQuery("SELECT m FROM MenuItem m WHERE LOWER(m.fooditem) = LOWER(:itemName)",MenuItem.class);
            query.setParameter("itemName", itemName);
            List<MenuItem> result = query.getResultList();

            if (!result.isEmpty()) 
            {
                MenuItem item = result.get(0);
                return item.getStock() >= quantity;
            }
        } 
        finally 
        {
            em.close();
        }

        return false;
    }

    public void reduceStock(String itemName, int quantity) 
    {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try 
        {
            tx.begin();
            TypedQuery<MenuItem> query = em.createQuery("SELECT m FROM MenuItem m WHERE LOWER(m.fooditem) = LOWER(:itemName)",MenuItem.class);
            query.setParameter("itemName", itemName);
            MenuItem item = query.getSingleResult();

            item.setStock(item.getStock() - quantity);
            em.merge(item);
            tx.commit();
        } 
        catch (Exception e) 
        {
            if (tx.isActive()) tx.rollback();
            System.out.println(" Failed to update stock.");
        } 
        finally 
        {
            em.close();
        }
    }
}
