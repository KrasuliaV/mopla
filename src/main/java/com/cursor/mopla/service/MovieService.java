package com.cursor.mopla.service;

import com.cursor.mopla.entities.Movie;

import java.util.List;

public interface MovieService {

    Movie create(Movie movie);

    Movie getById(Long id);

    Movie update(Movie movie);

    void delete(Long id);

    List<Movie> findAll();

    List<Movie> findAllByRating(String sort);

    List<Movie> getAllByCategory(String categoryName);
}

