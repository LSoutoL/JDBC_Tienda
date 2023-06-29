/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciojdbc_tienda;

import ejerciciojdbc_tienda.servicios.FabricanteServicio;
import ejerciciojdbc_tienda.servicios.ProductoServicio;
import java.util.Scanner;

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
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        ProductoServicio ps = new ProductoServicio();
        FabricanteServicio fs = new FabricanteServicio();
        int opc;
        do{
            System.out.println("Indica la accion que queres realizar:");
            System.out.println("1. Listar el nombre de todos los productos que hay en la tabla producto.");
            System.out.println("2. Listar los nombres y los precios de todos los productos de la tabla producto.");
            System.out.println("3. Listar aquellos productos que su precio esté entre 120 y 202.");
            System.out.println("4. Buscar y listar todos los Portátiles de la tabla producto.");
            System.out.println("5. Listar el nombre y el precio del producto más barato.");
            System.out.println("6. Ingresar un producto a la base de datos.");
            System.out.println("7. Ingresar un fabricante a la base de datos.");
            System.out.println("8. Editar un producto con datos a elección.");
            System.out.println("9. Salir.");
            opc=leer.nextInt();
            switch (opc){
                case 1: ps.mostrarProductos();
                break;
                case 2: ps.nombreYPrecioProductos();
                break;
                case 3: ps.productosPorPrecio();
                break;
                case 4: ps.portatiles();
                break;
                case 5: ps.masBarato();
                break;
                case 6: ps.cargarProducto();
                break;
                case 7: fs.cargarFabricante();
                break;
                case 8: ps.modificarProducto();
                break;
            }
        } while (opc!=9);
        
    }
    
}
