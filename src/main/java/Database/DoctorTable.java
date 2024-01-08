package Database;

import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import Model.Doctor;

@Singleton
public class DoctorTable implements DoctorTableRemote{
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tad");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    @Override
    public Doctor getDoctorByNameAndAge(String name, Long age) {
        begin();

        Doctor ret = (Doctor)entityManager.createQuery("SELECT Doctor from Doctor a where a.name = ?1 and a.age = ?2")
                .setParameter(1, name)
                .setParameter(2, age)
                .getResultList().get(0);
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
