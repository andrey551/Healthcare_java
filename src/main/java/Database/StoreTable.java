package Database;

import Model.Location;
import Raw.ListId;
import Raw.RawLocation;
import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

@Singleton
public class StoreTable implements StoreTableRemote{
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tad");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    @Override
    public List<RawLocation> searchStoresByDistance(Location location) {
        begin();
        List<RawLocation> ret = entityManager.createNativeQuery("SELECT (store.name, location.address, location.longtude, location.latitude, store.avatar, store.from, store.to, store.rating, store.passengers ) " +
                        "FROM location natural join store " +
                        "order by cal_distance(location.longitude, location.latitude , ? ,?)")
                .setParameter(1, location.getLongitude())
                .setParameter(2, location.getLatitude())
                .getResultList();
        commit();
        return ret;
    }
    public List<RawLocation> getStores() {
        begin();
        List<RawLocation> ret = entityManager.createNativeQuery("SELECT (store.name, location.address, location.longtude, location.latitude, store.avatar, store.from, store.to, store.rating, store.passengers ) " +
                "FROM location natural join store ")
                .getResultList();
        commit();

        return ret;
    }

    public List<RawLocation> getStoresVisited(ListId listId) {
        begin();
        List<RawLocation> ret = entityManager.createNativeQuery("SELECT (store.name, location.address, location.longtude, location.latitude, store.avatar, store.from, store.to, store.rating, store.passengers ) " +
                "FROM location natural join store " +
                "where id in " +
                listId.toString())
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
