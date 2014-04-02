<%-- 
    Document   : inserirproduto
    Created on : 31/03/2014, 22:47:23
    Author     : LEONARDO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <FORM METHOD="GET" ACTION='FrontController'>
            <P> Por favor, forneça as informações abaixo solicitadas </P>
            <TABLE>
                <TR> <TD> ID do produto : </TD> <TD> <INPUT TYPE=TEXT SIZE=50 NAME = "idproduto"> </TD> </TR> 
                <TR> <TD> Quantidade : </TD> <TD> <INPUT TYPE=TEXT SIZE=30 NAME = "quantidade"> </TD> </TR>
                <TR> <TD> ID cliente : </TD> <TD> <INPUT TYPE=TEXT SIZE=30 NAME = "idcliente"> </TD> </TR>
                
            </TABLE>
            <input type="hidden" name="servlet" value="inserirproduto">
            <P><INPUT TYPE=SUBMIT VALUE="Adicionar ao carrinho"> 
                <INPUT TYPE=RESET VALUE="LIMPAR"> 
            </p>
        </FORM>
    </body>
</html>
