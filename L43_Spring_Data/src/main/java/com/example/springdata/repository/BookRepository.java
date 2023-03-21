package com.example.springdata.repository;

import com.example.springdata.model.BookEntity;
import com.example.springdata.model.BookProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Integer>, JpaSpecificationExecutor<BookEntity> {

    List<BookEntity> getByName(String name);

//    List<BookEntity> getByNameAndDescription(String name, String description);

    List<BookEntity> getByPagesBetween(Integer from, Integer to);

    @Modifying
    void updateBook(Integer id, @Param("des") String newDescription);

    List<BookProjection> getBy();

}
