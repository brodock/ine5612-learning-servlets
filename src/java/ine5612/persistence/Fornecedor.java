/*
 * Fornecedor.java
 * 
 * Created on 15/10/2007, 20:10:58
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ine5612.persistence;

import ine5612.servlets.*;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "Fornecedor")
@NamedQueries({@NamedQuery(name = "Fornecedor.findByIdFornecedor", query = "SELECT f FROM Fornecedor f WHERE f.idFornecedor = :idFornecedor"), @NamedQuery(name = "Fornecedor.findByNomeFantasia", query = "SELECT f FROM Fornecedor f WHERE f.nomeFantasia = :nomeFantasia"), @NamedQuery(name = "Fornecedor.findByEndereco", query = "SELECT f FROM Fornecedor f WHERE f.endereco = :endereco"), @NamedQuery(name = "Fornecedor.findByCidade", query = "SELECT f FROM Fornecedor f WHERE f.cidade = :cidade"), @NamedQuery(name = "Fornecedor.findByEstado", query = "SELECT f FROM Fornecedor f WHERE f.estado = :estado"), @NamedQuery(name = "Fornecedor.findByPais", query = "SELECT f FROM Fornecedor f WHERE f.pais = :pais"), @NamedQuery(name = "Fornecedor.findByTelefone", query = "SELECT f FROM Fornecedor f WHERE f.telefone = :telefone"), @NamedQuery(name = "Fornecedor.findByEmail", query = "SELECT f FROM Fornecedor f WHERE f.email = :email"), @NamedQuery(name = "Fornecedor.findByContato", query = "SELECT f FROM Fornecedor f WHERE f.contato = :contato")})
public class Fornecedor implements Serializable {
    @Id
    @Column(name = "idFornecedor", nullable = false)
    private Integer idFornecedor;
    @Column(name = "nome_fantasia")
    private Integer nomeFantasia;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "estado")
    private String estado;
    @Column(name = "pais")
    private String pais;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "email")
    private String email;
    @Column(name = "contato")
    private String contato;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFornecedor")
    private Collection<Produto> produtoCollection;

    public Fornecedor() {
    }

    public Fornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public Integer getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(Integer nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFornecedor != null ? idFornecedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedor)) {
            return false;
        }
        Fornecedor other = (Fornecedor) object;
        if ((this.idFornecedor == null && other.idFornecedor != null) || (this.idFornecedor != null && !this.idFornecedor.equals(other.idFornecedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ine5612.servlets.Fornecedor[idFornecedor=" + idFornecedor + "]";
    }

}
