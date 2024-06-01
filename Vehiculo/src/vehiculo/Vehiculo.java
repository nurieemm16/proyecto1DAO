/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vehiculo;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author nuria
 */
public class Vehiculo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       VehiculoClase.mostrarDetallesTodosVehiculos();
       VehiculoClase.mostrarDetallesUnVehiculo(15);
        //VehiculoClase.insertarVehiculo("avión", "Boeing", 3000, "13-11-2018");
        //VehiculoClase.insertarVehiculo("camión", "MAN", 2000, "23-01-2015");
        VehiculoClase.insertarVehiculo("camión", "BMW", 1700, "08-08-2019");
        VehiculoClase.eliminarVehiculo(1);
        VehiculoClase.mostrarDetallesUnVehiculo(4);
        VehiculoClase.modificarMarcaVehiculo(3, "Mercedes");
        VehiculoClase.ObtenerPotenciaMediaPorTipo("coche");
        VehiculoClase.obtenerPotenciaMaxPorTipo("avión");
        
        
    
   
        
        
        
    }
    
}
