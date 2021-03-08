/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eventos.ifms.controller;

import edu.eventos.ifms.model.alunoModel;
import edu.eventos.ifms.model.campusModel;
import edu.eventos.ifms.model.cursoModel;
import edu.eventos.ifms.repository.alunoRepository;
import edu.eventos.ifms.repository.campusRepository;
import edu.eventos.ifms.repository.cursoRepository;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@ViewScoped
public class alunoController {

    
    private alunoModel alunoModel;
    private campusModel campusModel;
    private alunoRepository alunoRepository;
    private campusRepository campusRepository;
    private cursoRepository cursoRepository;
    private List<alunoModel> listaDeAluno;
    
    public alunoController() {
        this.alunoModel = new alunoModel();
        this.campusRepository = new campusRepository();
        this.cursoRepository = new cursoRepository();
        this.listaDeAluno = new ArrayList<>();
    }

    public void salvar(){
        this.getAlunoRepository().salvar(this.getAlunoModel());
    }
    
    public String salvarEdicao() {
        this.getAlunoRepository().salvar(this.getAlunoModel());
        return "buscarAluno.xhtml?faces-redirect=true";
    }
    
    public void remover(long idAluno) {
        this.getAlunoRepository().remover(idAluno);
    }
    
    public String editar(long idAluno) {
        return "editarAluno.xhtml?faces-redirect=true&idServidor=" + idAluno;
    }
    
    public void buscarAluno() {
        this.setAlunoModel(this.getAlunoRepository().buscarPorId(this.getAlunoModel().getIdPessoa()));
    }

    public List<SelectItem> getCampus() {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        List<campusModel> listaDeCampus = this.getCampusRepository().buscarTodos();
        for (campusModel campus : listaDeCampus) {
            itens.add(new SelectItem(campus.getIdCampus(), campus.getCampusNome()));
        }
        return itens;
    }
    
    public List<SelectItem> getCursos() {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        List<cursoModel> listaDeCursos = this.cursoRepository.buscar();
        for (cursoModel curso : listaDeCursos) {
            itens.add(new SelectItem(curso.getIdCurso(), curso.getCursoNome()));
        }
        return itens;
    }

    public List<SelectItem> getAlunos() {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        List<alunoModel> listaDeAlunos = this.getAlunoRepository().buscarTodos();
        for (alunoModel aluno : listaDeAlunos) {
            itens.add(new SelectItem(aluno.getIdPessoa(), aluno.getPessoaNome()));
        }
        return itens;
    }
    
    public void buscarTodosAlunos() {
        this.setListaDeAluno(this.getAlunoRepository().buscarTodos());
    }

    public alunoModel getAlunoModel() {
        return alunoModel;
    }

    public void setAlunoModel(alunoModel alunoModel) {
        this.alunoModel = alunoModel;
    }

    public alunoRepository getAlunoRepository() {
        return alunoRepository;
    }

    public void setAlunoRepository(alunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public campusRepository getCampusRepository() {
        return campusRepository;
    }

    public void setCampusRepository(campusRepository campusRepository) {
        this.campusRepository = campusRepository;
    }

    public List<alunoModel> getListaDeAluno() {
        return listaDeAluno;
    }

    public void setListaDeAluno(List<alunoModel> listaDeAluno) {
        this.listaDeAluno = listaDeAluno;
    }

    public campusModel getCampusModel() {
        return campusModel;
    }

    public void setCampusModel(campusModel campusModel) {
        this.campusModel = campusModel;
    }

    public cursoRepository getCursoRepository() {
        return cursoRepository;
    }

    public void setCursoRepository(cursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }
    
    
    
}
