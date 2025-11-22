package com.joe.joepetitions.service;

import com.joe.joepetitions.model.Petition;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetitionService {

    private List<Petition> petitions = new ArrayList<>();

    public PetitionService() {
        petitions.add(new Petition(1, "Fix the roads", "It's only November and the potholes are massive.", "John"));

    }

    public List<Petition> getAllPetitions() {
        return petitions;
    }

    public Petition getPetitionById(int id) {
        return petitions.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }
}

