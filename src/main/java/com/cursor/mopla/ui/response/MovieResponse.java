package com.cursor.mopla.ui.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponse {

    private Long id;

    private String name;

    List<CategoryResponse> categoryList;

    private String director;

    private String description;

    //    private Rate rate;
    private long votesCount;

    private double value;
}
