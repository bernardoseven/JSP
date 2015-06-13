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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import peloduro.modelo.Cita;
import peloduro.modelo.Requerimiento;

public class DAORequerimiento extends ConDB {

    public ArrayList<Requerimiento> ListarRequerimiento() {
        Connection con;
        ArrayList<Requerimiento> lstRequerimiento = new ArrayList<Requerimiento>();
        Requerimiento req;

        try {
            con = this.getConexion();
            String strSQL = "select * from requerimiento";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                req = new Requerimiento();
                req.setRequerimiento(res.getString("requerimiento"));
                req.setDescripcion(res.getString("descripcion"));
                req.setPrecio(res.getInt("precio"));
                lstRequerimiento.add(req);
            }
            res.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAORequerimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstRequerimiento;
    }
    
    public int BuscarPrecio(String req){
        int precio=0;
        try {
            Connection con = this.getConexion();
            String strSQL = "select precio from requerimiento WHERE requerimiento = ?";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setString(1, req);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                precio = res.getInt("precio");
            }
            res.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAORequerimiento.class.getName()).log(Level.SEVERE, null, ex);
        }

        return precio;

    }
   
}
