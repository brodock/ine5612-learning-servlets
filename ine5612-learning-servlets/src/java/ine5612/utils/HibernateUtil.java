/*
 * HibernateUtil.java
 *
 * Created on 20 de Fevereiro de 2007, 03:44
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package ine5612.utils;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.*;
import org.hibernate.cfg.*;

/**
 * Cria um único EntityManagerFactory para o projeto todo (SINGLETON)
 * @author brodock
 */
public class HibernateUtil {
    
    /**
     * Entity Manager Factory - JPA
     */
    private static final EntityManagerFactory entityManagerFactory;
    
    static {
        try {

            entityManagerFactory = Persistence.createEntityManagerFactory("ine5612");
            
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial EntityManagerFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    /**
     * Referencia para o Factory do Entity Manager (singleton)
     * @return Retorna o Factory do Entity Manager
     */
    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
    
}

