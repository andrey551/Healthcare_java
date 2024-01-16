package Database;

import Raw.RawComment;
import Raw.coordinate;
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
    public List<RawComment> getCommentsByHospitalId(Long id) {
        begin();
        List<RawComment> ret = (List<RawComment>) entityManager.createQuery("SELECT new RawComment(b.name, b.avatar, a.content,a.time, a.rating) from Comment a inner join User b on a.user_id = b.id where a.location_id = ?1 order by a.time desc")
                .setParameter(1, id)
                .getResultList();
        commit();

        return ret;
    }

    @Override
    public boolean addComment(Comment comment) {
        begin();
        System.out.println(comment.toString());
        long ret = entityManager
                .createNativeQuery("INSERT INTO Comment(location_id, user_id, content, rating) values (?, ?, ?, ?)")
                .setParameter(1, comment.getLocation_id())
                .setParameter(2, comment.getUser_id())
                .setParameter(3, comment.getContent())
                .setParameter(4, comment.getRating())
                .executeUpdate();
        return ret != -1;
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
