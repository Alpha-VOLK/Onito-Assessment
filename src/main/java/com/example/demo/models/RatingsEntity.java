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
@Table(name = "ratings")
public class RatingsEntity {

    @Id
    @Column(name = "tconst")
    private String tconst;

    @Column(name = "averageRating")
    private double averageRating;

    @Column(name = "numVotes")
    private String numVotes;

}
