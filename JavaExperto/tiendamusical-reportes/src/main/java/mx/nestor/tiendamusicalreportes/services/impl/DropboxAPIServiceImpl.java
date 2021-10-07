package mx.nestor.tiendamusicalreportes.services.impl;

import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.DownloadErrorException;
import com.dropbox.core.v2.files.FileMetadata;
import mx.nestor.tiendamusicalreportes.services.DropboxAPIService;
import mx.nestor.tiendamusicalreportes.services.JasperReportsService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;

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

            //Se envia a compilar el archivo de jasper y se llena con la informacion de la base de datos
            this.jasperReportsServiceImpl.compilarReporteJasper(archivoBytes, orderID);
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
    public void cargarReporteToDropbox(DbxClientV2 dbxClientV2, String orderID, JasperPrint jasperPrint) {

    }
}
