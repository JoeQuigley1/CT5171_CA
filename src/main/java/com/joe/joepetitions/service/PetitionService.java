package com.joe.joepetitions.service;

import com.joe.joepetitions.model.Petition;
import com.joe.joepetitions.model.Signature;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetitionService {

    private final List<Petition> petitions = new ArrayList<>();
    private int createId;

    public PetitionService() {
        Petition p1 = new Petition(1, "Fix the roads", "It's only November and the potholes are massive.", "John");
        Petition p2 = new Petition(2, "Fix the windows", "It's only November and the house is freezing.", "Jane");
        Petition p3 = new Petition(3, "Fix the drains", "It's only November and the drains keep flooding.", "Declan");

        p1.addSignature(new Signature("Alice Doe", "alice@example.com", 123456789));
        p2.addSignature(new Signature("Bob Dylan", "bob@example.com", 123456789));
        p3.addSignature(new Signature("Charlie Chaplin", "charlie@example.com", 123456789));

        petitions.add(p1);
        petitions.add(p2);
        petitions.add(p3);

        createId = petitions.stream().mapToInt(Petition::getId).max().orElse(0)+1;
    }

    public List<Petition> getAllPetitions() {
        return petitions;
    }

    public List<Petition> searchPetitions(String keyword) {

        if (keyword == null || keyword.isBlank()){
            return getAllPetitions();
        }
        String lower = keyword.toLowerCase();
        return petitions.stream().filter(p ->
                        (p.getTitle() != null && p.getTitle().toLowerCase().contains(lower)) ||
                                (p.getDescription() != null && p.getDescription().toLowerCase().contains(lower)))
                .collect(Collectors.toList());

    }

    public Petition getPetitionById(int id) {
        return petitions.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Petition CreatePetition(Petition petition) {
        petition.setId(createId++);
        petitions.add(petition);
        return petition;
    }
}

