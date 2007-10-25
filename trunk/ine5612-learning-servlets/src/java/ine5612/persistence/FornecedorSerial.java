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
    private int fax;
    private String email;
    private int cnpj;
    private String contato;
    private ProdutoEnum fornece;

    public FornecedorSerial() {
        this.nome = "";
        this.endereco = "";
        this.telefone = 0;
        this.fax = 0;
        this.email = "";
        this.cnpj = 0;
        this.contato = "";
        this.fornece = null;
    }

    public FornecedorSerial(String nome, String endereco, int telefone, int fax, String email, int cnpj, String contato, ProdutoEnum fornece) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.fax = fax;
        this.email = email;
        this.cnpj = cnpj;
        this.contato = contato;
        this.fornece = fornece;
    }

    public int getcnpj() {
        return cnpj;
    }

    public void setcnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
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

    public int getFax() {
        return fax;
    }

    public void setFax(int fax) {
        this.fax = fax;
    }

    public ProdutoEnum getFornece() {
        return fornece;
    }

    public void setFornece(ProdutoEnum fornece) {
        this.fornece = fornece;
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
        return String.format("Nome: %s\nEndereço: %s\nTelefone: %d\nFax: %d\n" +
                "Email: %s\ncnpj: %d\nContato: %s\nFornece: %s",
                this.nome, this.endereco, this.telefone, this.fax, this.email,
                this.cnpj, this.contato, this.fornece.getNome());
    }
}