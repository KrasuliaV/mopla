package com.cursor.mopla.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "rate")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rate extends BasicEntity {

    @OneToOne(mappedBy = "rate")
    private Movie movie;

    @Column(name = "value")
    private double value;

    @Column(name = "votes_count")
    private long votesCount;

}