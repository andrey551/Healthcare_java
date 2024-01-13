package Database;

import Model.Location;
import Model.Store;
import Raw.RawLocationReq;
import jakarta.ejb.Local;
import jakarta.persistence.EntityManager;

import java.io.Serializable;
import java.util.List;

@Local
public interface StoreTableRemote {
    List<Store> searchStoresByDistance(Location location);
    EntityManager getEntityManager();
    void begin();
    void commit();
}
