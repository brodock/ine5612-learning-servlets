<%-- 
Document   : cad_fornecedor
Created on : 08/10/2007, 19:27:06
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
        <title>Cadastro de Fornecedores</title>
    </head>
    <body>
        <div align="center">
            <h2>Cadastrar Fornecedor</h2><br/><br/>
            <form name="form_cadastro" action="ServletFornecimento" method="POST">
            <% if (request.getParameter("id") != null) { %>
            <input type="hidden" id="id" name="id" value="<%=request.getParameter("id") %>" />
            <% } %>
            <label title="Nome Fantasia da Empresa"><br/>Nome Fantasia: <input type="text" name="nome" value="<%=request.getAttribute("nome") == null?"":request.getAttribute("nome") %>"  /></label><br/>Produto:
            <select id="produto" name="produto">
                <% 
                ArrayList<Produto> produtos = (ArrayList<Produto>)request.getAttribute("produtos");


                for(Produto p: produtos) { %>
                <option value="<%=p.getIdProduto() %>"<%=request.getAttribute("produto") == p.getNome()?"selected=\"selected\"":"" %>><%=p.getNome() %></option>
                <% } %>
            </select>

            <label title="Cidade da Matriz"><br/>Cidade: <input type="text" name="cidade" value="<%=request.getAttribute("cidade") == null?"":request.getAttribute("cidade") %>"  /></label>
            <label title="Estado da Matriz"><br/>Estado: <input type="text" name="estado" value="<%=request.getAttribute("estado") == null?"":request.getAttribute("estado") %>"  /></label>
            <label title="Pais da Matriz"><br/>Pais: <input type="text" name="pais" value="<%=request.getAttribute("pais") == null?"":request.getAttribute("pais") %>"  /></label>
            <label title="Endereço"><br/>Endereço: <input type="text" name="endereco" value="<%=request.getAttribute("endereco") == null?"":request.getAttribute("endereco") %>"  /></label>
            <label title="Telefone para contato"><br/>Telefone: <input type="text" name="telefone" value="<%=request.getAttribute("telefone") == null?"":request.getAttribute("telefone") %>"  /></label>
            <label title="e-mail para contato"><br/>E-mail: <input type="text" name="email" value="<%=request.getAttribute("email") == null?"":request.getAttribute("email") %>"  /></label>
            <label title="Pessoa a contatar"><br/>Contato: <input type="text" name="contato" value="<%=request.getAttribute("contato") == null?"":request.getAttribute("contato") %>"  /></label>
            <label title="enviar formulário"><br/><input type="submit" id ="salvar" value="Salvar" name="salvar" /></label>
                <input type="hidden" name="action" value="save" />
            </form>
        </div>
    </body>
</html>