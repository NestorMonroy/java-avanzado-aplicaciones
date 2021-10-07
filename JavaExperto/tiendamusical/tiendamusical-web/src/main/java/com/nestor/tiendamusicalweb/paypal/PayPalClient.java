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
            "Aff8i288wqQdtvtbod9RAmkLszsmVR-siK0mE4Pi_az1hPG5YPXe2QC9cGYS1UEDXCNkpy4BV2cRAL-u",
            "EH-z__ZROqNgGnqtSoUr2tAvl3oScwD-6HyJ6D70aw9eJTq7vq3czVdiE4XbKE_OQB--Cwe--lQNajRt");

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