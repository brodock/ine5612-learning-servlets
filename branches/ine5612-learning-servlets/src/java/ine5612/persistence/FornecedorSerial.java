/*
 * Fornecedor.java
 *
 * Created on 14/10/2007, 18:25:37
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ine5612.persistence;

import java.io.Serializable;

/**
 *
 * @author wabba
 */
public class FornecedorSerial implements Serializable {

    private String nome;
    private String endereco;
    private int telefone;
    private String contatos;
    private String pais;
    private String estado;
    private String cidade;
    private String email;
    private int cnpj;
    private ProdutoEnum produto;

    public FornecedorSerial() {
        this.nome = "";
        this.endereco = "";
        this.telefone = 0;
        this.contatos = "";
        this.pais = "";
        this.cidade = "";
        this.estado = "";
        this.email = "";
        this.cnpj = 0;
        this.produto = null;
    }

    public FornecedorSerial(String nome, String endereco, String cidade, String estado, String pais, int telefone, String email, int cnpj, String contatos, ProdutoEnum fornece) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.cnpj = cnpj;
        this.produto = fornece;
        this.estado = estado;
        this.cidade = cidade;
        this.pais = pais;
        this.contatos = contatos;
    }
    
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public String getContatos() {
        return contatos;
    }

    public void setContatos(String contatos) {
        this.contatos = contatos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getcnpj() {
        return cnpj;
    }

    public void setcnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public ProdutoEnum getProduto() {
        return produto;
    }

    public void setProduto(ProdutoEnum fornece) {
        this.produto = fornece;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s\nEndereço: %s\nCidade: %s\nEstado: %s\nPais: %s\nTelefone: %d\n" +
                "Email: %s\ncnpj: %d\nContatos: %s\nFornece: %s",
                this.nome, this.endereco, this.cidade, this.estado, this.pais, this.telefone, this.email,
                this.cnpj, this.contatos, this.produto.getNome());
    }
}