package de.home;

import de.home.entity.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HibernateXMLRepositoryDemo repository = new HibernateXMLRepositoryDemo();
        List<User> allUsers = repository.findAll();
        System.out.println(allUsers);
        System.out.println("----- find by ID ---------------------");
        System.out.println(repository.findById(2L));
        System.out.println("----- save --------------------");
        repository.create(new User(null, "Nick", "nick2@mail.com", "ytrewq"));
    }
}