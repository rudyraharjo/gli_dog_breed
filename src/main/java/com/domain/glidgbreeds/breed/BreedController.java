package com.domain.glidgbreeds.breed;

import com.domain.glidgbreeds.dto.RequestBreed;
import com.domain.glidgbreeds.dto.ResponseDogBreed;
import com.domain.glidgbreeds.subbreed.SubBreed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@RequestMapping("api/v1/breed")
public class BreedController {
    private final BreedService breedService;
    @Autowired
    public BreedController(BreedService breedService){
        this.breedService = breedService;
    }
    @GetMapping("list")
    public ResponseEntity<Iterable<Breed>> getBreeds(){
        try {
            if(breedService.getBreeds() != null){
                return new ResponseEntity<>(breedService.getBreeds(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//    Breed breed
    @PostMapping("create")
    public ResponseEntity<String> addNewBreedMultipleSubBreed(
            @RequestBody RequestBreed requestBreed){
        try {
            breedService.addNewBreed(requestBreed);
            if(requestBreed.getSubBreeds().size() > 0){
                return new ResponseEntity<>("Success Created with Sub", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("Success Created", HttpStatus.CREATED);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("sub/{id}")
    public ResponseEntity<String> addSingleSubBreed(
            @RequestBody SubBreed subBreed,
            @PathVariable("id") Long breedId) {
        try {
            breedService.addNewSubBreed(subBreed, breedId);
            return new ResponseEntity<>("Success Created Sub Breed", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Breed> detailBreed(
            @PathVariable("id") Long id
    ){
        try {
            if(breedService.findById(id) != null){
                return new ResponseEntity<>(breedService.findById(id), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{name}/list")
    public ResponseEntity<Breed> detailBreedByName(
            @PathVariable("name") String name
    ){
        try {
            if(breedService.findByName(name) != null){
                return new ResponseEntity<>(breedService.findByName(name), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<String> updateBreed(
            @PathVariable("id") Long id,
            @RequestBody Breed breed){
        try {
            if(breedService.updateBreed(id, breed)){
                return new ResponseEntity<>("Success Updated", HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteBreed(
            @PathVariable("id") Long id) {
        try {
            if(breedService.deleteBreedById(id)){
                return new ResponseEntity<>("Success Deleted!", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Failed Deleted! data dog not found", HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("DogApi/breed/list")
    public String getDogApi(){
        String url = "https://dog.ceo/api/breeds/list/all";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        System.out.println(result);
        return result;
    }

}
