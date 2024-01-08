package Database;

import jakarta.ejb.Local;
import jakarta.persistence.EntityManager;
import Model.Education;

import java.util.List;

@Local
public interface EducationTableRemote {
    List<Education> getListEducationByDoctorId(Long id);
    EntityManager getEntityManager();
    void begin();
    void commit();
}
