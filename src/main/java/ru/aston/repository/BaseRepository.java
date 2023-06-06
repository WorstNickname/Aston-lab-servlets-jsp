package ru.aston.repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import ru.aston.util.HibernateUtil;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Getter
public abstract class BaseRepository<E, K extends Serializable>
        implements Repository<E, K> {

    protected final SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
    private final Class<E> clazz;

    @Override
    public Optional<E> findById(K id) {
        var session = sessionFactory.openSession();
        var mayBeEntity = session.find(clazz, id);
        return Optional.ofNullable(mayBeEntity);
    }

    @Override
    public List<E> findAll() {
        var session = sessionFactory.openSession();
        var criteria = session.getCriteriaBuilder()
                .createQuery(clazz);
        criteria.from(clazz);
        return session.createQuery(criteria).getResultList();
    }

    @Override
    public void update(E entity) {
        var session = sessionFactory.openSession();
        session.merge(entity);
        session.flush();
    }

    @Override
    public void delete(E entity) {
        var session = sessionFactory.openSession();
        session.remove(entity);
        session.flush();
    }

    @Override
    public E save(E entity) {
        var session = sessionFactory.openSession();
        session.persist(entity);
        return entity;
    }

}