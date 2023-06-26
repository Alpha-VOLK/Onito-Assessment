package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movies")
public class MoviesEntity {

    @Id
    @Column(name = "tconst")
    private String tconst;

    @Column(name = "titleType")
    private String titleType;

    @Column(name = "primaryTitle")
    private String primaryTitle;

    @Column(name = "runtimeMinutes")
    private int runtimeMinutes;

    @Column(name = "genres")
    private String genres;

}
