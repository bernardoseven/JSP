/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peloduro.Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import peloduro.DAO.DAOCliente;
import peloduro.modelo.Cliente;

public class Sesion extends HttpServlet {

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
        DAOCliente DAOCli = new DAOCliente();
        Cliente cliente = new Cliente();

        if (request.getParameter("op").equals("Login")) {
            RequestDispatcher rd;
            ServletContext contexto = this.getServletContext();
            contexto.log(new Date() + " - Reporte de Inicio de Sesion:");
            Cliente usuario = new Cliente();
            HttpSession sesion = request.getSession();
            
            String user = request.getParameter("txtRut");
            String passw = request.getParameter("txtPass");
                             
                    
            usuario = DAOCli.VerificarCliente(request.getParameter("txtRut"), request.getParameter("txtPass"));
            if (usuario.getRut().isEmpty()) {
                if (sesion.isNew()) {
                    contexto.log(new Date() + " - User: " + usuario.getRut());
                    contexto.log(new Date() + " - Password: " + usuario.getPassword());
                    sesion.setAttribute("UsuarioRut", usuario.getRut());

                    rd = request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
                } else {
                    contexto.log(new Date() + " - Sesión existente.");
                }
            } else {
                contexto.log(new Date() + " - ¡Error usuario o password!");
                rd = request.getRequestDispatcher("atencion.jsp");
                rd.forward(request, response);
            }
            
            
        } else if (request.getParameter("op").equals("Logout")) {
            RequestDispatcher rd;
            HttpSession sesion = request.getSession(false);
            //Verificar que la sesión exista para cerrarla.
            if (sesion != null) {
                //Procedo a cerrar la sesión del usuario
                sesion.invalidate();
                rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            } else {
            //Se indica que la sesión no está abierta.
                //Redireccionar o enviar mensaje al usuario para 
                //indicarle que la sesión no existía.
            }
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
