package Database;

import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import Model.Info;

import java.util.List;

@Singleton
public class InfoTable implements InfoTableRemote{
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tad");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    @Override
    public Info getInfoByDoctorId(Long id) {
        begin();
        Info ret = (Info) entityManager.createQuery("SELECT Info from Info a where a.id = ?1")
                .setParameter(1, id)
                .getResultList()
                .get(0);
        commit();

        return ret;
    }

    @Override
    public List<Info> getListInfoByHospitalId(Long id) {
        begin();
        List<Info> ret = (List<Info>) entityManager.createQuery("SELECT Info from Info a where a.hospital_id = ?1")
                .setParameter(1, id)
                .getResultList();
        commit();

        return ret;
    }

    @Override
    public List<Info> getListInfoBySpecializationId(Long id) {
        begin();
        List<Info> ret = (List<Info>) entityManager.createQuery("SELECT Info from Info a where a.specialization_id = ?1")
                .setParameter(1, id)
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
