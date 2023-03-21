package com.example.springdata.service.impl;

import com.example.springdata.model.Author;
import com.example.springdata.model.Author_;
import com.example.springdata.model.BookEntity;
import com.example.springdata.model.BookEntity_;
import com.example.springdata.model.BookProjection;
import com.example.springdata.repository.BookRepository;
import com.example.springdata.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    @Override
    public Page<BookEntity> getAll(Integer page, Integer size) {

        if (page == null || page < 0 || size == null || size < 1) {
            return repository.findAll(PageRequest.of(0, 1000_000));
        }

        Sort sort = Sort.by(Sort.Direction.DESC, "pages");
        PageRequest pageRequest = PageRequest.of(page, size, sort);

        return repository.findAll(pageRequest);
    }

    @Override
    public BookEntity getById(Integer id) {
        BookEntity bookEntity = repository.findById(id).orElse(null);

        return bookEntity;
    }

    @Override
    public List<BookEntity> getByName(String name) {
        return repository.getByName(name);
    }

    @Override
    public BookEntity save(BookEntity book) {
        return repository.save(book);
    }

    @Override
    public List<BookEntity> getByNameAndDescription(String name, String description) {
        Specification<BookEntity> specification = createSpecification(name, description);
        return repository.findAll(specification);
    }

    private static Specification<BookEntity> createSpecification(String name, String description) {
        return (root, query, builder) -> {
//для поиска надо очистить gradle->build->clean
//затем скомпилировать наши объекты gradle->other->compileJava для получения например :
// L43_Spring_Data/build/generated/sources/annotationProcessor/java/main/com/example/springdata/model/BookEntity_.java
            List<Predicate> listCond = new ArrayList<>();

            if(name != null && !name.isBlank()){
                Predicate equalName = builder.equal(root.get(BookEntity_.NAME), name);
                listCond.add(equalName);
            }

            if(description != null && !description.isBlank()){
                Predicate equalDescription = builder.equal(root.get(BookEntity_.DESCRIPTION), description);
                listCond.add(equalDescription);
            }

//написане джоина пример по автору (недописан)
//            ListJoin<BookEntity, Author> joinAuthor = root.join(BookEntity_.authors);
//            joinAuthor.get(Author_.ID, )

            return builder.and(listCond.toArray(new Predicate[]{}));
        };
    }

    @Override
    public List<BookEntity> getByPages(Integer from, Integer to) {
        return repository.getByPagesBetween(from, to);
    }

    @Override
    public BookEntity deleteById(Integer id) {
        var bookFromDB = repository.findById(id).orElse(null);
        if (bookFromDB != null) {
            repository.deleteById(id);
        }
        return bookFromDB;
    }

    @Transactional
    @Override
    public BookEntity update(BookEntity book) {
        var fromDB = repository.findById(book.getId()).orElseThrow(RuntimeException::new);

        fromDB.setName(book.getName());
        fromDB.setDescription(book.getDescription());
        fromDB.setPages(book.getPages());

        return fromDB;
    }

    @Transactional
    @Override
    public void simpleUpdate(int id, String newDescription) {
        repository.updateBook(id, newDescription);
    }

    @Override
    public List<BookProjection> getAllBy() {
        return repository.getBy();
    }
}
