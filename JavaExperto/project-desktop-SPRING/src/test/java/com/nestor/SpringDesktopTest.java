package com.nestor;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.nestor.DAO.DisqueraDAO;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDesktopTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testContext() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        assertNotNull(context);
        //DisqueraDAO disqueraDAO = context.getBean("disqueraDAO");
        DisqueraDAO disqueraDAO = (DisqueraDAO) context.getBean("disqueraDAO");
        assertNotNull(disqueraDAO);;

        System.out.println("El Contexto cargo con exito :) ");
        System.out.println(disqueraDAO);

    }

}
