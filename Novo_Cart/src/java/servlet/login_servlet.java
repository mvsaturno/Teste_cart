package servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sun.xml.ws.transport.tcp.io.OutputWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cliente;
import model.EnderecoCliente;

/**
 *
 * @author Saturno
 */
public class login_servlet extends HttpServlet {
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        
        String pId = (String) request.getParameter("pId");
        Cliente user = (Cliente) session.getAttribute("user");
        String senha_post= (String) request.getParameter("senha");
        String email_post= (String) request.getParameter("email");
        
        if(email_post.equals(user.getEmail()) && senha_post.equals(user.getSenha())){
                //Login sucesso!
                user.setOnline(true);
                session.setAttribute("user", user);
                session.setAttribute("online", "true");
                if(pId.equals("null")){
                    response.sendRedirect("/Novo_Cart/index.jsp");
                } else {
                    response.sendRedirect("/Novo_Cart/detalhes.jsp?p=" + pId);
                }
            } else { System.out.println("Login/Senha inválidos!"); }
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
