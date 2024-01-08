package Database;

import jakarta.ejb.Local;
import jakarta.persistence.EntityManager;
import Model.Comment;

import java.util.List;

@Local
public interface CommentTableRemote {
    List<Comment> getCommentsByHospitalId(Long id);
    EntityManager getEntityManager();
    void begin();
    void commit();
}
