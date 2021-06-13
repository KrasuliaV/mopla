package com.cursor.mopla.repositories;

import com.cursor.mopla.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
