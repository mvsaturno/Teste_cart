/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Carrinho;
import model.CarrinhoDAO;
import model.Produto;
import model.ProdutoCarrinho;
import model.ProdutoCarrinhoDAO;
import model.ProdutoDAO;
/**
 *
 * @author LEONARDO
 */
public class TrataInserirProduto extends Comando{
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
    public void executar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

         response.sendRedirect("index.jsp"); ////////////testando -- excluir linha depois
        
        int idproduto = Integer.parseInt(request.getParameter("idproduto"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        int idcliente = Integer.parseInt(request.getParameter("idcliente"));
        
        
        
        
        Carrinho carrinho = new Carrinho(idcliente);
        
        PrintWriter out = response.getWriter();

        try {
            CarrinhoDAO dao = new CarrinhoDAO();
            int idCarrinho = dao.inserir2(carrinho);
            
           
            
            HttpSession session2 = request.getSession(true);
            session2.setAttribute("carrinho", carrinho);
            
            ProdutoCarrinho produtocarrinho = new ProdutoCarrinho(idproduto,idCarrinho,quantidade);
            
            ProdutoCarrinhoDAO dao2 = new ProdutoCarrinhoDAO();
            dao2.inserir(produtocarrinho);
            
            ProdutoDAO dao3 = new ProdutoDAO();
            Produto prod = dao3.pesquisarId(idproduto);
            
            dao.atualizarValor(idCarrinho,prod.getValor()*quantidade); //multiplica pela quantidade e atualiza valor do carrinho
            
            
            
            //falta criar produtocarrinhoDAO pra continuar
            
            response.sendRedirect("index.jsp");
            
        } catch(SQLException ex){
            throw new ServletException(ex);
        }catch (ClassNotFoundException cnfe) {
            throw new ServletException(cnfe);
        }
            out.close();
    }
    
        
}
