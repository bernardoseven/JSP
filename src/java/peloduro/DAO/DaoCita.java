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
import peloduro.modelo.Cliente;


public class DaoCita extends ConDB{
    
    public void AgregarCita(Cita cita) {
        Connection con;
        DAORequerimiento DAOReq = new DAORequerimiento();
        try {
            con = this.getConexion();
            //Generar Sql de Inserción
            String strSQL = "Insert into Cita (fecha,hora,empleado,requerimiento,cliente,precio,estado) values (?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(strSQL);
            //definición de parametros       
            ps.setDate(1, (Date) cita.getFecha());
            ps.setString(2, cita.getHora());
            ps.setString(3, cita.getEmpleado());
            ps.setString(4, cita.getRequerimiento());
            ps.setString(5, cita.getCliente());
            ps.setInt(6, DAOReq.BuscarPrecio(cita.getRequerimiento()));
            ps.setString(7, "Reservado");
            ps.executeQuery();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoCita.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Cita> BuscarCita (Date fechaCita){
        ArrayList<Cita> lstCita = new ArrayList();
        Cita cita;
        try {
            Connection con = this.getConexion();
            String strSQL = "select * from Cita WHERE fecha = ?";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setDate(1, fechaCita);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                cita = new Cita();
                cita.setFecha(res.getDate("fecha"));
                cita.setHora(res.getString("hora"));
                cita.setEmpleado(res.getString("empleado"));
                cita.setRequerimiento(res.getString("requerimiento"));
                cita.setCliente(res.getString("cliente"));               
                lstCita.add(cita);
            }
            res.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoCita.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lstCita;

    }
   
    public void ConfirmacionCita(Cita cita) {
        Connection con;
        try {
            con = this.getConexion();
            String strSQL = "Update Cita set estado= 'Confirmado' "
                    + "WHERE fecha = ? AND hora = ? AND empleado=?"
                    + "AND requerimiento=? AND cliente = ? ";        
            PreparedStatement ps = con.prepareStatement(strSQL);
            //definición de parametros       
            ps.setDate(1, (Date) cita.getFecha());
            ps.setString(2, cita.getHora());
            ps.setString(3, cita.getEmpleado());
            ps.setString(4, cita.getRequerimiento());
            ps.setString(5, cita.getCliente());
            ps.executeQuery();
            ps.close();
            con.close();            
        } catch (SQLException ex) {
            Logger.getLogger(DaoCita.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public void RealizacionCita(Cita cita) {
        Connection con;
        try {
            con = this.getConexion();
            String strSQL = "Update Cita set estado= 'Realizado' "
                    + "WHERE fecha = ? AND hora = ? AND empleado=?"
                    + "AND requerimiento=? AND cliente = ? ";        
            PreparedStatement ps = con.prepareStatement(strSQL);
            //definición de parametros       
            ps.setDate(1, (Date) cita.getFecha());
            ps.setString(2, cita.getHora());
            ps.setString(3, cita.getEmpleado());
            ps.setString(4, cita.getRequerimiento());
            ps.setString(5, cita.getCliente());
            ps.executeQuery();
            ps.close();
            con.close();            
        } catch (SQLException ex) {
            Logger.getLogger(DaoCita.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        }
    
    public ArrayList<Cita> ListaCitaConfirmada (){
        ArrayList<Cita> lstCita = new ArrayList();
        Cita cita;
        try {
            Connection con = this.getConexion();
            String strSQL = "select * from Cita WHERE estado ='Confirmado'";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                cita = new Cita();
                cita.setFecha(res.getDate("fecha"));
                cita.setHora(res.getString("hora"));
                cita.setEmpleado(res.getString("empleado"));
                cita.setRequerimiento(res.getString("requerimiento"));
                cita.setCliente(res.getString("cliente"));               
                lstCita.add(cita);
            }
            res.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoCita.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lstCita;

    }
        
    public ArrayList<Cita> ListaCitaRealizada (){
        ArrayList<Cita> lstCita = new ArrayList();
        Cita cita;
        try {
            Connection con = this.getConexion();
            String strSQL = "select * from Cita WHERE estado ='Realizado'";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                cita = new Cita();
                cita.setFecha(res.getDate("fecha"));
                cita.setHora(res.getString("hora"));
                cita.setEmpleado(res.getString("empleado"));
                cita.setRequerimiento(res.getString("requerimiento"));
                cita.setCliente(res.getString("cliente"));               
                lstCita.add(cita);
            }
            res.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoCita.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lstCita;

    }
    
    public ArrayList<Cita> BuscarCitaAgendada (Date fechaCita){
        ArrayList<Cita> lstCita = new ArrayList();
        Cita cita;
        try {
            Connection con = this.getConexion();
            String strSQL = "select * from Cita WHERE fecha = ? and estado='Agendado'";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setDate(1, fechaCita);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                cita = new Cita();
                cita.setFecha(res.getDate("fecha"));
                cita.setHora(res.getString("hora"));
                cita.setEmpleado(res.getString("empleado"));
                cita.setRequerimiento(res.getString("requerimiento"));
                cita.setPrecio(res.getInt("precio"));
                cita.setCliente(res.getString("cliente"));               
                lstCita.add(cita);
            }
            res.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoCita.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lstCita;

    }
    
    public ArrayList<Cita> BuscarCitaRealizada (Date fechaCita){
        ArrayList<Cita> lstCita = new ArrayList();
        Cita cita;
        try {
            Connection con = this.getConexion();
            String strSQL = "select * from Cita WHERE fecha = ? and estado='Realizado'";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setDate(1, fechaCita);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                cita = new Cita();
                cita.setFecha(res.getDate("fecha"));
                cita.setHora(res.getString("hora"));
                cita.setEmpleado(res.getString("empleado"));
                cita.setRequerimiento(res.getString("requerimiento"));
                cita.setCliente(res.getString("cliente"));
                cita.setPrecio(res.getInt("precio"));
                lstCita.add(cita);
            }
            res.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoCita.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lstCita;

    }
}
