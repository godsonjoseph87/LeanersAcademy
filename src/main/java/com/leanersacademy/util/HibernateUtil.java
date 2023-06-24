package com.leanersacademy.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory buildSessionFactory(){
        try{
            return new Configuration().configure().buildSessionFactory();
        }catch (Throwable e){
            System.out.println("Initial SesionFactory creation failed" + e);
            throw new RuntimeException();
        }
    }

    

}
