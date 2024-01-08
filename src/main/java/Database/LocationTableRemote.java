package Database;

import jakarta.ejb.Local;
import jakarta.persistence.EntityManager;
import Model.Location;

@Local
public interface LocationTableRemote {
    Location getLocationById(Long id);
    EntityManager getEntityManager();
    void begin();
    void commit();
}
