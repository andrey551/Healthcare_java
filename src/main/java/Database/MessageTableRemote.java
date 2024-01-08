package Database;

import jakarta.ejb.Local;
import jakarta.persistence.EntityManager;
import Model.Message;

import java.util.List;

@Local
public interface MessageTableRemote {
    List<Message> getMessageByChatId(Long id);

    EntityManager getEntityManager();
    void begin();
    void commit();
}
