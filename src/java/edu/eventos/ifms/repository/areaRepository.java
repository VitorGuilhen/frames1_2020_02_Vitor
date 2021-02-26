/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eventos.ifms.repository;

import edu.eventos.ifms.model.areaModel;
import edu.eventos.ifms.util.hibernateConector;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class areaRepository {
    private Session session;
    private Transaction transaction;

    public List<areaModel> buscar(){
        this.session = hibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        
        List<areaModel> listaDeAreas = this.session.createQuery("from areaModel").list();
        
        this.transaction.commit();
        this.session.close();
        return listaDeAreas;
    }
}
