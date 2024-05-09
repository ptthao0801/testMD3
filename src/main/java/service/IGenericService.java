package service;

import model.Student;

import java.util.List;

public interface IGenericService<T> {
    List<T> showAll();

    void saveList(T t);

    T searchById(int id);

    void update(int id, T t);

    void delete(int id);
}
