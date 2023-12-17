package github.sh1rsh1n.repository;

import java.util.List;

public interface Repository<E> {

    boolean save(E e);

    boolean remove(E e);

    E getElementById(Integer id);

    List<E> getAll();
    
}