package edu.eventos.ifms.controller;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

@ManagedBean
public class campusController {

    private String campusNome;
    private int campusCidadeId;
    private int campusEstadoId;

    public campusController() {
        this.campusNome = "";
        this.campusCidadeId = 0;
        this.campusEstadoId = 0;
    }

    public void salvar() {
        System.out.println("Campus nome: " + this.campusNome
                + " - Estado e Cidade Id´s: " + this.campusCidadeId
                + " - " + this.campusEstadoId);
    }

    public List<SelectItem> getEstados() {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        itens.add(new SelectItem(1, "São Paulo"));
        itens.add(new SelectItem(2, "Minas Gerais"));
        itens.add(new SelectItem(3, "Paraná"));
        return itens;
    }

    public List<SelectItem> getCidades() {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        itens.add(new SelectItem(1, "Cidade 1"));
        itens.add(new SelectItem(2, "Cidade 2"));
        itens.add(new SelectItem(3, "Cidade 3"));
        return itens;
    }

    public String getCampusNome() {
        return campusNome;
    }

    public void setCampusNome(String campusNome) {
        this.campusNome = campusNome;
    }

    public int getCampusCidadeId() {
        return campusCidadeId;
    }

    public void setCampusCidadeId(int campusCidadeId) {
        this.campusCidadeId = campusCidadeId;
    }

    public int getCampusEstadoId() {
        return campusEstadoId;
    }

    public void setCampusEstadoId(int campusEstadoId) {
        this.campusEstadoId = campusEstadoId;
    }
}
