
package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;
import java.sql.Timestamp;

public class DBQueries {
    private int votos;
    private String mensaje;
    private String status;
    public static ConexionSGBD conexion;
    public static Connection conectar;

    public DBQueries() {
        conexion = new ConexionSGBD("shiftdb","champeto","mysql-f6.homelinux.net","simons83");
        conectar = conexion.ConectToDatabase();
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    public int getVotosEstado(String candidato){
        try{
            try (Statement consulta = conectar.createStatement()) {
                String query = "SELECT sum(numVotos) as numVotos FROM resultados WHERE cveCandidato='" + candidato + "'";
                try (ResultSet resultado = consulta.executeQuery(query)) {
                    if(resultado.next()){
                        setVotos(resultado.getInt("numVotos"));
                    }
                    resultado.close();
                }
                consulta.close();
            }
        }catch(Exception e){
            System.out.println("Error SQL"+e);
        }
        return getVotos();
    }
    
    public String[] getEstadoCasilla(String casilla){
        try{
            try (Statement consulta = conectar.createStatement()) {
                String query = "SELECT status, mensaje FROM eventos WHERE cveFuncionario='"+ casilla+"'";
                try (ResultSet resultado = consulta.executeQuery(query)) {
                    if(resultado.next()){
                        setStatus(resultado.getString("status"));
                        setMensaje(resultado.getString("mensaje"));
                    }
                    resultado.close();
                }
                consulta.close();
            }
        }catch(Exception e){
            System.out.println("Error SQL"+e);
        }
        String estadoCasilla[] = {
            getStatus(),
            getMensaje(),
        };
        return estadoCasilla;
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
    
    public void insertBitacora(String cveFuncionario, String asunto, String nota, String fecha, String hora) {
        Date fechaSystem = new Date(System.currentTimeMillis());
        Timestamp horaSystem = new Timestamp(fechaSystem.getTime());
        try {
            String query = "INSERT INTO bitacoras VALUES(?,?,?,?,?)";
            PreparedStatement consulta = conectar.prepareStatement(query);
            consulta.setString(1, cveFuncionario);
            consulta.setString(2, asunto);
            consulta.setString(3, nota);
            consulta.setDate(4, fechaSystem);
            consulta.setTimestamp(5, horaSystem);
            consulta.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error SQL");
        }
    }

    public void updateResultados(String celular, String candidato, String votos) {
        try {
            String query = "UPDATE resultados SET numvotos=?  WHERE cveFuncionario= '" + celular + "' and cveCandidato= '" + candidato + "'";
            PreparedStatement consulta = conectar.prepareStatement(query);
            consulta.setString(1, votos);
            consulta.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error SQL");
        }
    }    
}
