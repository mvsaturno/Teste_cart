package model;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Guilherme
 */
public class Produto implements Serializable{
    
    private int idProduto;
    private String nome;
    private String info;
    private double valor;
    
    
    public Produto(String nome, String info, double valor) {
        this.nome = nome;
        this.info = info;
        this.valor = valor;
        
    }

    public Produto(int id_prod, String nome, String info, double valor) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.info = info;
        this.valor = valor;
    }
    

    public int getIdProduto() {
        return idProduto;
    }
    
    

    

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the informacoes
     */
    public String getInfo() {
        return info;
    }

    /**
     * @param informacoes the informacoes to set
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 59 * hash + (this.info != null ? this.info.hashCode() : 0);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.valor) ^ (Double.doubleToLongBits(this.valor) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.info == null) ? (other.info != null) : !this.info.equals(other.info)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(other.valor)) {
            return false;
        }
        return true;
    }

 

    @Override
    public String toString() {
        return "Produto{" + "nome=" + nome + ", informacoes=" + info + ", valor=" + valor + '}';
    }

    /**
     * @param id_prod the id_prod to set
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
    
    
}
