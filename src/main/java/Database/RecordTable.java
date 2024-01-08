package Database;

import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import Model.Record;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Singleton
public class RecordTable implements RecordTableRemote{
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tad");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    @Override
    public List<Record> getRecordByUserId(Long id) {

        begin();

        List<Record> ret = (List<Record>) entityManager.createQuery("select a from Record a where a.user_id = ?1 order by a.time desc")
                .setParameter(1, id)
                .getResultList();

        commit();

        return ret;
    }

    @Override
    public Long deleteRecordByTime(Long id, Timestamp time) {
        begin();

        long ret = (long)entityManager.createQuery("DELETE from Record r where r.user_id = ?1 and r.time = ?2")
                .setParameter(1, id)
                .setParameter(2, time)
                .executeUpdate();
        commit();

        return ret;
    }

    @Override
    public Long addRecord(Record record) {
        begin();

        entityManager.createNativeQuery("INSERT INTO record(heart_beat, weight, height, blood_pressure, cholesterol, analysis, user_id) values (?,?,?,?,?,?,?)")
                .setParameter(1, record.getHeartBeat())
                .setParameter(2, record.getWeight())
                .setParameter(3, record.getHeight())
                .setParameter(4, record.getBloodPressure())
                .setParameter(5, record.getCholesterol())
                .setParameter(6, record.getAnalysis())
                .setParameter(7, record.getUser_id()).executeUpdate();
        commit();

        return 1L;

    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public void begin() {
        entityManager.getTransaction().begin();
    }

    @Override
    public void commit() {
        entityManager.getTransaction().commit();
    }
}
