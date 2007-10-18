<%-- 
Document   : cad_fornecedor
Created on : 08/10/2007, 19:27:06
Author     : Gabriel, Ramon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <label name="Nome Fantasia da Empresa"><br/>Nome Fantasia: <input type="text" name="nome" value=""  /></label>
            <label name="Produtos Fornecidos pela Empresa"><br/>Produtos Fornecidos: <input type="text" name="produto" value=""  /></label>
            <label name="Cidade da Matriz"><br/>Cidade: <input type="text" name="cidade" value=""  /></label>
            <label name="Estado da Matriz"><br/>Estado: <input type="text" name="estado" value=""  /></label>
            <label name="Pais da Matriz"><br/>Pais: <input type="text" name="pais" value=""  /></label>
            <label name="Endereço"><br/>Endereço: <input type="text" name="endereco" value=""  /></label>
            <label name="Telefone para contato"><br/>Telefone: <input type="text" name="telefone" value=""  /></label>
            <label name="e-mail para contato"><br/>E-mail: <input type="text" name="email" value=""  /></label>
            <label name="Pessoa a contatar"><br/>Contatos: <input type="text" name="contatos" value=""  /></label>
            <label name="enviar formulário"><br/><input type="submit" value="Salvar" name="submeter" /></label>
        </div>
    </body>
</html>