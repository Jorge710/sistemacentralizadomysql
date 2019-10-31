/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.main;

import com.company.session.ProductoJpaController;
import com.mycompany.entidades.Producto;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Aplicaciones D
 */
public class Test {

    public static void main(String[] args) {
        //TOMA LOS PARAMETROS ESTABLECIDOS DE LA CADENA DE CONEXION
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("practicabdd");
        
        //LA CLASE CONTROLLER RECIBE DE PARAMETRO UN ACADENA DE CONEXION
        ProductoJpaController pjc = new ProductoJpaController(emf);
        
        //CREAMOS UN NUEVO PRODUCTO
        Producto p = new Producto();
        
        p.setNombre("pan");
        Double dl = 10.35;
        BigDecimal bd1 = BigDecimal.valueOf(dl.doubleValue());
        p.setPrecio(bd1);
        
        try {
            //LLAMAR AL METODO CREATE POR MEDIO DEL OBJETO PJC
            pjc.create(p);
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.ALL.SEVERE, null, ex);
        }
    }

}
