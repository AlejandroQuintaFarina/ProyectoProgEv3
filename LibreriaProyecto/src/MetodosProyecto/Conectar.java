/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetodosProyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alex0
 */
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
    
    
    public Boolean validarLogin (String user, String password) throws SQLException{
        try{
        Conectar conect = new Conectar();
        Connection conexion= conect.Conecta();
        
        java.sql.Statement consulta = conexion.createStatement();
        java.sql.ResultSet resultado = consulta.executeQuery("SELECT * from usuarios WHERE Nombre='"+user+"' and Contraseña='"+password+"'");
        
        if(resultado.first())
            return true;
        else
            return false;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
 public static boolean isNumeric(String cadena){
           try{
               Integer.parseInt(cadena);
               return true;
           }
           catch(NumberFormatException e){
               return false;
           }
        }
        
        //Método para mostrar la BD en un JTable
        public static void Listar (int opBuscar, String valor,JTable tabla){
            Conectar conect = new Conectar();
        Connection conexion= conect.Conecta();
        //Llamamos a la consulta select que reoge todos las filas de nuestra Tabla registro

        java.sql.Statement st;
        //Creamos un modelo para nuestro JTable 
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("nombre");
        modelo.addColumn("apellido");
        modelo.addColumn("DNI");
        modelo.addColumn("telf.");
        modelo.addColumn("correo");
        modelo.addColumn("Fechaent");
        modelo.addColumn("días");
        
        tabla.setModel(modelo);
        
        String codsql = null;
        //Creamos una serie de if-else que detectarán las opciones de busqueda y realizarán la consulta que corresponda.
        if(opBuscar==0 && valor==null){
            codsql="SELECT * from registro";
        }else{
            if(opBuscar==1 && valor!=null){
                codsql="SELECT * from registro where dni='"+valor+"'";
            }else{
                if (opBuscar==2 && valor!=null){
                    codsql="SELECT * from registro where apellidos='"+valor+"'";
                }else{
                    if(opBuscar==3 && valor!=null){
                        codsql="SELECT * from registro where fechaent='"+valor+"'";
                    }else{
                        codsql="SELECT * from registro";
                    }
                }
            }
        }
        
        //Crea un array que recogerá los datos de la BD
        String datos[] = new String[7];
        try{
            st = conexion.createStatement();
            java.sql.ResultSet resultado = st.executeQuery(codsql);
            
        //Creamos un while para que mientras existan regsitros se añadan los datos al array y finalmente se va añadiendo a la tabla.
        while(resultado.next()){
            datos[0]=resultado.getString(1);
            datos[1]=resultado.getString(2);
            datos[2]=resultado.getString(3);
            datos[3]=resultado.getString(4);
            datos[4]=resultado.getString(5);
            datos[5]=resultado.getString(6);
            datos[6]=resultado.getString(7);

            modelo.addRow(datos);
        }
            
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al insertar los datos en la tabla.");
        }
        }
    
}
