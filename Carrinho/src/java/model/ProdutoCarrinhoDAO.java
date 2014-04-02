/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.DBConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import util.PropertiesManager;
import model.*;
/**
 *
 * @author LEONARDO
 */
public class ProdutoCarrinhoDAO implements OperacoesDAO{
    
    private static ProdutoCarrinhoDAO instancia = null;
    private Connection conexao;
    
    public ProdutoCarrinhoDAO() throws ClassNotFoundException, SQLException {     
            conexao = DBConnection.getConnection();
    }
   
    
    @Override
    public void inserir(Object obj) throws SQLException {
        String SQL = buscaSQL("insert.ProdutoCarrinho");
        if (obj instanceof ProdutoCarrinho) {
            ProdutoCarrinho user = (ProdutoCarrinho) obj;
            PreparedStatement st = conexao.prepareStatement(SQL);
            
            st.setInt(1, user.getIdProduto());
            st.setInt(2, user.getIdCarrinho());
            st.setInt(3, user.getQuantidade());
            
            
            st.execute();
            
        }
        
    }
    
    public int inserir2(Object obj) throws SQLException { //cria o carrinho e retorna o id dele
        String SQL = buscaSQL("insert.ProdutoCarrinho");
        int idcarrinho = 0;
        if (obj instanceof Carrinho) {
            
            ProdutoCarrinho user = (ProdutoCarrinho) obj;
            PreparedStatement st = conexao.prepareStatement(SQL);
            
            st.setInt(1, user.getIdCliente());
            st.setFloat(2, user.getValorTotal());
            
            
            st.execute();
            
            String SQL2 = buscaSQL("selectById.Produtocarrinho");
            PreparedStatement st2 = conexao.prepareStatement(SQL2);
            ResultSet res2 = st2.executeQuery(); //recebe o ultimo id_carrinho
            while (res2.next()) {
                idcarrinho = res2.getInt(1);
            }
             
        }
        return idcarrinho;
    }

    @Override
    public boolean excluir(Object obj) throws SQLException {
        String SQL = buscaSQL("delete.ProdutoCarrinho");
        if (obj instanceof Carrinho) {
            Carrinho user = (Carrinho) obj;
            PreparedStatement st = conexao.prepareStatement(SQL);
            st.setString(1, user.getNome());
            st.execute();
            st.close();
        }
        return true;
    }

    @Override
    public void editar(Object obj) throws SQLException {
        String SQL = buscaSQL("Update.ProdutoCarrinho");
       
            ProdutoCarrinho carrinho = (ProdutoCarrinho) obj;
            PreparedStatement st = conexao.prepareStatement(SQL);            
            st.setString(1, carrinho.getInfo());
            st.setDouble(2, carrinho.getValor());
            st.setString(3, carrinho.getNome());
            st.setInt(4, carrinho.getIdProduto());
            st.execute();
            st.close();     
            
    }

    @Override
    public ArrayList pesquisar() throws SQLException {
        ArrayList retorno = new ArrayList();
        String SQL = buscaSQL("selectAll.ProdutoCarrinho");
        Statement st = conexao.createStatement();
        ResultSet res = st.executeQuery(SQL);
        while (res.next()) {
            int id = res.getInt(1);
            String nome = res.getString(2);
            String informacoes = res.getString(3);
            Double valor = res.getDouble(4);
            
            ProdutoCarrinho prod = new ProdutoCarrinho(id, nome, informacoes, valor);
            retorno.add(prod);
        }
        return retorno;
    }
    
    private String buscaSQL(String chave) {
        String sql = null;
        try {
            PropertiesManager pm = new PropertiesManager("sql.properties");
            HashMap dados = pm.readPropertiesFile();
            sql = (String) dados.get(chave);
        } catch (IOException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sql;
    }
}
