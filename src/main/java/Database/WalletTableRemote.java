package Database;

import jakarta.ejb.Local;
import jakarta.persistence.EntityManager;
import Model.Wallet;

@Local
public interface WalletTableRemote {
    Wallet getWalletByUserId(Long id);
    Long addMoney(Long amount, Long id);
    Long payMoney(long amount, Long id);
    EntityManager getEntityManager();
    void begin();
    void commit();
}
