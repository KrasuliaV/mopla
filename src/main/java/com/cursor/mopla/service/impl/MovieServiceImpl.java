package com.cursor.mopla.service.impl;

import com.cursor.mopla.entities.Movie;
import com.cursor.mopla.exception.NullEntityReferenceException;
import com.cursor.mopla.repositories.CategoryRepository;
import com.cursor.mopla.repositories.MovieRepository;
import com.cursor.mopla.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository, CategoryRepository categoryRepository) {
        this.movieRepository = movieRepository;
        this.categoryRepository = categoryRepository;
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
            throw new IllegalArgumentException("You must enter correct data");
        }
        movieRepository.deleteById(id);
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> findAllByRating(String sort) {
        return sort.equals("asc") ?
                movieRepository.getAllByOrderByRateValueAsc() :
                movieRepository.getAllByOrderByRateValueDesc();
    }

    @Override
    public List<Movie> getAllByCategory(String categoryName) {
        final var category2 = categoryRepository.findAll()
                .stream()
                .filter(category1 -> category1.getFullName().equals(categoryName) || category1.getShortName().equals(categoryName))
                .findFirst()
                .orElse(null);

        return category2 == null ?
                movieRepository.findAll(Sort.by("name")) :
                movieRepository.findAllByCategoryIdAndOrderByName(category2.getId());
    }
}
