package edu.eventos.ifms.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "campus")
public class campusModel implements Serializable {

    @Id
    @GeneratedValue
    private long idCampus;
    @Column(nullable = false, length = 80)
    private String campusNome;
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "idCidade", insertable = true, updatable = true)
    private cidadeModel cidade;
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "idEstado", insertable = true, updatable = true)
    private estadoModel estado;
    @ManyToMany
    @JoinTable(name = "campus_servidor",
            joinColumns = @JoinColumn(name = "id_Campus"),
            inverseJoinColumns = @JoinColumn(name = "id_Servidor"))
    private List<servidorModel> servidores;

    public campusModel() {
        this.cidade = new cidadeModel();
        this.estado = new estadoModel();
    }

    public long getIdCampus() {
        return idCampus;
    }

    public void setIdCampus(long idCampus) {
        this.idCampus = idCampus;
    }

    public String getCampusNome() {
        return campusNome;
    }

    public void setCampusNome(String campusNome) {
        this.campusNome = campusNome;
    }

    public cidadeModel getCidade() {
        return cidade;
    }

    public void setCidade(cidadeModel cidade) {
        this.cidade = cidade;
    }

    public estadoModel getEstado() {
        return estado;
    }

    public void setEstado(estadoModel estado) {
        this.estado = estado;
    }

    public List<servidorModel> getServidores() {
        return servidores;
    }

    public void setServidores(List<servidorModel> servidores) {
        this.servidores = servidores;
    }

}
