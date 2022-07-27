package com.domain.glidgbreeds.breed;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="sub_breed")
public class SubBreed implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(columnDefinition = "serial")
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "breed_id", nullable=false)
    private Breed breed;

    public SubBreed() {
    }

    public SubBreed(Long id, String name, Breed breed) {
        this.id = id;
        this.name = name;
        this.breed = breed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }
}
