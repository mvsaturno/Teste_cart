/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.PropertiesManager;

/**
 *
 * @author Karen
 */
public class DBConnection {

    private static String user;
    private static String senha;
    private static String url;
    private static Connection conexao;

   
    public DBConnection(String user, String senha, String url, String driver) throws ClassNotFoundException, SQLException {
        this.user = user;
        this.senha = senha;
        this.url = url;
        //this.DRIVER = driver;       
        Class.forName(driver); //registra o DRIVER
    }

   public void closeConnection() throws SQLException {
        if (conexao != null) {
            conexao.close();
            conexao = null;
        }
    }

   public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if(conexao == null){
            conexao = DriverManager.getConnection(url, user, senha);               
        }
        return conexao;
    }

  public static void main(String[] args) {
        try {
            DBConnection db = new DBConnection("b211", "b211", "jdbc:oracle:thin:@oracle.inf.poa.ifrs.edu.br:1521:XE", "oracle.jdbc.OracleDriver");
            Connection conex1= DBConnection.getConnection();
            System.out.println("Conexão 1 = " + conex1);
            
            Connection conex2= DBConnection.getConnection();
            System.out.println("Conexão 2 = " + conex2);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
  
}
