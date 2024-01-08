package Database;

import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import Model.Chat;

@Singleton
public class ChatTable implements ChatTableRemote{
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tad");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    @Override
    public Chat getChatFromXAndY(Long from, Long to) {
        begin();
        Chat ret = (Chat) entityManager.createQuery("SELECT Chat from Chat a where a.from = ?1 and a.to = ?2")
                .setParameter(1, from)
                .setParameter(2, to)
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
