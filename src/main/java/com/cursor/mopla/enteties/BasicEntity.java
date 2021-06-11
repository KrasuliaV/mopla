package com.cursor.mopla.enteties;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public abstract class BasicEntity {

    private Long id;
}
