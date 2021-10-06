package com.nestor.tiendamusicalweb.paypal;

import com.paypal.core.PayPalEnvironment;
import com.paypal.core.PayPalHttpClient;
/**
 *
 * @author NestorMonroy
 * Clase Client de PayPal que configura las clases necesarias para realizar las transacciones
 * hacia PayPal y tambien el CLIENT ID y SECRET ID de acceso a la aplicacion de Sandbox.
 */
public class PayPalClient {

    /**
     *Set up the PayPal Java SDK environment with PayPal access credentials.
     *This sample uses SandboxEnvironment. In production, use LiveEnvironment.
     */
    private PayPalEnvironment environment = new PayPalEnvironment.Sandbox(
            "AdInxzUUQgvxB5ig4fZvRGPB5qdGiFF3zGxbpGTRY9bMJeo0F1NukBBc-HSDospt9-FosAgHEUSsLypA",
            "EGg4VEqPb96uVUr0_DJQ2yWX7aQUixxJuJ4Di186mbD0BldQo2bSu7sH0M0WLPA3SOPpdmLIw17JbO1K");

    /**
     *PayPal HTTP client instance with environment that has access
     *credentials context. Use to invoke PayPal APIs.
     */
    PayPalHttpClient client = new PayPalHttpClient(environment);

    /**
     *Method to get client object
     *
     *@return PayPalHttpClient client
     */
    public PayPalHttpClient client() {
        return this.client;
    }
}