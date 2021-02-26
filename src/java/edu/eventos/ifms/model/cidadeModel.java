package edu.eventos.ifms.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "cidades")
public class cidadeModel implements Serializable {

    @Id
    private long idCidade;

    @Column(nullable = false, length = 80)
    private String cidadeNome;

    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "idEstado", insertable = true, updatable = true)
    private estadoModel estado;

    public long getIdCidade() {
        return idCidade;
    }
    public void setIdCidade(long idCidade) {
        this.idCidade = idCidade;
    }
    public String getCidadeNome() {
        return cidadeNome;
    }
    public void setCidadeNome(String cidadeNome) {
        this.cidadeNome = cidadeNome;
    }
    public estadoModel getEstado() {
        return estado;
    }
    public void setEstado(estadoModel estado) {
        this.estado = estado;
    }

}
