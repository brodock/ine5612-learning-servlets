/*
 * FornecedorLista.java
 * 
 * Created on 25/10/2007, 11:00:03
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ine5612.persistence;

import java.util.ArrayList;
import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author wabba
 */
public class FornecedorLista {
    
    private ArrayList<FornecedorSerial> lista;
    private String file;
    private Map<String, ProdutoEnum> lista_produto = new LinkedHashMap<String, ProdutoEnum>();
    
    public FornecedorLista() {
        this.file = "listaforn.info";
        this.carregaArquivo();
        this.preparaListaProduto();
    }

    private void preparaListaProduto() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    @SuppressWarnings("unchecked")
    public void carregaArquivo() {
        try {
            ObjectInputStream objstream = new ObjectInputStream(new FileInputStream(this.file));
            Object obj = objstream.readObject();
            objstream.close();
            this.lista = (ArrayList<FornecedorSerial>) obj;
        } catch (IOException e) {
            System.err.println("Problema ao carregar o arquivo!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (this.lista == null) {
            this.lista = new ArrayList<FornecedorSerial>();
        }
    }
    
    public void salvaArquivo() {
        try {
            ObjectOutputStream objstream = new ObjectOutputStream(new FileOutputStream(this.file));
            objstream.writeObject(this.lista);
            objstream.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<FornecedorSerial> getLista() {
        return lista;
    }
    
    public FornecedorSerial getFornecedor(int id) {
        return this.lista.get(id);
    }
}
