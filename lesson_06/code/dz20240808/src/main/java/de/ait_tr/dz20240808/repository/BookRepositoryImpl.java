package de.ait_tr.dz20240808.repository;

import de.ait_tr.dz20240808.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository{
    private List<Book> list = List.of(
            new Book(1L, "1984", "George Orwell", "1949-06-08", 328, "Dystopian Fiction"),
            new Book(2L, "To Kill a Mockingbird", "Harper Lee", "1960-07-11", 281, "Historical Fiction"),
            new Book(3L, "The Great Gatsby", "F. Scott Fitzgerald", "1925-04-10", 180, "Classic"),
            new Book(4L, "Moby Dick", "Herman Melville", "1851-10-18", 635, "Adventure"),
            new Book(5L, "Pride and Prejudice", "Jane Austen", "1813-01-28", 279, "Romantic Fiction"));

    @Override
    public List<Book> findAll() {
        return list;
    }
}