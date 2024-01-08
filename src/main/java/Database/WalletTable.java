package Database;

import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import Model.Wallet;

@Singleton
public class WalletTable implements WalletTableRemote{
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tad");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public Wallet getWalletByUserId(Long id) {
        begin();
        Wallet ret = (Wallet) entityManager.createQuery("SELECT Wallet from Wallet a where a.id = ?1")
                .setParameter(1, id)
                .getResultList()
                .get(0);
        commit();

        return ret;
    }

    @Override
    public Long addMoney(Long amount, Long id) {
        begin();
        long ret = entityManager.createQuery("update Wallet a set a.balance = (a.balance + ?1) where a.id = ?2")
                .setParameter(1, amount)
                .setParameter(2, id)
                .executeUpdate();
        commit();

        return ret;
    }

    @Override
    public Long payMoney(long amount, Long id) {
        begin();
        long ret = entityManager.createQuery("update Wallet a set a.balance = (a.balance - ?1) where a.id = ?2")
                .setParameter(1, amount)
                .setParameter(2, id)
                .executeUpdate();
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
