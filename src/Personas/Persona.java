package Personas;

public class Persona {
    private double identificacion;
    private String nombres;
    private String apellidos;
    static int contadorObjetos;
    static int edadMinima;    
    public Persona() {}
    static
    {
        contadorObjetos=0;
        edadMinima=18;    
    }
    public double getIdentificacion() {
        return identificacion;
    }
    public void setIdentificacion(double identificacion) {
        this.identificacion = identificacion;
    }
    public Persona(double identificacion, String nombres, String apellidos) 
    {
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        contadorObjetos++;
    }
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    
}

