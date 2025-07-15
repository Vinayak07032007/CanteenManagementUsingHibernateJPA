# 🍽️ CANTEEN MANAGEMENT SYSTEM  



The *Canteen Management System* is a *Java console application* using **Hibernate ORM** and **PostgreSQL**. It enables administrators to manage the menu, place student food orders, and view all orders efficiently. Built with JPA (Jakarta Persistence) and Maven, the system supports real-time stock updates and ensures a clean modular design.


It enables users to manage menu items and orders through a simple and intuitive **menu-driven interface**.  


---

# ✨ FEATURES

-  *ADD NEW MENU ITEM*: Insert new food items with price and stock.

-  *VIEW AVAILABLE FOOD MENU*: Display all items in the canteen with their prices and stock.

-  *PLACE FOOD ORDER*: Students can place food orders.

-  *VIEW ALL FOOD ORDERS*: Shows order history with quantities and total price.

-  *REAL-TIME STOCK UPDATES*:Stock is automatically reduced when an order is placed, ensuring accuracy in availability.

-  *DATABASE PERSISTENCE WITH HIBERNATE & POSTGRESQL*:All menu items and orders are stored persistently using Hibernate ORM with a PostgreSQL database.

-  *CONSOLE-BASED INTERACTIVE UI*:User-friendly console interface for students and admins to perform operations smoothly.



---

# 🛠 TECHNOLOGIES USED


- **Java 17+**: Core Java language features and console application development.

- **Hibernate ORM 7.0.5.Final**: Object-relational mapping for managing data persistence.

- **Jakarta Persistence 3.2.0**: Standard JPA API for ORM integration.

- **PostgreSQL 15+**: Relational database system to store menu and order records.

- **Apache Maven 3.8.6+**: Build automation and dependency management tool.


---

# 📦 DEPENDENCIES

If you're using Maven, include the following dependency:

```xml
# DEPENDENCIES
This project uses the following Maven dependency:

xml

<dependency>
    <groupId>org.hibernate.orm</groupId>
    <artifactId>hibernate-core</artifactId>
    <version>7.0.5.Final</version>
</dependency>


<dependency>
    <groupId>jakarta.persistence</groupId>
    <artifactId>jakarta.persistence-api</artifactId>
    <version>3.2.0</version>
</dependency>


<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.7.7</version>
</dependency>

```

---


# 📄 JPA CONFIGURATION

```xml

<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="https://jakarta.ee/xml/ns/persistence" version="3.1">
    <persistence-unit name="canteenPU" transaction-type="RESOURCE_LOCAL">
        <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>

        <class>com.vinayak.MenuItem</class>
        <class>com.vinayak.Order</class>

        <properties>
           
            <property name="jakarta.persistence.jdbc.driver" value="org.postgresql.Driver"/>
            <property name="jakarta.persistence.jdbc.url" value="jdbc:postgresql://localhost:5432/canteen"/>
            <property name="jakarta.persistence.jdbc.user" value="postgres"/>
            <property name="jakarta.persistence.jdbc.password" value="2007"/>

            
            <property name="hibernate.dialect" value="org.hibernate.dialect.PostgreSQLDialect"/>
            <property name="hibernate.hbm2ddl.auto" value="update"/>
            <property name="hibernate.show_sql" value="false"/>
        </properties>
    </persistence-unit>
</persistence>

```


---


# 🖥 PREREQUISITES

**Make sure the following tools are installed:**

-**✅ Java JDK 17+**

-**✅ PostgreSQL 15+**

-**✅ Apache Maven 3.8.6+**

-**✅ Internet connection (to download Maven dependencies on first build)**

-**✅ IDE like VS Code / IntelliJ IDEA (recommended for easier development)**



---


# 🗄 DATABASE SETUP
**Create a PostgreSQL database named canteen with the following tables:**

```sql

CREATE TABLE menus (
    fooditem VARCHAR(100) PRIMARY KEY,
    price NUMERIC,
    stock INT
);

CREATE TABLE foodorders (
    order_id SERIAL PRIMARY KEY,
    student_name VARCHAR(200) NOT NULL,
    item_name VARCHAR(300) NOT NULL,
    quantity INT NOT NULL,
    total_price NUMERIC NOT NULL
);

```
---

# 📂 PROJECT STRUCTURE

```bash
📦 MYMAVEN
└── 📁 src
    └── 📁 main
        ├── 📁 java
        │   └── 📁 com
        │       └── 📁 vinayak
        │           ├── 📄 Canteen.java                         
        │           ├── 📁 entity
        │           │   ├── 📄 MenuItem.java                     
        │           │   └── 📄 FoodOrder.java                   
        │           ├── 📁 service
        │           │   ├── 📄 MenuService.java                  
        │           │   └── 📄 OrderService.java                 
        │           └── 📁 util
        │               └── 📄 HibernateUtil.java                
        └── 📁 resources
            └── 📁 META-INF
                └── 📄 persistence.xml                           

```

---

# ▶️ HOW TO RUN


- *Make sure PostgreSQL is installed and running.*

- *Create the canteen database.*

- *Open the project in VS Code or IntelliJ.*

- *Update DB credentials in persistence.xml if needed.*

- *Open terminal and run:*
  mvn clean install

- *Then run the main file:* 
  Canteen.java


---

# 📬 CONTACT
-**Developer:** Vinayak Sonawane

-**Email:** vinayaksonawane377@gmail.com

-**GitHub:** Vinayak07032007

---

# 📷 SCREENSHOT


![Project](https://github.com/Vinayak07032007/CanteenManagementUsingHibernateJPA/blob/8b58c5dcb64787d3c99961ab973ce745b540eaf1/mymaven/Project2.png)
![Project](https://github.com/Vinayak07032007/CanteenManagementUsingHibernateJPA/blob/811db9d7187b288ee54de091fcaf4b0046b2869c/mymaven/Projectop.png)
=======

