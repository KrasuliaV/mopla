package com.cursor.mopla.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "category")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category extends BasicEntity {

    @Column(name = "full_name")
    private String fullName;

    @EqualsAndHashCode.Exclude
    @ManyToMany
    private List<Movie> movieList;
}
