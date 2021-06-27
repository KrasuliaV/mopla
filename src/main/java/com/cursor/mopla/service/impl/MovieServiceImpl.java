package com.cursor.mopla.service.impl;

import com.cursor.mopla.entities.Movie;
import com.cursor.mopla.exception.NullEntityReferenceException;
import com.cursor.mopla.maper.ListMovieMapper;
import com.cursor.mopla.repositories.CategoryRepository;
import com.cursor.mopla.repositories.MovieRepository;
import com.cursor.mopla.service.MovieService;
import com.cursor.mopla.ui.response.MovieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final CategoryRepository categoryRepository;
    private final ListMovieMapper mapper;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository, CategoryRepository categoryRepository, ListMovieMapper mapper) {
        this.movieRepository = movieRepository;
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    @Override
    public Movie create(Movie movie) {

        if (movie != null) {
            return movieRepository.save(movie);
        }

        throw new NullEntityReferenceException("Movie cannot be 'null'");
    }

    @Override
    public Movie getById(Long id) {
        return movieRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Movie with id " + id + " not found"));
    }

    @Override
    public Movie update(Movie movie) {

        if (movie != null) {
            return movieRepository.save(movie);
        }

        throw new NullEntityReferenceException("Movie cannot be 'null'");
    }

    @Override
    public void delete(Long id) {

        if (id == null || id < 0) {
            throw new IllegalArgumentException("You must enter correct id");
        }

        movieRepository.deleteById(id);
    }

    @Override
    public List<MovieResponse> findAll() {
        return mapper.convertListMovieToListMovieResponse(movieRepository.findAll(Sort.by("id")));
    }

    @Override
    public List<MovieResponse> findAllByRating(String sort) {
        List<Movie> movies = sort.equals("asc") ?
                movieRepository.getAllByOrderByRateValueAsc() :
                movieRepository.getAllByOrderByRateValueDesc();

        return mapper.convertListMovieToListMovieResponse(movies);
    }

    @Override
    public List<MovieResponse> getAllByCategory(String categoryName) {
        var category = categoryRepository.existsByShortName(categoryName) ?
                categoryRepository.getCategoryByShortName(categoryName) :
                categoryRepository.getCategoryByFullName(categoryName);

        List<Movie> movies = category == null ?
                movieRepository.findAll(Sort.by("name")) :
                movieRepository.findAllByCategoryIdAndOrderByName(category.getId());

        return mapper.convertListMovieToListMovieResponse(movies);
    }
}
