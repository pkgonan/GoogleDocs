package com.kim.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long num;

    @Column(unique = true)
    @NotNull
    private String id;

    @Column
    @NotNull
    private String password;
}