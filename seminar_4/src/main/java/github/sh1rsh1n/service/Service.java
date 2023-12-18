package github.sh1rsh1n.service;

import java.util.List;

public interface Service<E> {

    void save(E e);

    void remove(int id);

    E getElementById(Integer integer);

    List<E> getAll();
}
