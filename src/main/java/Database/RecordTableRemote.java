package Database;

import jakarta.ejb.Local;
import jakarta.persistence.EntityManager;

import Model.Record;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Local
public interface RecordTableRemote {
    List<Record> getRecordByUserId(Long id);
    Long deleteRecordByTime(Long id, Timestamp time);

    Long addRecord( Record record);
    EntityManager getEntityManager();
    void begin();
    void commit();
}
