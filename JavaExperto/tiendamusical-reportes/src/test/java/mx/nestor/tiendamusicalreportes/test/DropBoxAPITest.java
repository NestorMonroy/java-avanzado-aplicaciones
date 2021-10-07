package mx.nestor.tiendamusicalreportes.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.users.FullAccount;

/**
 * @author NestorMonroy
 * Prueba Unitaria para verificar la comunicacion de una aplicativo java con DropBox.
 */
public class DropBoxAPITest {
    @Test
    public void test() {
        // Se configura el token de acceso a la APP creada en DROPBOX
        String TOKEN = "sl.A54xITmUN8kuUQpSXRMoez_1drmXWHrbrr4gQ4biLUqsOHaoEXe56C-v7SAAQRPNdptwhdkFfgbJz0-c6-9KdUM31XPqWu8Kev0KgaZjzt3N0fIdsPDUECCa4lUH_jR2ZVF-T2g";

        //Se configura el token y el ambiente de configuración inicial de DROPBOX
        DbxRequestConfig dbxRequestConfig = DbxRequestConfig.newBuilder("nestor/test-dropbox").build();
        DbxClientV2 dbxClientV2 = new DbxClientV2(dbxRequestConfig, TOKEN);

        try {
            assertNotNull(dbxClientV2);
            // Se obtiene y se muestra la información de la cuenta perteneciente a la APP
            FullAccount fullAccount = dbxClientV2.users().getCurrentAccount();
            System.out.println("Nombre de la cuenta: " + fullAccount.getEmail());
        } catch (DbxException e) {
            e.printStackTrace();
            assertNull(dbxClientV2);
        }
    }
}
