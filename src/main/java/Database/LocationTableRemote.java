package Database;

import Raw.ListId;
import Raw.RawLocation;
import jakarta.ejb.Local;
import jakarta.persistence.EntityManager;
import Model.Location;

import java.util.List;

@Local
public interface LocationTableRemote {
    Location getLocationById(Long id);
    List<RawLocation> searchLocationsByDistance(Float lon, Float lat, String type);
    List<RawLocation> getLocs(String type);

    List<RawLocation> getLocsVisited(ListId ids, String type);
    EntityManager getEntityManager();
    void begin();
    void commit();
}
