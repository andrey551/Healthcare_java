package Database;

import Model.Comment;
import Raw.RawComment;
import jakarta.ejb.Local;
import jakarta.persistence.EntityManager;

import java.util.List;

@Local
public interface CommentTableRemote {
    List<RawComment> getCommentsByHospitalId(Long id);
    boolean addComment(Comment comment);
    EntityManager getEntityManager();
    void begin();
    void commit();
}
