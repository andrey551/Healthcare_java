package Database;

import jakarta.ejb.Local;
import jakarta.persistence.EntityManager;

import java.util.List;

@Local
public interface VisitedTableRemote {

    List<Long> getListVisited(Long userID) ;
    EntityManager getEntityManager();
    void begin();
    void commit();
}
