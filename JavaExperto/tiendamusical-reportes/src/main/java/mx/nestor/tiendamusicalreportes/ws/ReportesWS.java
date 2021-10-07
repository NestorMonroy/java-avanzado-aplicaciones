package mx.nestor.tiendamusicalreportes.ws;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import mx.nestor.tiendamusicalreportes.services.DropboxAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author NestorMonroy
 * WebService que contendra los metodos configurados como servicios del WS.
 */

@Component
@Path("/reportesWS")
public class ReportesWS {

    @Value("${spring.dropbox.access.token}")
    String ACCESS_TOKEN;

    @Autowired
    private DropboxAPIService dropboxAPIServiceImpl;

    @GET
    @Path("/pruebaWS")
    public String pruebaWs() {
        return "Ingresando al webservices";
    }

    @POST
    @Path("/generarReporte")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response generarReporte(@FormParam("oderID") String orderID, @FormParam("cliente") String cliente, @FormParam("destinatario") String destinatario) {

        DbxRequestConfig dbxRequestConfig = DbxRequestConfig.newBuilder("dropbox/nestor").build();
        DbxClientV2 dbxClientV2 = new DbxClientV2(dbxRequestConfig, ACCESS_TOKEN);

        Response response = this.dropboxAPIServiceImpl.descargarReporte(dbxClientV2, orderID, cliente);

        return response;

    }
}
