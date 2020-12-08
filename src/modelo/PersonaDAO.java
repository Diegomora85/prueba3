package modelo;

import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PersonaDAO {

    Conexion con = new Conexion();

    public void agregarPersona(Object obj) {
        Persona p = (Persona) obj;
        PreparedStatement ps = null;
        String query = "insert into persona(id,rut,apellido,nombre,genero,estadoCivil)"
                + "value(?,?,?,?,?,?)";
        String msj = "";
        try {
            ps = con.getConecction().prepareStatement(query);
            ps.setInt(1, p.getId());
            ps.setString(2, p.getRut());
            ps.setString(3, p.getApellido());
            ps.setString(4, p.getNombre());
            ps.setInt(5, p.getGenero());
            ps.setInt(6, p.getEstadoCivil());

            if (ps.executeUpdate() == 1) {
                msj = "Persona agregada correctamente";
            } else {
                msj = "Persona no agregada";
            }

            JOptionPane.showMessageDialog(null, msj);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error\n" + e.toString());
        }

    }
    
    public Persona consultarPersona(Object obj){
        Persona p = (Persona) obj;
        PreparedStatement ps = null;
        String query = "select * from persona where rut=?";
        ResultSet rs;
        String msj = "";
        try {
            ps = con.getConecction().prepareStatement(query);
            ps.setString(1, p.getRut());
            rs=ps.executeQuery();
            if (rs.next()) {
                msj="Persona Encontrada";
                p.setId(rs.getInt("ID"));
                p.setRut(rs.getString("rut"));
                p.setApellido(rs.getString("apellido"));
                p.setNombre(rs.getString("Nombre"));
                p.setGenero(rs.getInt("genero"));
                p.setEstadoCivil(rs.getInt("estadoCivil"));
            }else{
                msj="Persona Encontrada";
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error\n" + e.toString());
        }
        JOptionPane.showMessageDialog(null, msj);
        
        return p;
    }
    
    public Persona selectPersonaByID(int ID) throws SQLException{   
        String query = "SELECT * FROM persona WHERE ID = ?";
        PreparedStatement ps = con.getConecction().prepareStatement(query);
        ps.setInt(1, ID);
        
        ResultSet rs = ps.executeQuery(); // No se espera mas de 1 resultado
        rs.next();                        // debido a que ID es PK
        
        Persona p = new Persona();
        
        p.setId(rs.getInt("ID"));
        p.setRut(rs.getString("rut"));
        p.setApellido(rs.getString("apellido"));
        p.setNombre(rs.getString("Nombre"));
        p.setGenero(rs.getInt("genero"));
        p.setEstadoCivil(rs.getInt("estadoCivil"));
        
        return p;
    }
    
    public void ModificarPersonaByID(Persona p) throws SQLException, Exception{
        if(p.getRut().equals("")){
            throw new Exception("El RUT no es valido");
        }
        
        String query = "UPDATE persona SET "
                + (p.getRut().equals("")? "" : "rut = ?, ")
                + "apellido = ?, "
                + "nombre = ?, "
                + "genero = ?, "
                + "estadoCivil = ? "
                + "WHERE ID = ?";
        
        PreparedStatement ps = con.getConecction().prepareStatement(query);
        ps.setString(2, p.getApellido());
        ps.setString(3, p.getNombre());
        ps.setInt(4, p.getGenero());
        ps.setInt(5, p.getEstadoCivil());
        ps.setInt(6, p.getId());
        
        ps.executeUpdate();
    }
    
    public void eliminarPersona(Object obj){
        Persona p=(Persona)obj;
        PreparedStatement ps=null;
        String query="delete from persona where rut=?";
        String msj="";
        try {
            ps=con.getConecction().prepareStatement(query);
            ps.setString(1, p.getRut());
            if (ps.executeUpdate()==1) {
                msj="Persona Eliminada Correctamente";
                                
            }else{
                msj="Persona NO Eliminada";
                
            }
            JOptionPane.showMessageDialog(null, msj);
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Error\n" + e.toString());
        }
        
    } 
    

    /* public static void main(String[] args) {
        Persona p=new Persona(0,"12345678-9","Farias","Gustavo",2,1);
        PersonaDAO pd=new PersonaDAO();
        pd.agregarPersona(p);
    }
     */
}
