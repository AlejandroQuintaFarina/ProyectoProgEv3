
package proyectoprog;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conectar {
        java.sql.Connection con;
    
    //Este método crea la conexión a la base de Datos SQL, y lo utilizaremos para conectarnos cuando queramos realizar alguna acción en esta.
    public Connection Conecta(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Indicamos la url, el nombre del perfil, y la contraseña ( que en este caso no existe)
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectoprog","root","");
            
    
         }
         catch(Exception e){
               JOptionPane.showMessageDialog(null, "Error al conectar.");
               e.printStackTrace();
        }
        return con;
    }
    
    
    public static Boolean validarLogin (String user, String password) throws SQLException{
        try{
            //Nos conectamos a la base de datos.
        Conectar conect = new Conectar();
        Connection conexion= conect.Conecta();
        
        //Preparamos la consulta.
        java.sql.Statement consulta = conexion.createStatement();
        java.sql.ResultSet resultado = consulta.executeQuery("SELECT * from usuarios WHERE Nombre='"+user+"' and Contraseña='"+password+"'");
        
        if(resultado.next())
            return true;        //usuario validado
        else
            return false;       //error al validar el usuario
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
