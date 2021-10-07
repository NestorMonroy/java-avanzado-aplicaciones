package mx.nestor.tiendamusicalreportes.services;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author NestorMonroy
 * Interface que contiene los metodos de logica de negocio para compilar y generar el reporte pdf.
 */
public interface JasperReportsService {
    /**
     * Método que permite compilar el archivo jasper jrxml descargado de Dropbox.
     * @param archivoBytes {@link ByteArrayOutputStream} archivo jrxml a compilar.
     * @param orderID {@link String} orden de pedido del cliente.
     * @return {@link JasperPrint} archivo jasper con la información a generarse en PDF.
     * @throws ClassNotFoundException {@link ClassNotFoundException} excepción en caso de error al encontrar el driver
     * @throws SQLException {@link SQLException} excepción en caso de error al conectarse a la base de datos.
     * @throws JRException  {@link JRException} excepción en caso de error al compilar el reporte de jasper.
     * @throws IOException {@link IOException} excepción en caso de error al cerrar el flujo de datos de los archivos.
     */
    JasperPrint compilarReporteJasper(ByteArrayOutputStream archivoBytes, String orderID) throws ClassNotFoundException, SQLException, JRException, IOException;
}
