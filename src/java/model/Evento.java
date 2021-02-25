
package model;

public class Evento {
    
    private int idEvento;
    private String nome;
    private String dataInicio;
    private String dataFim;
    private Campus idCampus;

    public int getIdEvento() {
        return idEvento;
    }
    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }
    public String getDataFim() {
        return dataFim;
    }
    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }
    public Campus getIdCampus() {
        return idCampus;
    }
    public void setIdCampus(Campus idCampus) {
        this.idCampus = idCampus;
    }
    
    
    
}
