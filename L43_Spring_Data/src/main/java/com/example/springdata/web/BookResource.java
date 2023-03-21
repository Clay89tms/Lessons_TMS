package com.example.springdata.web;

import com.example.springdata.model.BookEntity;
import com.example.springdata.model.BookProjection;
import com.example.springdata.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping("/book")
public class BookResource {

    private final BookService service;

    @GetMapping
    public Page<BookEntity> getAll(@RequestParam(name = "page", required = false) Integer page, @RequestParam(name = "size", required = false) Integer size) {
        return service.getAll(page, size);
    }

    @GetMapping("/id/{id}")
    public BookEntity getById(@PathVariable(name = "id") Integer id) {
        return service.getById(id);
    }

    @GetMapping("/name/{name}")
    public List<BookEntity> getByName(@PathVariable(name = "name") String name) {
        return service.getByName(name);
    }

    @GetMapping("/search")
    public List<BookEntity> getByName(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "description", required = false) String description) {
        return service.getByNameAndDescription(name, description);
    }

    @PostMapping
    public BookEntity save(@RequestBody BookEntity book) {
        return service.save(book);
    }

    @GetMapping("/pages")
    public List<BookEntity> getByPages(@RequestParam(name = "from") Integer from, @RequestParam(name = "to") Integer to) {
        return service.getByPages(from, to);
    }

    @DeleteMapping("/{id}")
    public BookEntity deleteById(@PathVariable(name = "id") Integer id) {
        return service.deleteById(id);
    }

    @PutMapping("/{id}")
    public BookEntity update(@PathVariable(name = "id") String id, @RequestBody BookEntity book) {
        book.setId(Integer.parseInt(id));
        return service.update(book);
    }

    @PutMapping("/update/{id}")
    public void simpleUpdate(@PathVariable(name = "id") String id, @RequestParam(name = "des") String newDescription) {
        service.simpleUpdate(Integer.parseInt(id), newDescription);
    }

    @GetMapping("/all-pages")
    public List<BookProjection> getAllForPages() {
        return service.getAllBy();
    }
}
