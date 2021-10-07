package mx.nestor.tiendamusicalreportes.services.impl;

import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.DownloadErrorException;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.UploadBuilder;
import com.dropbox.core.v2.files.WriteMode;
import mx.nestor.tiendamusicalreportes.services.DropboxAPIService;
import mx.nestor.tiendamusicalreportes.services.JasperReportsService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.io.*;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author NestorMonroy
 * Clase que implementa los metodos para realizar la logica de negocio para descargar y cargar reportes con Dropbox.
 */

@Service
public class DropboxAPIServiceImpl implements DropboxAPIService {

    @Value("${spring.dropbox.directorio.reportes}")
    String DIRECTORIO_REPORTES;

    @Value("${spring.dropbox.archivo.jrxml}")
    String ARCHIVO_JASPER_JRXML;

    @Autowired
    private JasperReportsService jasperReportsServiceImpl;

    @Override
    public Response descargarReporte(DbxClientV2 dbxClientV2, String orderID, String cliente) {
        ByteArrayOutputStream archivoBytes = new ByteArrayOutputStream();
        String mensaje = null;
        try {
            //Se descarga el archivo jrxml de DropBox
            DbxDownloader<FileMetadata> downloader = dbxClientV2.files().download(DIRECTORIO_REPORTES + ARCHIVO_JASPER_JRXML);
            downloader.download(archivoBytes);
            mensaje = "Comprobante se ha generado exitosamente";

            //Se envía a compilar el archivo de jasper y se llena con la información de la base de datos
            JasperPrint jasperPrint =  this.jasperReportsServiceImpl.compilarReporteJasper(archivoBytes, orderID);

            //Se realiza la carga del reporte PDF a dropbox
            this.cargarReporteToDropbox(dbxClientV2,orderID,cliente, jasperPrint);
        } catch (DownloadErrorException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        } catch (DbxException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        } catch (IOException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        } catch (JRException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
        return Response.status(Response.Status.OK).entity(mensaje).build();

    }

    @Override
    public void cargarReporteToDropbox(DbxClientV2 dbxClientV2, String orderID, String cliente, JasperPrint jasperPrint) throws IOException, JRException, DbxException {

        String nombreArchivoPDF = orderID + ".pdf";

        File filePDF = File.createTempFile("temp", nombreArchivoPDF);

        InputStream archivoExport = new FileInputStream(filePDF);

        JRPdfExporter jrPdfExporter = new JRPdfExporter();
        jrPdfExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        jrPdfExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(filePDF));

        SimplePdfReportConfiguration simplePdfReportConfiguration = new SimplePdfReportConfiguration();
        jrPdfExporter.setConfiguration(simplePdfReportConfiguration);

        jrPdfExporter.exportReport();

        //Se realiza la carga de archivos a dropbox
        UploadBuilder uploadBuilder = dbxClientV2.files().uploadBuilder(DIRECTORIO_REPORTES + "/" + cliente + "/" + nombreArchivoPDF);
        uploadBuilder.withClientModified(new Date(filePDF.lastModified())); //La última fecha de modificación
        uploadBuilder.withMode(WriteMode.ADD);
        uploadBuilder.withAutorename(true); //Se renombre el archivo por doble

        uploadBuilder.uploadAndFinish(archivoExport);

        archivoExport.close();

    }
}
