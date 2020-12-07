package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion 
{
    private String USERNAME="root";
    private String PASSWORD=""; // "" 
    private String HOST="localhost";
    private String PORT="3306";
    private String DATABASE="poo4"; // 
    private String CLASSNAME="com.mysql.jdbc.Driver";
    private String URL="jdbc:mysql://"+HOST+"/"+DATABASE;
    
    private Connection con;

    public Conexion() 
    {
        try
        {
            Class.forName(CLASSNAME);
            con=DriverManager.getConnection(URL,USERNAME,PASSWORD);
             //JOptionPane.showMessageDialog(null,"Conexión EXITOSA");
        }
        catch (Exception e)
        {
           // JOptionPane.showMessageDialog(null,"ERROR:\n"+e);
        }
    }
    
    public Connection getConecction()
    {
        return con;
    }
    /*
    public static void main(String[] args) 
    {
        Conexion c=new Conexion();                
    }
    */
}
