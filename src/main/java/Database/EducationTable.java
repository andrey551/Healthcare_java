package Database;

import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import Model.Education;

import java.util.List;

@Singleton
public class EducationTable implements EducationTableRemote{
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tad");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    @Override
    public List<Education> getListEducationByDoctorId(Long id) {
        begin();
        List<Education> ret = (List<Education>) entityManager.createQuery("SELECT Education from Education a where a.id = ?1")
                .setParameter(1, id)
                .getResultList()
                .get(0);
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
