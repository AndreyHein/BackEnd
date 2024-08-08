package de.ait_tr.dz20240808.service;

import de.ait_tr.dz20240808.entity.Book;
import de.ait_tr.dz20240808.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository repository;

    @Autowired
    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }
    @Override
    public List<Book> getAllBooks() {
        return repository.findAll();
    }
}
