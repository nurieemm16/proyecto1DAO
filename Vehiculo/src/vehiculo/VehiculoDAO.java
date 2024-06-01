/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehiculo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.*;

/**
 *
 * @author nuria
 */
public class VehiculoDAO {
    
    //CONSULTAR TODOS LOS VEHÍCULOS
     public static void printVehiculoDetails(){ // método que no devuelve ningún valor ya que su objetivo es imprimir detalles de los usuarios almacenados en la tabla users
    String query = "SELECT * FROM vehiculo;"; // consulta SQL para seleccionar todos los registros de la tabla users. Si sólo queremos sacar el id=1, escribiriamos esto:String query = "SELECT * FROM users where id = 1;";  
        
    // Este bloque se utiliza para manejar los recursos de manera automática y asegurar que se cierren adecuadamente al finalizar su uso.
    try(Connection conn = DataBaseConnection.getConnection(); // Se obtiene una conexión a la base de datos usando un método estático getConnection de la clase DatabaseConnection.
                Statement stmt = conn.createStatement(); //Se crea un objeto Statement para ejecutar la consulta SQL.
                ResultSet rs = stmt.executeQuery(query)){ // Se ejecuta la consulta y se obtiene un ResultSet que contiene los resultados.
            
        
        // Iteración sobre el ResultSet
            while(rs.next()){
                int id = rs.getInt("id");
                String tipo = rs.getString("tipo");
                String marca = rs.getString("marca");
                int potencia = rs.getInt("potencia");
                String fechaCompra = rs.getString("fechaCompra");
                
                System.out.println(" ID: " + id + " , tipo: " + tipo + " , marca: " + marca + " , potencia: " + potencia + " , fecha de la compra: " + fechaCompra );
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
                
    }
     
     //CONSULTAR UN VEHÍCULO POR SU ID
     
 public static void printOneVehiculoDetails(int id) {
    String query = "SELECT * FROM vehiculo WHERE id = ?;";
    try (Connection conn = DataBaseConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(query)) {
        
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        
        if (rs.next()) {
            String tipo = rs.getString("tipo");
            String marca = rs.getString("marca");
            int potencia = rs.getInt("potencia");
            String fechaCompra = rs.getString("fechaCompra");
            
            System.out.println("ID: " + id);
            System.out.println("Tipo: " + tipo);
            System.out.println("Marca: " + marca);
            System.out.println("Potencia: " + potencia);
            System.out.println("Fecha de Compra: " + fechaCompra);
        } else {
            System.out.println("No se encontró un vehículo con el ID: " + id);
        }
        
    } catch (SQLException e) {
        System.out.println("Error con el printOneVehiculoDetails.");
        e.printStackTrace();
    }
}
    
    //Método para insertar un nuevo vehiculo  en la base de datos:
  public static void insertVehiculo(String tipo, String marca, int potencia, String fechaCompra){ // Estos parámetros se utilizan para insertar un nuevo usuario en la base de datos.Esto de aquí será para poder llamar al insertUser del main pasandole los argumentios
      String query = "INSERT INTO vehiculo(tipo, marca, potencia, fechaCompra) VALUES (?, ?, ?, ?);"; // Se crea una string que contiene una consulta SQL para insertar un nuevo registro en la tabla users. Los signos de interrogación (?) son marcadores de posición que se reemplazarán con los valores reales en tiempo de ejecución.Los ? son marcadores de posición que serán reemplazados en setString
      try(Connection conn = DataBaseConnection.getConnection();
              PreparedStatement pstmt = conn.prepareStatement(query)){ //sirve para insertar o updatear
          
          //Reemplazo de los marcadores de posición:
      pstmt.setString (1, tipo); //Reemplaza el primer marcador de posición (?) con el valor de la variable username./Lo de 1 no es el id 1, es la columna, y username es la variable que cojemos de la linia 38
      pstmt.setString (2, marca);
      pstmt.setInt(3, potencia);// Reemplaza el segundo marcador de posición (?) con el valor de la variable password
      pstmt.setString (4, fechaCompra); // Reemplaza el tercer marcador de posición (?) con el valor de la variable email.
      pstmt.executeUpdate(); //  Ejecuta la actualización en la base de datos (inserción en este caso).
     System.out.println(" Nuevo vehículo adquirido! tipo: " + tipo + " , marca: " + marca + " , potencia: " + potencia + " , fecha de la compra: " + fechaCompra );
          
      }catch(SQLException e){
            e.printStackTrace(); //això ens torna l'error que dona sql
      }
    
    }
  
  
  // ELIMINAR VEHÍCULO POR ID EN MI BASE DE DATOS
 
    public static void deleteVehiculoByID(int id) { 
        String query = "DELETE FROM vehiculo WHERE id = ?;";
        try (Connection conn = DataBaseConnection.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Vehículo eliminado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //ACTUALIZAR DATOS DE MI VEHICULO, EN MI CASO, CAMBIAR LA MARVA
  
   public static void updateVehiculo(int id, String newMarca){
        String query = "UPDATE vehiculo SET marca = ? WHERE id = ?";
        try(Connection conn = DataBaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)){
                pstmt.setString(1, newMarca);
                pstmt.setInt(2, id);// El número es la posició de l'atribut (al primer INTERROGANT), el nom es el mateix que hem posat als parèntesis de dalt.
                
                pstmt.executeUpdate();
                
                 System.out.println("La marca de tu vehículo se ha modificada con éxito.");
                
        }catch(SQLException e){
            System.out.println("No se ha podido modificar la marca.");
            e.printStackTrace();
        }
    }
     
      // Método para obtener la potencia media según el tipo de vehículo
  
    public static void obtenerPotenciaMediaPorTipo(String tipo) {
        String query = "SELECT ROUND(AVG(potencia), 0) AS potencia FROM vehiculo WHERE tipo = ?;";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, tipo);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int potenciaMedia = rs.getInt("potencia");
                System.out.println("La potencia media para el tipo de vehículo '" + tipo + "' es: " + potenciaMedia);
            } else {
                System.out.println("No se encontraron vehículos del tipo: " + tipo);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la potencia media por tipo de vehículo.");
            e.printStackTrace();
        }
    }


 // Método para obtener la potencia max según el tipo de vehículo

    public static void obtenerPotenciaMaxPorTipo(String tipo) {
        String query = "SELECT MAX(potencia) AS potencia FROM vehiculo WHERE tipo = ?;";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, tipo);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int potenciaMax = rs.getInt("potencia");
                System.out.println("La potencia maxima para el tipo de vehículo '" + tipo + "' es: " + potenciaMax);
            } else {
                System.out.println("No se encontraron vehículos del tipo: " + tipo);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la potencia maxima por tipo de vehículo.");
            e.printStackTrace();
        }
    }

}

     
     
     



//Es mejor el preparedStatement que el Statment solo
//El executeUpdate() sirve para el insert, delete, update y crear tablas. En cambio el executeQuery() sirve para extraer/devolver datos
