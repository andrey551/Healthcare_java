package Database;

import jakarta.ejb.Local;
import jakarta.persistence.EntityManager;
import Model.Prize;

import java.util.List;

@Local
public interface PrizeTableRemote {
    List<Prize> getListPrizeByDoctorId(Long id);
    EntityManager getEntityManager();
    void begin();
    void commit();
}
