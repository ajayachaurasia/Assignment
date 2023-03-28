package com.basic.synchrony.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "roles")
public class Role {

    public Role() {

    }

    public Role(String name) {
        super();
        this.name = name;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 60)
    private String name;
}
