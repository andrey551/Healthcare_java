package Database;

import Raw.ListId;
import Raw.RawLocation;
import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import Model.Location;

import java.util.List;

@Singleton
public class LocationTable implements LocationTableRemote{
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tad");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    @Override
    public Location getLocationById(Long id) {
        begin();
        Location ret = (Location) entityManager.createQuery("select a from Location a where a.id = ?1")
                .setParameter(1, id)
                .getResultList().get(0);
        commit();
        return ret;
    }

    @Override
    public List<RawLocation> searchLocationsByDistance(Float lon, Float lat, String type) {
        begin();
        List<RawLocation> ret = entityManager.createNativeQuery("SELECT (location.name, " +
                        "location.address, location.longtude, " +
                        "location.latitude, location.avatar, " +
                        "location.from, location.to, location.rating, " +
                        "location.passengers, location.type ) " +
                        "FROM location " +
                        "WHERE location.type = ?" +
                        "order by cal_distance(location.longitude, location.latitude , ? ,?)")
                .setParameter(1, type)
                .setParameter(2, lon)
                .setParameter(3, lat)
                .getResultList();
        commit();
        return ret;
    }
    public List<RawLocation> getLocs(String type) {
        begin();
        List<RawLocation> ret = entityManager.createNativeQuery("SELECT (location.name, " +
                        "location.address, location.longtude, " +
                        "location.latitude, location.avatar, " +
                        "location.from, location.to, location.rating, " +
                        "location.passengers , location.type) " +
                        "FROM location " +
                        "WHERE location.type = ?")
                .setParameter(1, type)
                .getResultList();
        commit();

        return ret;
    }



    public List<RawLocation> getLocsVisited(ListId listId, String type) {
        List<RawLocation> ret = entityManager.createNativeQuery("SELECT (location.name, " +
                        "location.address, location.longtude, " +
                        "location.latitude, location.avatar, " +
                        "location.from, location.to, location.rating, " +
                        "location.passengers, location.type ) " +
                        "FROM location " +
                        "WHERE location.type = ? AND location.id IN " +
                        listId.toString())
                .setParameter(1, type)
                .getResultList();
        commit();

        return ret;
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
