package Database;

import jakarta.ejb.Local;
import jakarta.persistence.EntityManager;
import Model.Account;
import Raw.RawAccount;

@Local
public interface AccountTableRemote {
    boolean checkAccount(RawAccount rawAccount);
    long addAccount(RawAccount account);
    Long getIdByUsernameAndPassword(RawAccount account);

    long updatePassword(Account account, String newPassword);

    long deleteAccount(Account account);

    boolean checkUsername(RawAccount account);

    EntityManager getManager();
    void begin();
    void commit();
}
