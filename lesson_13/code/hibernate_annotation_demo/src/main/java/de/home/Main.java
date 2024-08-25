package de.home;

import de.home.entity.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        HibernateAnnoptationRepositoryDemo repository = new HibernateAnnoptationRepositoryDemo();
        List<User> allUsers = repository.findAll();
        System.out.println(allUsers);
        System.out.println("----- find by ID ---------------------");
        System.out.println(repository.findById(2L));
        System.out.println("----- save --------------------");
        User user = repository.create(new User(null, "Nick", "nick25@mail.com", "ytrewq"));
        System.out.println(user);
    }
}