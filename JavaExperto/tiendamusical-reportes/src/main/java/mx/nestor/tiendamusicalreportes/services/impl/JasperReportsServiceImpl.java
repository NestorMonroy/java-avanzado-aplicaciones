package mx.nestor.tiendamusicalreportes.services.impl;

import mx.nestor.tiendamusicalreportes.services.JasperReportsService;
import net.sf.jasperreports.engine.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author NestorMonroy
 * Clase que implementa los metodos de logica de negocio de jasper reports.
 */
@Service
public class JasperReportsServiceImpl implements JasperReportsService {

    @Value("${spring.datasource.driverClassName}")
    String driver;

    @Value("${spring.datasource.url}")
    String url;

    @Value("${spring.datasource.username}")
    String user;

    @Value("${spring.datasource.password}")
    String password;

    @Override
    public JasperPrint compilarReporteJasper(ByteArrayOutputStream archivoBytes, String orderID) throws ClassNotFoundException, SQLException, JRException, IOException {
        //Se obtiene la imagen del archivo del classpath del proyecto
        InputStream imageInputStream = this.getClass().getClassLoader().getResourceAsStream("images/logo.png");

        Map<String, Object> map = new HashMap<>();

        //Se envían los parámetros de compilación para el archivo jrxml
        map.put("oderID", orderID);
        map.put("logo", imageInputStream);

        //Se convierte el archivo de salida en un flujo de bytes
        byte[] bytes = archivoBytes.toByteArray();
        InputStream archivoInputStream = new ByteArrayInputStream(bytes);
        //Se asignan los parámetros de conexión para el archivo de jasper.
        Class.forName(this.driver);
        Connection connection = DriverManager.getConnection(this.url, this.user, this.password);

        JasperReport jasperReport = JasperCompileManager.compileReport(archivoInputStream);

        assert imageInputStream != null;
        imageInputStream.close();
        archivoInputStream.close();

        return JasperFillManager.fillReport(jasperReport,map,connection);

    }
}
