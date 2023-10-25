package dat.sem3.persistence.dao;

import java.util.List;

public interface DataAccessObject<T> {
    List<T> getAll();
    <K> T getById(Class<T> clazz, K id);
    T create(T entity);
    T update(T entity);
    void delete(T entity);
}
