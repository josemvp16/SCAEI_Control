
package Entidades;

public class Vehiculos {
    
    private String CveMatricula;
    private String CveEmpleado;
    private String Marca;
    private String Modelo;
    private String Color;

    public Vehiculos() {
    }

    public Vehiculos(String CveMatricula, String CveEmpleado, String Marca, String Modelo, String Color) {
        this.CveMatricula = CveMatricula;
        this.CveEmpleado = CveEmpleado;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Color = Color;
    }

    public String getCveMatricula() {
        return CveMatricula;
    }

    public void setCveMatricula(String CveMatricula) {
        this.CveMatricula = CveMatricula;
    }

    public String getCveEmpleado() {
        return CveEmpleado;
    }

    public void setCveEmpleado(String CveEmpleado) {
        this.CveEmpleado = CveEmpleado;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "CveMatricula=" + CveMatricula + ", CveEmpleado=" + CveEmpleado + ", Marca=" + Marca + ", Modelo=" + Modelo + ", Color=" + Color + '}';
    }
    
    
    
}
