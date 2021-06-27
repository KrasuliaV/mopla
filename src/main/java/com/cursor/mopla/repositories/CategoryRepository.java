package com.cursor.mopla.repositories;

import com.cursor.mopla.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    boolean existsByFullName(String name);

    boolean existsByShortName(String name);

    Category getCategoryByFullName(String name);

    Category getCategoryByShortName(String name);

}
