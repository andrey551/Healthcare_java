package Database;

import jakarta.ejb.Local;
import jakarta.persistence.EntityManager;
import Model.Consultant;

import java.util.List;

@Local
public interface ConsultantTableRemote {
    List<Consultant> getConsultantsByUserId(Long id);
    EntityManager getEntityManager();
    void begin();
    void commit();
}
