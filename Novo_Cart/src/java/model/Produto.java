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
public class Produto {
    int idProduto;
    int quantidadeEstoque;
    double valor;
    String nome;
    String descricao;
    String imagemProduto;

    public Produto() {
    }

    public Produto(int idProduto, int quantidadeEstoque, double valor, String nome, String descricao, String imagemProduto) {
        this.idProduto = idProduto;
        this.quantidadeEstoque = quantidadeEstoque;
        this.valor = valor;
        this.nome = nome;
        this.descricao = descricao;
        this.imagemProduto = imagemProduto;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagemProduto() {
        return imagemProduto;
    }

    public void setImagemProduto(String imagemProduto) {
        this.imagemProduto = imagemProduto;
    }
    
    
}
