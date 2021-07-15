package databaseconnection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {

    private EntityManagerFactory emf;
    private EntityManager em;


    public Connection(){
        this.emf = Persistence.createEntityManagerFactory("hotel_project");
        this.em = emf.createEntityManager();
    }


    public EntityManager getEm() {
        return em;
    }
    public void startTransaction(){
        em.getTransaction().begin();
    }
    public void endTransaction(){
        em.getTransaction().commit();
    }

    public void closeConnection(){
        em.close();
        emf.close();
    }


}
