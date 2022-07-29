package com.domain.glidgbreeds.breed;

import com.domain.glidgbreeds.dto.RequestBreed;
import com.domain.glidgbreeds.subbreed.SubBreed;
import com.domain.glidgbreeds.subbreed.SubBreedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BreedService {

    private final BreedRepository breedRepository;

    private final SubBreedRepository subBreedRepository;

    @Autowired
    public BreedService(BreedRepository breedRepository, SubBreedRepository subBreedRepository) {
        this.breedRepository = breedRepository;
        this.subBreedRepository = subBreedRepository;
    }

    public Iterable<Breed> getBreeds(){
        return breedRepository
                .findAll();
//        return  null;
    }

    public void addNewBreed(RequestBreed requestBreed) {

        Breed newBreed = new Breed();
        newBreed.setName(requestBreed.getName());
        breedRepository.save(newBreed);
        List<SubBreed> subBreed = requestBreed.getSubBreeds();

        if (subBreed.size() > 0) {
            for (int i = 0; i < subBreed.size(); i++) {
                SubBreed newSubBreed = new SubBreed();
                newSubBreed.setName(subBreed.get(i).getName());
                addNewSubBreed(newSubBreed, newBreed.getBreed_id());
            }
        }
    }

    public Breed findById(Long id){
        Optional<Breed> breedExist = breedRepository.findById(id);

        if(!breedExist.isPresent()){
            return null;
        }
        return breedExist.get();
    }

    public Breed findByName(String name){
        Optional<Breed> breedByName = breedRepository.findBreedByName(name);
        if(!breedByName.isPresent()){
            return null;
        }
        return breedByName.get();





    }

    public void addNewSubBreed(SubBreed subBreed, Long breedId){
        Breed breed = findById(breedId);
        if(breed == null){
            throw new RuntimeException("Breed with ID: " + breedId + " Not Found");
        }

        subBreedRepository.save(subBreed);
        breed.getSubBreeds().add(subBreed);
        breedRepository.save(breed);
    }

    public boolean updateBreed(Long id, Breed breed) {
        Optional<Breed> breedExist = breedRepository.findById(id);

        if (breedExist.isPresent()) {
            Breed updateBreed = breedExist.get();
            updateBreed.setBreed_id(id);
            updateBreed.setName(breed.getName());
            breedRepository.save(updateBreed);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteBreedById(Long breedId) {
        Optional<Breed> breedExist = breedRepository.findById(breedId);
        if (breedExist.isPresent()) {
            breedRepository.deleteById(breedId);
            return true;
        } else {
            return false;
        }
    }

}
