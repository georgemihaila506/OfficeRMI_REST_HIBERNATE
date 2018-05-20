package Repository;

import java.util.List;

public interface IRepository<T> {
    void addEntity(T entity);
    void deleteEntity(T entity);
    List<T> getAll();
    void findOne(T entity);
}
