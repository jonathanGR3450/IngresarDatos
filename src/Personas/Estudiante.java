package Personas;
import java.util.Date;
public class Estudiante extends Persona{
    private double codigo;
    private String programa;
    private Date fechaIngres;
    public Estudiante(double codigo, String programa, double identificacion, String nombres, String apellidos, Date fecha) {
        super(identificacion, nombres, apellidos);
        this.codigo = codigo;
        this.programa = programa;
        this.fechaIngres=fecha;
    }
    public Estudiante(double codigo, String programa) {
        this.codigo = codigo;
        this.programa = programa;
    }
    public Date getFechaIngreso() {
        return fechaIngres;
    }
    public double getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getPrograma() {
        return programa;
    }
    public void setPrograma(String programa) {
        this.programa = programa;
    }
}
