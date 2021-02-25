package model;

public class Curso {
    
    private int idCurso;
    private String nome;
    private String descricao;
    private Area idArea;
    private Campus idCampus;

    public int getIdCurso() {
        return idCurso;
    }
    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Area getIdArea() {
        return idArea;
    }
    public void setIdArea(Area idArea) {
        this.idArea = idArea;
    }
    public Campus getIdCampus() {
        return idCampus;
    }
    public void setIdCampus(Campus idCampus) {
        this.idCampus = idCampus;
    }
    
    
    
    
    
}
