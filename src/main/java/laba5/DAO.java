package laba5;

import java.util.List;

public interface DAO <T> {

        T findById(Long id);

        List<T> findAll();

        Long save(T name);

        void deleteById(Long id);
}
