
package BaseDatos;

import Entidades.Empleados;
import Entidades.Tarjetas;
import Entidades.Vehiculos;
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
        conexion = new ConexionSGBD("shiftdb","root","192.168.1.65","");
        conectar = conexion.ConectToDatabase();
    }
    
    public Tarjetas verificarIDCard(String id_tarjeta){
        try{
            try (Statement consulta = conectar.createStatement()) {
                String query = "SELECT * FROM Tarjetas WHERE CveTarjeta='"+id_tarjeta+"'";
                Tarjetas tarjeta = new Tarjetas();
                try (ResultSet resultado = consulta.executeQuery(query)) {
                    if(resultado.next()){
                        tarjeta.setCveTarjeta(resultado.getString("CveTarjeta"));
                        tarjeta.setCveEmpleado(resultado.getString("CveEmpleado"));
                        tarjeta.setEstado(resultado.getString("Estado"));
                        tarjeta.setContraseña(resultado.getString("Contraseña"));
                        System.out.println(tarjeta.toString());
                        return tarjeta;
                    }
                    resultado.close();
                    return null;
                }
            }
        }catch(Exception e){
            System.out.println("Error SQL"+e);
            return null;
        }
    }
    
    public Empleados getEmpleado(String id_empleado){
        try{
            try (Statement consulta = conectar.createStatement()) {
                String query = "SELECT * FROM Empleados WHERE CveEmpleado='"+id_empleado+"'";
                Empleados empleado = new Empleados();
                try (ResultSet resultado = consulta.executeQuery(query)) {
                    if(resultado.next()){
                        empleado.setCveEmpleado(resultado.getString("CveEmpleado"));
                        empleado.setPriNombre(resultado.getString("PriNombre"));
                        empleado.setSegNombre(resultado.getString("SegNombre"));
                        empleado.setApePaterno(resultado.getString("ApePaterno"));
                        empleado.setApeMaterno(resultado.getString("ApeMaterno"));
                        empleado.setTelefono(resultado.getString("Telefono"));
                        empleado.setCveDepartamento(resultado.getString("CveDepartamento"));
                        empleado.setCveCajon(resultado.getString("CveCajon"));
                        System.out.println(empleado.toString());
                        return empleado;
                    }
                    resultado.close();
                    return null;
                }
            }
        }catch(Exception e){
            System.out.println("Error SQL"+e);
            return null;
        }
    }
    
    public Vehiculos getVehiculo(String id_empleado){
        try{
            try (Statement consulta = conectar.createStatement()) {
                String query = "SELECT * FROM Vehiculos WHERE CveEmpleado='"+id_empleado+"'";
                Vehiculos vehiculo = new Vehiculos();
                try (ResultSet resultado = consulta.executeQuery(query)) {
                    if(resultado.next()){
                        vehiculo.setCveMatricula(resultado.getString("CveMatricula"));
                        vehiculo.setCveEmpleado(resultado.getString("CveEmpleado"));
                        vehiculo.setMarca(resultado.getString("Marca"));
                        vehiculo.setModelo(resultado.getString("Modelo"));
                        vehiculo.setColor(resultado.getString("Color"));
                        System.out.println(vehiculo.toString());
                        return vehiculo;
                    }
                    resultado.close();
                    return null;
                }
            }
        }catch(Exception e){
            System.out.println("Error SQL"+e);
            return null;
        }
    }
    
    public void insertBitacora(String TipEvento, String cveMatricula) {
        Date fechaSystem = new Date(System.currentTimeMillis());
        Timestamp horaSystem = new Timestamp(fechaSystem.getTime());
        try {
            String query = "INSERT INTO bitacorascaei (TipEvento, Hora, Fecha, CveMatricula) VALUES(?,?,?,?)";
            PreparedStatement consulta = conectar.prepareStatement(query);
            consulta.setString(1, TipEvento);
            consulta.setTimestamp(2, horaSystem);
            consulta.setDate(3, fechaSystem);
            consulta.setString(4, cveMatricula);

            consulta.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error SQL INSERT " + e.getMessage());
        }
    }
    
    public void insertLogs(String Evento, String cveTarjeta) {
        Date fechaSystem = new Date(System.currentTimeMillis());
        Timestamp horaSystem = new Timestamp(fechaSystem.getTime());
        try {
            String query = "INSERT INTO logs (Evento, Hora, Fecha, CveTarjeta) VALUES(?,?,?,?)";
            PreparedStatement consulta = conectar.prepareStatement(query);
            consulta.setString(1, Evento);
            consulta.setTimestamp(2, horaSystem);
            consulta.setDate(3, fechaSystem);
            consulta.setString(4, cveTarjeta);
            consulta.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error SQL INSERT " + e.getMessage());
        }
    }
    
}
