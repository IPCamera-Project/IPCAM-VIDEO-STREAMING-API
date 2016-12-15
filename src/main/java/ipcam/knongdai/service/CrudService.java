package ipcam.knongdai.service;

import java.util.List;

public interface CrudService<T> {

	T findOne(int id);

	List<T> findAll();

	boolean remove(int id);

	boolean update(T object);

	boolean save(T object);
}
