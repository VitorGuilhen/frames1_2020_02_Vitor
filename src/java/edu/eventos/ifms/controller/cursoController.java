package edu.eventos.ifms.controller;

import edu.eventos.ifms.model.campusModel;
import edu.eventos.ifms.model.cursoModel;
import edu.eventos.ifms.model.servidorModel;
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
    private cursoRepository cursoRepository;
    private campusRepository campusRepository;
    private servidorRepository servidorRepository;
    private List<cursoModel> listaDeCursos;

    public cursoController() {
        this.cursoModel = new cursoModel();
        this.campusModel = new campusModel();
        this.cursoRepository = new cursoRepository();
        this.campusRepository = new campusRepository();
        this.listaDeCursos = new ArrayList<>();
        this.servidorRepository = new servidorRepository();
    }

    public void salvar() {
        this.getCursoRepository().salvar(this.getCursoModel());
    }

    public String salvarEdicao() {
        this.getCursoRepository().salvar(this.getCursoModel());
        return "buscarCurso.xhtml?faces-redirect=true";
    }

    public void remover(long idCurso) {
        this.getCursoRepository().remover(idCurso);
    }

    public String editar(long idCurso) {
        return "editarCurso.xhtml?faces-redirect=true&idCurso=" + idCurso;
    }

    public void getCurso() {
        this.setCursoModel(this.getCursoRepository().buscarPorId(this.getCursoModel().getIdCurso()));
    }

    public List<SelectItem> getCampi() {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        this.setListaDeCampus(this.getCampusRepository().buscarTodos());
        for (campusModel campus : getListaDeCampus()) {
            itens.add(new SelectItem(campus.getIdCampus(), campus.getCampusNome()));
        }
        return itens;
    }

    public void buscarTodosCampus() {
        this.setListaDeCampus(this.getCampusRepository().buscarTodos());
    }

    public void buscarTodosCampusComServidores() {
        List<campusModel> listaDeCampusTemp = new ArrayList<>();
        listaDeCampusTemp.addAll(this.getListaDeCampus());
        this.getListaDeCampus().clear();
        for (campusModel campus : listaDeCampusTemp) {
            campus = this.getCampusRepository().buscarPorId(campus.getIdCampus());
            if (!campus.getServidores().isEmpty()) {
                this.getListaDeCampus().add(campus);
            }
        }
    }

    public void desvincularServidor(campusModel campus, servidorModel servidor) {
        campus.getServidores().remove(servidor);
        this.getCampusRepository().salvar(campus);
    }

    public void vincularCampusServidor(servidorModel servidor) {
        this.setCampusModel(this.getCampusRepository().buscarPorId(getCampusModel().getIdCampus()));
        List<servidorModel> listaDeServidores = new ArrayList<>();
        if (!campusModel.getServidores().isEmpty()) {
            servidor = (servidorModel) getServidorRepository().buscarPorId(servidor.getIdPessoa());
            listaDeServidores = getCampusModel().getServidores();
            listaDeServidores.add(servidor);
            getCampusModel().setServidores(listaDeServidores);
        } else {
            servidor = getServidorRepository().buscarPorId(servidor.getIdPessoa());
            listaDeServidores.add(servidor);
            getCampusModel().setServidores(listaDeServidores);
        }
        this.getCampusRepository().salvar(getCampusModel());
    }

    public List<SelectItem> getCidades(long idEstado) {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        List<cidadeModel> listaDeCidades = this.getCidadeRepository().buscar(idEstado);
        for (cidadeModel cidade : listaDeCidades) {
            itens.add(new SelectItem(cidade.getIdCidade(), cidade.getCidadeNome()));
        }
        return itens;
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

    public estadoRepository getEstadoRepository() {
        return estadoRepository;
    }

    public void setEstadoRepository(estadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    public cidadeRepository getCidadeRepository() {
        return cidadeRepository;
    }

    public void setCidadeRepository(cidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    public servidorRepository getServidorRepository() {
        return servidorRepository;
    }

    public void setServidorRepository(servidorRepository servidorRepository) {
        this.servidorRepository = servidorRepository;
    }

    public List<SelectItem> getListaDeCidades() {
        return listaDeCidades;
    }

    public void setListaDeCidades(List<SelectItem> listaDeCidades) {
        this.listaDeCidades = listaDeCidades;
    }

    public List<campusModel> getListaDeCampus() {
        return listaDeCampus;
    }

    public void setListaDeCampus(List<campusModel> listaDeCampus) {
        this.listaDeCampus = listaDeCampus;
    }

}
