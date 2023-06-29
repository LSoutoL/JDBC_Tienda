/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciojdbc_tienda.servicios;

import ejerciciojdbc_tienda.entidades.Fabricante;
import ejerciciojdbc_tienda.entidades.Producto;
import ejerciciojdbc_tienda.persistencia.ProductoDAO;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lucia
 */
public class ProductoServicio {
    private ProductoDAO dao;

    public ProductoServicio() {
        this.dao=new ProductoDAO();
    }
    
    public void mostrarProductos() throws Exception{
        ArrayList<Producto> productos = dao.consultaProdcuto();
        System.out.println("Codigo | Nombre                      | Precio   | Codigo_fabricante    ");
        for (Producto producto : productos) {
            System.out.println(producto.getCodigo()+ " | " + producto.getNombre() + " | " + producto.getPrecio() + " | " + producto.getCodigo_fabricante());
        }
    }
    public void nombreYPrecioProductos() throws Exception{
        ArrayList<Producto> productos = dao.consultaProdcuto();
        System.out.println("Nombre                      | Precio   ");
        for (Producto producto : productos) {
            System.out.println(producto.getNombre() + " | " + producto.getPrecio());
        }
    }
    
    public void productosPorPrecio() throws Exception{
        String condicion = "WHERE precio BETWEEN 120 AND 202";
        ArrayList<Producto> productos = dao.consultaProdcutoCondicion(condicion);
        System.out.println("Codigo | Nombre                      | Precio   | Codigo_fabricante    ");
        for (Producto producto : productos) {
            System.out.println(producto.getCodigo()+ " | " + producto.getNombre() + " | " + producto.getPrecio() + " | " + producto.getCodigo_fabricante());
        }
    }
     public void portatiles() throws Exception{
        String condicion = "WHERE nombre LIKE '%portatil%'";
        ArrayList<Producto> productos = dao.consultaProdcutoCondicion(condicion);
        System.out.println("Codigo | Nombre                      | Precio   | Codigo_fabricante    ");
        for (Producto producto : productos) {
            System.out.println(producto.getCodigo()+ " | " + producto.getNombre() + " | " + producto.getPrecio() + " | " + producto.getCodigo_fabricante());
        }
    }
     public void masBarato() throws Exception{
        String condicion = "ORDER BY precio ASC LIMIT 1";
        ArrayList<Producto> productos = dao.consultaProdcutoCondicion(condicion);
        System.out.println("Nombre                      | Precio   ");
        for (Producto producto : productos) {
            System.out.println(producto.getNombre() + " | " + producto.getPrecio());
        }
    }
     public void cargarProducto() throws Exception{
         Scanner leer = new Scanner(System.in).useDelimiter("\n");
         System.out.println("Indique el nombre del producto");
         String nombre = leer.next();
         System.out.println("Indique el precio del producto");
         double precio = leer.nextDouble();
         System.out.println("Indique el codigo de fabricante");
         int codigo_fabricante=leer.nextInt();
         ingresarProducto(nombre, precio,codigo_fabricante);
     }
     public void ingresarProducto (String nombre, double precio, int codigo_fabricante) throws Exception{
         try{
            if (nombre==null){
                throw new Exception("Error. Debe ingresar un nombre.");
            }
            if (precio<0){
                throw new Exception("Error. El precio no puede ser menor a cero.");
            }
            if(codigo_fabricante<1 | codigo_fabricante>9){
                throw new Exception("Error. El codigo fabricante no puede ser menor que uno ni mayor que nueve.");
            }
        Producto producto = new Producto(nombre, precio, codigo_fabricante);
        dao.guardarProducto(producto);
        
        } catch (Exception e){
        throw e;
        }
     }
     
     public void modificarProducto() throws Exception{
        Producto producto = new Producto();
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Indique el codigo del producto que desea modificar:");
        producto.setCodigo(leer.nextInt());
        int opc=0;
        System.out.println("Indique el dato que desea modificar:");
        System.out.println("1. Nombre");
        System.out.println("2. Precio");
        System.out.println("3. Codigo de Fabricante");
        opc=leer.nextInt();
        switch(opc){
            case 1: System.out.println("Indique el nuevo nombre");
                producto.setNombre(leer.next());
            break;
            case 2:System.out.println("Indique el nuevo precio");
                producto.setPrecio(leer.nextDouble());
            break;
            case 3: System.out.println("Indique el nuevo codigo de fabricante");
                producto.setCodigo_fabricante(leer.nextInt());
            break;
        }
        dao.modificarProducto(producto, opc);
     }
}
