package edu.eventos.ifms.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "area")
public class areaModel implements Serializable {

    @Id
    @GeneratedValue
    private long idArea;

    @Column(nullable = false, length = 40)
    private String areaNome;

    public long getIdArea() {
        return idArea;
    }
    public void setIdArea(long idArea) {
        this.idArea = idArea;
    }
    public String getAreaNome() {
        return areaNome;
    }
    public void setAreaNome(String areaNome) {
        this.areaNome = areaNome;
    }
    
    
    
}
