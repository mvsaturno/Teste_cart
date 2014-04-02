/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import database.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author KAREN
 */
@WebServlet(name = "FrontController", urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {
     
    HashMap controle;
    
    
    @Override
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        ServletContext contexto = getServletContext();
        String USER = contexto.getInitParameter("user");
        String SENHA = contexto.getInitParameter("senha"); 
        String URL = contexto.getInitParameter("url");
        String DRIVER = contexto.getInitParameter("driver");
        
        controle = new HashMap();
        controle.put("inserirproduto","controle.TrataInserirProduto");

        try {

            DBConnection db = new DBConnection(USER, SENHA, URL, DRIVER);
            //Connection conex1= DBConnection.getConnection();
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
       
        
        
    }
    /*
    public void direct(String comandName) throws InstantiationException{
        String actionClass = (String) controle.get(comandName);        
        
        try {
            Class classe;
            classe = Class.forName(actionClass);
            Comando comando = (Comando) classe.newInstance();
            comando.executar();
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String servletName = request.getParameter("servlet");
        String ClassDestino = (String)controle.get(servletName);
        
        try{
            Class classe = Class.forName(ClassDestino);
            Comando comando = (Comando) classe.newInstance();
            comando.executar(request, response);
        } catch (ClassNotFoundException ex) {
            throw new ServletException(ex);            
        } catch (InstantiationException iex) {
            throw new ServletException(iex);
        } catch (IllegalAccessException iaex) {
            throw new ServletException(iaex);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
