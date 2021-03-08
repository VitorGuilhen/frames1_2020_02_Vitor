package edu.eventos.ifms.controller;

import edu.eventos.ifms.model.areaModel;
import edu.eventos.ifms.model.servidorModel;
import edu.eventos.ifms.repository.areaRepository;
import edu.eventos.ifms.repository.campusRepository;
import edu.eventos.ifms.repository.servidorRepository;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@ViewScoped
public class areaController {

    private areaModel areaModel;
    private areaRepository areaRepository;
    private servidorRepository servidorRepository;
    private List<areaModel> listaDeArea;

    public areaController() {
        this.areaModel = new areaModel();
        this.areaRepository = new areaRepository();
        this.listaDeArea = new ArrayList<>();
        this.servidorRepository = new servidorRepository();
    }

    public void salvar() {
        this.getAreaRepository().salvar(this.getAreaModel());
    }

    public String salvarEdicao() {
        this.getAreaRepository().salvar(this.getAreaModel());
        return "buscarArea.xhtml?faces-redirect=true";
    }

    public void remover(long idArea) {
        this.areaRepository().remover(idArea);
    }

    public String editar(long idArea) {
        return "editarArea.xhtml?faces-redirect=true&idArea=" + idArea;
    }

    public void getArea() {
        this.setAreaModel(this.getAreaRepository().buscarPorId(this.getAreaModel().getIdArea()));
    }

    public areaRepository getAreaRepository() {
        return areaRepository;
    }

    public void setAreaRepository(areaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public areaModel getAreaModel() {
        return areaModel;
    }

    public void setAreaModel(areaModel areaModel) {
        this.areaModel = areaModel;
    }

    public servidorRepository getServidorRepository() {
        return servidorRepository;
    }

    public void setServidorRepository(servidorRepository servidorRepository) {
        this.servidorRepository = servidorRepository;
    }

    public List<areaModel> getListaDeArea() {
        return listaDeArea;
    }

    public void setListaDeArea(List<areaModel> listaDeArea) {
        this.listaDeArea = listaDeArea;
    }

    
    
    
}
