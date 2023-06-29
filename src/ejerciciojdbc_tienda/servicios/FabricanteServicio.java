/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciojdbc_tienda.servicios;

import ejerciciojdbc_tienda.entidades.Fabricante;
import ejerciciojdbc_tienda.persistencia.FabricanteDAO;
import java.util.Scanner;

/**
 *
 * @author lucia
 */
public class FabricanteServicio {
    private FabricanteDAO dao;

    public FabricanteServicio() {
        this.dao=new FabricanteDAO();
    }
    
    public void cargarFabricante() throws Exception{
         Scanner leer = new Scanner(System.in).useDelimiter("\n");
         System.out.println("Indique el nombre del producto");
         String nombre = leer.next();
         ingresarFabricante(nombre);
    }     
    
    public void ingresarFabricante(String nombre) throws Exception{
        try{
            if (nombre==null){
                throw new Exception("Error. Debe ingresar un nombre.");
            }
        Fabricante fabricante = new Fabricante();
        fabricante.setNombre(nombre);
        dao.guardarFabricante(fabricante);
        } catch (Exception e){
        throw e;
        }
    }
    
}
