package com.cursor.mopla.controller;

import com.cursor.mopla.entities.Category;
import com.cursor.mopla.entities.Movie;
import com.cursor.mopla.service.CategoryService;
import com.cursor.mopla.service.MovieService;
import com.cursor.mopla.ui.request.MovieRequest;
import com.cursor.mopla.ui.response.MovieResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    private final CategoryService categoryService;

    private final ModelMapper mapper;

    @Autowired
    public MovieController(MovieService movieService, CategoryService categoryService, ModelMapper mapper) {
        this.movieService = movieService;
        this.categoryService = categoryService;
        this.mapper = mapper;
    }

    @Secured(value = "ROLE_ADMIN")
    @GetMapping("/admin/create")
    public List<Category> create() {
        return categoryService.findAll();
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping(produces = {"application/json"},
            consumes = {"application/json"},
            path = "/admin/create")
    public ResponseEntity<?> create(@RequestBody final MovieRequest movieRequest) {

        final var newMovie = movieService.create(mapper.map(movieRequest, Movie.class));

        return ResponseEntity.ok(newMovie);
    }

    @GetMapping(produces = {"application/json"}, path = "/{id}")
    public ResponseEntity<?> getMovieById(@PathVariable Long id) {

        final var movieById = movieService.getById(id);

        return new ResponseEntity<>(mapper.map(movieById, MovieResponse.class), HttpStatus.OK);
    }

    @GetMapping(produces = {"application/json"}, path = "/all")
    public ResponseEntity<?> getAll() {

        return ResponseEntity.ok(movieService.findAll());

    }

    @Secured({"ROLE_ADMIN"})
    @PutMapping(produces = {"application/json"},
            consumes = {"application/json"},
            path = "/admin/updateMovie/{id}")
    public ResponseEntity<?> updateMovie(@PathVariable("id") long movieId,
                                         @RequestBody final Movie movie) {
        final var newCountry = movieService.update(movie);

        return ResponseEntity.ok(newCountry);
    }

    @Secured({"ROLE_ADMIN"})
    @DeleteMapping("/admin/deleteMovie/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {

        movieService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/stats/rating")
    public ResponseEntity<?> getAllByRate(
            @RequestParam(value = "sort", required = false, defaultValue = "desc") String sort) {

        return ResponseEntity.ok(movieService.findAllByRating(sort));
    }

    @GetMapping("/stats/category")
    public ResponseEntity<?> getAllByCategory(
            @RequestParam(value = "categoryName", defaultValue = "default") String categoryName) {

        return ResponseEntity.ok(movieService.getAllByCategory(categoryName));
    }
}
