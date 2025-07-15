package com.vinayak;

import com.vinayak.service.MenuManagementService;
import com.vinayak.service.FoodOrderService;
import com.vinayak.util.HibernateUtil;

import java.util.Scanner;

public class Canteen 
{

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        MenuManagementService menuService = new MenuManagementService();
        FoodOrderService orderService = new FoodOrderService();

        try {
            while (true) 
            {
                System.out.println("\n******** CANTEEN MANAGEMENT SYSTEM ********");
                System.out.println("1. Add Menu Item ");
                System.out.println("2. View Menu");
                System.out.println("3. Place Food Order ");
                System.out.println("4. View All Orders ");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) 
                {
                    case 1:
                        menuService.addMenuItem();
                        break;
                    case 2:
                        menuService.viewMenuItems();
                        break;
                    case 3:
                        orderService.placeOrder();
                        break;
                    case 4:
                        orderService.viewAllOrders();
                        break;
                    case 5:
                        System.out.println("Exiting... Thank you!");
                        return;
                    default:
                        System.out.println(" Invalid choice. Please try again.");
                }
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Unexpected error: " + e.getMessage());
        } 
        finally 
        {
            HibernateUtil.shutdown();
            scanner.close();
        }
    }
}
