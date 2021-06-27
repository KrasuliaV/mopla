package com.cursor.mopla.maper;

import com.cursor.mopla.entities.Movie;
import com.cursor.mopla.ui.response.MovieResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class ListMovieMapper {

    private final ModelMapper mapper;

    public List<MovieResponse> convertListMovieToListMovieResponse(List<Movie> movies) {
        return movies.stream()
                .map(movie -> mapper.map(movie, MovieResponse.class))
                .collect(Collectors.toList());
    }
}
