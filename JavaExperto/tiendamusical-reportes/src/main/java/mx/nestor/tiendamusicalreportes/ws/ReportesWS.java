package mx.nestor.tiendamusicalreportes.ws;


import javax.ws.rs.*;
import org.springframework.stereotype.Component;

/**
 * @author NestorMonroy
 * WebService que contendra los metodos configurados como servicios del WS.
 */

@Component
@Path("/reportesWS")
public class ReportesWS {

    @GET
    @Path("/pruebaWS")
    public String pruebaWs(){
        return "Ingresando al webservices";
    }
}
