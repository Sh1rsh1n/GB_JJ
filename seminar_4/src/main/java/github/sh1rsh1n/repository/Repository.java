package github.sh1rsh1n.repository;

import java.util.List;

public interface Repository<E> {

    boolean save(E e);

    boolean remove(int id);

    E getElementById(Integer id);

    List<E> getAll();
    
}