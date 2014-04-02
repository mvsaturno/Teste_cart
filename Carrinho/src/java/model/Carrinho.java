/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author paddock
 */
public class Carrinho {
    int idCarrinho;
    //Cliente cliente;
    private int idCliente;
    Date dataCompra;
    private double valorTotal;
    
    

    public Carrinho(int idCarrinho, int idCliente, Date dataCompra) {
        this.idCarrinho = idCarrinho;
        this.idCliente = idCliente;
        this.dataCompra = dataCompra;
    }
    
    public Carrinho(int idCliente, Date dataCompra) {
        
        this.idCliente = idCliente;
        this.dataCompra = dataCompra;
    }
    
    public Carrinho(int idCliente) { // inicia o carrinho com o valor zero, que deverá ser atualizado depois
        // a data inicializa com a inclusao no banco de dados.
        this.idCliente = idCliente;
        this.valorTotal = 0;
    }
    
    

    public int getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(int idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    /**
     * @return the valorTotal
     */
    public double getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    
    
}
