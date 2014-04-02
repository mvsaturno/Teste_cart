package model;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author paddock
 */
public interface OperacoesDAO {
 
    void inserir (Object obj) throws SQLException;
    
    boolean excluir (Object obj) throws SQLException;
    
    void editar (Object obj) throws SQLException;
    
    ArrayList pesquisar() throws SQLException; //Pesquisar tudo 
    
}
