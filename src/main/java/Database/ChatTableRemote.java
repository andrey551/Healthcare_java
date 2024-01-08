package Database;

import jakarta.ejb.Local;
import jakarta.persistence.EntityManager;
import Model.Chat;

@Local
public interface ChatTableRemote {
    Chat getChatFromXAndY(Long from, Long to);
    EntityManager getEntityManager();
    void begin();
    void commit();
}
