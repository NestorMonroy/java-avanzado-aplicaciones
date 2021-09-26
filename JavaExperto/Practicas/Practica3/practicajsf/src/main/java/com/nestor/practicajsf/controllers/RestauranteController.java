package com.nestor.practicajsf.controllers;

import com.nestor.practicajsf.entity.Restaurante;
import com.nestor.practicajsf.services.RestauranteService;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean
@ViewScoped
public class RestauranteController {
    /**RestauranteController
     * Lista de restaurantes para la tabla.
     */
    private List<Restaurante> restaurantes;
    /**
     * Lista de restaurantes filtrados.
     */
    private List<Restaurante> empleadosFiltrados;
    /**
     * Servicio con los metodos que realizan la logica de negocio de restaurantes..
     */
    private final RestauranteService restauranteService = new RestauranteService();

    /**
     * Metodo que se encarga de inicializar la informacion de la pantalla de restaurantes.
     */
    @PostConstruct
    public void init() {
        this.consultarRestaurantes();
    }

    /**
     * Metodo que consulta la lista de empleados.
     */
    public void consultarRestaurantes() {
        this.restaurantes = this.restauranteService.consultarRestaurantes();
    }

    /**
     * @return the empleados
     */
    public List<Restaurante> getEmpleados() {
        return restaurantes;
    }

    /**
     * @param empleados the empleados to set
     */
    public void setEmpleados(List<Restaurante> empleados) {
        this.restaurantes = empleados;
    }

    public List<Restaurante> getEmpleadosFiltrados() {
        return empleadosFiltrados;
    }

    /**
     * @param empleadosFiltrados the empleadosFiltrados to set
     */
    public void setEmpleadosFiltrados(List<Restaurante> empleadosFiltrados) {
        this.empleadosFiltrados = empleadosFiltrados;
    }

    /**
     * @return the restaurantes
     */
    public List<Restaurante> getRestaurantes() {
        return restaurantes;
    }

    /**
     * @param restaurantes the restaurantes to set
     */
    public void setRestaurantes(List<Restaurante> restaurantes) {
        this.restaurantes = restaurantes;
    }

}
