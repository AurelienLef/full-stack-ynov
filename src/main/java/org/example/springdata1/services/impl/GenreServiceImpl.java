package org.example.springdata1.services.impl;

import org.example.springdata1.entity.Genre;
import org.example.springdata1.repository.GenreRepository;
import org.example.springdata1.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {


    @Autowired
    private GenreRepository genreRepository;

    @Override
    public Genre save(Genre entity) {
        return genreRepository.save(entity);
    }

    @Override
    public Genre findById(Long aLong) {
        return genreRepository.findById(aLong)
                .orElseThrow(() -> new RuntimeException("Genre not found"));
    }

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public Genre update(Long id, Genre entity) {
        Genre genre = genreRepository.findById(id).orElseThrow(() -> new RuntimeException("Genre not found"));
        genre.setName(entity.getName());
        return genreRepository.save(genre);
    }

    @Override
    public void delete(Long aLong) {
        genreRepository.findById(aLong).orElseThrow(() -> new RuntimeException("Genre not found"));
        genreRepository.deleteById(aLong);
    }
}
