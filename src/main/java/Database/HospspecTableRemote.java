package Database;

import jakarta.ejb.Local;
import jakarta.persistence.EntityManager;
import Model.HospSpec;

import java.util.List;

@Local
public interface HospspecTableRemote {
    List<HospSpec> getHospspecByHospitalId(Long id);
    EntityManager getEntityManager();
    void begin();
    void commit();
}
