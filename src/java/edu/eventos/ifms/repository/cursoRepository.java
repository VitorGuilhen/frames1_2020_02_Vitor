/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eventos.ifms.repository;

import edu.eventos.ifms.model.cursoModel;
import edu.eventos.ifms.util.hibernateConector;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class cursoRepository {
    private Session session;
    private Transaction transaction;

    public void salvar(cursoModel curso) {
        this.session = hibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();

        this.session.saveOrUpdate(curso);

        this.transaction.commit();
        this.session.close();
    }

    public List<cursoModel> buscarTodos() {
        this.session = hibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();

        List<cursoModel> listaDeCursos = this.session.createQuery("from cursoModel").list();

        this.transaction.commit();
        this.session.close();
        return listaDeCursos;
    }

    public void remover(long idCurso) {
        this.session = hibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();

        cursoModel curso = (cursoModel) this.session.get(cursoModel.class, idCurso);
        this.session.delete(curso);

        this.transaction.commit();

    }

    public cursoModel buscarPorId(long idCurso) {
        this.session = hibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();

        cursoModel curso = (cursoModel) this.session.get(cursoModel.class, idCurso);
        Hibernate.initialize(curso.getIdCurso());
        
        this.transaction.commit();
        this.session.close();
        return curso;
    }
}
