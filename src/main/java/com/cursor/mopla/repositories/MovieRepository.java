package com.cursor.mopla.repositories;

import com.cursor.mopla.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> getAllByOrderByRateValueAsc();

    List<Movie> getAllByOrderByRateValueDesc();

    @Query("select m from Movie m " +
            "join m.categoryList cat " +
            "where cat.id = ?1")
    List<Movie> findAllByCategoryIdAndOrderByName(Long categoryId);
}
