package github.sh1rsh1n.repository;

import java.util.List;

public interface Repository<E, EId> {

    boolean add(E e);

    boolean update(E e);

    boolean remove(E e);

    E getElementById(EId id);

    List<E> getAll();
    
}