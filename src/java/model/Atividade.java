
package model;

public class Atividade {
    
    private int idAtividade;
    private String nome;
    private String descricao;
    private int qntVagas;
    private Evento idEvento;
    private int idMinistrante;

    public int getIdAtividade() {
        return idAtividade;
    }
    public void setIdAtividade(int idAtividade) {
        this.idAtividade = idAtividade;
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
    public int getQntVagas() {
        return qntVagas;
    }
    public void setQntVagas(int qntVagas) {
        this.qntVagas = qntVagas;
    }
    public Evento getIdEvento() {
        return idEvento;
    }
    public void setIdEvento(Evento idEvento) {
        this.idEvento = idEvento;
    }
    public int getIdMinistrante() {
        return idMinistrante;
    }
    public void setIdMinistrante(int idMinistrante) {
        this.idMinistrante = idMinistrante;
    }
    
    
    
    
    
}
