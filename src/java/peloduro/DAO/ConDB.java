/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package peloduro.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Gonzalo
 */
public class ConDB {
    private String url="jdbc:oracle:thin:@192.168.56.10:1521:orcl";
    private String user="peloduro";
    private String pass="peloduro";
    
    public Connection getConexion() {
        Connection con=null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection(url,user,pass); 
            
        } catch (ClassNotFoundException ex){
            System.out.println("No se pudo registrar el Driver. " 
                    + ex.toString());
        } catch (SQLException ex) {
            System.out.println("No se pudo establecer la Conexión. " 
                    + ex.toString());
        }
        return con;
    }//fin método 
}