package model;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
/**
 *
 * @author 0867110
 */
public class ProdutoDAO implements OperacoesDAO {
    
    //private ArrayList<Produto> produtos = new ArrayList();
    private static ProdutoDAO instancia = null;
    private Connection conexao;
    
    public ProdutoDAO() throws ClassNotFoundException, SQLException {     
            conexao = DBConnection.getConnection();
    }
   
    
    @Override
    public void inserir(Object obj) throws SQLException {
        String SQL = buscaSQL("insert.Produto");
        if (obj instanceof Produto) {
            Produto user = (Produto) obj;
            PreparedStatement st = conexao.prepareStatement(SQL);
            
            st.setString(1, user.getNome());
            st.setString(2, user.getInfo());
            st.setDouble(3, user.getValor());
            st.execute();
            
        }
    }

    @Override
    public boolean excluir(Object obj) throws SQLException {
        String SQL = buscaSQL("delete.Produto");
        if (obj instanceof Produto) {
            Produto user = (Produto) obj;
            PreparedStatement st = conexao.prepareStatement(SQL);
            st.setString(1, user.getNome());
            st.execute();
            st.close();
        }
        return true;
    }

    @Override
    public void editar(Object obj) throws SQLException {
        String SQL = buscaSQL("Update.Produto");
       
            Produto produto = (Produto) obj;
            PreparedStatement st = conexao.prepareStatement(SQL);            
            st.setString(1, produto.getInfo());
            st.setDouble(2, produto.getValor());
            st.setString(3, produto.getNome());
            st.setInt(4, produto.getIdProduto());
            st.execute();
            st.close();     
            
    }

    @Override
    public ArrayList pesquisar() throws SQLException {
        ArrayList retorno = new ArrayList();
        String SQL = buscaSQL("selectAll.Produto");
        Statement st = conexao.createStatement();
        ResultSet res = st.executeQuery(SQL);
        while (res.next()) {
            int id = res.getInt(1);
            String nome = res.getString(2);
            String informacoes = res.getString(3);
            Double valor = res.getDouble(4);
            
            Produto prod = new Produto(id, nome, informacoes, valor);
            retorno.add(prod);
        }
        return retorno;
    }

    
    public Produto pesquisarNome(String chave) throws SQLException {
        Produto user = null;
        String SQL = buscaSQL("selectByNome.Produto");
        PreparedStatement st = conexao.prepareStatement(SQL);
        st.setString(1, chave);
        ResultSet res = st.executeQuery();
        while (res.next()) {
            int id = res.getInt(1);
            String nome = res.getString(2);
            String informacoes = res.getString(3);
            Double valor = res.getDouble(4);
            
            user = new Produto(id, nome, informacoes, valor);
        }
        return user;
    }
    
    public Produto pesquisarId(int chave) throws SQLException {
        Produto user = null;
        String SQL = buscaSQL("selectById.Produto");
        PreparedStatement st = conexao.prepareStatement(SQL);
        st.setInt(1, chave);
        ResultSet res = st.executeQuery();
        while (res.next()) {
            int id = res.getInt(1);
            String nome = res.getString(2);
            String informacoes = res.getString(3);
            Double valor = res.getDouble(4);
            
            user = new Produto(id, nome, informacoes, valor);
        }
        return user;
    }

    public Produto ComprarProd(Object obj, Object obj2, HttpServletRequest request) throws SQLException {
        Produto prod = (Produto) obj;
        Cliente pessoa = (Cliente) obj2;
        Integer idc = null;
        String SQL = buscaSQL("insert.carrinho");
        PreparedStatement st = conexao.prepareStatement(SQL);
        st.setString(1, pessoa.getCpf());
        st.setDouble(2, prod.getValor());
        ResultSet res = st.executeQuery();
        
        String SQL2 = buscaSQL("selectById.carrinho");
        PreparedStatement st2 = conexao.prepareStatement(SQL2);
        ResultSet res2 = st2.executeQuery(); //recebe o ultimo id_carrinho
        while (res2.next()) {
            idc = res2.getInt(1);
        }
        
        
        String SQL3 = buscaSQL("insert.produto_carrinho");
        PreparedStatement st3 = conexao.prepareStatement(SQL3);
        st3.setInt(1, prod.getIdProduto());
        st3.setInt(2, idc);
        st3.setInt(3, 33);
        ResultSet res3 = st3.executeQuery();
        
        String SQL4 = buscaSQL("updateValor.carrinho");
        PreparedStatement st4 = conexao.prepareStatement(SQL4);
        st4.setDouble(1, prod.getValor());
        st4.setInt(2, idc);
        ResultSet res4 = st4.executeQuery();
        
        HttpSession session2 = request.getSession(true);
        session2.setAttribute("carrinho", idc);
        
        return prod;
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
