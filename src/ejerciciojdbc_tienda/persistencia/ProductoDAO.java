/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciojdbc_tienda.persistencia;

import ejerciciojdbc_tienda.entidades.Producto;
import java.util.ArrayList;

/**
 *
 * @author lucia
 */
public final class ProductoDAO extends DAO {
    public void guardarProducto(Producto producto) throws Exception{
        try{
            if(producto==null){
                throw new Exception("Por favor, primero ingrese los datos del producto.");
            }
            String sql= "INSERT INTO producto (codigo, nombre, precio, codigo_fabricante)"
                    +"VALUES ('" + producto.getCodigo() + "', '" + producto.getNombre() + "', '" + producto.getPrecio() + "', '" + producto.getCodigo_fabricante()+"');";
            insertarModificarEliminar(sql);
    } catch (Exception e){
        throw e;
    }
}
    
    public void modificarProducto(Producto producto, int opc) throws Exception{
        try{
            if (opc<1 | opc>3){
                throw new Exception("Error. Debe ingresar una opcion valida (entre 1 y 3).");
            }
            String sql="";
            switch (opc){
                case 1:
                    if (producto.getNombre()==null){
                       throw new Exception("Error. Debe ingresar un nombre.");
                    }
                    sql= "UPDATE producto SET nombre= '" + producto.getNombre() + "' WHERE codigo =" + producto.getCodigo() + ";";
                break;
                case 2:
                    if (producto.getPrecio()<0){
                        throw new Exception("Error. El precio no puede ser menor que cero.");
                    }
                    sql= "UPDATE producto SET precio= " + producto.getPrecio() + " WHERE codigo =" + producto.getCodigo() + ";";
                break;
                case 3:
                    if(producto.getCodigo_fabricante()<1 | producto.getCodigo_fabricante()>9){
                    throw new Exception("Error. El codigo fabricante no puede ser menor que uno ni mayor que nueve.");
                    }
                    sql= "UPDATE producto "
                    +"SET codigo_fabricante= '" + producto.getCodigo_fabricante() + " WHERE codigo =" + producto.getCodigo() + ";";
                break;    
            }
           
            insertarModificarEliminar(sql);
    } catch (Exception e){
        throw e;
    }
}
    
    public void eliminarProducto(Producto producto) throws Exception{
        try{
            if(producto==null){
                throw new Exception("Error, el producto indicado no existe.");
            }
            String sql= "DELET FROM fabricante "
                    + "WHERE codigo =" + producto.getCodigo() + ";";
            insertarModificarEliminar(sql);
    } catch (Exception e){
        throw e;
    }
}
    public ArrayList <Producto> consultaProdcuto() throws Exception{
        try{
            String sql= "SELECT * FROM producto;";
        consultarBase(sql);
        ArrayList<Producto> productos = new ArrayList<>();
        while(resultado.next()){
            productos.add(new Producto (resultado.getInt("codigo"), resultado.getString("nombre"), resultado.getDouble("precio"), resultado.getInt("codigo_fabricante")));
        }
        desconectarBase();
        return productos;
    } catch (Exception e){
        desconectarBase();
        throw e;
    }
}
    public ArrayList <Producto> consultaProdcutoCondicion(String condicion) throws Exception{
        try{
            String sql= "SELECT * FROM producto " + condicion + ";";
        consultarBase(sql);
        ArrayList<Producto> productos = new ArrayList<>();
        while(resultado.next()){
            productos.add(new Producto(resultado.getInt("codigo"), resultado.getString("nombre"), resultado.getDouble("precio"), resultado.getInt("codigo_fabricante")));
        }
        desconectarBase();
        return productos;
    } catch (Exception e){
        desconectarBase();
        throw e;
    }
}
}
