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
    public void add(Long userId, Long locationId) {
        begin();
        entityManager.createNativeQuery("INSERT INTO LocationVisited(user_id, location_id) values(?, ?)")
                .setParameter(1, userId)
                .setParameter(2, locationId)
                .executeUpdate();

        commit();
    }

    @Override
    public void del(Long userId, Long locationId) {
        begin();
        entityManager.createNativeQuery("DELETE FROM LocationVisited where user_id = ? and location_id = ?")
                .setParameter(1, userId)
                .setParameter(2, locationId)
                .executeUpdate();
        commit();
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
