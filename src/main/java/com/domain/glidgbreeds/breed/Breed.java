package com.domain.glidgbreeds.breed;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="breed")
public class Breed implements Serializable{
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(columnDefinition = "serial")
    private Long id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "breed")
    private Set<SubBreed> subBreeds;

    public Breed() {
    }

    public Breed(Long id, String name, Set<SubBreed> subBreeds) {
        this.id = id;
        this.name = name;
        this.subBreeds = subBreeds;
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

    public Set<SubBreed> getSubBreeds() {
        return subBreeds;
    }

    public void setSubBreeds(Set<SubBreed> subBreeds) {
        this.subBreeds = subBreeds;
    }
}
