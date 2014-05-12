<%-- 
    Document   : index
    Created on : 15/04/2014, 15:41:44
    Author     : Saturno
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="model.CarrinhoProduto"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="model.Carrinho"%>
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
                        <%                            if (user.isOnline() == true) {
                        %>
                        <p>Bem vindo 
                            <%
                                    out.println(user.getNomeCompleto());
                                }
                            %>
                        </p>
                        <%
                            if (user.isOnline() == false) {
                                response.sendRedirect("login.jsp");
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
                    <%
                        Cliente client = (Cliente) session.getAttribute("user");
                        Carrinho cart = (Carrinho) session.getAttribute("carrinho");
                        HashMap lista = cart.getProdutos();
                        int tam = lista.size();
                    %>

                    <table class="tbl_price">
                        <tr>
                            <th>Produto: </th>
                            <th>Quantidade: </th>
                            <th>Valor: </th>
                        </tr>
                        <%
                            Iterator it = lista.entrySet().iterator();
                            while (it.hasNext()) {
                                Map.Entry pairs = (Map.Entry) it.next();
                                CarrinhoProduto pr = (CarrinhoProduto) pairs.getValue();
                                out.println("<tr>");
                                out.println("<td style='font-weight:bold'>" + pr.getProduto().getNome() + "</td>");
                                out.print("<td style='text-align:center'>" + pr.getQtdeCarrinho() + "</td>");
                                out.print("<td style='text-align:center'>" + pr.getProduto().getValor() + "</td>");
                                out.println("</tr>");
                            }
                        %>
                        <tr style="font-weight: bold; text-align: center">
                            <td colspan="2">Valor Total: </td>
                            <td> R$ 
                                <%
                                    double number = cart.getValorTotal();
                                    DecimalFormat numberFormat = new DecimalFormat("#.00");
                                    out.print(numberFormat.format(number));
                                %></td>
                        </tr>
                    </table>

                </div>
            </div>
        </div>

    </body>
</html>
