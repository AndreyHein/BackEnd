package de.ait_tr.dz20240808.repository;

import de.ait_tr.dz20240808.entity.Book;

import java.util.List;

public interface BookRepository {
    public List<Book> findAll();
}
