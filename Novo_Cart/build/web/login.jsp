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
    Produto p1 = (Produto) session.getAttribute("p1");
    Produto p2 = (Produto) session.getAttribute("p2");
    Produto p3 = (Produto) session.getAttribute("p3");
    Produto p4 = (Produto) session.getAttribute("p4");
    String pId = request.getParameter("p");

    String email = request.getParameter("email");
    String senha = request.getParameter("senha");

    String online = request.getParameter("online");
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
        <div id="main_login" class="grid">
            <div class="col-1-1">
                <h1>Faça seu login pra continuar:</h1>
                <form action="/Novo_Cart/login_servlet" method="GET" class="login">
                    <table>
                        <tr>
                            <td><label>Usuario (email): </label></td>
                            <td><input type="email" placeholder="Email" name="email" required /></td>
                        </tr>
                        <tr>
                            <td><label>Senha: </label></td>
                            <td><input type="password" placeholder="senha" name="senha" required /></td>
                        </tr>
                        <tr>
                            <td><input type="hidden" name="pId" value="<% out.print(pId);%>" /></td>
                            <td><input type="submit" value="Login" /></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>

    </body>
</html>
