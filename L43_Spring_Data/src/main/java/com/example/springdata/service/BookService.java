package com.example.springdata.service;

import com.example.springdata.model.BookEntity;
import com.example.springdata.model.BookProjection;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookService {
    Page<BookEntity> getAll(Integer page, Integer size);

    BookEntity getById(Integer id);

    List<BookEntity> getByName(String name);

    BookEntity save(BookEntity book);

    List<BookEntity> getByNameAndDescription(String name, String description);

    List<BookEntity> getByPages(Integer from, Integer to);

    BookEntity deleteById(Integer id);

    BookEntity update(BookEntity book);

    void simpleUpdate(int id, String newDescription);

    List<BookProjection> getAllBy();

}
