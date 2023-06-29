/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciojdbc_tienda.persistencia;

import ejerciciojdbc_tienda.entidades.Fabricante;
import java.util.ArrayList;

/**
 *
 * @author lucia
 */
public final class FabricanteDAO extends DAO{
    public void guardarFabricante(Fabricante fabricante) throws Exception{
        try{
            if(fabricante==null){
                throw new Exception("Por favor, primero ingrese los datos del fabricante.");
            }
            String sql= "INSERT INTO fabricante "
                    +"VALUES ('" + fabricante.getNombre() + "');";
            insertarModificarEliminar(sql);
    } catch (Exception e){
        throw e;
    }
}
    
    public void modificarFabricante(Fabricante fabricante) throws Exception{
        try{
            if(fabricante==null){
                throw new Exception("Por favor, primero ingrese los datos a modificar.");
            }
            String sql= "UPDATE fabricante "
                    +"SET nombre '" + fabricante.getNombre() + "' WHERE codigo =" + fabricante.getCodigo() + ";";
            insertarModificarEliminar(sql);
    } catch (Exception e){
        throw e;
    }
}
    
    public void eliminarFabricante(Fabricante fabricante) throws Exception{
        try{
            if(fabricante==null){
                throw new Exception("Error, el fabricante indicado no existe.");
            }
            String sql= "DELET FROM fabricante "
                    + "WHERE codigo =" + fabricante.getCodigo() + ";";
            insertarModificarEliminar(sql);
    } catch (Exception e){
        throw e;
    }
}
    public ArrayList <Fabricante> consultaFabricante(String condicion) throws Exception{
        try{
            String sql= "SELECT * FROM fabricante "
                    + "WHERE "  + condicion + ";";
        consultarBase(sql);
        ArrayList<Fabricante> fabricantes = new ArrayList<>();
        while(resultado.next()){
            fabricantes.add(new Fabricante(resultado.getInt("codigo"), resultado.getString("nombre")));
        }
        desconectarBase();
        return fabricantes;
    } catch (Exception e){
        desconectarBase();
        throw e;
    }
}
}
