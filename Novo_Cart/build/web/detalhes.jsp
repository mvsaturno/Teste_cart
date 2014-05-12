<%-- 
    Document   : index
    Created on : 15/04/2014, 15:41:44
    Author     : Saturno
--%>

<%@page import="model.Produto"%>
<%@page import="model.Cliente"%>
<%@page import="model.EnderecoCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    Cliente user = (Cliente) session.getAttribute("user");

    String pId = request.getParameter("p");
    Produto produto = (Produto) session.getAttribute(pId);

    
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
                            if (user.isOnline() == true) {
                        %>
                        <p>Bem vindo 
                            <%
                                    out.println(user.getNomeCompleto());
                                }
                            %>
                        </p>
                        <%
                            if (user.isOnline() == false) {
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
        <div id="details" class="grid">
            <div class="col-1-1">
                <div>
                    <img src="<% out.println(produto.getImagemProduto()); %>" class="col-1-3" id="img_prd" />
                </div>
                <div>
                    <h2> <% out.println(produto.getNome()); %> </h2>

                    <h4>Descrição:</h4>
                    <p><% out.println(produto.getDescricao()); %></p>

                    <p>R$ <% out.print(produto.getValor());%> </p>
                </div>
                <div>
                    <a href="/Novo_Cart/index.jsp"><Button>Voltar</Button></a>
                    <a href="carrinho?p=<% out.println(produto.getIdProduto()); %>"><input type="button" class="compra" value="Adicionar ao Carrinho!" id="prod" /></a>
                </div>
            </div>
        </div>

    </body>
</html>
