package Database;

import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import Model.Hospital;

import java.util.List;

@Singleton
public class HospitalTable implements HospitalTableRemote{
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tad");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    @Override
    public Hospital getHospitalByName(String name) {
        begin();
        Hospital ret = (Hospital)entityManager.createQuery("select Hospital from Hospital a where a.name = ?1")
                .setParameter(1, name)
                .getResultList().get(0);
        commit();

        return ret;
    }

    @Override
    public Hospital getHospitalByLocationId(Long location_id) {
        begin();
        Hospital ret = (Hospital)entityManager.createQuery("select Hospital from Hospital a where a.id = ?1")
                .setParameter(1, location_id)
                .getResultList().get(0);
        commit();

        return ret;
    }

    @Override
    public List<Hospital> getHospitalInOrderRating() {
        begin();
        List<Hospital> ret = (List<Hospital>) entityManager.createQuery("select Hospital from Hospital a order by a.rating asc")
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
