package Database;

import jakarta.ejb.Singleton;
import jakarta.ejb.Stateful;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import Model.Account;
import Raw.RawAccount;

import java.util.List;

@Singleton
public class AccountTable implements AccountTableRemote{
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tad");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    @Override
    public boolean checkAccount(RawAccount rawAccount) {
        System.out.println(rawAccount.toString());
        begin();
        List ret =  entityManager.createQuery("SELECT a FROM Account a WHERE a.username = ?1 AND a.password= ?2")
                .setParameter(1, rawAccount.getUsername())
                .setParameter(2, rawAccount.getPassword())
                .getResultList();
        commit();

        System.out.println(ret.toString());
        return !ret.isEmpty();
    }

    @Override
    public long addAccount(RawAccount account) {
        begin();
        long ret = entityManager.createNativeQuery("insert into account (username, password)  values ( ?, ?)")

                .setParameter(1, account.getUsername())
                .setParameter(2, account.getPassword())
                .executeUpdate();
        commit();

        return ret;
    }

    @Override
    public Long getIdByUsernameAndPassword(RawAccount account) {
        begin();
        List<Account> acc = (List<Account>)entityManager.createQuery("SELECT a from Account a where a.username = ?1 and a.password = ?2")
                .setParameter(1, account.getUsername())
                .setParameter(2, account.getPassword())
                .getResultList();
        commit();
        if(acc.isEmpty()) return -1L;
        return acc.get(0).getId();
    }

    @Override
    public long updatePassword(Account account, String newPassword) {
        begin();
        long ret = entityManager.createQuery("update Account a set a.password = ?1 where a.username = ?2 and a.password = ?3")
                .setParameter(1, newPassword)
                .setParameter(2, account.getUsername())
                .setParameter(3, account.getPassword())
                .executeUpdate();
        commit();

        return ret;
    }

    @Override
    public long deleteAccount(Account account) {
        begin();
        long ret = entityManager.createQuery("delete from Account a where a.username = ?1 and a.password = ?2")
                .setParameter(1, account.getUsername())
                .setParameter(2, account.getPassword())
                .executeUpdate();
        commit();

        return ret;
    }

    @Override
    public boolean checkUsername(RawAccount account) {
        begin();
        List<Account> res = (List<Account>) entityManager.createQuery("SELECT a FROM Account a WHERE a.username = ?1", Account.class)
                .setParameter(1, account.getUsername())
                .getResultList();
        return res.isEmpty();

    }

    @Override
    public EntityManager getManager() {
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
