package org.example.springdata1.services;

import org.example.springdata1.entity.Author;

public interface AuthorService extends CrudService<Author, Long>{
    Author findByName(String nom);
}
