package org.example.springdata1.services.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.example.springdata1.entity.Author;
import org.example.springdata1.repository.AuthorRepository;
import org.example.springdata1.services.AuthorService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author save(Author entity) {
        entity.toString();
        return authorRepository.save(entity);
    }

    @Override
    @Transactional
    public Author findById(Long aLong) {
        Author author = authorRepository
                .findById(aLong)
                .orElseThrow(
                        () -> new EntityNotFoundException("Author not found"));

        Hibernate.initialize(author.getBooks());
        return author;
    }

    public Author findByName(String name){
        Author author = authorRepository.findByName(name).orElseThrow(
                () -> new EntityNotFoundException("Author not found"));
        return author;
    }

    @Override
    // @Transactional
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author update(Long id, Author entity) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Author not found"));

        author.setName(entity.getName());

        author.toString();
        return authorRepository.save(author);
    }

    @Override
    public void delete(Long aLong) {
        authorRepository.deleteById(aLong);
    }
}
