/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author 0871117
 */
public class Carrinho {
    private int idCarrinho;
    private int idCliente;
    private double valorTotal;
    private HashMap<Integer, CarrinhoProduto> produtos;

    public HashMap<Integer, CarrinhoProduto> getProdutos() {
        return produtos;
    }

    public void setProdutos(HashMap<Integer, CarrinhoProduto> produtos) {
        this.produtos = produtos;
    }
    
    public void addProduto(Produto produto, int quantidade){
        
        if (produtos.containsKey(produto.getIdProduto())) {
            produtos.get(produto.getIdProduto()).qtdeCarrinho += quantidade;
        } else {
            produtos.put(produto.getIdProduto() , new CarrinhoProduto(produto, quantidade));
        }
    }

    public Carrinho(int idCarrinho, int idCliente, double valorTotal) {
        this.idCarrinho = idCarrinho;
        this.idCliente = idCliente;
        this.valorTotal = valorTotal;
        this.produtos = new HashMap<>();
    }
    
    public Carrinho(int idCarrinho, int idCliente) {
        this.idCarrinho = idCarrinho;
        this.idCliente = idCliente;
        this.produtos = new HashMap<>();
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

    public double getValorTotal() {
        double total = 0;
        for (int key : produtos.keySet()) {
            total += produtos.get(key).getValorTotalProduto();
        }
        
        return total;
    }

}
