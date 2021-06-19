package com.cursor.mopla.service;

import com.cursor.mopla.entities.Movie;

import java.util.List;

public interface MovieService {

    Movie create(Movie movie);

    Movie getById(Long id);

    Movie update(Movie movie);

    void delete(Movie movie);

    List<Movie> findAll();
}
