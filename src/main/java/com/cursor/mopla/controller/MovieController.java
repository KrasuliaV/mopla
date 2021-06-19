package com.cursor.mopla.controller;

import com.cursor.mopla.entities.Movie;
import com.cursor.mopla.service.CategoryService;
import com.cursor.mopla.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    private final CategoryService categoryService;

    @Autowired
    public MovieController(MovieService movieService, CategoryService categoryService) {
        this.movieService = movieService;
        this.categoryService = categoryService;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("movie", new Movie());
        model.addAttribute("categories", categoryService.findAll());
        return "create-movie";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("movie") Movie movie, BindingResult result) {
        if (result.hasErrors()) {
            return "create-todo";
        }
        movieService.create(movie);
        return "redirect:/movie/all";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("movies", movieService.findAll());

        return "movies-list";
    }
}
