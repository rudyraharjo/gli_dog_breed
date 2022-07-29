package com.domain.glidgbreeds.subbreed;

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

    public SubBreed() {
    }

    public SubBreed(Long id, String name) {
        this.id = id;
        this.name = name;
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

}
