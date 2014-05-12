/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author 0871117
 */
public class CarrinhoProduto {
    Produto produto;
    int qtdeCarrinho;
    int idCarrinho;

    public CarrinhoProduto() {
    }

    public CarrinhoProduto(Produto produto, int qtdeCarrinho) {
        this.produto = produto;
        this.qtdeCarrinho = qtdeCarrinho;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQtdeCarrinho() {
        return qtdeCarrinho;
    }
    
    public double getValorTotalProduto(){
        return qtdeCarrinho * produto.valor;
    }

    public void setQtdeCarrinho(int qtdeCarrinho) {
        this.qtdeCarrinho = qtdeCarrinho;
    }
    
    
}
