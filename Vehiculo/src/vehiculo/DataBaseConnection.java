/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehiculo;
import java.sql.*;
import java.util.*;

/**
 *
 * @author nuria
 */
public class DataBaseConnection {
    
 private static final String URL = "jdbc:mysql://localhost:3306/vehiculo"; //url de la base de datos
    private static final String USER = "root"; //usuario de la base de datos
    private static final String PASSWORD = "Ironhack12!"; //contraseña de la base de datos 
    /**
     * Método para obterner una conexión a la base de datos
     *
    *@return Connection objeto de conexión a la base de datos
    * @throws SQLException si ocurre un error al establecer la conexión
    */
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
}

}
