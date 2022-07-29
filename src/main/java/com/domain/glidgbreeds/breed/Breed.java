package com.domain.glidgbreeds.breed;

import com.domain.glidgbreeds.subbreed.SubBreed;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="breed")
public class Breed implements Serializable{
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(columnDefinition = "serial")
    private Long breed_id;
    private String name;

    @OneToMany
    @JoinTable(
            name = "fk_breed_sub",
            joinColumns = @JoinColumn(name = "breed_id"),
            inverseJoinColumns = @JoinColumn(name = "sub_breed_id")
    )
    private Set<SubBreed> subBreeds = new HashSet<SubBreed>();

    public Breed() {
    }

    public Breed(Long breed_id, String name, Set<SubBreed> subBreeds) {
        this.breed_id = breed_id;
        this.name = name;
        this.subBreeds = subBreeds;
    }

    public Long getBreed_id() {
        return breed_id;
    }

    public void setBreed_id(Long breed_id) {
        this.breed_id = breed_id;
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
