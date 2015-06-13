/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peloduro.Controlador;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.catalina.Session;
import peloduro.DAO.DAOCliente;
import peloduro.DAO.DaoCita;
import peloduro.modelo.Cita;
import peloduro.modelo.Cliente;

public class ControladorCita extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        ArrayList<Cita> lstCita;
        RequestDispatcher rd;
        Cita cita = new Cita();
        DaoCita DAOCit = new DaoCita();
        if (request.getParameter("op").equals("IngresarCita")) {
            cita.setCliente(request.getParameter("txtRut"));
            cita.setFecha(Date.valueOf(request.getParameter("txtFecha")));
            cita.setHora(request.getParameter("cmbHora"));
            cita.setEmpleado(request.getParameter("cmbEmpleado"));
            cita.setRequerimiento(request.getParameter("cmbRequerimiento"));
            DAOCit.AgregarCita(cita);
            request.setAttribute("cliente", cita);
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
        } else if (request.getParameter("op").equals("BuscarCita")) {
            Date strFecha = Date.valueOf(request.getParameter("txtFecha"));
            lstCita = new ArrayList();
            lstCita = DAOCit.BuscarCita(strFecha);
            request.setAttribute("citas", lstCita);
            request.getRequestDispatcher("listadoCita.jsp").forward(request, response);     
       
        }else if (request.getParameter("op").equals("confirmaCita")) {
            cita.setCliente(request.getParameter("cliente"));
            cita.setFecha(Date.valueOf(request.getParameter("fecha")));
            cita.setHora(request.getParameter("hora"));
            cita.setEmpleado(request.getParameter("empleado"));
            cita.setRequerimiento(request.getParameter("req"));
            DAOCit.ConfirmacionCita(cita);
            request.getRequestDispatcher("atenConfirmadas.jsp").forward(request, response);
            
        }else if (request.getParameter("op").equals("realizaCita")) {
            cita.setCliente(request.getParameter("cliente"));
            cita.setFecha(Date.valueOf(request.getParameter("fecha")));
            cita.setHora(request.getParameter("hora"));
            cita.setEmpleado(request.getParameter("empleado"));
            cita.setRequerimiento(request.getParameter("req"));
            DAOCit.RealizacionCita(cita);
            request.getRequestDispatcher("atenRealizadas.jsp").forward(request, response);
        
        } else if (request.getParameter("op").equals("BuscarCitaAgendada")) {
            Date strFecha = Date.valueOf(request.getParameter("txtFecha"));
            lstCita = new ArrayList();
            lstCita = DAOCit.BuscarCitaAgendada(strFecha);
            request.setAttribute("citas", lstCita);
            request.getRequestDispatcher("reporteAgendado.jsp").forward(request, response);     
        
        }else if (request.getParameter("op").equals("BuscarCitaRealizada")) {
            Date strFecha = Date.valueOf(request.getParameter("txtFecha"));
            lstCita = new ArrayList();
            lstCita = DAOCit.BuscarCitaRealizada(strFecha);
            request.setAttribute("citas", lstCita);
            request.getRequestDispatcher("reporteRealizado.jsp").forward(request, response);     
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
