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
 * @author leonardo.loeck
 */
public class ClienteDAO implements OperacoesDAO{
    private Connection conexao;

    public ClienteDAO() throws ClassNotFoundException, SQLException {     
            conexao = DBConnection.getConnection();
    }

    //TODO: Completar inserir Usuario
    @Override
    public void inserir(Object obj) throws SQLException {
        String SQL = buscaSQL("insert.Usuario");
        if (obj instanceof Cliente) {
            Cliente user = (Cliente) obj;
            
            PreparedStatement st = conexao.prepareStatement(SQL);
            st.setString(1, user.getNome());
            st.setString(2, user.getEmail());
            st.setString(3, user.getSenha());
            st.setString(4, user.getCpf());
            st.setString(5, user.getEstado());
            st.setString(6, user.getCidade());
            st.setString(7, user.getRua());
            st.setString(8, user.getNumero());
            st.setString(9, user.getComplemento());
            st.setString(10, user.getCep());
            
            
            //st.setBoolean(5, user.isEhGerente());
            st.execute();
            
        }
    }
    
//    public void inserirCliente(Object obj) throws SQLException {
//        String SQL = buscaSQL("insert.Usuario.Cliente");
//        if (obj instanceof Cliente) {
//            Cliente user = (Cliente) obj;
//            
//            PreparedStatement st = conexao.prepareStatement(SQL);
//            st.setString(1, user.getCpf());
//            st.setString(2, user.getNome());
//            st.setString(3, user.getEmail());
//            st.setString(4, user.getSenha());
//            st.setString(5, user.getEndereco());
//            st.setString(6, user.getTelefone());
//           
//            st.execute();
//            
//        }
//    }

    @Override
    public boolean excluir(Object obj) throws SQLException {
        String SQL = buscaSQL("delete.Usuario");
        if (obj instanceof Cliente) {
            Cliente user = (Cliente) obj;
            PreparedStatement st = conexao.prepareStatement(SQL);
            st.setString(1, user.getCpf());
            st.execute();
            st.close();
        }
        return true;
    }

    @Override
    public void editar(Object obj) throws SQLException {
        String SQL = buscaSQL("Update.Usuario");
        //if (obj instanceof Pessoa) {
            Cliente user = (Cliente) obj;
            PreparedStatement st = conexao.prepareStatement(SQL);            
            st.setString(1, user.getNome());
            st.setString(2, user.getEmail());
            st.setString(3, user.getSenha());
            st.setString(4, user.getCpf());
            st.setString(5, user.getEstado());
            st.setString(6, user.getCidade());
            st.setString(7, user.getRua());
            st.setString(8, user.getNumero());
            st.setString(9, user.getComplemento());
            st.setString(10, user.getCep());
            st.execute();
            st.close();
        //}
            
    }

    @Override
    public ArrayList pesquisar() throws SQLException {
        ArrayList retorno = new ArrayList();
        String SQL = buscaSQL("selectAll.Usuario");
        Statement st = conexao.createStatement();
        ResultSet res = st.executeQuery(SQL);
        while (res.next()) {
            String nome = res.getString(1);
            String email = res.getString(2);
            String senha = res.getString(3);
            String cpf = res.getString(4);
            String estado = res.getString(5);
            String cidade = res.getString(6);
            String rua = res.getString(7);
            String numero = res.getString(8);
            String complemento = res.getString(9);
            String cep = res.getString(10);
            
            
            Cliente user = new Cliente(nome, email, senha, cpf, estado, cidade, rua, numero, complemento, cep);
            retorno.add(user);
            /*
             * 
             * TESTE
             * 
             * 
             */
        }
        return retorno;
    }

    public Cliente pesquisarLogin(String chave) throws SQLException {
        Cliente user = null;
        String SQL = buscaSQL("selectByLogin.Usuario");
        PreparedStatement st = conexao.prepareStatement(SQL);
        st.setString(1, chave);
        ResultSet res = st.executeQuery();
        while (res.next()) {
            String nome = res.getString(1);
            String email = res.getString(2);
            String senha = res.getString(3);
            String cpf = res.getString(4);
            String estado = res.getString(5);
            String cidade = res.getString(6);
            String rua = res.getString(7);
            String numero = res.getString(8);
            String complemento = res.getString(9);
            String cep = res.getString(10);
            
            
            user = new Cliente(nome, email, senha, cpf, estado, cidade, rua, numero, complemento, cep);
        }
        return user;
    }
    
    public Cliente pesquisarCPF(String chave) throws SQLException {
        Cliente user = null;
        String SQL = buscaSQL("selectByCPF.Usuario");
        PreparedStatement st = conexao.prepareStatement(SQL);
        st.setString(1, chave);
        ResultSet res = st.executeQuery();
        while (res.next()) {
            String nome = res.getString(1);
            String email = res.getString(2);
            String senha = res.getString(3);
            String cpf = res.getString(4);
            String estado = res.getString(5);
            String cidade = res.getString(6);
            String rua = res.getString(7);
            String numero = res.getString(8);
            String complemento = res.getString(9);
            String cep = res.getString(10);
            
            
            user = new Cliente(nome, email, senha, cpf, estado, cidade, rua, numero, complemento, cep);
        }
        return user;
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
