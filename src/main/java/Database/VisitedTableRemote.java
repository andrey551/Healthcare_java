package Database;

import jakarta.ejb.Local;
import jakarta.persistence.EntityManager;

import java.util.List;

@Local
public interface VisitedTableRemote {

    List<Long> getListVisited(Long userID) ;

    void add(Long userId, Long locationId);
    void del(Long userId, Long locationId);
    EntityManager getEntityManager();
    void begin();
    void commit();
}
