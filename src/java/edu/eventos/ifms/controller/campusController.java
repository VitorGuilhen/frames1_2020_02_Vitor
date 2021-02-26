package edu.eventos.ifms.controller;

import edu.eventos.ifms.model.campusModel;
import edu.eventos.ifms.model.cidadeModel;
import edu.eventos.ifms.model.estadoModel;
import edu.eventos.ifms.model.servidorModel;
import edu.eventos.ifms.repository.campusRepository;
import edu.eventos.ifms.repository.cidadeRepository;
import edu.eventos.ifms.repository.estadoRepository;
import edu.eventos.ifms.repository.servidorRepository;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@ViewScoped
public class campusController {

    private campusModel campusModel;
    private campusRepository campusRepository;
    private estadoRepository estadoRepository;
    private cidadeRepository cidadeRepository;
    private servidorRepository servidorRepository;
    private List<SelectItem> listaDeCidades;
    private List<campusModel> listaDeCampus;

    public campusController() {
        this.campusModel = new campusModel();
        this.campusRepository = new campusRepository();
        this.estadoRepository = new estadoRepository();
        this.cidadeRepository = new cidadeRepository();
        this.listaDeCidades = this.getCidades(1);
        this.listaDeCampus = new ArrayList<>();
        this.servidorRepository = new servidorRepository();
    }

    public void salvar() {
        this.getCampusRepository().salvar(this.getCampusModel());
    }

    public String salvarEdicao() {
        this.getCampusRepository().salvar(this.getCampusModel());
        return "buscarCampus.xhtml?faces-redirect=true";
    }

    public void remover(long idCampus) {
        this.getCampusRepository().remover(idCampus);
    }

    public String editar(long idCampus) {
        return "editarCampus.xhtml?faces-redirect=true&idCampus=" + idCampus;
    }

    public void getCampus() {
        this.setCampusModel(this.getCampusRepository().buscarPorId(this.getCampusModel().getIdCampus()));
        this.setListaDeCidades(this.getCidades(this.getCampusModel().getEstado().getIdEstado()));
    }

    public List<SelectItem> getEstados() {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        List<estadoModel> listaDeEstados = this.getEstadoRepository().buscar();
        for (estadoModel estado : listaDeEstados) {
            itens.add(new SelectItem(estado.getIdEstado(), estado.getEstadoNome()));
        }
        return itens;
    }

    public List<SelectItem> getCampi() {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        this.setListaDeCampus(this.getCampusRepository().buscarTodos());
        for (campusModel campus : getListaDeCampus()) {
            itens.add(new SelectItem(campus.getIdCampus(), campus.getCampusNome()));
        }
        return itens;
    }

    public void onChangeEstado() {
        this.setListaDeCidades(this.getCidades(this.getCampusModel().getEstado().getIdEstado()));
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
