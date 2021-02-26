package edu.eventos.ifms.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pessoaInterna")
public abstract class pessoaInternaModel extends pessoaModel implements Serializable {

    @Temporal(TemporalType.DATE)
    private Date dataIngresso;

    public Date getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(Date dataIngresso) {
        this.dataIngresso = dataIngresso;
    }

}
