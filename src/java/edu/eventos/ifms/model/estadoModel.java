
package edu.eventos.ifms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estados")
public class estadoModel {
 @Id
 private long idEstado;
 @Column(nullable = false, length = 50)
 private String estadoNome;

 @Column(nullable = false, length = 2)
 private String estadoSigla;

    public long getIdEstado() {
        return idEstado;
    }
    public void setIdEstado(long idEstado) {
        this.idEstado = idEstado;
    }
    public String getEstadoNome() {
        return estadoNome;
    }
    public void setEstadoNome(String estadoNome) {
        this.estadoNome = estadoNome;
    }
    public String getEstadoSigla() {
        return estadoSigla;
    }
    public void setEstadoSigla(String estadoSigla) {
        this.estadoSigla = estadoSigla;
    }
 
 
 
 
}