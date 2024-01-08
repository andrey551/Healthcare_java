package Database;

import jakarta.ejb.Local;
import jakarta.persistence.EntityManager;
import Model.Specialization;

@Local
public interface SpecializationTableRemote {
    Specialization getSpecializationByName(String name);
    EntityManager getEntityManager();
    void begin();
    void commit();
}
