package com.cursor.mopla.ui.request;

import com.cursor.mopla.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieRequest {

    private String name;

    List<Category> categoryList;

    private String director;

    private String description;

}
