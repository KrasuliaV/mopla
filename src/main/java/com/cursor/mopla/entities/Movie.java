package com.cursor.mopla.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movie")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"categoryList", "feedbacks"})
@EqualsAndHashCode(callSuper = true, exclude = {"categoryList", "feedbacks"})
public class Movie extends BasicEntity {

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(name = "movie_category",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    List<Category> categoryList;

    @Column(name = "director")
    private String director;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "movie",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Feedback> feedbacks = new ArrayList<>();

    @Column(name = "votes_count")
    private long votesCount;

    @Column(name = "value")
    private double rateValue;

    private double valueCount() {
        if (feedbacks.isEmpty()) return 1.00;
        final long likeCount = feedbacks
                .stream()
                .filter(Feedback::isLiked)
                .count();
        return Math.max(10.00 / votesCount * likeCount, 1.00);
    }

    public double getRateValue() {
        return valueCount();
    }

    public long getVotesCount() {
        return feedbacks.size();
    }

}
