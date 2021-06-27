package com.cursor.mopla.service;

import com.cursor.mopla.entities.Movie;
import com.cursor.mopla.ui.response.MovieResponse;

import java.util.List;

public interface MovieService {

    Movie create(Movie movie);

    Movie getById(Long id);

    Movie update(Movie movie);

    void delete(Long id);

    List<MovieResponse> findAll();

    List<MovieResponse> findAllByRating(String sort);

    List<MovieResponse> getAllByCategory(String categoryName);
}

