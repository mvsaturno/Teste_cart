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
import java.util.logging.Level;
import java.util.logging.Logger;
import util.PropertiesManager;
/**
 *
 * @author LEONARDO
 */
public class CarrinhoDAO implements OperacoesDAO{
    
    private static CarrinhoDAO instancia = null;
    private Connection conexao;
    
    public CarrinhoDAO() throws ClassNotFoundException, SQLException {     
            conexao = DBConnection.getConnection();
    }
   
    
    @Override
    public void inserir(Object obj) throws SQLException {
        String SQL = buscaSQL("insert.Carrinho");
        if (obj instanceof Carrinho) {
            Carrinho user = (Carrinho) obj;
            PreparedStatement st = conexao.prepareStatement(SQL);
            
            st.setInt(1, user.getIdCliente());
            st.setDouble(2, user.getValorTotal());
            
            
            st.execute();
            
            
        }
        
    }
    
    public int inserir2(Object obj) throws SQLException { //cria o carrinho e retorna o id dele
        String SQL = buscaSQL("insert.Carrinho");
        int idcarrinho = 0;
        if (obj instanceof Carrinho) {
            
            Carrinho user = (Carrinho) obj;
            PreparedStatement st = conexao.prepareStatement(SQL);
            
            st.setInt(1, user.getIdCliente());
            st.setDouble(2, user.getValorTotal());
            
            
            st.execute();
            
            String SQL2 = buscaSQL("selectById.carrinho");
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
        String SQL = buscaSQL("delete.Carrinho");
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
        String SQL = buscaSQL("Update.Carrinho");
       
            Carrinho carrinho = (Carrinho) obj;
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
        String SQL = buscaSQL("selectAll.Carrinho");
        Statement st = conexao.createStatement();
        ResultSet res = st.executeQuery(SQL);
        while (res.next()) {
            int id = res.getInt(1);
            String nome = res.getString(2);
            String informacoes = res.getString(3);
            Double valor = res.getDouble(4);
            
            Carrinho prod = new Carrinho(id, nome, informacoes, valor);
            retorno.add(prod);
        }
        return retorno;
    }
    
    public void atualizarValor(int idCar, double valor)throws SQLException {
         String SQL = buscaSQL("updateValor.carrinho");
        
            
            PreparedStatement st = conexao.prepareStatement(SQL);
            st.setDouble(1, valor);
            st.setInt(2, idCar);
            st.execute();
            st.close();
        
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
