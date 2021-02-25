
package model;

public class Servidor {
    
    private int idServidor;
    private String nome;
    private long cpf;
    private String telefone;
    private String dataIngresso;
    private Area idArea;
    private String siape;
    private String cargo;

    public int getIdServidor() {
        return idServidor;
    }
    public void setIdServidor(int idServidor) {
        this.idServidor = idServidor;
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
    public Area getIdArea() {
        return idArea;
    }
    public void setIdArea(Area idArea) {
        this.idArea = idArea;
    }
    public String getSiape() {
        return siape;
    }
    public void setSiape(String siape) {
        this.siape = siape;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    
    
    
    
}
