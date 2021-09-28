package com.nestor;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.nestor.DAO.DisqueraDAO;
import com.nestor.DAO.impl.DisqueraDAOImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Properties;

public class SpringDesktopTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testContext() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        assertNotNull(context);
        //DisqueraDAO disqueraDAO = context.getBean("disqueraDAO");

        DisqueraDAO disqueraDAOSinSpring = new DisqueraDAOImpl();

        DisqueraDAO disqueraDAO = (DisqueraDAO) context.getBean("disqueraDAO");
        assertNotNull(disqueraDAO);

        DisqueraDAO disqueraDAO1 = (DisqueraDAO) context.getBean("disqueraDAO");
        assertNotNull(disqueraDAO1);

        System.out.println("Singleton: Memoria optima");
        DisqueraDAO disqueraDAO01SinSpring = new DisqueraDAOImpl();
        System.out.println("El Contexto cargo con exito :) ");
        System.out.println("Soy disqueraDAO:" + disqueraDAO);
        System.out.println("Soy disqueraDAO1:" + disqueraDAO1);
        System.out.println("---");

        System.out.println("Java normal: Multiples objetos a llamar hacia virtual machine");
        System.out.println("Soy disqueraDAOSinSpring:" + disqueraDAOSinSpring);
        System.out.println("Soy disqueraDAO01SinSpring:" + disqueraDAO01SinSpring);

        //:::::: Properties :::::::::::

        //Properties properties =  context.getBean("propertiesNestor");
        Properties properties = (Properties) context.getBean("propertiesNestor");


        System.out.println("Soy properties : " +properties.get("spring-username"));

    }

}
