package com.cursor.mopla.entities;

import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "rate")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rate extends BasicEntity {

    @OneToOne()
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private Movie movie;

    @Column(name = "value")
    private double value;

    @Column(name = "votes_count")
    private long votesCount;

}