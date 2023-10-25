package dat.sem3.persistence.dao;

import dat.sem3.persistence.config.HibernateConfig;
import dat.sem3.persistence.model.Hotel;
import dat.sem3.persistence.model.Room;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Set;

public class HotelDAO extends AbstractDataAccessObjectImpl<Hotel> {
    private static HotelDAO instance;
    private HotelDAO(EntityManagerFactory emf) {
        super(emf);
    }
    public static HotelDAO getInstance() {
        if (instance == null) {
            instance = new HotelDAO(HibernateConfig.getEntityManagerFactoryConfig("hoteldb"));
        }
        return instance;
    }

    @Override
    public List<Hotel> getAll() {
        try(EntityManager em = emf.createEntityManager()) {
            TypedQuery<Hotel> q = em.createQuery("SELECT h FROM Hotel h", Hotel.class);
            return q.getResultList();
        }
    }

    public Hotel getById(Long id) {
        return getById(Hotel.class, id);
    }

    public Set<Room> getAllRoomsInHotel(Long id) {
        Hotel h = getById(id);
        return h.getRooms();
    }
}
