
package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;
import java.sql.Timestamp;

public class DBQueries {
    private String ID_Card;
    private ConexionSGBD conexion;
    private Connection conectar;

    public DBQueries() {
        conexion = new ConexionSGBD("shiftdb","champeto","mysql-f6.homelinux.net","simons83");
        conectar = conexion.ConectToDatabase();
    }
    
    public boolean verificarIDCard(String id_tarjeta){
        try{
            try (Statement consulta = conectar.createStatement()) {
                String query = "SELECT CveTarjeta FROM Tarjetas WHERE cveTarjeta='" + id_tarjeta+ "'";
                try (ResultSet resultado = consulta.executeQuery(query)) {
                    if(resultado.next()){
                        return true;
                    }
                    resultado.close();
                    return false;
                }
            }
        }catch(Exception e){
            System.out.println("Error SQL"+e);
            return false;
        }
    }
         
    public void updateEstado(String casilla, String msj, String status) {
        try {
            String query = "UPDATE estado set mensaje=?, status=? WHERE cveCasilla= '" + casilla + "'";
            PreparedStatement consulta = conectar.prepareStatement(query);
            consulta.setString(1, msj);
            consulta.setString(2, status);
            consulta.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error SQL");
        }
    }
    
    public boolean insertBitacora(String tipoEvento, String id) {
        Date fechaSystem = new Date(System.currentTimeMillis());
        Timestamp horaSystem = new Timestamp(fechaSystem.getTime());
        try {
            String CveMatricula = "SELECT CveMatricula FROM Tarjetas t1 INNER JOIN Vehiculos v1 ON t1.CveEmpleado = v1.CveEmpleado WHERE t1.CveTarjeta = '"+id+"'";
            String query = "INSERT INTO bitacoras VALUES(?,?,?,?)";
            PreparedStatement consulta = conectar.prepareStatement(query);
            consulta.setString(1, tipoEvento);
            consulta.setDate(2, fechaSystem);
            consulta.setTimestamp(3, horaSystem);
            consulta.setString(4, CveMatricula);
            consulta.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error SQL");
            return false;
        }
    }
}
