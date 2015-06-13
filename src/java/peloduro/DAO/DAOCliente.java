/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package peloduro.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import peloduro.modelo.Cliente;

public class DAOCliente extends ConDB{

    public void AgregarCliente(Cliente cli) {
        Connection con;
        try {
            con = this.getConexion();
            //Generar Sql de Inserción
            String strSQL = "Insert into Cliente (rut,nombre,comuna,email,password,fono,tipo) values (?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(strSQL);
            //definición de parametros
            
            ps.setString(1, cli.getRut());
            ps.setString(2, cli.getNombre());
            ps.setString(3, cli.getComuna());
            ps.setString(4, cli.getEmail());
            ps.setString(5, cli.getPassword());
            ps.setInt(6, cli.getFono());
            ps.setString(7, "User");
            ps.executeQuery();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Cliente VerificarCliente(String rut, String passw) {
        Cliente cli = new Cliente();
        try {
            Connection con = this.getConexion();
            String strSQL = "select * from CLIENTE WHERE RUT = ? AND PASSWORD = ?";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setString(1, rut);
            ps.setString(2, passw);
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                cli.setRut(res.getString("rut"));
                cli.setNombre(res.getString("nombre"));
                cli.setComuna(res.getString("comuna"));
                cli.setEmail(res.getString("email"));
                cli.setPassword(res.getString("password"));
                cli.setFono(res.getInt("fono"));
                cli.setTipo(res.getString("tipo"));
                Logger.getLogger(DAOCliente.class.getName()).
                        log(Level.INFO, "Rut {0} encontrado. ", cli);
            } else {
                Logger.getLogger(DAOCliente.class.getName()).
                        log(Level.WARNING, "Rut {0} NO encontrado. ", cli);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).
                    log(Level.SEVERE, "Error en SQL. ", ex);
        }

        return cli;
    }
    
}
