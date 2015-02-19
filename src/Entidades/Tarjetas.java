package Entidades;

public class Tarjetas {
    
    private String CveTarjeta;
    private String CveEmpleado;
    private String Estado;
    private String Contraseña;

    public Tarjetas() {
    }
    
    public Tarjetas(String CveTarjeta, String CveEmpleado, String Estado, String Contraseña) {
        this.CveTarjeta = CveTarjeta;
        this.CveEmpleado = CveEmpleado;
        this.Estado = Estado;
        this.Contraseña = Contraseña;
    }

    public String getCveTarjeta() {
        return CveTarjeta;
    }

    public void setCveTarjeta(String CveTarjeta) {
        this.CveTarjeta = CveTarjeta;
    }

    public String getCveEmpleado() {
        return CveEmpleado;
    }

    public void setCveEmpleado(String CveEmpleado) {
        this.CveEmpleado = CveEmpleado;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    @Override
    public String toString() {
        return "Tarjetas{" + "CveTarjeta=" + CveTarjeta + ", CveEmpleado=" + CveEmpleado + ", Estado=" + Estado + ", Contrase\u00f1a=" + Contraseña + '}';
    }
    
        
}
