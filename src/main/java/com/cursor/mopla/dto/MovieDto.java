package com.cursor.mopla.dto;

import com.cursor.mopla.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {

    private String name;

    List<Category> categoryList;

    private String director;

    private String description;

}
