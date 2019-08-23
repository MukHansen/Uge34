/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Bruger
 */
public class MakeTestData {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        BankCustomer customer1 = new BankCustomer("Ib", "Ibsen", "24314", 202430, 3, "This is ib");
        BankCustomer customer2 = new BankCustomer("Bo", "Bosen", "4234", 23535, 4, "This is bo");
        BankCustomer customer3 = new BankCustomer("Benny", "Benner", "2525", 235453, 2, "This is benny");
        BankCustomer customer4 = new BankCustomer("Kurt", "Kurtsen", "25352", 23455, 1, "This is kurt");
        BankCustomer customer5 = new BankCustomer("Albert", "Albertsen", "25353", 4523, 5, "This is albert");
        try {
            em.getTransaction().begin();
            em.persist(customer1);
            em.persist(customer2);
            em.persist(customer3);
            em.persist(customer4);
            em.persist(customer5);
            em.getTransaction().commit();
            //Verify that BankCustomers are managed and has been given a database id
            System.out.println(customer1.getId());
            System.out.println(customer2.getId());

        } finally {
            em.close();
        }
    }
}
