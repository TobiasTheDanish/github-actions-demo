package dat.sem3.persistence.dao;

import dat.sem3.persistence.config.HibernateConfig;
import dat.sem3.persistence.model.Room;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class RoomDAO extends AbstractDataAccessObjectImpl<Room> {
    private static RoomDAO instance;

    private RoomDAO(EntityManagerFactory emf) {
        super(emf);
    }

    public static RoomDAO getInstance() {
        if (instance == null) {
            instance = new RoomDAO(HibernateConfig.getEntityManagerFactoryConfig("hoteldb"));
        }
        return instance;
    }

    @Override
    public List<Room> getAll() {
        try(EntityManager em = emf.createEntityManager()) {
            TypedQuery<Room> q = em.createQuery("SELECT r FROM Room r", Room.class);
            return q.getResultList();
        }
    }
}
