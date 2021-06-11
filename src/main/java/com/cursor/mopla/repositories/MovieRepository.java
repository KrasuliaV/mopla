package com.cursor.mopla.repositories;

import com.cursor.mopla.enteties.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
