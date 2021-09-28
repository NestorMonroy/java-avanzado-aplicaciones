package com.nestor.projectspringweb.test;


import com.nestor.projectspringweb.services.SpringService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author NestorMonroy
 * Clase de Prueba Unitaria con Spring y JUnit4.
 * NOTA: No tiene soporte Spring Test para JUnit5.
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-test.xml"}) //Ubicación de la aplicación context
public class SpringJUnit4Test {

    @Autowired
    private SpringService springServiceImp;

    @Test
    public void test() {
        //assertNotNull(this.springServiceImpl);
        System.out.println(this.springServiceImp.mostrarNombreEmpleado());

    }

}
