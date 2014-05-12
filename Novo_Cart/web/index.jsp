<%-- 
    Document   : index
    Created on : 15/04/2014, 15:41:44
    Author     : Saturno
--%>

<%@page import="model.CarrinhoProduto"%>
<%@page import="model.Carrinho"%>
<%@page import="model.Produto"%>
<%@page import="model.Cliente"%>
<%@page import="model.EnderecoCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%

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
    
    Cliente user = new Cliente(0, nome, cpf, email, senha, endereco);
    
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
    String nomeProd4 = "Suplemento Macho Man";
    String descr4 = "Fique bombado e sarado igual ao Pit Bicha, au au!";
    String img4 = "img/suplemento.png";
    
    Produto p4 = new Produto(idProduto++, quantidadeEstoque, valor4, nomeProd4, descr4, img4);
    
    Carrinho cart = new Carrinho(0, 0);
    
    session.setAttribute("p1", p1);
    session.setAttribute("p2", p2);
    session.setAttribute("p3", p3);
    session.setAttribute("p4", p4);
    
    if(session.getAttribute("user") == null){
        session.setAttribute("user", user);
    }
    
    if(session.getAttribute("carrinho") == null){
     session.setAttribute("carrinho", cart);   
    }
    
    Cliente client = (Cliente) session.getAttribute("user");
    
    String add = request.getParameter("add");
    if (add != null){
    if(add.equals("true")){
        out.println("<script>");
        out.print("alert('Produto adicionado com sucesso!');");;
        out.println("</script>");
    }
    }
%>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style/norm_grid.min.css">
        <link rel="stylesheet" type="text/css" href="style/main.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Express Sale</title>
    </head>
    <body>
        <div id="head" class="grid">

            <div class="col-1-1">
                <div class="col-1-6" id="logo">
                    <img src="img/logo.png">
                </div>
                <div class="col-1-2" id="title">
                    <h1>Express Sale</h1>
                </div>
                <div class="col-1-3" id="side">

                    <div id="login" class="col-1-2 push-1-2">
                        <% 
                            if (client.isOnline() == true) {
                        %>
                        <p>Bem vindo 
                        <%
                                out.println("<a href='chk_cart.jsp'>"+client.getNomeCompleto()+"</a>");
                            }
                         %>
                        </p>
                        <%
                            if (client.isOnline() == false) {
                        %>
                        <a href="login.jsp">Faça seu login</a>
                        <%
                            }
                        %>
                    </div>
                    <div id="srch" class="col-1-1">
                        <input type="text" placeholder="Pesquisar" /><img src="img/search.png"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="grid">
            <div id="top_menu">
                    <ul id="lista">
                        <li>Selecione seu departamento: </li>
                        <li>Eletrônicos</li>
                        <li>Livros</li>
                        <li>Móveis</li>
                        <li>Brinquedos</li>
                        <li class="destaq"> <a href="index.jsp">Mais Vendidos!</a></li>
                    </ul>
            </div>
        </div>
        <div class="grid" id="produtos">
            <h1>Confirma os produtos mais vendidos no site:</h1>
            <div class="col-1-4 produto">
                <img src="<% out.println(p1.getImagemProduto()); %>">
                <p><a href="/Novo_Cart/detalhes.jsp?p=p1"><% out.println(p1.getNome()); %></a> R$ <% out.println(p1.getValor()); %> </p>
                <a href="carrinho?p=<% out.println(p1.getIdProduto()); %>"><input type="button" class="compra" value="Comprar!" id="p1" /></a>
            </div>

            <div class="col-1-4 produto">
                <img src="<% out.println(p2.getImagemProduto()); %>">
                <p><a href="/Novo_Cart/detalhes.jsp?p=p2"><% out.println(p2.getNome()); %></a> R$ <% out.println(p2.getValor()); %> </p>
                <a href="carrinho?p=<% out.println(p2.getIdProduto()); %>"><input type="button" class="compra" value="Comprar!" id="p2" /></a>
            </div>
            
            <div class="col-1-4 produto">
                <img src="<% out.println(p3.getImagemProduto()); %>">
                <p><a href="/Novo_Cart/detalhes.jsp?p=p3"><% out.println(p3.getNome()); %></a> R$ <% out.println(p3.getValor()); %> </p>
                <a href="carrinho?p=<% out.println(p3.getIdProduto()); %>"><input type="button" class="compra" value="Comprar!" id="p3" /></a>
            </div>
            
            <div class="col-1-4 produto">
                <img src="<% out.println(p4.getImagemProduto()); %>">
                <p><a href="/Novo_Cart/detalhes.jsp?p=p4"><% out.println(p4.getNome()); %></a> R$ <% out.println(p4.getValor()); %> </p>
                <a href="carrinho?p=<% out.println(p4.getIdProduto()); %>"><input type="button" class="compra" value="Comprar!" id="p4" /></a>
            </div>

        </div>
        
    </body>
</html>
