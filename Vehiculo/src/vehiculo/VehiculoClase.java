/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehiculo;
import java.util.*;
import java.util.Date;

/**
 *
 * @author nuria
 */
public class VehiculoClase {
    
    private int id;
    private String tipo;
    private String marca;
    private int potencia;
    private String fechaCompra;

    public VehiculoClase(int id, String tipo, String marca, int potencia, String fechaCompra) {
        this.id = id;
        this.tipo = tipo;
        this.marca = marca;
        this.potencia = potencia;
        this.fechaCompra = fechaCompra;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
    
      public static void mostrarDetallesTodosVehiculos(){
            
            
            VehiculoDAO.printVehiculoDetails();
 
        }
      
      
       public static void mostrarDetallesUnVehiculo(int id){
            
            
            VehiculoDAO.printOneVehiculoDetails(id);
 
        }
    
    
      public static void insertarVehiculo(String tipo, String marca, int potencia, String fechaCompra){
            
            
            VehiculoDAO.insertVehiculo(tipo, marca, potencia, fechaCompra);
 
        }
      
      public static void eliminarVehiculo(int id){
            
            
            VehiculoDAO.deleteVehiculoByID(id);
 
        }
      
      public static void modificarMarcaVehiculo(int id, String newMarca){
            
            
            VehiculoDAO.updateVehiculo(id, newMarca);
 
        }
      
      
         public static void ObtenerPotenciaMediaPorTipo(String tipo){
            
            
            VehiculoDAO.obtenerPotenciaMediaPorTipo(tipo);
 
        }
      
         
         
           public static void obtenerPotenciaMaxPorTipo(String tipo){
            
            
            VehiculoDAO.obtenerPotenciaMaxPorTipo(tipo);
 
        }
      
      
      
      
    
}

