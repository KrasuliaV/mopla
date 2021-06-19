package com.cursor.mopla.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "category")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category extends BasicEntity {

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "full_name")
    private String fullName;

//    @EqualsAndHashCode.Exclude
//    @ManyToMany(mappedBy = "categoryList")
//
////    @ManyToMany(mappedBy = "categoryList", fetch = FetchType.LAZY)
////    @JoinTable(name = "movie_category",
////            joinColumns = @JoinColumn(name = "movie_id"),
////            inverseJoinColumns = @JoinColumn(name = "category_id"))
//    private List<Movie> movieList;
}
