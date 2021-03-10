package edu.eventos.ifms.controller;

import edu.eventos.ifms.model.areaModel;
import edu.eventos.ifms.model.campusModel;
import edu.eventos.ifms.model.cursoModel;
import edu.eventos.ifms.model.servidorModel;
import edu.eventos.ifms.repository.areaRepository;
import edu.eventos.ifms.repository.campusRepository;
import edu.eventos.ifms.repository.cursoRepository;
import edu.eventos.ifms.repository.servidorRepository;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@ViewScoped
public class cursoController {

    private cursoModel cursoModel;
    private campusModel campusModel;
    private areaModel areaModel;
    private cursoRepository cursoRepository;
    private campusRepository campusRepository;
    private servidorRepository servidorRepository;
    private List<cursoModel> listaDeCursos;
    private areaRepository areaRepository;

    public cursoController() {
        this.cursoModel = new cursoModel();
        this.campusModel = new campusModel();
        this.areaModel = new areaModel();
        this.areaRepository = new areaRepository();
        this.cursoRepository = new cursoRepository();
        this.campusRepository = new campusRepository();
        this.listaDeCursos = new ArrayList<>();
        this.servidorRepository = new servidorRepository();
    }

    public void salvar() {
        this.getCursoRepository().salvar(getCursoModel());
    }
    
    public List<SelectItem> getAreas() {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        List<areaModel> listaDeAreas = this.getAreaRepository().buscarTodos();
        for (areaModel area : listaDeAreas) {
            itens.add(new SelectItem(area.getIdArea(), area.getAreaNome()));
        }
        return itens;
    }
    
    public List<SelectItem> getCampus() {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        List<campusModel> listaDeCampus = this.getCampusRepository().buscarTodos();
        for (campusModel campus : listaDeCampus) {
            itens.add(new SelectItem(campus.getIdCampus(), campus.getCampusNome()));
        }
        return itens;
    }

    public String salvarEdicao() {
        this.getCursoRepository().salvar(getCursoModel());
        return "buscarCurso.xhtml?faces-redirect=true";
    }

    public void remover(long idCurso) {
        this.getCursoRepository().remover(idCurso);
    }

    public String editar(long idCurso) {
        return "editarCurso.xhtml?faces-redirect=true&idCurso=" + idCurso;
    }

    public campusModel getCampusModel() {
        return campusModel;
    }

    public void setCampusModel(campusModel campusModel) {
        this.campusModel = campusModel;
    }

    public campusRepository getCampusRepository() {
        return campusRepository;
    }

    public void setCampusRepository(campusRepository campusRepository) {
        this.campusRepository = campusRepository;
    }

    public servidorRepository getServidorRepository() {
        return servidorRepository;
    }

    public void setServidorRepository(servidorRepository servidorRepository) {
        this.servidorRepository = servidorRepository;
    }

    public cursoModel getCursoModel() {
        return cursoModel;
    }

    public void setCursoModel(cursoModel cursoModel) {
        this.cursoModel = cursoModel;
    }

    public cursoRepository getCursoRepository() {
        return cursoRepository;
    }

    public void setCursoRepository(cursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<cursoModel> getListaDeCursos() {
        return listaDeCursos;
    }

    public void setListaDeCursos(List<cursoModel> listaDeCursos) {
        this.listaDeCursos = listaDeCursos;
    }

    public void buscarTodosCursos() {
        this.setListaDeCursos(this.getCursoRepository().buscarTodos());
    }

    public areaModel getAreaModel() {
        return areaModel;
    }

    public void setAreaModel(areaModel areaModel) {
        this.areaModel = areaModel;
    }

    public areaRepository getAreaRepository() {
        return areaRepository;
    }

    public void setAreaRepository(areaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }
    
    
    
    
}
