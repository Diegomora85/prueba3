
package modelo;


public class Persona {
    private int id;
    private String rut;
    private String apellido;
    private String nombre;
    private int genero;
    private int estadoCivil;

    public Persona(int id, String rut, String apellido, String nombre, int genero, int estadoCivil) {
        this.id = id;
        this.rut = rut;
        this.apellido = apellido;
        this.nombre = nombre;
        this.genero = genero;
        this.estadoCivil = estadoCivil;
    }

    public Persona() {
    }

    public Persona(int id) {
        this.id = id;
    }

    public Persona(String rut) {
        this.rut = rut;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public int getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(int estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

   
    
    
}
