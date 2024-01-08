package Database;

import jakarta.ejb.Local;
import jakarta.persistence.EntityManager;
import Model.Doctor;

@Local
public interface DoctorTableRemote {
    Doctor getDoctorByNameAndAge(String name, Long age);
    EntityManager getEntityManager();
    void begin();
    void commit();
}
