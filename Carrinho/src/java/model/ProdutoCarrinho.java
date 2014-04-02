/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author leonardo.loeck
 */
public class ProdutoCarrinho {
    private int idProduto;
    private int idCarrinho;
    private int quantidade;

    public ProdutoCarrinho(int idProduto, int idCarrinho, int quantidade) {
        this.idProduto = idProduto;
        this.idCarrinho = idCarrinho;
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(int idCarrinho) {
        this.idCarrinho = idCarrinho;
    }
    
    
}
