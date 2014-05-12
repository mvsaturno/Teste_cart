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
public class EnderecoCliente {
    String endereco;
    String CEP;
    String estado;
    String cidade;
    String pais;
    String complemento;

    public EnderecoCliente(String endereco, String CEP, String estado, String cidade, String pais, String complemento) {
        this.endereco = endereco;
        this.CEP = CEP;
        this.estado = estado;
        this.cidade = cidade;
        this.pais = pais;
        this.complemento = complemento;
    }

    public EnderecoCliente() {
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    
}
