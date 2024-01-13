package Database;

import Model.Location;
import Raw.ListId;
import Raw.RawLocation;
import jakarta.ejb.Local;
import jakarta.persistence.EntityManager;

import java.util.List;

@Local
public interface StoreTableRemote {
    List<RawLocation> searchStoresByDistance(Location location);
    List<RawLocation> getStores();

    List<RawLocation> getStoresVisited(ListId ids);
    EntityManager getEntityManager();
    void begin();
    void commit();
}
