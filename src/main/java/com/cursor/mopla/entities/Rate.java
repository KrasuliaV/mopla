package com.cursor.mopla.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

    @Column(name = "votesCount")
    private long votesCount;

}