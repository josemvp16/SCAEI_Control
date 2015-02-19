
package Entidades;

public class Empleados {
    
    private String CveEmpleado;
    private String PriNombre;
    private String SegNombre;
    private String ApePaterno;
    private String ApeMaterno;
    private String Telefono;
    private String CveDepartamento;
    private String CveCajon;

    public Empleados() {
    }

    public Empleados(String CveEmpleado, String PriNombre, String SegNombre, String ApePaterno, String ApeMaterno, String Telefono, String CveDepartamento, String CveCajon) {
        this.CveEmpleado = CveEmpleado;
        this.PriNombre = PriNombre;
        this.SegNombre = SegNombre;
        this.ApePaterno = ApePaterno;
        this.ApeMaterno = ApeMaterno;
        this.Telefono = Telefono;
        this.CveDepartamento = CveDepartamento;
        this.CveCajon = CveCajon;
    }

    public String getCveEmpleado() {
        return CveEmpleado;
    }

    public void setCveEmpleado(String CveEmpleado) {
        this.CveEmpleado = CveEmpleado;
    }

    public String getPriNombre() {
        return PriNombre;
    }

    public void setPriNombre(String PriNombre) {
        this.PriNombre = PriNombre;
    }

    public String getSegNombre() {
        return SegNombre;
    }

    public void setSegNombre(String SegNombre) {
        this.SegNombre = SegNombre;
    }

    public String getApePaterno() {
        return ApePaterno;
    }

    public void setApePaterno(String ApePaterno) {
        this.ApePaterno = ApePaterno;
    }

    public String getApeMaterno() {
        return ApeMaterno;
    }

    public void setApeMaterno(String ApeMaterno) {
        this.ApeMaterno = ApeMaterno;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCveDepartamento() {
        return CveDepartamento;
    }

    public void setCveDepartamento(String CveDepartamento) {
        this.CveDepartamento = CveDepartamento;
    }

    public String getCveCajon() {
        return CveCajon;
    }

    public void setCveCajon(String CveCajon) {
        this.CveCajon = CveCajon;
    }

    @Override
    public String toString() {
        return "Empleados{" + "CveEmpleado=" + CveEmpleado + ", PriNombre=" + PriNombre + ", SegNombre=" + SegNombre + ", ApePaterno=" + ApePaterno + ", ApeMaterno=" + ApeMaterno + ", Telefono=" + Telefono + ", CveDepartamento=" + CveDepartamento + ", CveCajon=" + CveCajon + '}';
    }
    
}
