package com.cursor.mopla.entities;

import lombok.*;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "feedback")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Feedback extends BasicEntity {

    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;

    @Column(name = "feedback_text")
    private String feedbackText;

    @Column(name = "is_liked")
    private boolean isLiked;
}
