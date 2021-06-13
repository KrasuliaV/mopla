package com.cursor.mopla.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BasicEntity {

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "user")
    private List<Feedback> feedbacks;

}
