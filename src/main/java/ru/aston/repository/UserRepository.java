package ru.aston.repository;

import ru.aston.entity.User;

import java.util.Optional;

public class UserRepository extends BaseRepository<User, Long> {

    private static final UserRepository INSTANCE = new UserRepository();

    public UserRepository() {
        super(User.class);
    }

    public Optional<User> findByName(String name) {
        var session = sessionFactory.openSession();
        var query = session.createQuery(
                "from User u where u.name = :name",
                User.class);
        query.setParameter("name", name);
        return Optional.ofNullable(query.uniqueResult());
    }

    public Optional<User> findByNameAndPassword(String name, String password) {
        var session = sessionFactory.openSession();
        var query = session.createQuery(
                "from User u where u.name = :name and u.password = :password",
                User.class
        );
        query.setParameter("name", name);
        query.setParameter("password", password);
        var result = query.uniqueResult();
        return Optional.ofNullable(result);
    }

    public static UserRepository getInstance() {
        return INSTANCE;
    }

}
