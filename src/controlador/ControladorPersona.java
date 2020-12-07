package controlador;

import modelo.Persona;
import modelo.PersonaDAO;

public class ControladorPersona {

    public void agregarPersona(String rut, String apellido, String nombre, int genero, int estadoCivil) {
        Persona p = new Persona(0, rut, apellido, nombre, genero, estadoCivil);
        PersonaDAO pd = new PersonaDAO();
        pd.agregarPersona(p);

    }

    public Persona consultarPersona(String rut) {
        Persona p = new Persona(rut);
        PersonaDAO pd = new PersonaDAO();
        return pd.consultarPersona(p);

    }
    
    public void eliminarPersona(String rut){
        Persona p=new Persona(rut);
        PersonaDAO pd=new PersonaDAO();
        pd.eliminarPersona(p);
        
    }

}
