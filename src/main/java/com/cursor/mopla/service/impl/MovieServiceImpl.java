package com.cursor.mopla.service.impl;

import com.cursor.mopla.entities.Movie;
import com.cursor.mopla.exception.NullEntityReferenceException;
import com.cursor.mopla.repositories.MovieRepository;
import com.cursor.mopla.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie create(Movie movie) {
        if (movie != null) {
            return movieRepository.save(movie);
        }
        throw new NullEntityReferenceException("Task cannot be 'null'");
    }

    @Override
    public Movie getById(Long id) {
        return null;
    }

    @Override
    public Movie update(Movie movie) {
        return null;
    }

    @Override
    public void delete(Movie movie) {

    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }
}
