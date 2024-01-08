package Database;

import jakarta.ejb.Local;
import jakarta.persistence.EntityManager;
import Model.CurrencyUnit;

@Local
public interface UnitTableRemote {
    CurrencyUnit getCurrencyUnitById(Long id);
    EntityManager getEntityManager();
    void begin();
    void commit();
}
