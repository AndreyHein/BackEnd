package de.home;

import de.home.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.selector.SimpleStrategyRegistrationImpl;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateAnnoptationRepositoryDemo {

    private final SessionFactory sessionFactory;
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/app42_2";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "soly1810";

    public HibernateAnnoptationRepositoryDemo() {
        sessionFactory = init();
    }

    public SessionFactory init() {
        try {
            Configuration configuration = new Configuration();
            configuration.setProperty("hibernate.connection.driver_class", DRIVER);
            configuration.setProperty("hibernate.connection.url", URL);
            configuration.setProperty("hibernate.connection.username", USERNAME);
            configuration.setProperty("hibernate.connection.password", PASSWORD);
//            configuration.setProperty("hibernate.default_schema", SCHEMA);

            configuration.addAnnotatedClass(User.class);

            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();

            return  configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            throw new RuntimeException("Could not initialize Hibernate SessionFactory", e);
        }
    }

    public List<User> findAll() {
        try(EntityManager entityManager = sessionFactory.createEntityManager()) {
            return entityManager.createQuery("from User", User.class).getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Error finding users", e);
        }
    }

    public User findById(Long id) {
        try(EntityManager entityManager = sessionFactory.createEntityManager()) {
            return entityManager.find(User.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Error finding user by id" + id);
        }
    }

    public User create(User user) {
        EntityTransaction transaction = null;
        try(EntityManager entityManager = sessionFactory.createEntityManager()) {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(user);
            transaction.commit();
            return user;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error creating user" + user);
        }
    }
}
