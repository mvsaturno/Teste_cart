/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package init;

import model.Cliente;
import model.EnderecoCliente;
import model.Produto;

/**
 *
 * @author Saturno
 */
public class Init {
    //endereço:
    String rua = "Avenida Beco da glória, 125";
    String CEP = "90460080";
    String estado = "RS"; 
    String cidade = "Alegrete"; 
    String pais = "Brasil"; 
    String complemento = null;
    //cliente:
    String nome = "José Ruéla da Silva";
    String cpf = "00360812501";
    String email = "ze_ruela@gmail.com";
    String senha = "12345";
    
    
    EnderecoCliente endereco = new EnderecoCliente(rua, CEP, estado, cidade, pais, complemento);
    
    Cliente user = new Cliente(nome, cpf, email, senha, endereco);
    
    //Produtos
    int idProduto = 1;
    int quantidadeEstoque = 10;
    //Produto 1
    double valor1 = 32.49;
    String nomeProd1 = "Cafeteira Italiana";
    String descr1 = "Faça cafés maravilhosos com essa ótima cafeteira italiana. Ideal para aquele cafézinho após o almoço";
    String img1 = "img/cafeteira.png";
    
    Produto p1 = new Produto(idProduto++, quantidadeEstoque, valor1, nomeProd1, descr1, img1);
    
    double valor2 = 12.49;
    String nomeProd2 = "Cereal Matinal";
    String descr2 = "Comece o seu dia com muito mais saúde e energia!";
    String img2 = "img/cereal.png";
    
    Produto p2 = new Produto(idProduto++, quantidadeEstoque, valor2, nomeProd2, descr2, img2);
    
    double valor3 = 4.99;
    String nomeProd3 = "Cerveja Tommy's";
    String descr3 = "Malte Belga, sabor incomparável! Beba com moderação";
    String img3 = "img/garrafa.png";
    
    Produto p3 = new Produto(idProduto++, quantidadeEstoque, valor3, nomeProd3, descr3, img3);
    
    double valor4 = 84.99;
    String nomeProd4 = "Suplemento Alimentar Macho Man";
    String descr4 = "Fique bombado e sarado igual ao Pit Bicha, au au!";
    String img4 = "img/suplemento.png";
    
    Produto p4 = new Produto(idProduto++, quantidadeEstoque, valor4, nomeProd4, descr4, img4);
}
