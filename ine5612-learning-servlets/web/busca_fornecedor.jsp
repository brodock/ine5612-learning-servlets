<%-- 
Document   : busca_fornecedor
Created on : 25/10/2007, 11:22:36
Author     : Gabriel, Ramon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ine5612.persistence.Produto" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Busca de Fornecedores</title>
    </head>
    <body>
        <h2>Buscar Fornecedor</h2><form name="form_busca" action="ServletFornecimento" method="POST">
            
            <input type="radio" name="param_busca" value="nome" checked="checked" />Nome 
            <input type="radio" name="param_busca" value="produto" /> Produto: <select name="listaproduto">
                <% 
                ArrayList<Produto> produtos = (ArrayList<Produto>)request.getAttribute("produtos");


                for(Produto p: produtos) { %>
                <option value="<%=p.getIdProduto() %>"<%=request.getAttribute("produto") == p.getNome()?"selected=\"selected\"":"" %>><%=p.getNome() %></option>
                <% } %>
            </select>
            
            <br/><input type="text" name="texto" value="" />
            <br/><br/>
            <input type="hidden" name="action" value="search" />
            <input type="submit" id="buscar" value="Buscar" name="buscar" />
        </form>
    </body>
</html>
