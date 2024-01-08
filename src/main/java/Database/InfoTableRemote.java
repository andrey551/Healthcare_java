package Database;

import jakarta.ejb.Local;
import jakarta.persistence.EntityManager;
import Model.Info;

import java.util.List;

@Local
public interface InfoTableRemote {
    Info getInfoByDoctorId(Long id);
    List<Info> getListInfoByHospitalId(Long id);
    List<Info> getListInfoBySpecializationId(Long id);
    EntityManager getEntityManager();
    void begin();
    void commit();
}
