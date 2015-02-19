package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;
import java.sql.Timestamp;

public class DBQueries {

    public static ConexionSGBD conexion;
    public static Connection conectar;

    public String getPriNombre() {
        return PriNombre;
    }

    public String getSegNombre() {
        return SegNombre;
    }

    public String getApePaterno() {
        return ApePaterno;
    }

    public String getApeMaterno() {
        return ApeMaterno;
    }

    public String getCveTarjeta() {
        return CveTarjeta;
    }

    public void setPriNombre(String PriNombre) {
        this.PriNombre = PriNombre;
    }

    public void setSegNombre(String SegNombre) {
        this.SegNombre = SegNombre;
    }

    public void setApePaterno(String ApePaterno) {
        this.ApePaterno = ApePaterno;
    }

    public void setApeMaterno(String ApeMaterno) {
        this.ApeMaterno = ApeMaterno;
    }

    public void setCveTarjeta(String CveTarjeta) {
        this.CveTarjeta = CveTarjeta;
    }
    String PriNombre, SegNombre, ApePaterno, ApeMaterno, CveTarjeta;

    public DBQueries() {
        conexion = new ConexionSGBD("shiftdb", "eduardomq", "shift-f6.ddns.net", "lalo12345");
        conectar = conexion.ConectToDatabase();
    }

    public boolean searchClave(String casilla) {
        try {
            try (Statement consulta = conectar.createStatement()) {
                String query = "Select e.PriNombre,e.SegNombre,e.ApePaterno,e.ApeMaterno, t.CveTarjeta\n"
                        + "From Empleados e inner join Tarjetas t \n"
                        + "on e.CveEmpleado=t.CveEmpleado where\n"
                        + "(Select t.CveEmpleado From tarjetas t inner join vehiculos v \n"
                        + "on t.CveEmpleado=v.CveEmpleado where \n"
                        + "(Select v.CveMatricula From Bitacorascaei b inner join Vehiculos v\n"
                        + "on v.cveMatricula=b.cveMatricula));";
                try (ResultSet resultado = consulta.executeQuery(query)) {
                    if (resultado.next()) {
                        PriNombre = "e.PriNombre";
                        SegNombre = "e.SegNombre";
                        ApePaterno = "e.ApePaterno";
                        ApeMaterno = "e.e.ApeMaterno";
                        CveTarjeta = "t.CveTarjeta";
                    }
                    resultado.close();
                }
                consulta.close();
            }
        } catch (Exception e) {
            System.out.println("Error SQL" + e);
        }
        return true;
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
}
