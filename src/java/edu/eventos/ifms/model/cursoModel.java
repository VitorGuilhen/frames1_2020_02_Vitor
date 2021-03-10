package edu.eventos.ifms.model;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
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
@Table(name = "curso")
public class cursoModel implements Serializable {

    @Id
    @GeneratedValue
    private long idCurso;
    @Column(nullable = false, length = 80)
    private String cursoNome;
    @Column(nullable = false, length = 80)
    private String descricao;
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "idArea", insertable = true, updatable = true)
    private areaModel area;
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "idCampus", insertable = true, updatable = true)
    private campusModel campus;
    
    
    public long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(long idCurso) {
        this.idCurso = idCurso;
    }

    public String getCursoNome() {
        return cursoNome;
    }

    public void setCursoNome(String cursoNome) {
        this.cursoNome = cursoNome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public areaModel getArea() {
        return area;
    }

    public void setArea(areaModel area) {
        this.area = area;
    }

    public campusModel getCampus() {
        return campus;
    }

    public void setCampus(campusModel campus) {
        this.campus = campus;
    }

    

    
    
}
