package Database;

import jakarta.ejb.Local;
import jakarta.persistence.EntityManager;
import Model.Hospital;

import java.util.List;

@Local
public interface HospitalTableRemote {
    Hospital getHospitalByName(String name);
    Hospital getHospitalByLocationId(Long location_id);
    List<Hospital> getHospitalInOrderRating();
    EntityManager getEntityManager();
    void begin();
    void commit();
}
