package Database;

import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

@Singleton
public class VisitedTable implements VisitedTableRemote{
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tad");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    @Override
    public List<Long> getListVisited(Long userID) {
        begin();
        List<Long> ret = entityManager.createQuery("SELECT a.loc_id from LocationVisited a where a.user_id = ?1")
                .setParameter(1, userID)
                .getResultList();
        commit();

        return ret;
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public void begin() {
        entityManager.getTransaction().begin();
    }

    @Override
    public void commit() {
        entityManager.getTransaction().commit();
    }
}
