package com.domain.glidgbreeds.breed;

import com.domain.glidgbreeds.models.RequestBreed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
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

    public List<Breed> getBreeds(){
        return breedRepository.findAll();
    }

    public void addNewBreed(RequestBreed requestBreed) {

        if(requestBreed.getName() != "") {
            Breed newBreed = new Breed();
            newBreed.setName(requestBreed.getName());

            Breed breed = breedRepository.save(newBreed);
            breedRepository.flush();

            System.out.println("breed ID " + breed.getId());

            ArrayList<String> subBreed = requestBreed.getSub();

            if (subBreed.size() > 0) {
                for (int i = 0; i < subBreed.size(); i++) {
                    SubBreed newSubBreed = new SubBreed();
                    newSubBreed.setBreed(breed);
                    newSubBreed.setName(subBreed.get(i));
                    subBreedRepository.save(newSubBreed);
                }
            }
        }
    }

    public boolean updateBreed(Long id, Breed breed) {
        Optional<Breed> breedExist = breedRepository.findById(id);

        if (breedExist.isPresent()) {
            Breed updateBreed = breedExist.get();
            updateBreed.setId(id);
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

    public void addNewSubBreed(SubBreed subBreed) {
        SubBreed newSubBread = new SubBreed();
        newSubBread.setName(subBreed.getName());
        subBreedRepository.save(newSubBread);
    }
}
