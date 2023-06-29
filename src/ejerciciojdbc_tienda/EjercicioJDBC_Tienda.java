/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciojdbc_tienda;

import ejerciciojdbc_tienda.servicios.FabricanteServicio;
import ejerciciojdbc_tienda.servicios.ProductoServicio;

/**
 *
 * @author lucia
 */
public class EjercicioJDBC_Tienda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        /*Realizar un menú en Java a través del cual se permita elegir qué consulta se desea realizar.
Las consultas a realizar sobre la BD son las siguientes:
a) Lista el nombre de todos los productos que hay en la tabla producto.
b) Lista los nombres y los precios de todos los productos de la tabla producto.
c) Listar aquellos productos que su precio esté entre 120 y 202.
d) Buscar y listar todos los Portátiles de la tabla producto.
e) Listar el nombre y el precio del producto más barato.
f) Ingresar un producto a la base de datos.
g) Ingresar un fabricante a la base de datos
h) Editar un producto con datos a elección.*/
        
        ProductoServicio ps = new ProductoServicio();
        FabricanteServicio fs = new FabricanteServicio();
        //ps.mostrarProductos();
        //ps.nombreYPrecioProductos();
        //ps.productosPorPrecio();
        //ps.portatiles();
        //ps.masBarato();
        //ps.cargarProducto();
        //fs.cargarFabricante();
        ps.modificarProducto();
        ps.mostrarProductos();
    }
    
}
