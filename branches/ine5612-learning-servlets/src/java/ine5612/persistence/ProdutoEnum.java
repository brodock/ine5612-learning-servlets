/*
 * ProdutoEnum.java
 * 
 * Created on 25/10/2007, 10:30:27
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ine5612.persistence;

/**
 *
 * @author wabba
 */
public enum ProdutoEnum {
    
    
    CALCAS("CALÇAS"), CAMISETAS("CAMISETAS"), CALCADOS("CALÇADOS"), ACESSORIOS("ACESSÓRIOS"), CHAPEUS("CHAPÉUS"), OCULOS("ÓCULOS");

    private final String nome;
    
    ProdutoEnum(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return this.nome;
    }
}
    
    
