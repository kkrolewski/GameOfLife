/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.lab.kkrolewski.gameoflife.controller;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import pl.polsl.lab.kkrolewski.gameoflife.model.PlayerEntity;
/**
 *
 * @author Krzysiek
 */
public class EntityController {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("prod");

    

    
     public static void main(String[] args){
        PlayerEntity person = new PlayerEntity();
        person.setName("tadek");
        EntityController main = new EntityController();
        main.persist(person);
    }

    public void persist(Object object) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }


   
}
