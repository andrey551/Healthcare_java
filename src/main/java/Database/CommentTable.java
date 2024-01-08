package Database;

import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import Model.Comment;

import java.util.List;

@Singleton
public class CommentTable implements CommentTableRemote{
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tad");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    @Override
    public List<Comment> getCommentsByHospitalId(Long id) {
        begin();
        List<Comment> ret = (List<Comment>) entityManager.createQuery("SELECT Comment from Comment a where a.hospital_id = ?1")
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
