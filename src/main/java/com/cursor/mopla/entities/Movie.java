package com.cursor.mopla.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "movie")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie extends BasicEntity {

    @Column(name = "name")
    private String name;

    @EqualsAndHashCode.Exclude
    @ManyToMany
    @JoinTable(name = "movie_category",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    List<Category> categoryList;

    @Column(name = "director")
    private String director;

    @Column(name = "description")
    private String description;

    @EqualsAndHashCode.Exclude
    @OneToOne(cascade = CascadeType.ALL)
    private Rate rate;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "movie")
    private List<Feedback> feedbacks = new ArrayList<>();
}
