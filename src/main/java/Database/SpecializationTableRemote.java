package Database;

import jakarta.ejb.Local;
import jakarta.persistence.EntityManager;
import Model.Specialization;

import java.util.List;

@Local
public interface SpecializationTableRemote {
    Specialization getSpecializationByName(String name);
    List<Specialization> getSpecializationsByHospitalId(Long id);
    EntityManager getEntityManager();
    void begin();
    void commit();
}
