package edu.eventos.ifms.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "aluno")
@PrimaryKeyJoinColumn(name = "idPessoa")
public class alunoModel extends pessoaInternaModel implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "idCampus", insertable = true, updatable = true)
    private campusModel campus;
    @Column(nullable = false)
    private long RA;
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "idCurso", insertable = true, updatable = true)
    private cursoModel curso;
    @ManyToMany(mappedBy = "alunos")
    private List<campusModel> campusAoQualPertence;
    @ManyToMany(mappedBy = "alunos")
    private List<cursoModel> cursoAoQualPertence;

    public alunoModel() {
        this.campus = new campusModel();
    }

    public campusModel getCampus() {
        return campus;
    }

    public void setCampus(campusModel campus) {
        this.campus = campus;
    }

    public long getRA() {
        return RA;
    }

    public void setRA(long RA) {
        this.RA = RA;
    }

    public cursoModel getCurso() {
        return curso;
    }

    public void setCurso(cursoModel curso) {
        this.curso = curso;
    }

    public List<campusModel> getCampusAoQualPertence() {
        return campusAoQualPertence;
    }

    public void setCampusAoQualPertence(List<campusModel> campusAoQualPertence) {
        this.campusAoQualPertence = campusAoQualPertence;
    }
    
    public List<cursoModel> getCursoAoQualPertence() {
        return cursoAoQualPertence;
    }

    public void setCursoAoQualPertence(List<cursoModel> cursoAoQualPertence) {
        this.cursoAoQualPertence = cursoAoQualPertence;
    }

}
