package de.home;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        JDBCDemo.loadDriver();
        List<User> users = JDBCDemo.findAll();
        System.out.println(users);

        User user = new User("JDBC", "sql@mail.com", "qwerty");
        User user1 = JDBCDemo.create(user);
        System.out.println(user1);

        System.out.println("--------------------------------");
        users = JDBCDemo.findAll();
        System.out.println(users);
    }
}