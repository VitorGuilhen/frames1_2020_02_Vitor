
package model;

public class Aluno {
    
    private int idAluno;
    private String nome;
    private long cpf;
    private String telefone;
    private String dataIngresso;
    private Campus idCampus;
    private Curso idCurso;
    private String ra;

    public int getIdAluno() {
        return idAluno;
    }
    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public long getCpf() {
        return cpf;
    }
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getDataIngresso() {
        return dataIngresso;
    }
    public void setDataIngresso(String dataIngresso) {
        this.dataIngresso = dataIngresso;
    }
    public Campus getIdCampus() {
        return idCampus;
    }
    public void setIdCampus(Campus idCampus) {
        this.idCampus = idCampus;
    }
    public Curso getIdCurso() {
        return idCurso;
    }
    public void setIdCurso(Curso idCurso) {
        this.idCurso = idCurso;
    }
    public String getRa() {
        return ra;
    }
    public void setRa(String ra) {
        this.ra = ra;
    }
    
    
    
    
    
    
}
