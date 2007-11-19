/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ine5612.persistence;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author brodock
 */
@Entity
@Table(name = "Produto")
@NamedQueries({@NamedQuery(name = "Produto.findByIdProduto", query = "SELECT p FROM Produto p WHERE p.idProduto = :idProduto"), @NamedQuery(name = "Produto.findByNome", query = "SELECT p FROM Produto p WHERE p.nome = :nome"), @NamedQuery(name = "Produto.findByPreco", query = "SELECT p FROM Produto p WHERE p.preco = :preco")})
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "idProduto", nullable = false)
    private Integer idProduto;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "preco", nullable = false)
    private BigDecimal preco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProduto")
    private Collection<Fornecedor> fornecedorCollection;

    public Produto() {
    }

    public Produto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Produto(Integer idProduto, String nome, BigDecimal preco) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.preco = preco;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Collection<Fornecedor> getFornecedorCollection() {
        return fornecedorCollection;
    }

    public void setFornecedorCollection(Collection<Fornecedor> fornecedorCollection) {
        this.fornecedorCollection = fornecedorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduto != null ? idProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.idProduto == null && other.idProduto != null) || (this.idProduto != null && !this.idProduto.equals(other.idProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ine5612.persistence.Produto[idProduto=" + idProduto + "]";
    }

}
