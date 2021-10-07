package com.nestor.tiendamusicalweb.paypal;

import com.google.gson.Gson;
import com.nestor.tiendamusicalentities.entities.CarritoAlbum;
import com.nestor.tiendamusicalweb.session.SessionBean;
import com.paypal.http.HttpResponse;
import com.paypal.orders.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author NestorMonroy
 * Clase que se encarga de generar la estructura y la orden de la informacion
 * de la compra que desea realizar el usuario en PayPal.
 */
public class PayPalCreateOrder extends PayPalClient {
    /**
     * Objeto que permite mostrar los mensajes de LOG en la consola del servidor o en un archivo externo.
     */
    private static final Logger LOGGER = LogManager.getLogger(PayPalCreateOrder.class);

    /**
     * Objeto que contiene la orden de pago de la compra.
     */
    private OrderRequest orderRequest;

    /**
     * Método que se encarga de generar la orden de compra de los productos para el botón de paypal.
     *
     * @param sessionBean {@link SessionBean} objeto con la información del carrito del usuario en sesión.
     * @return {@link HttpResponse} objeto que obtiene una respuesta HTTP del servicio de paypal.
     * @throws IOException {@link IOException} excepción en caso de error al generar la transacción de compra con PayPal.
     */

    public HttpResponse<Order> crearOrden(SessionBean sessionBean) throws IOException {
        LOGGER.info("Ingresando a la función de crearOrden...");
        OrdersCreateRequest ordersCreateRequest = new OrdersCreateRequest();
        ordersCreateRequest.prefer("return=representation");
        ordersCreateRequest.requestBody(this.generarCuerpoOrden(sessionBean));

        HttpResponse<Order> response = client().execute(ordersCreateRequest);
        sessionBean.setOrder(response);
        return response;
    }

    /**
     * Método que permite generar el cuerpo de la información del formulario de pago de PayPal con el detalle de toda la transaccion.
     *
     * @param sessionBean {@link SessionBean} objeto con la información en sesión de los productos del carrito.
     * @return {@link OrderRequest} objeto con la solicitud de la orden de compra.
     */
    private OrderRequest generarCuerpoOrden(SessionBean sessionBean) {
        //Se genera el objeto de solicitud de la orden a mostrar con la información del carrito en paypal.
        this.orderRequest = new OrderRequest();

        //Cliente que realiza la aprobación de la compra.
        Payer payer = new Payer();
        this.orderRequest.checkoutPaymentIntent("CAPTURE");

        //Se configura la landingPage, el nombre de la empresa que vende el producto y la dirección de envio.
        ApplicationContext applicationContext = new ApplicationContext().brandName("TiendaMusical INC.")
                .landingPage("BILLING").shippingPreference("SET_PROVIDED_ADDRESS");

        this.orderRequest.applicationContext(applicationContext);

        //Se obtiene los datos personales del comprador.
        String nombre = sessionBean.getPersona().getNombre();
        String primerApellido = sessionBean.getPersona().getPrimerApellido();
        String segundoApellido = sessionBean.getPersona().getSegundoApellido();

        //Se crea la lista de unidades de compra a mostrarse en el formulario de PayPal.
        List<PurchaseUnitRequest> purchaseUnitRequests = new ArrayList<PurchaseUnitRequest>();
        List<Item> items = new ArrayList<Item>();

        //Se obtiene los productos seleccionados en el carrito de la persona o usuario en sesión.
        List<CarritoAlbum> carritoAlbums = sessionBean.getPersona().getCarrito().getCarritosAlbum();

        //Se definen las variables que indicaran los impuestos de la compra.
        double impuestoPorProducto = 10.00;
        double impuestoSumaTotalProductos = 0.0;

        //Se obtiene e iteran cada producto del carrito y se agregan al objeto item de PayPal para mostrarse en el detalle de compra de PayPal.
        for (CarritoAlbum carritoAlbum : carritoAlbums) {
            Item item = new Item();
            item.name(carritoAlbum.getAlbum().getNombre());
            String descripcionCorta = carritoAlbum.getAlbum().getDescripcion().substring(0, 50);
            item.description(descripcionCorta);
            item.unitAmount(new Money().currencyCode("MXN").value(String.valueOf(carritoAlbum.getAlbum().getValor())));
            item.tax(new Money().currencyCode("MXN").value(String.valueOf(impuestoPorProducto)));
            item.quantity(String.valueOf(carritoAlbum.getCantidad()));
            item.category("PHYSICAL_GOODS");
            item.sku("sku1");
            items.add(item);
            impuestoSumaTotalProductos += (impuestoPorProducto * carritoAlbum.getCantidad());
        }

        // Se configura el detalle de envío de los productos.
        ShippingDetail shippingDetail = new ShippingDetail();
        shippingDetail.name(new Name().fullName(nombre + " " + primerApellido + " " + segundoApellido));
        shippingDetail.addressPortable(new AddressPortable().addressLine1("Nombre calle")
                .addressLine2("Nombre Colonia")
                .adminArea1("Nombre Area1")
                .adminArea2("Nombre Area2")
                .postalCode("5555")
                .countryCode("MX"));

        //Se aplica un formato a la cantidad del total de compra de los productos.
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        double totalConDecimales = Double.parseDouble(decimalFormat.format(sessionBean.getTotalCompra()));

        double envio = 20.00;
        double handling = 10.00;
        double descuentoEnvio = 20.00;

        double totalCompraConImpuesto = totalConDecimales + impuestoSumaTotalProductos + handling + (envio - descuentoEnvio);

        //Se agrega la información calculada con los items en la unidad de compra.
        PurchaseUnitRequest purchaseUnitRequest = new PurchaseUnitRequest();
        purchaseUnitRequest.items(items);
        purchaseUnitRequest.shippingDetail(shippingDetail);
        purchaseUnitRequest.amountWithBreakdown(new AmountWithBreakdown()
                .currencyCode("MXN").value(String.valueOf(totalCompraConImpuesto))
                .amountBreakdown(new AmountBreakdown()
                        .itemTotal(new Money().currencyCode("MXN").value(String.valueOf(totalConDecimales)))
                        .shipping(new Money().currencyCode("MXN").value(String.valueOf(envio)))
                        .handling(new Money().currencyCode("MXN").value(String.valueOf(handling)))
                        .taxTotal(new Money().currencyCode("MXN").value(String.valueOf(impuestoSumaTotalProductos)))
                        .shippingDiscount(new Money().currencyCode("MXN").value(String.valueOf(descuentoEnvio)))));

        //Se agrega la unidad de compra a la lista y a la orden final de compra.
        purchaseUnitRequests.add(purchaseUnitRequest);
        this.orderRequest.purchaseUnits(purchaseUnitRequests);

        payer.addressPortable(purchaseUnitRequest.shippingDetail().addressPortable());
        this.orderRequest.payer(payer);
        Gson gson = new Gson();
        LOGGER.info(gson.toJson(purchaseUnitRequests));

        return this.orderRequest;
    }

}
