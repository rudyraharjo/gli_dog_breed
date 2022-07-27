package com.domain.glidgbreeds.breed;

import com.domain.glidgbreeds.models.RequestBreed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/breed")
public class BreedController {

    private final BreedService breedService;

    @Autowired
    public BreedController(BreedService breedService){
        this.breedService = breedService;
    }

    @GetMapping("all")
    public ResponseEntity<List<Breed>> getBreeds(){
        try {
            return new ResponseEntity<>(breedService.getBreeds(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
//        return breedService.getBreeds();
    }

    @PostMapping("create")
    public ResponseEntity<String> addNewBreed(@RequestBody RequestBreed requestBreed){
        try {
            Breed newBreed = new Breed();
            newBreed.setName(requestBreed.getName());
            ArrayList<String> subBreed = requestBreed.getSub();
            breedService.addNewBreed(requestBreed);

            if(subBreed.size() > 0){
                return new ResponseEntity<>("Success Created with Sub", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("Success Created only parent", HttpStatus.CREATED);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
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
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
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
}
