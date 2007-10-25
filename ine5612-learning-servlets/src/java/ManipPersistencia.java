/*
 * ManipPersistencia.java
 * 
 * Created on 23/10/2007, 09:38:41
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import ine5612.persistence.Fornecedor;
import ine5612.persistence.Produto;
import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author wabba
 */
public class ManipPersistencia implements Serializable {
    
    private ArrayList<Fornecedor> listaForn;
    private ArrayList<Produto> listaProd;
    
    public ManipPersistencia() {
        listaForn = new ArrayList<Fornecedor>();
        listaProd = new ArrayList<Produto>();
    }

    public ArrayList<Fornecedor> getListaForn() {
        return listaForn;
    }

    public void setListaForn(ArrayList<Fornecedor> listaForn) {
        this.listaForn = listaForn;
    }

    public ArrayList<Produto> getListaProd() {
        return listaProd;
    }

    public void setListaProd(ArrayList<Produto> listaProd) {
        this.listaProd = listaProd;
    }
}
