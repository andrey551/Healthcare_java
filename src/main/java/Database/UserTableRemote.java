package Database;

import jakarta.ejb.Local;
import jakarta.persistence.EntityManager;
import Model.User;

@Local
public interface UserTableRemote {
    User getUserByAccountId(Long id);

    EntityManager getEntityManager();
    void begin();
    void commit();
}
