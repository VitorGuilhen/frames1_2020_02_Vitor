package edu.eventos.ifms.repository;

import edu.eventos.ifms.model.servidorModel;
import edu.eventos.ifms.util.hibernateConector;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class servidorRepository {

    private Session session;
    private Transaction transaction;

    public void salvar(servidorModel servidor) {
        this.session = hibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();

        this.session.saveOrUpdate(servidor);

        this.transaction.commit();
        this.session.close();
    }

    public List<servidorModel> buscarTodos() {
        this.session = hibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();

        List<servidorModel> listaDeServidores = this.session.createQuery("from servidorModel").list();

        this.transaction.commit();
        this.session.close();
        return listaDeServidores;
    }

    public void remover(long idServidor) {
        this.session = hibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();

        servidorModel servidor = (servidorModel) this.session.get(servidorModel.class, idServidor);
        this.session.delete(servidor);
        this.transaction.commit();
        this.session.close();
    }

    public servidorModel buscarPorId(long idServidor) {
        this.session = hibernateConector.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();

        servidorModel servidor = (servidorModel) this.session.get(servidorModel.class, idServidor);

        this.transaction.commit();
        this.session.close();
        return servidor;
    }
}
