package edu.eventos.ifms.repository;

import edu.eventos.ifms.model.cidadeModel;
import edu.eventos.ifms.util.hibernateConector;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class cidadeRepository {

    private Session session;
    private Transaction transaction;

    public List<cidadeModel> buscar(long IdEstado) {
        this.setSession(hibernateConector.getSessionFactory().openSession());
        this.setTransaction(getSession().beginTransaction());

        List<cidadeModel> listaDeCidades = this.getSession().createQuery("from cidadeModel where idEstado = "
                + IdEstado).list();

        this.getTransaction().commit();
        this.getSession().close();
        return listaDeCidades;
    }

    public Session getSession() {
        return session;
    }
    public void setSession(Session session) {
        this.session = session;
    }
    public Transaction getTransaction() {
        return transaction;
    }
    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
    
    
}
